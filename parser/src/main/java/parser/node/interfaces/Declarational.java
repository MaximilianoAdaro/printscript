package parser.node.interfaces;

import parser.node.Node;
import parser.node.impl.IdentifierNode;

public interface Declarational extends Node {

  IdentifierNode getIdentifierNode();
}
