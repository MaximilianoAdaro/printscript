package parser.node.impl.declarationNodes;

import lombok.*;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeclarationNode extends DeclarationalNode {

  private TypeValue typeValue;
  private IdentifierNode identifierNode;

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }
}
