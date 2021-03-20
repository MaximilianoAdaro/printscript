package node.interfaces;

import node.impl.literalNodes.TypeValue;

public interface LiteralValue<T> {

    T getValue();

    TypeValue getTypeValue();
}
