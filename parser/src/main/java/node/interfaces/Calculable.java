package node.interfaces;

import node.Node;

public interface Calculable<T> extends Node {

    T calculate();

}
