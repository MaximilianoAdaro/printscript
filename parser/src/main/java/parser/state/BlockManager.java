package parser.state;

import java.util.ArrayList;
import java.util.List;
import lexer.model.Position;
import parser.node.Node;
import parser.node.impl.ConditionNode;
import parser.node.interfaces.Calculable;

public class BlockManager {

  static class Blocks {
    List<Node> ifTrue = new ArrayList<>();
    List<Node> ifFalse = new ArrayList<>();
  }

  enum BlockType {
    NONE,
    IF,
    ELSE,
  }

  private static Calculable condition;
  private static Blocks blocks;
  private static BlockType blockType = BlockType.NONE;
  private static BlockType previousBlockType = BlockType.NONE;

  public static void addToBlock(Node node) {
    switch (blockType) {
      case IF -> blocks.ifTrue.add(node);
      case ELSE -> blocks.ifFalse.add(node);
      case NONE -> {
      }
    }
  }

  public static void setCondition(Calculable calculable) {
    condition = calculable;
  }

  public static boolean isInsideBlock() {
    return blockType != BlockType.NONE;
  }

  public static void openIfBlock() {
    blocks = new Blocks();
    previousBlockType = blockType;
    blockType = BlockType.IF;
  }

  public static void openElseBlock() {
    previousBlockType = blockType;
    blockType = BlockType.ELSE;
  }

  public static void closeBlock() {
    previousBlockType = blockType;
    blockType = BlockType.NONE;
  }

  public static boolean canHaveIf() {
    return !isInsideBlock();
  }

  public static boolean canHaveElse() {
    return !isInsideBlock() && previousBlockType == BlockType.IF;
  }

  public static Node getConditionNode(Position position) {
    return new ConditionNode(position, condition, blocks.ifTrue, blocks.ifFalse);
  }
}
