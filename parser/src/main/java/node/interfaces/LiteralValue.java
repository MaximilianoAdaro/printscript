package node.interfaces;

import node.literalNode.TypeValue;

public interface LiteralValue<T> {

    T getValue();

    TypeValue getTypeValue();
}
