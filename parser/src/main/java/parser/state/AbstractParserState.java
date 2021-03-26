package parser.state;

import lombok.Data;
import parser.node.Node;

import java.util.Optional;

@Data
public abstract class AbstractParserState implements ParserState {

    protected Node node;

    @Override
    public Optional<Node> getNode() {
        return Optional.ofNullable(node);
    }

}
