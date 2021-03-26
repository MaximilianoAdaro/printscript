package parser.state.util;

import jdk.jshell.spi.ExecutionControl;
import lexer.model.Token;
import lombok.SneakyThrows;
import parser.node.impl.operandNodes.OperandNode;
import parser.node.interfaces.Calculable;

import java.util.ArrayList;
import java.util.List;

import static parser.state.util.CalculableUtils.getNode;

public class StateUtils {

    public static List<Token> addToList(List<Token> tokens, Token token) {
        List<Token> list = new ArrayList<>(tokens);
        list.add(token);
        return list;
    }

    //TODO: implement this
    @SneakyThrows
    public static Calculable makeTree(List<Token> tokens) {
        if (tokens.size() == 1) return getNode(tokens.get(0));
        if (tokens.size() == 3) {
            OperandNode node = (OperandNode) getNode(tokens.get(1));
            node.setLeftNode(getNode(tokens.get(0)));
            node.setRightNode(getNode(tokens.get(2)));
            return node;
        }
        throw new ExecutionControl.NotImplementedException("We are lazy");
    }

}
