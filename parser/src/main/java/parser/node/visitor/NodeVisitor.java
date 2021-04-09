package parser.node.visitor;

import parser.node.impl.AssignationNode;
import parser.node.impl.PrintNode;
import parser.node.impl.declarationNodes.DeclarationNode;
import parser.node.impl.declarationNodes.IdentifierNode;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.operatorNodes.DivisionNode;
import parser.node.impl.operatorNodes.MinusNode;
import parser.node.impl.operatorNodes.MultiplyNode;
import parser.node.impl.operatorNodes.SumNode;
import parser.node.interfaces.LiteralValue;

public interface NodeVisitor {

  void visit(DeclarationNode declarationNode);

  void visit(PrintNode printNode);

  void visit(AssignationNode assignationNode);

  LiteralValue visit(IdentifierNode identifierNode);

  LiteralValue visit(SumNode sumNode);

  LiteralValue visit(MinusNode minusNode);

  LiteralValue visit(DivisionNode divisionNode);

  LiteralValue visit(MultiplyNode multiplyNode);

  LiteralValue visit(LiteralNode literalNode);
}
