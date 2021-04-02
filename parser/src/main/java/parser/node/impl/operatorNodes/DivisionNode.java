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
public class DivisionNode extends OperatorNode {

  @Builder
  public DivisionNode(Calculable rightNode, Calculable leftNode) {
    super(rightNode, leftNode);
  }

  @Override
  public LiteralValue calculate(NodeVisitor nodeVisitor) {
    //        return leftNode.calculate() / rightNode.calculate();
    return null;
  }

  @Override
  public Calculable resolveTree(OperatorNode operator, Calculable operand) {
    return resolveTreeAsMulAndDiv(operator, operand);
  }

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }
}
