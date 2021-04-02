package parserTest.states.declarationStatesTest;

import static org.assertj.core.api.Assertions.assertThat;
import static parser.node.impl.literalNodes.TypeValue.NUMBER;
import static parser.node.impl.literalNodes.TypeValue.STRING;
import static utils.NodeUtils.declNode;
import static utils.NodeUtils.identifierNode;

import java.util.List;
import lexer.LexerImpl;
import lexer.model.Token;
import org.junit.Test;
import parser.ParserImpl;
import parser.node.Node;
import parser.node.impl.DeclarationNode;

public class TypeStateTest {

  @Test
  public void toTypeStateTest_whenTypeString_shouldReturnDeclarationNode() {
    String text = "let x: string;";
    List<Token> tokens = LexerImpl.lex(text);
    List<Node> parse = ParserImpl.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeX = parse.get(0);
    assertThat(nodeX).hasSameClassAs(new DeclarationNode());

    assertThat(nodeX).isEqualTo(declNode(identifierNode("x"), STRING));
  }

  @Test
  public void toTypeStateTest_whenTypeNumber_shouldReturnDeclarationNode() {
    String text = "let y: number;";
    List<Token> tokens = LexerImpl.lex(text);
    List<Node> parse = ParserImpl.parse(tokens);
    assertThat(parse).hasSize(1);
    Node nodeY = parse.get(0);
    assertThat(nodeY).hasSameClassAs(new DeclarationNode());
    assertThat(nodeY).isEqualTo(declNode(identifierNode("y"), NUMBER));
  }
}