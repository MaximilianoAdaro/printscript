package parserTest.states.assignationStatesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static utils.NodeUtils.*;

import java.util.List;
import lexer.LexerImpl;
import lexer.model.Token;
import org.junit.Test;
import parser.ParserImpl;
import parser.node.Node;
import parser.node.impl.AssignationNode;
import parser.node.impl.literalNodes.TypeValue;

public class OperatorStateTest {

  @Test
  public void toOperatorSate_shouldThrowException() {
    String text = "let x: string = y - ;";
    List<Token> tokens = LexerImpl.lex(text);
    assertThatThrownBy(() -> ParserImpl.parse(tokens)).isInstanceOf(RuntimeException.class);
  }

  @Test
  public void resolveOperator_whenComingFromDecl_shouldReturnAssignationNode() {
    String text = "let x: string = y - z;";
    List<Token> tokens = LexerImpl.lex(text);
    List<Node> parse = ParserImpl.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new AssignationNode());
    assertThat(nodeX)
        .isEqualTo(
            assignNode(
                declNode(identifierNode("x"), TypeValue.STRING),
                minusNode(identifierNode("y"), identifierNode("z"))));
  }

  @Test
  public void resolveOperator_whenComingFromIdent_shouldReturnAssignationNode() {
    String text = "x = y * z;";
    List<Token> tokens = LexerImpl.lex(text);
    List<Node> parse = ParserImpl.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new AssignationNode());
    assertThat(nodeX)
        .isEqualTo(
            assignNode(
                identifierNode("x"), multiplyNode(identifierNode("y"), identifierNode("z"))));
  }
}
