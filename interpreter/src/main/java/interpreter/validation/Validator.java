package interpreter.validation;

import java.util.List;
import parser.node.Node;

public interface Validator {

  void validate(List<Node> nodes);
}
