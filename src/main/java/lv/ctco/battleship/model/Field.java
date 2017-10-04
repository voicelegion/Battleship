package lv.ctco.battleship.model;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by roman.pipchenko on 10/4/2017.
 */
public class Field implements Serializable {
    private static final long serialVersionUID = 1;
    private Map<String, CellContent> content = new HashMap<>();

    public Map<String, CellContent> getContent() {
        return content;
    }
    public CellContent get(String address){
        return content.getOrDefault(address, CellContent.EMPTY);
    }
    public void set(String addr, CellContent cc){
        content.put(addr,cc);
    }

}
