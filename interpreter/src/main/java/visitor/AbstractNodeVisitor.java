package visitor;

import node.impl.*;
import node.impl.literalNodes.LiteralNode;
import node.impl.operandNodes.DivisionNode;
import node.impl.operandNodes.MinusNode;
import node.impl.operandNodes.MultiplyNode;
import node.impl.operandNodes.SumNode;
import node.visitor.NodeVisitor;

public abstract class AbstractNodeVisitor implements NodeVisitor {


    @Override
    public  void visit(DeclarationNode declarationNode) {

    }

    @Override
    public  void visit(IdentifierNode identifierNode) {

    }

    @Override
    public  void visit(LiteralNode literalNode) {

    }

    @Override
    public void visit(PrintNode printNode) {

    }

    @Override
    public  void visit(AssignationNode assignationNode) {

    }

    @Override
    public  void visit(SumNode sumNode) {

    }

    @Override
    public  void visit(MinusNode minusNode) {

    }

    @Override
    public void visit(DivisionNode divisionNode) {

    }

    @Override
    public void visit(MultiplyNode multiplyNode) {

    }

    @Override
    public void visit(EmptyNode emptyNode) {

    }
}
