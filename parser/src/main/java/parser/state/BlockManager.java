package parser.state;

import java.util.ArrayList;
import java.util.List;
import parser.node.Node;
import parser.node.interfaces.Calculable;

public class BlockManager {

  private static final List<Calculable> conditions = new ArrayList<>();
  private static final List<List<Node>> blocks = new ArrayList<>();

  public static void addToScope(Node node) {
    blocks.get(blocks.size() - 1).add(node);
  }

  private static boolean isInScope() {
    return !blocks.isEmpty();
  }

  public static void newBlock() {
    blocks.add(new ArrayList<>());
  }

  public static void endBlock() {
    blocks.remove(blocks.size() - 1);
  }
}
