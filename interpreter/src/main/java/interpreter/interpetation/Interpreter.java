package interpreter.interpetation;

import interpreter.visitor.InterpretationVisitor;
import java.util.List;
import lombok.val;
import parser.node.Node;

public class Interpreter {

  private final Writer writer;

  private Interpreter(Writer writer) {
    this.writer = writer;
  }

  public static void run(List<Node> nodes, Writer writer) {
    new Interpreter(writer).interpret(nodes);
  }

  private void interpret(List<Node> nodes) {
    val visitor = new InterpretationVisitor(writer);
    nodes.forEach(n -> n.accept(visitor));
  }
}
