package parser.node.impl;

import lexer.model.Position;
import lombok.*;
import parser.node.AbstractNode;
import parser.node.interfaces.Calculable;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Data
public class PrintNode extends AbstractNode {

  private Calculable calculable;

  @Builder
  public PrintNode(Position position, Calculable calculable) {
    super(position);
    this.calculable = calculable;
  }

  public PrintNode(Position position) {
    super(position);
  }

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }
}
