package parser.node.impl.operatorNodes;

import lexer.model.Position;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Data
public class SumNode extends OperatorNode {

  @Builder
  public SumNode(Position position, Calculable rightNode, Calculable leftNode) {
    super(position, rightNode, leftNode);
  }

  public SumNode(Position position) {
    super(position);
  }

  @Override
  public LiteralValue calculate(NodeVisitor visitor) {
    return visitor.visit(this);
  }

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }

  @Override
  public Calculable resolveTree(OperatorNode operator, Calculable operand) {
    return resolveTreeAsSumAndMin(operator, operand);
  }
}
