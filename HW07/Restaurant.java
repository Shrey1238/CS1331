/**
 * This class contains recursive methods for solving sushi restaurant puzzles.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class Restaurant {
    /**
     * Sorts sushi rolls in ascending lexicographical order by name using recursive merge sort.
     *
     * @param rolls the sushi rolls to sort
     * @return a new array containing the sushi rolls in ascending order by name
     */
    public static SushiRoll[] mergeSortRolls(SushiRoll[] rolls) {
        if (rolls.length <= 1) {
            return RecursionUtils.copyOfRange(rolls, 0, rolls.length);
        }
        int mid = rolls.length / 2;
        SushiRoll[] left = mergeSortRolls(RecursionUtils.copyOfRange(rolls, 0, mid));
        SushiRoll[] right = mergeSortRolls(RecursionUtils.copyOfRange(rolls, mid, rolls.length));
        return RecursionUtils.merge(left, right);
    }

    /**
     * Merges sorted orders into one array sorted in ascending lexicographical order by name.
     *
     * @param orders the orders to merge, each sorted in ascending order by name
     * @return an array containing every sushi roll from every order in ascending order by name
     */
    public static SushiRoll[] mergeOrders(SushiRoll[][] orders) {
        return mergeOrders(orders, 0, orders.length);
    }

    /**
     * Merges the sorted orders in the index range [start, end).
     *
     * @param orders the orders to merge, each sorted in ascending order by name
     * @param start  the first index of the range, inclusive
     * @param end    the last index of the range, exclusive
     * @return an array containing every sushi roll in the range of orders in ascending order by name
     */
    private static SushiRoll[] mergeOrders(SushiRoll[][] orders, int start, int end) {
        if (start >= end) {
            return new SushiRoll[0];
        }
        if (end - start == 1) {
            return RecursionUtils.copyOfRange(orders[start], 0, orders[start].length);
        }
        int mid = start + (end - start) / 2;
        return RecursionUtils.merge(mergeOrders(orders, start, mid), mergeOrders(orders, mid, end));
    }

    /**
     * Finds the sushi rolls served on a plate of the given color, keeping them in ascending order by name.
     *
     * @param rolls the sushi rolls to search, sorted in ascending order by name
     * @param color the desired plate color
     * @return an array containing only the sushi rolls of the given color in ascending order by name
     */
    public static SushiRoll[] platesOfColor(SushiRoll[] rolls, Color color) {
        return platesOfColor(rolls, color, 0, rolls.length);
    }

    /**
     * Finds the sushi rolls of the given color in the index range [start, end).
     *
     * @param rolls the sushi rolls to search, sorted in ascending order by name
     * @param color the desired plate color
     * @param start the first index of the range, inclusive
     * @param end   the last index of the range, exclusive
     * @return an array containing only the sushi rolls of the given color in the range, in ascending order by name
     */
    private static SushiRoll[] platesOfColor(SushiRoll[] rolls, Color color, int start, int end) {
        if (start >= end) {
            return new SushiRoll[0];
        }
        if (end - start == 1) {
            if (rolls[start].getColor() == color) {
                return RecursionUtils.copyOfRange(rolls, start, end);
            }
            return new SushiRoll[0];
        }
        int mid = start + (end - start) / 2;
        return RecursionUtils.merge(platesOfColor(rolls, color, start, mid), platesOfColor(rolls, color, mid, end));
    }

    /**
     * Calculates the total price of an order based on the plate color of each sushi roll.
     *
     * @param rolls the sushi rolls in the order
     * @return the total price of the order
     */
    public static double totalPrice(SushiRoll[] rolls) {
        return totalPrice(rolls, 0);
    }

    /**
     * Calculates the total price of the sushi rolls from the given index to the end of the array.
     *
     * @param rolls the sushi rolls in the order
     * @param index the index of the first sushi roll to include
     * @return the total price of the sushi rolls from index onward
     */
    private static double totalPrice(SushiRoll[] rolls, int index) {
        if (index >= rolls.length) {
            return 0.0;
        }
        return rolls[index].getColor().getPrice() + totalPrice(rolls, index + 1);
    }

    /**
     * Reverses a sorted array of sushi rolls in place so it is in descending order by name.
     *
     * @param rolls the sushi rolls to flip, sorted in ascending order by name
     */
    public static void flip(SushiRoll[] rolls) {
        flip(rolls, 0, rolls.length - 1);
    }

    /**
     * Swaps the sushi rolls at the two given indices and continues inward until the indices meet.
     *
     * @param rolls the sushi rolls to flip
     * @param left  the index of the left sushi roll to swap
     * @param right the index of the right sushi roll to swap
     */
    private static void flip(SushiRoll[] rolls, int left, int right) {
        if (left >= right) {
            return;
        }
        SushiRoll temp = rolls[left];
        rolls[left] = rolls[right];
        rolls[right] = temp;
        flip(rolls, left + 1, right - 1);
    }
}
