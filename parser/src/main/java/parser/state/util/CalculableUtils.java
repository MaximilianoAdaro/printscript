package parser.state.util;

import lexer.model.Token;
import parser.node.impl.IdentifierNode;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.literalNodes.NumberLiteralValue;
import parser.node.impl.literalNodes.StringLiteralValue;
import parser.node.impl.operatorNodes.DivisionNode;
import parser.node.impl.operatorNodes.MinusNode;
import parser.node.impl.operatorNodes.MultiplyNode;
import parser.node.impl.operatorNodes.SumNode;
import parser.node.interfaces.Calculable;

public class CalculableUtils {

  static Calculable getNode(Token token) {
    return switch (token.getTokenType()) {
      case PLUS -> new SumNode();
      case MINUS -> new MinusNode();
      case MULTIPLY -> new MultiplyNode();
      case DIVIDE -> new DivisionNode();
      case STRING -> new LiteralNode(new StringLiteralValue(token.getValue()));
      case NUMBER -> new LiteralNode(new NumberLiteralValue(Double.parseDouble(token.getValue())));
      case IDENTIFIER -> new IdentifierNode(token.getValue());
      default -> throw new IllegalStateException("Unexpected value: " + token.getTokenType());
    };
  }
}
