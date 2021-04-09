package parserTest.states.assignationStatesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static parser.node.impl.literalNodes.TypeValue.NUMBER;
import static parser.node.impl.literalNodes.TypeValue.STRING;
import static utils.NodeUtils.*;

import java.util.List;
import lexer.Lexer;
import lexer.model.Token;
import org.junit.Test;
import parser.Parser;
import parser.node.Node;
import parser.node.impl.AssignationNode;

public class ValueStateTest {

  @Test
  public void
      toValueState_whenComingFromStringDeclarationAndNoOperator_shouldReturnAssignationNode() {
    String text = "let x: string = \"asd\";";
    List<Token> tokens = Lexer.lex(text);
    List<Node> parse = Parser.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new AssignationNode());
    assertThat(nodeX)
        .isEqualTo(assignNode(declNode(identifierNode("x"), STRING), strValueNode("asd")));
  }

  @Test
  public void
      toValueState_whenComingFromNumberDeclarationAndNoOperator_shouldReturnAssignationNode() {
    String text = "let x: number = 132.3;";
    List<Token> tokens = Lexer.lex(text);
    List<Node> parse = Parser.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new AssignationNode());
    assertThat(nodeX)
        .isEqualTo(assignNode(declNode(identifierNode("x"), NUMBER), numbValueNode(132.3)));
  }

  @Test
  public void toValueState_whenComingFromIdentifierAndNoOperator_shouldReturnAssignationNode() {
    String text = "x = 433.142;";
    List<Token> tokens = Lexer.lex(text);
    List<Node> parse = Parser.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new AssignationNode());
    assertThat(nodeX).isEqualTo(assignNode(identifierNode("x"), numbValueNode(433.142)));
  }
}
