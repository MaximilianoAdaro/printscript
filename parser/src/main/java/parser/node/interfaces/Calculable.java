package parser.node.interfaces;

import parser.node.impl.operatorNodes.OperatorNode;
import parser.node.visitor.NodeVisitor;

public interface Calculable {

  LiteralValue calculate(NodeVisitor nodeVisitor);

  Calculable resolveTree(OperatorNode operator, Calculable operand);
}
