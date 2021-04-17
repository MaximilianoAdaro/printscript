package parserTest;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.NodeUtils.*;

import java.io.File;
import java.util.List;

import fileReader.FileReaderPS;
import lexer.Lexer;
import lexer.model.Position;
import lexer.model.Token;
import lombok.val;
import org.junit.Test;
import parser.Parser;
import parser.node.Node;
import parser.node.impl.declarationNodes.DeclarationNode;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.impl.operatorNodes.SumNode;
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
    List<Token> tokens = Lexer.lex(text);
    List<Node> nodes = Parser.parse(tokens);
    nodes.forEach(System.out::println);
    assertThat(nodes).hasSize(3);

    LiteralNode assignNodeLeft0 = literalNode(strValue("hello world"));
    DeclarationNode assignNodeRight0 = declNode(identifierNode("x"), TypeValue.STRING);
    assertThat(nodes.get(0)).isEqualTo(assignNode(assignNodeRight0, assignNodeLeft0));

    LiteralNode assignNodeLeft1 = literalNode(numbValue(18.3));
    DeclarationNode assignNodeRight1 = declNode(identifierNode("y"), TypeValue.NUMBER);
    assertThat(nodes.get(1)).isEqualTo(assignNode(assignNodeRight1, assignNodeLeft1));

    Calculable calculableNode =
        new SumNode(Position.empty(), identifierNode("y"), identifierNode("x"));
    assertThat(nodes.get(2)).isEqualTo(printNode(calculableNode));
  }


  @Test
  public void testIfElse() {
    val text =
            """
                   if (5 > 2) {
                      println(3);
                   } else {
                      println(5);
                   }
                    """;

    final var tokens = Lexer.lex(text);
    final var nodes = Parser.parse(tokens);
    final var expected = FileReaderPS.readFile("./src/test/resources/ifelse/ifelsetest.txt");

    assertThat(nodes.toString()).isEqualTo(expected);

  }
}
