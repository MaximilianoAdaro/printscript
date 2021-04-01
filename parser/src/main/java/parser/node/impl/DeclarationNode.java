package parser.node.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.interfaces.Declarational;
import parser.node.visitor.NodeVisitor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeclarationNode implements Declarational {

  private TypeValue typeValue;
  private IdentifierNode identifierNode;

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }
}
