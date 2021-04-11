package parser.node.impl.operatorNodes;

import lombok.*;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
@AllArgsConstructor
public class GreaterNode extends OperatorNode {

  @Builder
  public GreaterNode(Calculable rightNode, Calculable leftNode) {
    super(rightNode, leftNode);
  }

  @Override
  public void accept(NodeVisitor nodeVisitor) {}

  @Override
  public LiteralValue calculate(NodeVisitor nodeVisitor) {
    return nodeVisitor.visit(this);
  }

  @Override
  public Calculable resolveTree(OperatorNode operator, Calculable operand) {
    throw new RuntimeException("NOPE");
  }
}
