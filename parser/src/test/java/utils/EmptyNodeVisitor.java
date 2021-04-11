package utils;

import parser.node.impl.AssignationNode;
import parser.node.impl.PrintNode;
import parser.node.impl.declarationNodes.DeclarationNode;
import parser.node.impl.declarationNodes.IdentifierNode;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.operatorNodes.*;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

public class EmptyNodeVisitor implements NodeVisitor {
  @Override
  public void visit(DeclarationNode declarationNode) {}

  @Override
  public void visit(PrintNode printNode) {}

  @Override
  public void visit(AssignationNode assignationNode) {}

  @Override
  public LiteralValue visit(IdentifierNode identifierNode) {
    return NodeUtils.strValue("Nothing");
  }

  @Override
  public LiteralValue visit(SumNode sumNode) {
    return NodeUtils.strValue("Nothing");
  }

  @Override
  public LiteralValue visit(MinusNode minusNode) {
    return NodeUtils.strValue("Nothing");
  }

  @Override
  public LiteralValue visit(DivisionNode divisionNode) {
    return NodeUtils.strValue("Nothing");
  }

  @Override
  public LiteralValue visit(GreaterNode greaterNode) {
    return NodeUtils.strValue("Nothing");
  }

  @Override
  public LiteralValue visit(GreaterEqualNode greaterEqualNode) {
    return NodeUtils.strValue("Nothing");
  }

  @Override
  public LiteralValue visit(LessNode lessNode) {
    return NodeUtils.strValue("Nothing");
  }

  @Override
  public LiteralValue visit(LessEqualNode lessEqualNode) {
    return NodeUtils.strValue("Nothing");
  }

  @Override
  public LiteralValue visit(MultiplyNode multiplyNode) {
    return NodeUtils.strValue("Nothing");
  }

  @Override
  public LiteralValue visit(LiteralNode literalNode) {
    return NodeUtils.strValue("Nothing");
  }
}
