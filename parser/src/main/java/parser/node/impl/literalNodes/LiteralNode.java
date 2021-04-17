package parser.node.impl.literalNodes;

import lexer.model.Position;
import lombok.*;
import parser.node.AbstractNode;
import parser.node.impl.operatorNodes.OperatorNode;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = false)
@Data
public class LiteralNode extends AbstractNode implements Calculable {

  private LiteralValue literalValue;

  @Builder
  public LiteralNode(Position position, LiteralValue literalValue) {
    super(position);
    this.literalValue = literalValue;
  }

  public LiteralNode(Position position) {
    super(position);
  }

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
