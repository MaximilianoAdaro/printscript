package interpreter.utils;

import static parser.node.impl.literalNodes.TypeValue.NUMBER;

import interpreter.exception.InterpreterException;
import parser.node.impl.literalNodes.NumberLiteralValue;
import parser.node.impl.literalNodes.StringLiteralValue;
import parser.node.impl.operatorNodes.DivisionNode;
import parser.node.impl.operatorNodes.MinusNode;
import parser.node.impl.operatorNodes.MultiplyNode;
import parser.node.interfaces.LiteralValue;

public class OperatorUtils {
  public static LiteralValue calculateSum(LiteralValue left, LiteralValue right) {
    final var valueL = left.getValue();
    final var valueR = right.getValue();
    if (left.getTypeValue() == NUMBER && right.getTypeValue() == NUMBER)
      return new NumberLiteralValue((double) valueL + (double) valueR);
    return new StringLiteralValue(valueL.toString() + valueR.toString());
  }

  public static LiteralValue calculateMinus(
      LiteralValue left, LiteralValue right, MinusNode minusNode) {
    if (left.getTypeValue() == NUMBER && right.getTypeValue() == NUMBER) {
      return new NumberLiteralValue((double) left.getValue() - (double) right.getValue());
    }
    throw InterpreterException.invalidOp(left, right, minusNode);
  }

  public static LiteralValue calculateDivision(
      LiteralValue left, LiteralValue right, DivisionNode divisionNode) {
    if (left.getTypeValue() == NUMBER && right.getTypeValue() == NUMBER) {
      return new NumberLiteralValue((double) left.getValue() / (double) right.getValue());
    }
    throw InterpreterException.invalidOp(left, right, divisionNode);
  }

  public static LiteralValue calculateMultiply(
      LiteralValue left, LiteralValue right, MultiplyNode multiplyNode) {
    if (left.getTypeValue() == NUMBER && right.getTypeValue() == NUMBER) {
      return new NumberLiteralValue((double) left.getValue() * (double) right.getValue());
    }
    throw InterpreterException.invalidOp(left, right, multiplyNode);
  }
}
