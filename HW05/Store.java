import java.util.ArrayList;

/**
 * Represents a store that sells desserts.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class Store {
    private String name;
    private ArrayList<Dessert> desserts;

    /**
     * Creates a Store with the given name and no desserts.
     *
     * @param name the name of this Store
     */
    public Store(String name) {
        this.name = name;
        this.desserts = new ArrayList<>();
    }

    /**
     * Adds a dessert to the back of this Store's desserts. Runs in O(1) time.
     *
     * @param dessert the Dessert to add
     */
    public void addDessert(Dessert dessert) {
        desserts.add(dessert);
    }

    /**
     * Removes the first dessert in this Store that is equal to the given dessert. Runs in O(n) time.
     *
     * @param dessert the Dessert to remove
     * @return the Dessert removed from this Store, or null if no equal dessert was found
     */
    public Dessert removeDessert(Dessert dessert) {
        for (int i = 0; i < desserts.size(); i++) {
            if (desserts.get(i).equals(dessert)) {
                return desserts.remove(i);
            }
        }
        return null;
    }

    /**
     * Finds the dessert in this Store with the same sweetness and flavor as the given dessert
     * using binary search. Assumes the desserts are unique in sweetness and flavor and sorted
     * in ascending natural order. Runs in O(log n) time.
     *
     * @param dessert the Dessert to search for
     * @return the matching Dessert in this Store, or null if none was found
     */
    public Dessert findDessert(Dessert dessert) {
        int low = 0;
        int high = desserts.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = desserts.get(mid).compareTo(dessert);
            if (comparison == 0) {
                return desserts.get(mid);
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    /**
     * Sorts this Store's desserts in ascending order by sweetness, then flavor, using
     * insertion sort. Runs in O(n^2) time.
     */
    public void sortStore() {
        for (int i = 1; i < desserts.size(); i++) {
            Dessert current = desserts.get(i);
            int j = i - 1;
            while (j >= 0 && desserts.get(j).compareTo(current) > 0) {
                desserts.set(j + 1, desserts.get(j));
                j--;
            }
            desserts.set(j + 1, current);
        }
    }

    /**
     * Counts the desserts in this Store that are greater than or equal to the given dessert
     * by sweetness, then flavor. Runs in O(n) time.
     *
     * @param dessert the Dessert to compare against
     * @return the number of desserts not lesser than the given dessert
     */
    public int countGreaterDesserts(Dessert dessert) {
        int count = 0;
        for (Dessert d : desserts) {
            if (d.compareTo(dessert) >= 0) {
                count++;
            }
        }
        return count;
    }

    /**
     * Prints this Store's name followed by each dessert on its own line. Runs in O(n) time.
     */
    public void showMenu() {
        System.out.println(name + "'s Menu of the Day:");
        for (Dessert d : desserts) {
            System.out.println(d);
        }
    }

    /**
     * Returns the name of this Store.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name of this Store.
     *
     * @param name the new name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Returns the desserts this Store sells.
     *
     * @return the list of desserts
     */
    public ArrayList<Dessert> getDesserts() {
        return desserts;
    }

    /**
     * Sets the desserts this Store sells.
     *
     * @param desserts the new list of desserts
     */
    public void setDesserts(ArrayList<Dessert> desserts) {
        this.desserts = desserts;
    }
}
