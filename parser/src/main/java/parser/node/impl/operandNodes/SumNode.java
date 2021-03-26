package parser.node.impl.operandNodes;

import lombok.Data;
import lombok.EqualsAndHashCode;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = true)
@Data
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
