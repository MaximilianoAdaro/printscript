package interpreter.visitor;

import parser.node.impl.AssignationNode;
import parser.node.impl.DeclarationNode;
import parser.node.impl.IdentifierNode;
import parser.node.impl.PrintNode;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.operatorNodes.DivisionNode;
import parser.node.impl.operatorNodes.MinusNode;
import parser.node.impl.operatorNodes.MultiplyNode;
import parser.node.impl.operatorNodes.SumNode;
import parser.node.interfaces.LiteralValue;

public class ValidationVisitor extends AbstractNodeVisitor {
  @Override
  public void visit(DeclarationNode declarationNode) {}

  @Override
  public void visit(PrintNode printNode) {}

  @Override
  public void visit(AssignationNode assignationNode) {}

  @Override
  public LiteralValue visit(IdentifierNode identifierNode) {
    return null;
  }

  @Override
  public LiteralValue visit(SumNode sumNode) {
    return null;
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
