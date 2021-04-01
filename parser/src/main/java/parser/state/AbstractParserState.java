package parser.state;

import java.util.Optional;
import lombok.Data;
import parser.node.Node;

@Data
public abstract class AbstractParserState implements ParserState {

  protected Node node;

  @Override
  public Optional<Node> getNode() {
    return Optional.ofNullable(node);
  }
}
