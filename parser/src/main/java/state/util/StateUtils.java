package state.util;

import node.interfaces.Calculable;

import java.util.ArrayList;
import java.util.List;

public class StateUtils {

    public static List<Calculable> addToList(List<Calculable> calculableList, Calculable calculable) {
        List<Calculable> list = new ArrayList<>(calculableList);
        list.add(calculable);
        return list;
    }

    public static Calculable makeTree(List<Calculable> calculables) {
        return null;
    }

}
