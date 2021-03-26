package interpreter;

import parser.node.Node;

import java.util.List;

public interface Interpreter {

    List<Node> interpret();
}
