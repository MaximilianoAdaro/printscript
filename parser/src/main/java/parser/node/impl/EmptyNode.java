package parser.node.impl;

import lexer.model.Position;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import parser.node.AbstractNode;
import parser.node.impl.literalNodes.StringLiteralValue;
import parser.node.impl.operatorNodes.OperatorNode;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Data
public class EmptyNode extends AbstractNode implements Calculable {

  @Builder
  public EmptyNode(Position position) {
    super(position);
  }

  @Override
  public LiteralValue calculate(NodeVisitor nodeVisitor) {
    return new StringLiteralValue("");
  }

  @Override
  public Calculable resolveTree(OperatorNode operator, Calculable operand) {
    throw new RuntimeException("Aca no puede llegar");
  }

  @Override
  public void accept(NodeVisitor nodeVisitor) {}
}
