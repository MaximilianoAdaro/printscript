package parser.node.impl.declarationNodes;

import lexer.model.Position;
import lombok.*;
import parser.node.AbstractNode;

@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public abstract class DeclarationalNode extends AbstractNode {

  public DeclarationalNode(Position position) {
    super(position);
  }

  public abstract IdentifierNode getIdentifierNode();
}
