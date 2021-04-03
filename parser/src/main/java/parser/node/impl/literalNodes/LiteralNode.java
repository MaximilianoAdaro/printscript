package parser.node.impl.literalNodes;

import lombok.*;
import parser.node.AbstractNode;
import parser.node.impl.operatorNodes.OperatorNode;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LiteralNode extends AbstractNode implements Calculable {

  private LiteralValue literalValue;

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }

  @Override
  public LiteralValue calculate(NodeVisitor nodeVisitor) {
    return literalValue;
  }

  @Override
  public Calculable resolveTree(OperatorNode operator, Calculable operand) {
    operator.setLeftNode(this);
    operator.setRightNode(operand);
    return operator;
  }
}
