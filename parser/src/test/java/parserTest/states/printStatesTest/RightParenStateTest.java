package parserTest.states.printStatesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.NodeUtils.*;

import java.util.List;
import lexer.Lexer;
import lexer.model.Position;
import lexer.model.Token;
import org.junit.Test;
import parser.Parser;
import parser.node.Node;
import parser.node.impl.PrintNode;

public class RightParenStateTest {

  //  @Test
  //  public void toRightParenSate_whenThoRightParenFromLeftParen_shouldReturnPrintNode() {
  //    String text = "println( ));";
  //    List<Token> tokens = Lexer.lex(text);
  //    assertThatThrownBy(() -> Parser.parse(tokens))
  //        .isInstanceOf(ParserException.class)
  //        .hasMessage("Unexpected value at line 1 and column 11 -> )");
  //  }

  @Test
  public void toRightParenSate_fromLeftParen_shouldReturnPrintNode() {
    String text = "println( );";
    List<Token> tokens = Lexer.lex(text);
    List<Node> nodes = Parser.parse(tokens);
    assertThat(nodes).hasSize(1);
    Node node = nodes.get(0);
    assertThat(node).hasSameClassAs(new PrintNode(Position.empty()));
    assertThat(node).isEqualTo(printNode(emptyNode()));
  }

  @Test
  public void resolveOperatorPrint_whenComingFromIdentified_shouldReturnPrintNode() {
    String text = "println(x);";
    List<Token> tokens = Lexer.lex(text);
    List<Node> parse = Parser.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new PrintNode(Position.empty()));
    assertThat(nodeX).isEqualTo(printNode(identifierNode("x")));
  }

  @Test
  public void resolveOperatorPrint_whenComingFromNumValue_shouldReturnPrintNode() {
    String text = "println(123);";
    List<Token> tokens = Lexer.lex(text);
    List<Node> parse = Parser.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new PrintNode(Position.empty()));
    assertThat(nodeX).isEqualTo(printNode(numbValueNode(123)));
  }

  @Test
  public void resolveOperatorPrint_whenComingFromStrValue_shouldReturnPrintNode() {
    String text = "println(\"anString\");";
    List<Token> tokens = Lexer.lex(text);
    List<Node> parse = Parser.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new PrintNode(Position.empty()));
    assertThat(nodeX).isEqualTo(printNode(strValueNode("anString")));
  }

  @Test
  public void resolveOperatorPrint_whenComingFromOperators_shouldReturnPrintNode() {
    String text = "println(\"anString\" + str + x + 123);";
    List<Token> tokens = Lexer.lex(text);
    List<Node> parse = Parser.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new PrintNode(Position.empty()));
    assertThat(nodeX)
        .isEqualTo(
            printNode(
                sumNode(
                    strValueNode("anString"),
                    sumNode(
                        identifierNode("str"), sumNode(identifierNode("x"), numbValueNode(123))))));
  }
}
