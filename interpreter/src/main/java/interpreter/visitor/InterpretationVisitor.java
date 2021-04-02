package interpreter.visitor;

import java.util.HashMap;
import java.util.Map;
import parser.node.impl.AssignationNode;
import parser.node.impl.DeclarationNode;
import parser.node.impl.IdentifierNode;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.interfaces.LiteralValue;

public class InterpretationVisitor extends AbstractNodeVisitor {

  private static Map<String, TypeValue> variables = new HashMap<>();
  private static Map<String, LiteralValue> assignations = new HashMap<>();

  @Override
  public void visit(IdentifierNode identifierNode) {
    final var variableName = identifierNode.getValue();
  }

  @Override
  public void visit(DeclarationNode declarationNode) {
    final var variableName = declarationNode.getIdentifierNode().getValue();
    if (variables.containsKey(variableName)) throw new RuntimeException();
    final var variableType = declarationNode.getTypeValue();
    variables.put(variableName, variableType);
  }

  @Override
  public void visit(AssignationNode assignationNode) {
    assignationNode.getDeclarational().accept(this);
    final var value = assignationNode.getCalculable().calculate(this);
  }
}
