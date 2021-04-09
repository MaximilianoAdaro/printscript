package interpreter.visitor;

import interpreter.utils.OperatorUtils;
import java.util.HashMap;
import java.util.Map;
import lombok.val;
import parser.node.impl.AssignationNode;
import parser.node.impl.declarationNodes.DeclarationNode;
import parser.node.impl.declarationNodes.DeclarationalNode;
import parser.node.impl.declarationNodes.IdentifierNode;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.impl.operatorNodes.DivisionNode;
import parser.node.impl.operatorNodes.MinusNode;
import parser.node.impl.operatorNodes.MultiplyNode;
import parser.node.impl.operatorNodes.SumNode;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

public abstract class AbstractNodeVisitor implements NodeVisitor {

  private static final Map<String, TypeValue> variables = new HashMap<>();
  private static final Map<String, LiteralValue> assignations = new HashMap<>();

  @Override
  public LiteralValue visit(IdentifierNode identifierNode) {
    final var variableName = identifierNode.getValue();
    if (!variables.containsKey(variableName))
      throw new RuntimeException("THE IDENTIFIER DOES NOT EXIST");
    if (!assignations.containsKey(variableName))
      throw new RuntimeException("IT IS NOT INITIATED VARIABLE: " + variableName);
    return assignations.get(variableName);
  }

  @Override
  public void visit(DeclarationNode declarationNode) {
    final var variableName = declarationNode.getIdentifierNode().getValue();
    if (variables.containsKey(variableName))
      throw new RuntimeException("ALREADY EXISTS VARIABLE: " + variableName);
    final var variableType = declarationNode.getTypeValue();
    variables.put(variableName, variableType);
  }

  @Override
  public void visit(AssignationNode assignationNode) {
    final DeclarationalNode declarational = assignationNode.getDeclarational();
    declarational.accept(this);
    val literalValue = assignationNode.getCalculable().calculate(this);
    final IdentifierNode identifierNode = declarational.getIdentifierNode();
    if (variables.get(identifierNode.getValue()) != literalValue.getTypeValue())
      throw new RuntimeException("VERIFY TYPES");
    assignations.put(identifierNode.getValue(), literalValue);
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
    return OperatorUtils.calculateMinus(left, right);
  }

  @Override
  public LiteralValue visit(DivisionNode divisionNode) {
    final var left = divisionNode.getLeftNode().calculate(this);
    final var right = divisionNode.getRightNode().calculate(this);
    return OperatorUtils.calculateDivision(left, right);
  }

  @Override
  public LiteralValue visit(MultiplyNode multiplyNode) {
    final var left = multiplyNode.getLeftNode().calculate(this);
    final var right = multiplyNode.getRightNode().calculate(this);
    return OperatorUtils.calculateMultiply(left, right);
  }

  @Override
  public LiteralValue visit(LiteralNode literalNode) {
    return literalNode.getLiteralValue();
  }
}
