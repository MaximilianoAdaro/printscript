package parser.node.interfaces;

import parser.node.impl.literalNodes.TypeValue;

public interface LiteralValue {

  Object getValue();

  TypeValue getTypeValue();
}
