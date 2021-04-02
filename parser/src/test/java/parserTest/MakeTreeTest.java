package parserTest;

import static org.assertj.core.api.Assertions.assertThat;
import static utils.NodeUtils.*;

import java.util.List;
import lexer.LexerImpl;
import lexer.model.Token;
import org.junit.Test;
import parser.ParserImpl;
import parser.node.Node;
import parser.node.impl.AssignationNode;
import parser.node.impl.DeclarationNode;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.impl.operatorNodes.DivisionNode;
import parser.node.impl.operatorNodes.MultiplyNode;
import parser.node.impl.operatorNodes.SumNode;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.Declarational;

public class MakeTreeTest {

  @Test
  public void makeTreeTest() {
    String text = "let x: number = y + 2 * 3 + z / 3 * 4 * 5;";
    List<Token> tokens = LexerImpl.lex(text);
    List<Node> parse = ParserImpl.parse(tokens);

    assertThat(parse).hasSize(1);
    Node node = parse.get(0);
    assertThat(node).hasSameClassAs(new AssignationNode());

    Declarational declarational = ((AssignationNode) node).getDeclarational();
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
}
