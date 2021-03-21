package node.impl;


import node.impl.literalNodes.TypeValue;
import node.interfaces.Declarational;
import node.visitor.NodeVisitor;

public class DeclarationNode<T> implements Declarational {

    private final TypeValue typeValue;
    private final IdentifierNode<T> identifierNode;

    public DeclarationNode(TypeValue typeValue, IdentifierNode<T> identifierNode) {
        this.typeValue = typeValue;
        this.identifierNode = identifierNode;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
