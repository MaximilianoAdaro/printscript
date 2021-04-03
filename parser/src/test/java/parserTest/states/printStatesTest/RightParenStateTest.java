package parserTest.states.printStatesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static utils.NodeUtils.*;

import java.util.List;
import lexer.LexerImpl;
import lexer.model.Token;
import org.junit.Test;
import parser.ParserImpl;
import parser.node.Node;
import parser.node.impl.PrintNode;

public class RightParenStateTest {

  @Test
  public void toRightParenSate_whenThoRightParenFromLeftParen_shouldReturnPrintNode() {
    String text = "println( ));";
    List<Token> tokens = LexerImpl.lex(text);
    assertThatThrownBy(() -> ParserImpl.parse(tokens)).isInstanceOf(RuntimeException.class);
  }

  @Test
  public void toRightParenSate_fromLeftParen_shouldReturnPrintNode() {
    String text = "println( );";
    List<Token> tokens = LexerImpl.lex(text);
    List<Node> nodes = ParserImpl.parse(tokens);
    assertThat(nodes).hasSize(1);
    Node node = nodes.get(0);
    assertThat(node).hasSameClassAs(new PrintNode());
    assertThat(node).isEqualTo(printNode(emptyNode()));
  }

  @Test
  public void resolveOperatorPrint_whenComingFromIdentified_shouldReturnPrintNode() {
    String text = "println(x);";
    List<Token> tokens = LexerImpl.lex(text);
    List<Node> parse = ParserImpl.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new PrintNode());
    assertThat(nodeX).isEqualTo(printNode(identifierNode("x")));
  }

  @Test
  public void resolveOperatorPrint_whenComingFromNumValue_shouldReturnPrintNode() {
    String text = "println(123);";
    List<Token> tokens = LexerImpl.lex(text);
    List<Node> parse = ParserImpl.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new PrintNode());
    assertThat(nodeX).isEqualTo(printNode(numbValueNode(123)));
  }

  @Test
  public void resolveOperatorPrint_whenComingFromStrValue_shouldReturnPrintNode() {
    String text = "println(\"anString\");";
    List<Token> tokens = LexerImpl.lex(text);
    List<Node> parse = ParserImpl.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new PrintNode());
    assertThat(nodeX).isEqualTo(printNode(strValueNode("anString")));
  }

  @Test
  public void resolveOperatorPrint_whenComingFromOperators_shouldReturnPrintNode() {
    String text = "println(\"anString\" + str + x + 123);";
    List<Token> tokens = LexerImpl.lex(text);
    List<Node> parse = ParserImpl.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new PrintNode());
    assertThat(nodeX)
        .isEqualTo(
            printNode(
                sumNode(
                    strValueNode("anString"),
                    sumNode(
                        identifierNode("str"), sumNode(identifierNode("x"), numbValueNode(123))))));
  }
}
