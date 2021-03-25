package node.impl;


import node.impl.literalNodes.TypeValue;
import node.interfaces.Declarational;
import node.visitor.NodeVisitor;

public class DeclarationNode implements Declarational {

    private final TypeValue typeValue;
    private final IdentifierNode identifierNode;

    public DeclarationNode(TypeValue typeValue, IdentifierNode identifierNode) {
        this.typeValue = typeValue;
        this.identifierNode = identifierNode;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
