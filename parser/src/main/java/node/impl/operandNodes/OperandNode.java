package node.impl.operandNodes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import node.interfaces.Calculable;
import node.visitor.NodeVisitor;

@NoArgsConstructor
@AllArgsConstructor
public abstract class OperandNode implements Calculable {

    private Calculable rightNode;
    private Calculable leftNode;

}
