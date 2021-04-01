package parser.node.impl;

import lombok.Builder;
import lombok.Data;
import parser.node.impl.operandNodes.OperatorNode;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.Declarational;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@Data
@Builder
public class IdentifierNode implements Calculable, Declarational {

  private final String value;

  public IdentifierNode(String value) {
    this.value = value;
  }

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }

  @Override
  public LiteralValue calculate() {
    // todo: find in all assigment the value for this identity
    return null;
  }

  @Override
  public Calculable resolveTree(OperatorNode operator, Calculable operand) {
    operator.setLeftNode(this);
    operator.setRightNode(operand);
    return operator;
  }
}
