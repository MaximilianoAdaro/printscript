package visitor;

import node.impl.AssignationNode;
import node.impl.DeclarationNode;
import node.impl.IdentifierNode;
import node.impl.PrintNode;
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
    public  void visit(DivisionNode divisionNode) {

    }

    @Override
    public  void visit(MultiplyNode multiplyNode) {

    }
}
