package node.visitor;

import node.impl.AssignationNode;
import node.impl.DeclarationNode;
import node.impl.IdentifierNode;
import node.impl.PrintNode;
import node.impl.literalNodes.LiteralNode;
import node.impl.operandNodes.DivisionNode;
import node.impl.operandNodes.MinusNode;
import node.impl.operandNodes.ProductNode;
import node.impl.operandNodes.SumNode;

public interface NodeVisitor {

    <T> void visit(DeclarationNode<T> declarationNode);

    <T> void visit(IdentifierNode<T> identifierNode);

    void visit(PrintNode printNode);

    <T> void visit(AssignationNode<T> assignationNode);

    <T> void visit(SumNode<T> sumNode);

    <T> void visit(MinusNode<T> minusNode);

    <T> void visit(DivisionNode<T> divisionNode);

    <T> void visit(ProductNode<T> productNode);

    <T> void visit(LiteralNode<T> literalNode);

}
