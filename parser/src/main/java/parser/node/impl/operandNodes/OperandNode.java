package parser.node.impl.operandNodes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import parser.node.interfaces.Calculable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class OperandNode implements Calculable {

    private Calculable rightNode;
    private Calculable leftNode;

}
