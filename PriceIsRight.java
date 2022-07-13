import java.util.TreeMap;

/**
 * price is right implementation using hashmap and treeset.
 * 
 * @author jeromeli
 * @version May 6 2022.
 */
public class PriceIsRight {

  TreeMap<Double, String> tree;

  /**
   * hashmap and treeset constructor.
   */
  public PriceIsRight() {

    tree = new TreeMap<Double, String>();

  }

  /**
   * maps value to product. adds value to trees.
   * 
   * @param price price of product.
   * @param product name of product.
   */
  public void addProduct(double price, String product) {
    tree.put(price, product);

  }

  /**
   * retrieves and removes most expensive item from map and tree if it's there and affordable.
   * 
   * @param price budget.
   * @return name if affordable, null if not there or not affordable.
   */
  public String buy(double price) {

    String result = null;

    if (tree.size() > 0 && tree.floorKey(price) != null) {

      Double key = tree.floorKey(price);
      result = tree.get(key);
      tree.remove(key);

    }


    return result;
  }

}
