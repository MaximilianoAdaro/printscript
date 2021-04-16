package parser.node.impl;

import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.node.AbstractNode;
import parser.node.Node;
import parser.node.interfaces.Calculable;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = true)
@Data
public class ConditionNode extends AbstractNode {

  private final Calculable condition;
  private final List<Node> ifTrue;
  private final List<Node> ifFalse;

  @Override
  public void accept(NodeVisitor nodeVisitor) {
    nodeVisitor.visit(this);
  }
}
