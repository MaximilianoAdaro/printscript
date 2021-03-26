package parser.node.impl.operandNodes;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import parser.node.interfaces.Calculable;

@NoArgsConstructor
@AllArgsConstructor
public abstract class OperandNode implements Calculable {

    private Calculable rightNode;
    private Calculable leftNode;

}
