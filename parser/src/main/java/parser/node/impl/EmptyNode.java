package parser.node.impl;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import parser.node.impl.literalNodes.StringLiteralValue;
import parser.node.impl.operatorNodes.OperatorNode;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@Data
@Builder
@NoArgsConstructor
public class EmptyNode implements Calculable {

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
