package interpreter.visitor;

import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.val;
import parser.node.impl.AssignationNode;
import parser.node.impl.DeclarationNode;
import parser.node.impl.IdentifierNode;
import parser.node.impl.literalNodes.NumberLiteralValue;
import parser.node.impl.literalNodes.StringLiteralValue;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.interfaces.LiteralValue;

public class InterpretationVisitor extends AbstractNodeVisitor {

  @Data
  @AllArgsConstructor
  class Variable {
    private TypeValue typeValue;
    private LiteralValue literalValue;
  }

  private static Map<String, Variable> variables = new HashMap<>();

  @Override
  public void visit(IdentifierNode identifierNode) {
    final var variableName = identifierNode.getValue();
  }

  @Override
  public void visit(DeclarationNode declarationNode) {
    final var variableName = declarationNode.getIdentifierNode().getValue();
    if (variables.containsKey(variableName)) throw new RuntimeException();
    final var variableType = declarationNode.getTypeValue();
    val literalValue =
        switch (variableType) {
          case NUMBER -> new NumberLiteralValue(0);
          case STRING -> new StringLiteralValue("");
        };
    variables.put(variableName, new Variable(variableType, literalValue));
  }

  @Override
  public void visit(AssignationNode assignationNode) {
    assignationNode.getDeclarational().accept(this);
    final var value = assignationNode.getCalculable().calculate(this);
  }
}
