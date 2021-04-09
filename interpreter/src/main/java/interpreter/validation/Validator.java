package interpreter.validation;

import interpreter.visitor.ValidationVisitor;
import java.util.List;
import lombok.val;
import parser.node.Node;

public class Validator {

  private Validator() {}

  public static void run(List<Node> nodes) {
    new Validator().validate(nodes);
  }

  private void validate(List<Node> nodes) {
    val visitor = new ValidationVisitor();
    nodes.forEach(n -> n.accept(visitor));
    //
  }
}
