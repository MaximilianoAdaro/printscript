package node.impl.operandNodes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import node.interfaces.Calculable;
import node.interfaces.LiteralValue;
import node.visitor.NodeVisitor;

public class SumNode extends OperandNode {

    @Override
    public LiteralValue calculate() {
//        return leftNode.calculate() + rightNode.calculate();
        return null;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
