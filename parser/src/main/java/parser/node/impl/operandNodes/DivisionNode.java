package parser.node.impl.operandNodes;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class DivisionNode extends OperandNode {

    @Builder
    public DivisionNode(Calculable rightNode, Calculable leftNode) {
        super(rightNode, leftNode);
    }

    @Override
    public LiteralValue calculate() {
//        return leftNode.calculate() / rightNode.calculate();
        return null;
    }

    @Override
    public Calculable resolveTree(OperandNode operator, Calculable operand) {
        return resolveTreeAsMulAndDiv(operator, operand);
    }

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }
}
