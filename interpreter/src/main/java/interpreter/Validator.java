package interpreter;

import java.util.List;
import parser.node.Node;

public interface Validator {

  void validate(List<Node> nodes);
}
