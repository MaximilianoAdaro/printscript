package interpreter.interpetation;

import java.util.List;
import parser.node.Node;

public interface Interpreter {

  void interpret(List<Node> nodes);
}
