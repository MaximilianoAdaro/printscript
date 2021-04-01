package parser.node;

import parser.node.visitor.NodeVisitor;

public interface Node {

  void accept(NodeVisitor nodeVisitor);
}
