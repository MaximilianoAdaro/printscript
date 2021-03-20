package visitor;

import node.impl.AssignationNode;
import node.impl.DeclarationNode;
import node.impl.IdentifierNode;
import node.impl.PrintNode;
import node.impl.literalNodes.LiteralNode;
import node.impl.operandNodes.DivisionNode;
import node.impl.operandNodes.MinusNode;
import node.impl.operandNodes.ProductNode;
import node.impl.operandNodes.SumNode;
import node.visitor.NodeVisitor;

public abstract class AbstractNodeVisitor implements NodeVisitor {

    @Override
    public <T> void visit(DeclarationNode<T> declarationNode) {

    }

    @Override
    public <T> void visit(IdentifierNode<T> identifierNode) {

    }

    @Override
    public <T> void visit(LiteralNode<T> literalNode) {

    }

    @Override
    public void visit(PrintNode printNode) {

    }

    @Override
    public <T> void visit(AssignationNode<T> assignationNode) {

    }

    @Override
    public <T> void visit(SumNode<T> sumNode) {

    }

    @Override
    public <T> void visit(MinusNode<T> minusNode) {

    }

    @Override
    public <T> void visit(DivisionNode<T> divisionNode) {

    }

    @Override
    public <T> void visit(ProductNode<T> productNode) {

    }
}
