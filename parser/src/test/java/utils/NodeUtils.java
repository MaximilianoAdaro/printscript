package utils;

import parser.node.impl.*;
import parser.node.impl.literalNodes.LiteralNode;
import parser.node.impl.literalNodes.NumberLiteralValue;
import parser.node.impl.literalNodes.StringLiteralValue;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.impl.operatorNodes.DivisionNode;
import parser.node.impl.operatorNodes.MinusNode;
import parser.node.impl.operatorNodes.MultiplyNode;
import parser.node.impl.operatorNodes.SumNode;
import parser.node.interfaces.Calculable;
import parser.node.interfaces.Declarational;
import parser.node.interfaces.LiteralValue;

public class NodeUtils {

  // create EmptyNode
  public static EmptyNode emptyNode() {
    return EmptyNode.builder().build();
  }

  // create AssignationNode
  public static AssignationNode assignNode(Calculable calculable, Declarational declarational) {
    return AssignationNode.builder().calculable(calculable).declarational(declarational).build();
  }

  // create DeclarationNode
  public static DeclarationNode declNode(IdentifierNode identifierNode, TypeValue typeValue) {
    return DeclarationNode.builder().identifierNode(identifierNode).typeValue(typeValue).build();
  }

  // create IdentifierNode
  public static IdentifierNode identifierNode(String value) {
    return IdentifierNode.builder().value(value).build();
  }

  // create PrintNode
  public static PrintNode printNode(Calculable calculable) {
    return PrintNode.builder().calculable(calculable).build();
  }

  // create LiteralNode
  public static LiteralNode literalNode(LiteralValue literalValue) {
    return LiteralNode.builder().literalValue(literalValue).build();
  }

  // create NumberLiteralValueNode
  public static LiteralNode numbValueNode(double number) {
    return LiteralNode.builder().literalValue(numbValue(number)).build();
  }

  // create NumberLiteralValue
  public static NumberLiteralValue numbValue(double number) {
    return NumberLiteralValue.builder().value(number).build();
  }

  // create StringLiteralValueNode
  public static LiteralNode strValueNode(String value) {
    return LiteralNode.builder().literalValue(strValue(value)).build();
  }

  // create StringLiteralValue
  public static StringLiteralValue strValue(String value) {
    return StringLiteralValue.builder().value(value).build();
  }

  // create DivisionNode
  public static DivisionNode divisionNode(Calculable calculableL, Calculable calculableR) {
    return DivisionNode.builder().leftNode(calculableL).rightNode(calculableR).build();
  }

  // create MultiplyNode
  public static MultiplyNode multiplyNode(Calculable calculableL, Calculable calculableR) {
    return MultiplyNode.builder().leftNode(calculableL).rightNode(calculableR).build();
  }

  // create SumNode
  public static SumNode sumNode(Calculable calculableL, Calculable calculableR) {
    return SumNode.builder().leftNode(calculableL).rightNode(calculableR).build();
  }

  // create MinusNode
  public static MinusNode minusNode(Calculable calculableL, Calculable calculableR) {
    return MinusNode.builder().leftNode(calculableL).rightNode(calculableR).build();
  }
}
