package visitor;

import parser.node.impl.*;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.operandNodes.DivisionNode;
import parser.node.impl.operandNodes.MinusNode;
import parser.node.impl.operandNodes.MultiplyNode;
import parser.node.impl.operandNodes.SumNode;
import parser.node.visitor.NodeVisitor;

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
