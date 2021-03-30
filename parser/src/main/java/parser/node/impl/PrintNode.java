package parser.node.impl;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import parser.node.Node;
import parser.node.interfaces.Calculable;
import parser.node.visitor.NodeVisitor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrintNode implements Node {

  private Calculable calculable;

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }
}
