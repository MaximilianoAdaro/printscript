package parser.node.impl;

import lombok.*;
import parser.node.AbstractNode;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.DeclarationalNode;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssignationNode extends AbstractNode {

  private Calculable calculable;
  private DeclarationalNode declarational;

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }
}
