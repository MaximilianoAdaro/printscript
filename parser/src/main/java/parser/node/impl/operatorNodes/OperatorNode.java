package parser.node.impl.operatorNodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parser.node.interfaces.Calculable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class OperatorNode implements Calculable {

  private Calculable rightNode;
  private Calculable leftNode;

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
