package utils;

import java.util.List;

public class CharacterUtils {

    public static boolean isSemicolon(Character c) {
        return c == ';';
    }

    public static boolean isMathSymbol(Character c) {
        return List.of('=', '+', '-', '*', '/').contains(c);
    }

    public static boolean isSymbol(Character c) {
        return List.of('(', ')', ':', ';').contains(c);
    }

    public static boolean isStringSymbol(Character c) {
        return List.of('"', '\'').contains(c);
    }

    public static boolean isAnySymbol(Character c) {
        return isMathSymbol(c) || isSymbol(c);
    }

    public static boolean isNumber(Character c) {
        return Character.isDigit(c);
    }

    public static boolean isWhitespace(Character c) {
        return Character.isWhitespace(c);
    }

    public static boolean isLetter(Character c) {
        return Character.isLetter(c);
    }
}
