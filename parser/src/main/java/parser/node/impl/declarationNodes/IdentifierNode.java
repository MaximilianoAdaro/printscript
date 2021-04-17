package parser.node.impl.declarationNodes;

import lexer.model.Position;
import lombok.*;
import parser.node.impl.operatorNodes.OperatorNode;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Data
public class IdentifierNode extends DeclarationalNode implements Calculable {

  private String value;

  @Builder
  public IdentifierNode(Position position, String value) {
    super(position);
    this.value = value;
  }

  public IdentifierNode(Position position) {
    super(position);
  }

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }

  @Override
  public LiteralValue calculate(NodeVisitor visitor) {
    return visitor.visit(this);
  }

  @Override
  public Calculable resolveTree(OperatorNode operator, Calculable operand) {
    operator.setLeftNode(this);
    operator.setRightNode(operand);
    return operator;
  }

  @Override
  public IdentifierNode getIdentifierNode() {
    return this;
  }
}
