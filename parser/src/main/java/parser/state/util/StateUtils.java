package parser.state.util;

import static parser.state.util.CalculableUtils.getNode;

import java.util.ArrayList;
import java.util.List;
import lexer.model.Token;
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
    Calculable root = getNode(tokens.get(0));
    if (tokens.size() == 1) return root;

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
