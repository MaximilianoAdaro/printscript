package interpreter.interpetation;

import interpreter.visitor.InterpretationVisitor;
import java.util.List;
import lombok.val;
import parser.node.Node;

public class InterpreterImpl implements Interpreter {

  private final Writer writer;

  public InterpreterImpl(Writer writer) {
    this.writer = writer;
  }

  public static void run(List<Node> nodes, Writer writer) {
    new InterpreterImpl(writer).interpret(nodes);
  }

  @Override
  public void interpret(List<Node> nodes) {
    val visitor = new InterpretationVisitor(writer);
    nodes.forEach(n -> n.accept(visitor));
  }
}
