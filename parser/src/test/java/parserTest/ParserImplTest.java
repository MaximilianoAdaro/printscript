package parserTest;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.NodeUtils.*;

import java.util.List;
import lexer.LexerImpl;
import lexer.model.Token;
import lombok.val;
import org.junit.Test;
import parser.ParserImpl;
import parser.node.Node;
import parser.node.impl.DeclarationNode;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.impl.operandNodes.SumNode;
import parser.node.interfaces.Calculable;

public class ParserImplTest {

  @Test
  public void test() {

    val text =
        """
                let x: string = "hello world";
                let y: number = 18.3;
                println(x + y);
                """;
    List<Token> tokens = LexerImpl.lex(text);
    List<Node> nodes = ParserImpl.parse(tokens);
    nodes.forEach(System.out::println);
    assertThat(nodes).hasSize(3);

    LiteralNode assignNodeLeft0 = literalNode(strValue("hello world"));
    DeclarationNode assignNodeRight0 = declNode(identifierNode("x"), TypeValue.STRING);
    assertThat(nodes.get(0)).isEqualTo(assignNode(assignNodeLeft0, assignNodeRight0));

    LiteralNode assignNodeLeft1 = literalNode(numbValue(18.3));
    DeclarationNode assignNodeRight1 = declNode(identifierNode("y"), TypeValue.NUMBER);
    assertThat(nodes.get(1)).isEqualTo(assignNode(assignNodeLeft1, assignNodeRight1));

    Calculable calculableNode = new SumNode(identifierNode("y"), identifierNode("x"));
    assertThat(nodes.get(2)).isEqualTo(printNode(calculableNode));
  }
}
