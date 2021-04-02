package interpreter.visitor;

import java.util.HashMap;
import java.util.Map;
import parser.node.impl.AssignationNode;
import parser.node.impl.DeclarationNode;
import parser.node.impl.IdentifierNode;
import parser.node.impl.PrintNode;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.impl.operatorNodes.DivisionNode;
import parser.node.impl.operatorNodes.MinusNode;
import parser.node.impl.operatorNodes.MultiplyNode;
import parser.node.impl.operatorNodes.SumNode;
import parser.node.interfaces.LiteralValue;

public class InterpretationVisitor extends AbstractNodeVisitor {

  private static final Map<String, TypeValue> variables = new HashMap<>();
  private static final Map<String, LiteralValue> assignations = new HashMap<>();

  @Override
  public LiteralValue visit(IdentifierNode identifierNode) {
    final var variableName = identifierNode.getValue();
    return null;
  }

  @Override
  public void visit(DeclarationNode declarationNode) {
    final var variableName = declarationNode.getIdentifierNode().getValue();
    if (variables.containsKey(variableName)) throw new RuntimeException();
    final var variableType = declarationNode.getTypeValue();
    variables.put(variableName, variableType);
  }

  @Override
  public void visit(PrintNode printNode) {}

  @Override
  public void visit(AssignationNode assignationNode) {
    assignationNode.getDeclarational().accept(this);
    final var value = assignationNode.getCalculable().calculate(this);
  }

  @Override
  public LiteralValue visit(SumNode sumNode) {
    final var left = sumNode.getLeftNode().calculate(this);
    final var right = sumNode.getRightNode().calculate(this);
    return left;
  }

  @Override
  public LiteralValue visit(MinusNode minusNode) {
    return null;
  }

  @Override
  public LiteralValue visit(DivisionNode divisionNode) {
    return null;
  }

  @Override
  public LiteralValue visit(MultiplyNode multiplyNode) {
    return null;
  }

  @Override
  public LiteralValue visit(LiteralNode literalNode) {
    return null;
  }
}
