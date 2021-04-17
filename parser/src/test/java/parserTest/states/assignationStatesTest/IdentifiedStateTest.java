package parserTest.states.assignationStatesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static parser.node.impl.literalNodes.TypeValue.NUMBER;
import static parser.node.impl.literalNodes.TypeValue.STRING;
import static utils.NodeUtils.*;

import java.util.List;
import lexer.Lexer;
import lexer.model.Position;
import lexer.model.Token;
import org.junit.Test;
import parser.Parser;
import parser.node.Node;
import parser.node.impl.AssignationNode;

public class IdentifiedStateTest {

  @Test
  public void
      toIdentifiedState_whenComingFromStringDeclarationAndNoOperator_shouldReturnAssignationNode() {
    String text = "let x: string = y;";
    List<Token> tokens = Lexer.lex(text);
    List<Node> parse = Parser.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new AssignationNode(Position.empty()));
    assertThat(nodeX)
        .isEqualTo(assignNode(declNode(identifierNode("x"), STRING), identifierNode("y")));
  }

  @Test
  public void
      toIdentifiedState_whenComingFromNumberDeclarationAndNoOperator_shouldReturnAssignationNode() {
    String text = "let x: number = y;";
    List<Token> tokens = Lexer.lex(text);
    List<Node> parse = Parser.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new AssignationNode(Position.empty()));
    assertThat(nodeX)
        .isEqualTo(assignNode(declNode(identifierNode("x"), NUMBER), identifierNode("y")));
  }

  @Test
  public void
      toIdentifiedState_whenComingFromIdentifierAndNoOperator_shouldReturnAssignationNode() {
    String text = "x = y;";
    List<Token> tokens = Lexer.lex(text);
    List<Node> parse = Parser.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new AssignationNode(Position.empty()));
    assertThat(nodeX).isEqualTo(assignNode(identifierNode("x"), identifierNode("y")));
  }
}
