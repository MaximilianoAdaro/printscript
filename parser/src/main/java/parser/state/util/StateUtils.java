package parser.state.util;

import static parser.state.util.CalculableUtils.getBoolOpNode;
import static parser.state.util.CalculableUtils.getNode;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import lexer.model.Token;
import lexer.model.TokenType;
import lombok.AllArgsConstructor;
import parser.exception.ParserException;
import parser.node.impl.operatorNodes.OperatorNode;
import parser.node.interfaces.Calculable;

public class StateUtils {

  public static List<Token> addToList(List<Token> tokens, Token token) {
    List<Token> list = new ArrayList<>(tokens);
    list.add(token);
    return list;
  }

  public static Calculable makeTree(List<Token> tokens) {
    if (tokens.isEmpty()) throw new RuntimeException("Cannot be empty");
    if (tokens.size() == 1) return getNode(tokens.get(0));

    final var splitBool = splitInBooleanOperator(tokens);

    final var booleanOp = splitBool.booleanOp;
    final var left = getCalculable(splitBool.left);

    if (booleanOp.isEmpty() || splitBool.right.isEmpty()) return left;

    final var right = getCalculable(splitBool.right.get());

    return getBoolOpNode(booleanOp.get(), left, right);
  }

  @AllArgsConstructor
  static class SplitBool {
    final List<Token> left;
    final Optional<List<Token>> right;
    final Optional<Token> booleanOp;
  }

  private static SplitBool splitInBooleanOperator(List<Token> tokens) {
    final var indexes =
        Stream.of(
                IntStream.of(-1),
                IntStream.range(0, tokens.size()).filter(i -> isBooleanOperator(tokens.get(i))),
                IntStream.of(tokens.size()))
            .flatMapToInt(s -> s)
            .toArray();

    if (indexes.length < 3) return new SplitBool(tokens, Optional.empty(), Optional.empty());

    if (indexes.length > 3) {
      final var invalid = tokens.get(indexes[2]);
      throw ParserException.unexpectedToken(invalid);
    }

    final var booleanOp = tokens.get(indexes[1]);

    final var collect =
        IntStream.range(0, indexes.length - 1)
            .mapToObj(i -> tokens.subList(indexes[i] + 1, indexes[i + 1]))
            .collect(Collectors.toList());

    final var left = collect.get(0);
    final var right = Optional.of(collect.get(1));

    return new SplitBool(left, right, Optional.of(booleanOp));
  }

  private static boolean isBooleanOperator(Token token) {
    return List.of(TokenType.LESS, TokenType.LESS_EQUAL, TokenType.GREATER, TokenType.GREATER_EQUAL)
        .contains(token.getTokenType());
  }

  private static Calculable getCalculable(List<Token> tokens) {
    Calculable root = getNode(tokens.get(0));
    for (int i = 1; i < tokens.size(); i = i + 2) {
      root = resolveTree(root, getNode(tokens.get(i)), getNode(tokens.get(i + 1)));
    }

    return root;
  }

  private static Calculable resolveTree(
      Calculable rootTree, Calculable operator, Calculable operand) {
    return rootTree.resolveTree((OperatorNode) operator, operand);
  }
}
