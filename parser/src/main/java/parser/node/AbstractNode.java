package parser.node;

import lexer.model.Position;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
@Data
public abstract class AbstractNode implements Node {

  private Position position;
}
