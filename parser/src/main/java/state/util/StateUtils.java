package state.util;

import node.interfaces.Calculable;

import java.util.ArrayList;
import java.util.List;

public class StateUtils {

    public static List<Calculable> addToList(List<Calculable> calculables, Calculable calculable) {
        List<Calculable> list = new ArrayList<>(calculables);
        list.add(calculable);
        return list;
    }

    public static Calculable makeTree(List<Calculable> calculables) {
        return null;
    }

}
