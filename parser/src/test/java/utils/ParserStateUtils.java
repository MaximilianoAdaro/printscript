package utils;

import lexer.model.Token;
import lexer.model.TokenType;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.Declarational;
import parser.state.impls.*;
import parser.state.impls.declarationStates.ColonState;
import parser.state.impls.declarationStates.DeclarationState;
import parser.state.impls.declarationStates.IdentifierState;
import parser.state.impls.declarationStates.TypeState;
import parser.state.impls.printStates.*;

import java.util.List;

public class ParserStateUtils {

    // create ColonState
    public static ColonState colonState(Token token) {
        return ColonState.builder()
                .token(token)
                .build();
    }

    // create DeclarationState
    public static DeclarationState declState() {
        return DeclarationState.builder()
                .build();
    }

    // create IdentifierState
    public static IdentifierState identState(Token token) {
        return IdentifierState.builder()
                .token(token)
                .build();
    }

    // create TypeState
    public static TypeState typeState(Token token, TokenType tokenType) {
        return TypeState.builder()
                .token(token)
                .tokenType(tokenType)
                .build();
    }

    // create IdentifiedPrintState
    public static IdentifiedPrintState identPrintState(List<Token> tokens) {
        return IdentifiedPrintState.builder()
                .tokens(tokens)
                .build();
    }

    // create LeftParenState
    public static LeftParenState leftPState() {
        return LeftParenState.builder()
                .build();
    }

    // create OperandPrintState
    public static OperandPrintState operandPrintState(List<Token> tokens) {
        return OperandPrintState.builder()
                .tokens(tokens)
                .build();
    }

    // create PrintState
    public static PrintState printState() {
        return PrintState.builder()
                .build();
    }

    // create RightParenState
    public static RightParenState rightParenState(Calculable calculable) {
        return RightParenState.builder()
                .calculable(calculable)
                .build();
    }

    // create ValuePrintState
    public static ValuePrintState valuePrintState(List<Token> tokens) {
        return ValuePrintState.builder()
                .tokens(tokens)
                .build();
    }

    // create AssignationState
    public static AssignationState assiState(Declarational declarational) {
        return AssignationState.builder()
                .declarational(declarational)
                .build();
    }

    // create EmptyState
    public static EmptyState emptyState(Declarational declarational) {
        return EmptyState.builder()
                .build();
    }

    // create IdentifiedState
    public static IdentifiedState identState(Declarational declarational, List<Token> tokens) {
        return IdentifiedState.builder()
                .declarational(declarational)
                .tokens(tokens)
                .build();
    }

    // create IdentifierAssignationState
    public static IdentifierAssignationState identAssignState() {
        return IdentifierAssignationState.builder()
                .build();
    }

    // create OperandState
    public static OperandState operandState(Declarational declarational, List<Token> tokens) {
        return OperandState.builder()
                .tokens(tokens)
                .declarational(declarational)
                .build();
    }

    // create ValueState
    public static ValueState valueState(Declarational declarational, List<Token> tokens) {
        return ValueState.builder()
                .tokens(tokens)
                .declarational(declarational)
                .build();
    }

}
