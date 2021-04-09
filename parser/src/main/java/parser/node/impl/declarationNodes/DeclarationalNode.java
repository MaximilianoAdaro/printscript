package parser.node.impl.declarationNodes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.node.AbstractNode;

@EqualsAndHashCode(callSuper = false)
@Data
public abstract class DeclarationalNode extends AbstractNode {

  public abstract IdentifierNode getIdentifierNode();
}
