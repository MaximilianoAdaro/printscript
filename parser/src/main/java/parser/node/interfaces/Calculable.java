package parser.node.interfaces;

import parser.node.Node;
import parser.node.impl.operatorNodes.OperatorNode;

public interface Calculable extends Node {

  LiteralValue calculate();

  Calculable resolveTree(OperatorNode operator, Calculable operand);
}
