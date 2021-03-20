package node;


import node.interfaces.Declarational;
import node.literalNode.TypeValue;

public class DeclarationNode<T> implements Declarational {

    private final TypeValue typeValue;
    private final IdentifierNode<T> node;

    public DeclarationNode(TypeValue typeValue, IdentifierNode<T> node) {
        this.typeValue = typeValue;
        this.node = node;
    }

    @Override
    public void accept() {

    }
}
