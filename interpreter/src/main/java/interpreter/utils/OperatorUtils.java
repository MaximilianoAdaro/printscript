package interpreter.utils;

import static parser.node.impl.literalNodes.TypeValue.NUMBER;

import interpreter.exception.InterpreterException;
import parser.node.impl.literalNodes.BooleanLiteralValue;
import parser.node.impl.literalNodes.NumberLiteralValue;
import parser.node.impl.literalNodes.StringLiteralValue;
import parser.node.impl.operatorNodes.*;
import parser.node.interfaces.LiteralValue;

public class OperatorUtils {
  public static LiteralValue calculateSum(LiteralValue left, LiteralValue right) {
    final var valueL = left.getValue();
    final var valueR = right.getValue();
    if (left.getTypeValue() == NUMBER && right.getTypeValue() == NUMBER)
      return new NumberLiteralValue((double) valueL + (double) valueR);
    return new StringLiteralValue(left.toString() + right);
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

  public static LiteralValue calculateLessEqual(
      LiteralValue left, LiteralValue right, LessEqualNode lessEqualNode) {
    if (left.getTypeValue() == NUMBER && right.getTypeValue() == NUMBER) {
      return new BooleanLiteralValue((double) left.getValue() <= (double) right.getValue());
    }
    throw InterpreterException.invalidOp(left, right, lessEqualNode);
  }

  public static LiteralValue calculateLess(
      LiteralValue left, LiteralValue right, LessNode lessNode) {
    if (left.getTypeValue() == NUMBER && right.getTypeValue() == NUMBER) {
      return new BooleanLiteralValue((double) left.getValue() < (double) right.getValue());
    }
    throw InterpreterException.invalidOp(left, right, lessNode);
  }

  public static LiteralValue calculateGreaterEqual(
      LiteralValue left, LiteralValue right, GreaterEqualNode greaterEqualNode) {
    if (left.getTypeValue() == NUMBER && right.getTypeValue() == NUMBER) {
      return new BooleanLiteralValue((double) left.getValue() >= (double) right.getValue());
    }
    throw InterpreterException.invalidOp(left, right, greaterEqualNode);
  }

  public static LiteralValue calculateGreater(
      LiteralValue left, LiteralValue right, GreaterNode greaterNode) {
    if (left.getTypeValue() == NUMBER && right.getTypeValue() == NUMBER) {
      return new BooleanLiteralValue((double) left.getValue() > (double) right.getValue());
    }
    throw InterpreterException.invalidOp(left, right, greaterNode);
  }
}
