package parser.node.impl;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.node.impl.operatorNodes.OperatorNode;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.DeclarationalNode;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
public class IdentifierNode extends DeclarationalNode implements Calculable {

  private final String value;

  public IdentifierNode(String value) {
    this.value = value;
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
