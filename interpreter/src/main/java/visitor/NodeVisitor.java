package visitor;

import node.*;
import node.literalNode.LiteralNode;
import node.operandNode.*;

public interface NodeVisitor {

    void visit(DeclarationNode declarationNode);

    void visit(IdentifierNode identifierNode);

    void visit(LiteralNode literalNode);

    void visit(PrintNode printNode);

    void visit(AssignationNode assignationNode);

    void visit(SumNode sumNode);

    void visit(MinusNode minusNode);

    void visit(DivisionNode divisionNode);

    void visit(ProductNode productNode);
}
