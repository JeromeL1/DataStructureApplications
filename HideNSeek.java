import java.util.HashMap;
import java.util.TreeSet;

/**
 * HideNSeek data structure implemented using hashmap and treeset.
 * 
 * @author jeromeli
 *
 */
public class HideNSeek {

  HashMap<Integer, HashMap<Integer, TreeSet<String>>> exCoord;
  HashMap<Integer, TreeSet<String>> whyCoord;
  TreeSet<String> items;

  /**
   * x coord map constructor.
   */
  public HideNSeek() {

    exCoord = new HashMap<Integer, HashMap<Integer, TreeSet<String>>>();
    whyCoord = new HashMap<Integer, TreeSet<String>>();
    items = new TreeSet<String>();

  }

  /**
   * hides the object.
   * 
   * @param x x coord.
   * @param y y coord.
   * @param item item to hide.
   */
  public void hide(int x, int y, String item) {
    if (!exCoord.containsKey(x)) {

      items.add(item);
      whyCoord.put(y, items);
      exCoord.put(x, whyCoord);

    } else {

      if (!exCoord.get(x).keySet().contains(y)) {

        items.add(item);
        exCoord.get(x).put(y, items);

      } else {

        if (!exCoord.get(x).get(y).contains(item)) {
          exCoord.get(x).get(y).add(item);
        }

      }
    }

  }

  /**
   * seeks item.
   * 
   * @param x x coord.
   * @param y y coord.
   * @param item item to find.
   * @return true if item is found.
   */
  public boolean seek(int x, int y, String item) {

    if (exCoord.get(x) == null || exCoord.get(x).get(y) == null) {
      return false;
    }

    return exCoord.get(x).get(y).contains(item);
  }

}
