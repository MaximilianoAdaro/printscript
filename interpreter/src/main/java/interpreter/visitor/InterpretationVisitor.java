package interpreter.visitor;

import interpreter.VariableManager;
import interpreter.VariableManager.ValueType;
import interpreter.exception.InterpreterException;
import interpreter.utils.OperatorUtils;
import java.util.function.Consumer;
import lombok.AllArgsConstructor;
import lombok.val;
import parser.node.Node;
import parser.node.impl.AssignationNode;
import parser.node.impl.ConditionNode;
import parser.node.impl.PrintNode;
import parser.node.impl.declarationNodes.DeclarationNode;
import parser.node.impl.declarationNodes.IdentifierNode;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.impl.operatorNodes.*;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@AllArgsConstructor
public class InterpretationVisitor implements NodeVisitor {

  private final Consumer<String> stdOut;

  private final VariableManager variableManager = new VariableManager();

  @Override
  public void visit(PrintNode printNode) {
    stdOut.accept(printNode.getCalculable().calculate(this).toString());
  }

  @Override
  public void visit(DeclarationNode declarationNode) {
    final var variableName = declarationNode.getIdentifierNode().getValue();
    if (variableManager.isDeclared(variableName))
      throw InterpreterException.alreadyExists(declarationNode);
    final var variableType = declarationNode.getTypeValue();
    variableManager.declareVar(
        variableName, new ValueType(variableType, declarationNode.isConst()));
  }

  @Override
  public void visit(AssignationNode assignationNode) {
    final var declarational = assignationNode.getDeclarational();
    if (declarational instanceof DeclarationNode) declarational.accept(this);
    val literalValue = assignationNode.getCalculable().calculate(this);
    final var identifierNode = declarational.getIdentifierNode();
    final String propertyName = identifierNode.getValue();
    final var varType =
        variableManager
            .getValueType(propertyName)
            .orElseThrow(() -> InterpreterException.invalidVar(identifierNode));
    if (declarational instanceof IdentifierNode && varType.isConst())
      throw InterpreterException.isConst(assignationNode, propertyName, literalValue);
    if (varType.getTypeValue() != literalValue.getTypeValue())
      throw InterpreterException.invalidType(varType.getTypeValue(), literalValue, identifierNode);
    variableManager.assignVar(propertyName, literalValue);
  }

  @Override
  public void visit(ConditionNode conditionNode) {
    final var literalValue = conditionNode.getCondition().calculate(this);
    if (!literalValue.getTypeValue().equals(TypeValue.BOOLEAN))
      throw InterpreterException.expectedBool(literalValue, conditionNode);

    final Consumer<Node> nodeConsumer = n -> n.accept(this);
    variableManager.newScope();
    if (literalValue.getValue().equals(true)) conditionNode.getIfTrue().forEach(nodeConsumer);
    else conditionNode.getIfFalse().forEach(nodeConsumer);
    variableManager.endScope();
  }

  @Override
  public LiteralValue visit(SumNode sumNode) {
    final var left = sumNode.getLeftNode().calculate(this);
    final var right = sumNode.getRightNode().calculate(this);
    return OperatorUtils.calculateSum(left, right);
  }

  @Override
  public LiteralValue visit(MinusNode minusNode) {
    final var left = minusNode.getLeftNode().calculate(this);
    final var right = minusNode.getRightNode().calculate(this);
    return OperatorUtils.calculateMinus(left, right, minusNode);
  }

  @Override
  public LiteralValue visit(DivisionNode divisionNode) {
    final var left = divisionNode.getLeftNode().calculate(this);
    final var right = divisionNode.getRightNode().calculate(this);
    return OperatorUtils.calculateDivision(left, right, divisionNode);
  }

  @Override
  public LiteralValue visit(GreaterNode greaterNode) {
    final var left = greaterNode.getLeftNode().calculate(this);
    final var right = greaterNode.getRightNode().calculate(this);
    return OperatorUtils.calculateGreater(left, right, greaterNode);
  }

  @Override
  public LiteralValue visit(GreaterEqualNode greaterEqualNode) {
    final var left = greaterEqualNode.getLeftNode().calculate(this);
    final var right = greaterEqualNode.getRightNode().calculate(this);
    return OperatorUtils.calculateGreaterEqual(left, right, greaterEqualNode);
  }

  @Override
  public LiteralValue visit(LessNode lessNode) {
    final var left = lessNode.getLeftNode().calculate(this);
    final var right = lessNode.getRightNode().calculate(this);
    return OperatorUtils.calculateLess(left, right, lessNode);
  }

  @Override
  public LiteralValue visit(LessEqualNode lessEqualNode) {
    final var left = lessEqualNode.getLeftNode().calculate(this);
    final var right = lessEqualNode.getRightNode().calculate(this);
    return OperatorUtils.calculateLessEqual(left, right, lessEqualNode);
  }

  @Override
  public LiteralValue visit(MultiplyNode multiplyNode) {
    final var left = multiplyNode.getLeftNode().calculate(this);
    final var right = multiplyNode.getRightNode().calculate(this);
    return OperatorUtils.calculateMultiply(left, right, multiplyNode);
  }

  @Override
  public LiteralValue visit(LiteralNode literalNode) {
    return literalNode.getLiteralValue();
  }

  @Override
  public LiteralValue visit(IdentifierNode identifierNode) {
    final var variableName = identifierNode.getValue();
    if (!variableManager.isDeclared(variableName))
      throw InterpreterException.invalidVar(identifierNode);
    return variableManager
        .getLiteralValue(variableName)
        .orElseThrow(() -> InterpreterException.notInitVar(identifierNode));
  }
}
