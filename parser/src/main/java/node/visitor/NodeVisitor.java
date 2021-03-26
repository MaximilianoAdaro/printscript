package node.visitor;

import node.impl.AssignationNode;
import node.impl.DeclarationNode;
import node.impl.IdentifierNode;
import node.impl.PrintNode;
import node.impl.literalNodes.LiteralNode;
import node.impl.operandNodes.DivisionNode;
import node.impl.operandNodes.MinusNode;
import node.impl.operandNodes.MultiplyNode;
import node.impl.operandNodes.SumNode;

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

}
