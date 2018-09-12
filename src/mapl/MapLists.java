package mapl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapLists {

    private Map<String, List<String>> mapLists = new HashMap<>();

    private void addMapLists(String key, String value){
        mapLists.computeIfAbsent(key, k-> new ArrayList<>()).add(value);
        //if list with this name doesn't exist add value in new list
    }
}
