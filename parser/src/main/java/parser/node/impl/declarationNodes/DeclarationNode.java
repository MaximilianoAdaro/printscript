package parser.node.impl.declarationNodes;

import lexer.model.Position;
import lombok.*;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Data
public class DeclarationNode extends DeclarationalNode {

  private TypeValue typeValue;
  private IdentifierNode identifierNode;
  private boolean isConst;

  public DeclarationNode(Position position) {
    super(position);
  }

  @Builder
  public DeclarationNode(
      Position position, TypeValue typeValue, IdentifierNode identifierNode, boolean isConst) {
    super(position);
    this.typeValue = typeValue;
    this.identifierNode = identifierNode;
    this.isConst = isConst;
  }

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }
}
