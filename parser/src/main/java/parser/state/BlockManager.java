package parser.state;

import java.util.ArrayList;
import java.util.List;
import parser.node.Node;
import parser.node.interfaces.Calculable;

public class BlockManager {

  class Blocks {

    List<Node> ifTrue = new ArrayList<>();
    List<Node> ifFalse = new ArrayList<>();
  }

  private static Calculable condition;
  private static Blocks blocks;

  public static void addToBlock(Node node) {}

  public static void setCondition(Calculable calculable) {
    condition = calculable;
  }

  public static void openElseBlock() {}

  public static Node getConditionNode() {
    return null;
  }

  public static boolean isInsideBlock() {
    //    return !blocks.isEmpty();
    return false;
  }

  public static void openIfBlock() {
    //    blocks.add(new ArrayList<>());
  }

  public static void closeBlock() {
    //    blocks.remove(blocks.size() - 1);
  }

  public static boolean canHaveIf() {
    return false;
  }

  public static boolean canHaveElse() {
    return false;
  }
}
