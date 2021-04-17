package parser.state.util;

import lexer.model.Token;
import parser.exception.ParserException;
import parser.node.impl.declarationNodes.IdentifierNode;
import parser.node.impl.literalNodes.BooleanLiteralValue;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.literalNodes.NumberLiteralValue;
import parser.node.impl.literalNodes.StringLiteralValue;
import parser.node.impl.operatorNodes.*;
import parser.node.interfaces.Calculable;

public class CalculableUtils {

  static Calculable getNode(Token token) {
    return switch (token.getTokenType()) {
      case PLUS -> new SumNode(token.getPosition());
      case MINUS -> new MinusNode(token.getPosition());
      case MULTIPLY -> new MultiplyNode(token.getPosition());
      case DIVIDE -> new DivisionNode(token.getPosition());
      case STRING -> new LiteralNode(token.getPosition(), new StringLiteralValue(token.getValue()));
      case NUMBER -> new LiteralNode(
          token.getPosition(), new NumberLiteralValue(Double.parseDouble(token.getValue())));
      case BOOLEAN -> new LiteralNode(
          token.getPosition(), new BooleanLiteralValue(Boolean.parseBoolean(token.getValue())));
      case IDENTIFIER -> new IdentifierNode(token.getPosition(), token.getValue());
      default -> throw ParserException.unexpectedToken(token);
    };
  }

  static Calculable getBoolOpNode(Token token, Calculable left, Calculable right) {
    return switch (token.getTokenType()) {
      case GREATER -> GreaterNode.builder().leftNode(left).rightNode(right).build();
      case GREATER_EQUAL -> GreaterEqualNode.builder().leftNode(left).rightNode(right).build();
      case LESS -> LessNode.builder().leftNode(left).rightNode(right).build();
      case LESS_EQUAL -> LessEqualNode.builder().leftNode(left).rightNode(right).build();
      default -> throw ParserException.unexpectedToken(token);
    };
  }
}
