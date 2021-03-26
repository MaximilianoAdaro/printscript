package parser.node.interfaces;

import parser.node.Node;

public interface Calculable extends Node {

    LiteralValue calculate();
}
