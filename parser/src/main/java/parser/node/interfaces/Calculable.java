package parser.node.interfaces;

import parser.node.Node;
import parser.node.impl.operandNodes.OperandNode;

public interface Calculable extends Node {

    LiteralValue calculate();

    Calculable resolveTree(OperandNode operator, Calculable operand);
}
