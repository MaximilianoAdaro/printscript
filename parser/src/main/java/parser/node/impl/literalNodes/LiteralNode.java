package parser.node.impl.literalNodes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import parser.node.impl.operandNodes.OperandNode;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.LiteralValue;
import parser.node.visitor.NodeVisitor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class LiteralNode implements Calculable {

    private LiteralValue literalValue;

    @Override
    public void accept(NodeVisitor nodeVisitor) {
        nodeVisitor.visit(this);
    }

    @Override
    public LiteralValue calculate() {
        return literalValue;
    }

    @Override
    public Calculable resolveTree(OperandNode operator, Calculable operand) {
        operator.setLeftNode(this);
        operator.setRightNode(operand);
        return operator;
    }
}
