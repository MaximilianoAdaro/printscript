package parser.node;

import lexer.model.Position;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
@Data
public abstract class AbstractNode implements Node {

  private Position position;

  public AbstractNode(Position position) {
    this.position = position;
  }
}
