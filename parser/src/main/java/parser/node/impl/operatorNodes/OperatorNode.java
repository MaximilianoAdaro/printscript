package parser.node.impl.operatorNodes;

import lexer.model.Position;
import lombok.*;
import parser.node.AbstractNode;
import parser.node.interfaces.Calculable;

@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Data
public abstract class OperatorNode extends AbstractNode implements Calculable {

  private Calculable rightNode;
  private Calculable leftNode;

  public OperatorNode(Position position, Calculable rightNode, Calculable leftNode) {
    super(position);
    this.rightNode = rightNode;
    this.leftNode = leftNode;
  }

  public OperatorNode(Position position) {
    super(position);
  }

  public Calculable resolveTreeAsSumAndMin(OperatorNode operator, Calculable operand) {
    this.setRightNode(this.getRightNode().resolveTree(operator, operand));
    return this;
  }

  public Calculable resolveTreeAsMulAndDiv(OperatorNode operator, Calculable operand) {
    operator.setLeftNode(this);
    operator.setRightNode(operand);
    return operator;
  }
}
