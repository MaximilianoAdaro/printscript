package node;

import node.visitor.NodeVisitor;

public interface Node {

    void accept(NodeVisitor nodeVisitor);

}
