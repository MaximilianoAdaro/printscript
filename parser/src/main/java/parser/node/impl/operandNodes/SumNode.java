package parser.node.impl.operandNodes;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class SumNode extends OperandNode {

    @Builder
    public SumNode(Calculable rightNode, Calculable leftNode) {
        super(rightNode, leftNode);
    }

    @Override
    public LiteralValue calculate() {
//        return leftNode.calculate() + rightNode.calculate();
        return null;
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    @Override
    public Calculable resolveTree(OperandNode operator, Calculable operand) {
        return resolveTreeAsSumAndMin(operator, operand);
    }
}
