package interpreter;

import java.util.*;
import lombok.Data;
import parser.node.impl.literalNodes.TypeValue;
import parser.node.interfaces.LiteralValue;

public class VariableManager {

  @Data
  public static class ValueType {
    private final TypeValue typeValue;
    private final boolean isConst;
  }

  private final List<Map<String, ValueType>> declarations =
      new ArrayList<>() {
        {
          add(new HashMap<>());
        }
      };
  private final List<Map<String, LiteralValue>> assignations =
      new ArrayList<>() {
        {
          add(new HashMap<>());
        }
      };

  public Optional<LiteralValue> getLiteralValue(String name) {
    return assignations.stream().filter(m -> m.containsKey(name)).findFirst().map(m -> m.get(name));
  }

  public Optional<ValueType> getValueType(String name) {
    return declarations.stream().filter(m -> m.containsKey(name)).findFirst().map(m -> m.get(name));
  }

  public boolean isDeclared(String variableName) {
    return declarations.stream().anyMatch(m -> m.containsKey(variableName));
  }

  public void newScope() {
    declarations.add(new HashMap<>());
    assignations.add(new HashMap<>());
  }

  public void endScope() {
    declarations.remove(declarations.size() - 1);
    assignations.remove(assignations.size() - 1);
  }

  public void declareVar(String name, ValueType valueType) {
    declarations.get(declarations.size() - 1).put(name, valueType);
  }

  public void assignVar(String name, LiteralValue literalValue) {
    int index = 0;
    for (int i = 0; i < declarations.size(); i++) {
      if (declarations.get(i).containsKey(name)) index = i;
    }
    assignations.get(index).put(name, literalValue);
  }
}
