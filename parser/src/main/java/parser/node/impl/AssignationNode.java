package parser.node.impl;

import lexer.model.Position;
import lombok.*;
import parser.node.AbstractNode;
import parser.node.impl.declarationNodes.DeclarationalNode;
import parser.node.interfaces.Calculable;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Data
public class AssignationNode extends AbstractNode {

  private Calculable calculable;
  private DeclarationalNode declarational;

  @Builder
  public AssignationNode(
      Position position, Calculable calculable, DeclarationalNode declarational) {
    super(position);
    this.calculable = calculable;
    this.declarational = declarational;
  }

  public AssignationNode(Position position) {
    super(position);
  }

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }
}
