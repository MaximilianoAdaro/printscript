package parser.node.impl.operatorNodes;

import lexer.model.Position;
import lombok.*;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Data
public class LessEqualNode extends OperatorNode {

  @Builder
  public LessEqualNode(Position position, Calculable rightNode, Calculable leftNode) {
    super(position, rightNode, leftNode);
  }

  public LessEqualNode(Position position) {
    super(position);
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
