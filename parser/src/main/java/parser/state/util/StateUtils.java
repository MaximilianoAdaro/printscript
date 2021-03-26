package parser.state.util;

import lexer.model.Token;
import lombok.SneakyThrows;
import parser.node.impl.IdentifierNode;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.literalNodes.NumberLiteralValue;
import parser.node.impl.literalNodes.StringLiteralValue;
import parser.node.interfaces.Calculable;

import java.util.ArrayList;
import java.util.List;

import static jdk.jshell.spi.ExecutionControl.NotImplementedException;

public class StateUtils {

    public static List<Token> addToList(List<Token> tokens, Token token) {
        List<Token> list = new ArrayList<>(tokens);
        list.add(token);
        return list;
    }

    @SneakyThrows
    public static Calculable makeTree(List<Token> tokens) {
        if (tokens.size() == 1) return convert(tokens.get(0));
        throw new NotImplementedException("We are lazy");
    }

    private static Calculable convert(Token token) {
        return switch (token.getTokenType()) {
            case IDENTIFIER -> new IdentifierNode(token.getValue());
            case NUMBER -> new LiteralNode(new NumberLiteralValue(Double.parseDouble(token.getValue())));
            case STRING -> new LiteralNode(new StringLiteralValue(token.getValue()));
            default -> throw new IllegalStateException();
        };
    }


}
