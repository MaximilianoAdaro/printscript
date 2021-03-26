package parser.state.util;

import lexer.model.Token;
import parser.node.interfaces.Calculable;

import java.util.ArrayList;
import java.util.List;

public class StateUtils {

    public static List<Token> addToList(List<Token> tokens, Token token) {
        List<Token> list = new ArrayList<>(tokens);
        list.add(token);
        return list;
    }

    public static Calculable makeTree(List<Token> tokens) {
//        OperandNode operandNode = (OperandNode) tokens.get(1);
//        operandNode.setLeftNode(tokens.get(0));
//        operandNode.setLeftNode(tokens.get(2));
        return null;
    }

}
