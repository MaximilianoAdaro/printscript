package interpreter.validation;

import interpreter.visitor.ValidationVisitor;
import java.util.List;
import lombok.val;
import parser.node.Node;

public class ValidatorImpl implements Validator {

  public static void run(List<Node> nodes) {
    new ValidatorImpl().validate(nodes);
  }

  @Override
  public void validate(List<Node> nodes) {
    val visitor = new ValidationVisitor();
    nodes.forEach(n -> n.accept(visitor));
  }
}
