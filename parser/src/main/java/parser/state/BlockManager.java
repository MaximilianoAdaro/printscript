package parser.state;

import java.util.List;
import parser.node.Node;
import parser.node.interfaces.Calculable;

public class BlockManager {

  public static void openElseBlock() {}

  public static Node getConditionNode() {
    return null;
  }

  class Blocks {
    List<Node> ifTrue;
    List<Node> ifFalse;
  }

  private static Calculable condition;
  private static Blocks blocks;

  public static void addToBlock(Node node) {}

  public static void setCondition(Calculable calculable) {
    condition = calculable;
  }

  public static boolean isInsideBlock() {
    //    return !blocks.isEmpty();
    return true;
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
