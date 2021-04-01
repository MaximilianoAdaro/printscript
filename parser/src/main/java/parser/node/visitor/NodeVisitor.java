package parser.node.visitor;

import parser.node.impl.*;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.operatorNodes.DivisionNode;
import parser.node.impl.operatorNodes.MinusNode;
import parser.node.impl.operatorNodes.MultiplyNode;
import parser.node.impl.operatorNodes.SumNode;

public interface NodeVisitor {

  void visit(DeclarationNode declarationNode);

  void visit(IdentifierNode identifierNode);

  void visit(PrintNode printNode);

  void visit(AssignationNode assignationNode);

  void visit(SumNode sumNode);

  void visit(MinusNode minusNode);

  void visit(DivisionNode divisionNode);

  void visit(MultiplyNode multiplyNode);

  void visit(LiteralNode literalNode);

  void visit(EmptyNode emptyNode);
}
