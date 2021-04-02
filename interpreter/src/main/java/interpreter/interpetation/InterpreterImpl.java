package interpreter.interpetation;

import interpreter.visitor.InterpretationVisitor;
import java.util.List;
import lombok.val;
import parser.node.Node;

public class InterpreterImpl implements Interpreter {

  public static void run(List<Node> nodes) {
    new InterpreterImpl().interpret(nodes);
  }

  @Override
  public void interpret(List<Node> nodes) {
    val visitor = new InterpretationVisitor();
    nodes.forEach(n -> n.accept(visitor));
  }
}
