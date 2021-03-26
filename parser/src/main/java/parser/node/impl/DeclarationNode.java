package parser.node.impl;


import lombok.Builder;
import lombok.Data;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.interfaces.Declarational;
import parser.node.visitor.NodeVisitor;

@Data
@Builder
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
