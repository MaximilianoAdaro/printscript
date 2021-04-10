package interpreter;

import interpreter.visitor.InterpretationVisitor;
import java.util.List;
import java.util.function.Consumer;
import lombok.val;
import parser.node.Node;

public class Interpreter {

  private Interpreter() {}

  public static void run(List<Node> nodes, Consumer<String> stdOut) {
    new Interpreter().interpret(nodes, stdOut);
  }

  private void interpret(List<Node> nodes, Consumer<String> stdOut) {
    val visitor = new InterpretationVisitor(stdOut);
    nodes.forEach(n -> n.accept(visitor));
  }
}
