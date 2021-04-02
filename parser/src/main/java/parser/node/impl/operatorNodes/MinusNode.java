package parser.node.impl.operatorNodes;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@ToString(callSuper = true)
public class MinusNode extends OperatorNode {

  @Builder
  public MinusNode(Calculable rightNode, Calculable leftNode) {
    super(rightNode, leftNode);
  }

  @Override
  public LiteralValue calculate(NodeVisitor nodeVisitor) {
    return nodeVisitor.visit(this);
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
