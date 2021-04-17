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
public class MultiplyNode extends OperatorNode {

  @Builder
  public MultiplyNode(Position position, Calculable rightNode, Calculable leftNode) {
    super(position, rightNode, leftNode);
  }

  public MultiplyNode(Position position) {
    super(position);
  }

  @Override
  public LiteralValue calculate(NodeVisitor nodeVisitor) {
    return nodeVisitor.visit(this);
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
