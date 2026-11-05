import java.util.ArrayList;

/**
 * Defines Bob's dessert-shopping behaviors.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class Bob {

    /**
     * Checks whether every dessert in store1 can be found in store2. Assumes both stores have the
     * same number of desserts and store2's desserts are unique and sorted in ascending natural order.
     * Runs in O(n log n) time.
     *
     * @param store1 the Store whose desserts are being looked for
     * @param store2 the sorted Store being searched
     * @return true if all desserts in store1 are found in store2
     */
    public static boolean compareStores(Store store1, Store store2) {
        for (Dessert d : store1.getDesserts()) {
            if (store2.findDessert(d) == null) {
                return false;
            }
        }
        return true;
    }

    /**
     * Sorts the store's desserts and then searches for a dessert with the same sweetness and flavor
     * as the given dessert. Runs in O(n^2) time.
     *
     * @param store   the Store to shop at
     * @param dessert the Dessert Bob is looking for
     * @return true if a dessert with equal sweetness and flavor is found
     */
    public static boolean shop(Store store, Dessert dessert) {
        store.sortStore();
        return store.findDessert(dessert) != null;
    }

    /**
     * Finds the stores that sell a dessert with the same sweetness and flavor as the target.
     * Assumes each store's desserts are sorted in ascending natural order.
     * Runs in O(n log m) time for n stores with m desserts each.
     *
     * @param stores the Stores to search
     * @param target the Dessert Bob is looking for
     * @return the Stores that have the target dessert
     */
    public static ArrayList<Store> findAvailableStores(ArrayList<Store> stores, Dessert target) {
        ArrayList<Store> available = new ArrayList<>();
        for (Store store : stores) {
            if (store.findDessert(target) != null) {
                available.add(store);
            }
        }
        return available;
    }
}
