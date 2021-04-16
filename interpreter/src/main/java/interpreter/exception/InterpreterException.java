package interpreter.exception;

import parser.node.impl.AssignationNode;
import parser.node.impl.declarationNodes.DeclarationNode;
import parser.node.impl.declarationNodes.IdentifierNode;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.impl.operatorNodes.OperatorNode;
import parser.node.interfaces.LiteralValue;

public class InterpreterException extends RuntimeException {

  private InterpreterException(String message) {
    super(message);
  }

  public static InterpreterException alreadyExists(DeclarationNode node) {
    return new InterpreterException(
        "Variable with name "
            + node.getIdentifierNode().getValue()
            + " on line "
            + node.getPosition().getLineStart()
            + " already exists");
  }

  public static InterpreterException invalidType(
      TypeValue varType, LiteralValue literalValue, IdentifierNode identifierNode) {
    return new InterpreterException(
        getStringType(literalValue.getTypeValue())
            + " "
            + literalValue.getValue()
            + " can't be assigned to variable "
            + identifierNode.getValue()
            + " of type "
            + getStringType(varType)
            + " on line "
            + identifierNode.getPosition().getLineStart());
  }

  private static String getStringType(TypeValue varType) {
    return varType.toString().toLowerCase().substring(10);
  }

  public static InterpreterException invalidVar(IdentifierNode identifierNode) {
    return new InterpreterException(
        "Variable with name "
            + identifierNode.getValue()
            + " doesn't exist on line "
            + identifierNode.getPosition().getLineStart());
  }

  public static InterpreterException notInitVar(IdentifierNode identifierNode) {
    return new InterpreterException(
        "Variable with name "
            + identifierNode.getValue()
            + " is not initialized on line "
            + identifierNode.getPosition().getLineStart());
  }

  public static InterpreterException invalidOp(
      LiteralValue left, LiteralValue right, OperatorNode node) {
    return new InterpreterException(
        "Invalid operation with "
            + getStringType(left.getTypeValue())
            + " "
            + left.getValue()
            + " and "
            + getStringType(right.getTypeValue())
            + " "
            + right.getValue()
            + " on line "
            + node.getPosition().getLineStart());
  }

  public static InterpreterException isConst(
      AssignationNode node, String propertyName, LiteralValue literalValue) {
    return new InterpreterException(
        "Cannot reassign constant "
            + propertyName
            + " with value "
            + literalValue.getValue()
            + " on line "
            + node.getPosition().getLineStart());
  }
}
