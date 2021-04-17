package parser.node.impl;

import java.util.List;
import lexer.model.Position;
import lombok.*;
import parser.node.AbstractNode;
import parser.node.Node;
import parser.node.interfaces.Calculable;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
@Data
public class ConditionNode extends AbstractNode {

  private Calculable condition;
  private List<Node> ifTrue;
  private List<Node> ifFalse;

  @Builder
  public ConditionNode(
      Position position, Calculable condition, List<Node> ifTrue, List<Node> ifFalse) {
    super(position);
    this.condition = condition;
    this.ifTrue = ifTrue;
    this.ifFalse = ifFalse;
  }

  public ConditionNode(Position position) {
    super(position);
  }

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }
}
