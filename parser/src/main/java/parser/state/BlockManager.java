package parser.state;

import java.util.ArrayList;
import java.util.List;
import parser.node.Node;
import parser.node.interfaces.Calculable;

public class BlockManager {

  private static final List<Calculable> conditions = new ArrayList<>();
  private static final List<List<Node>> blocks = new ArrayList<>();

  public static void addToBlock(Node node) {
    blocks.get(blocks.size() - 1).add(node);
  }

  public static void setCondition(Calculable condition) {
    conditions.add(condition);
  }

  public static boolean isInsideBlock() {
    return !blocks.isEmpty();
  }

  public static void openBlock() {
    blocks.add(new ArrayList<>());
  }

  public static void closeBlock() {
    blocks.remove(blocks.size() - 1);
  }

  public static boolean canHaveIf() {
    return false;
  }

  public static boolean canHaveElse() {
    return false;
  }
}
