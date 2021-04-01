package interpreter;

import java.util.List;
import parser.node.Node;

public interface Validator {

  List<Node> validate();
}
