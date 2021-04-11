package parserTest;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.NodeUtils.*;

import fileReader.FileReaderPS;
import java.util.List;
import lexer.Lexer;
import lexer.model.Token;
import org.junit.Test;
import parser.Parser;
import parser.node.Node;
import parser.node.impl.AssignationNode;
import parser.node.impl.declarationNodes.DeclarationNode;
import parser.node.impl.declarationNodes.DeclarationalNode;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.impl.operatorNodes.DivisionNode;
import parser.node.impl.operatorNodes.MultiplyNode;
import parser.node.impl.operatorNodes.SumNode;
import parser.node.interfaces.Calculable;

public class MakeTreeTest {

  @Test
  public void makeTreeTest() {
    String text = "let x: number = y + 2 * 3 + z / 3 * 4 * 5;";
    List<Token> tokens = Lexer.lex(text);
    List<Node> parse = Parser.parse(tokens);

    assertThat(parse).hasSize(1);
    Node node = parse.get(0);
    assertThat(node).hasSameClassAs(new AssignationNode());

    DeclarationalNode declarational = ((AssignationNode) node).getDeclarational();
    assertThat(declarational).hasSameClassAs(new DeclarationNode());
    DeclarationNode declarationNode = (DeclarationNode) declarational;
    assertThat(declarationNode.getTypeValue()).isEqualTo(TypeValue.NUMBER);
    assertThat(declarationNode.getIdentifierNode()).isEqualTo(identifierNode("x"));

    Calculable calculable = ((AssignationNode) node).getCalculable();
    assertThat(calculable).hasSameClassAs(new SumNode());
    SumNode sumNode = (SumNode) calculable;

    Calculable leftRootNode = sumNode.getLeftNode();
    assertThat(leftRootNode).isEqualTo(identifierNode("y"));

    Calculable rightRootNode = sumNode.getRightNode();
    DivisionNode div4 = divisionNode(identifierNode("z"), numbValueNode(3));
    MultiplyNode mult5 = multiplyNode(div4, numbValueNode(4));
    MultiplyNode mult6 = multiplyNode(mult5, numbValueNode(5));
    MultiplyNode mult2 = multiplyNode(numbValueNode(2), numbValueNode(3));
    SumNode sum3 = sumNode(mult2, mult6);
    assertThat(rightRootNode).isEqualTo(sum3);
  }

  @Test
  public void testBoolOp() {
    final var text = "const x: boolean = 5 > 3;";
    final var expectedPath = "./src/test/resources/boolTests/testBoolOp.txt";
    shouldReturnExpectedInFile(text, expectedPath);
  }

  @Test
  public void testBoolOpComplex() {
    final var text = "const x: boolean = 5 * 3 + 10 <= 3 - 10 / 4;";
    final var expectedPath = "./src/test/resources/boolTests/testBoolOpComplex.txt";
    shouldReturnExpectedInFile(text, expectedPath);
  }

  @Test
  public void testBoolOpComplex2() {
    final var text = "const x: boolean = 5 * 3 + 10 < 3 - 10 / 4;";
    final var expectedPath = "./src/test/resources/boolTests/testBoolOpComplex2.txt";
    shouldReturnExpectedInFile(text, expectedPath);
  }

  @Test
  public void testBoolOpComplex3() {
    final var text = "const x: boolean = 5 * 3 + 10 >= 3 - 10 / 4;";
    final var expectedPath = "./src/test/resources/boolTests/testBoolOpComplex3.txt";
    shouldReturnExpectedInFile(text, expectedPath);
  }

  private void shouldReturnExpectedInFile(String text, String expectedPath) {
    final var tokens = Lexer.lex(text);
    final var nodes = Parser.parse(tokens);

    final var expected = FileReaderPS.readFile(expectedPath);
    assertThat(nodes.toString()).isEqualTo(expected);
  }
}
