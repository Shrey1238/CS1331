/**
 * Represents a laptop device that may be overclocked once and keeps buffer slots open when low on CPU.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class Laptop extends Device {
    private boolean overclockable;

    /**
     * Creates a laptop with the given serial number, CPU capacity, task array length, and overclockability.
     *
     * @param serialNumber  the unique identifier of this laptop
     * @param cpuCapacity   the total processing power of this laptop
     * @param length        the length of the tasks array
     * @param overclockable whether this laptop can temporarily increase its CPU remaining
     */
    public Laptop(int serialNumber, int cpuCapacity, int length, boolean overclockable) {
        super(serialNumber, cpuCapacity, length);
        this.overclockable = overclockable;
    }

    /**
     * Creates a non-overclockable laptop with the given serial number, CPU capacity, and task array length.
     *
     * @param serialNumber the unique identifier of this laptop
     * @param cpuCapacity  the total processing power of this laptop
     * @param length       the length of the tasks array
     */
    public Laptop(int serialNumber, int cpuCapacity, int length) {
        this(serialNumber, cpuCapacity, length, false);
    }

    /**
     * Calculates how many slots in the tasks array should be left empty for the given CPU remaining.
     *
     * @param cpuRemaining the CPU remaining used to calculate the buffer slots
     * @return 0 if the tasks array has length 4 or less, otherwise 2 if cpuRemaining is less than 128
     *         and 1 if not
     */
    public int bufferSlotsRequired(int cpuRemaining) {
        if (tasks.length <= 4) {
            return 0;
        }
        return cpuRemaining < 128 ? 2 : 1;
    }

    /**
     * Returns whether the given task can be added: there must be enough CPU remaining (overclocking if
     * needed and possible) and enough empty slots left after adding it to satisfy the buffer requirement.
     * Does not change the state of this laptop.
     *
     * @param task the task to check
     * @return true if the task can be added
     */
    @Override
    public boolean canAddTask(Task task) {
        int available = availableCpu(task);
        if (available < task.getCpuCost()) {
            return false;
        }
        int slotsLeftAfter = emptySlotCount() - 1;
        return slotsLeftAfter >= 0 && slotsLeftAfter >= bufferSlotsRequired(available - task.getCpuCost());
    }

    /**
     * Adds the given task at the first empty slot if it can be added, overclocking if needed and
     * updating the CPU remaining.
     *
     * @param task the task to add
     * @return true if the task was added successfully
     */
    @Override
    public boolean addTask(Task task) {
        if (!canAddTask(task)) {
            return false;
        }
        int available = availableCpu(task);
        if (available != cpuRemaining) {
            cpuRemaining = available;
            overclockable = false;
        }
        storeTask(task);
        return true;
    }

    /**
     * Returns the CPU that would be available for the given task, including the one-fourth capacity
     * boost if the task does not fit and this laptop can still be overclocked.
     *
     * @param task the task to check
     * @return the CPU available for the task
     */
    private int availableCpu(Task task) {
        if (task.getCpuCost() > cpuRemaining && overclockable) {
            return cpuRemaining + cpuCapacity / 4;
        }
        return cpuRemaining;
    }

    /**
     * Two laptops are equal if they have the same serial number, CPU capacity, CPU remaining,
     * and overclockability.
     *
     * @param o the object to compare to
     * @return true if o is an equal laptop
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o) && overclockable == ((Laptop) o).overclockable;
    }

    /**
     * Returns a hash code consistent with equals.
     *
     * @return the hash code of this laptop
     */
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + (overclockable ? 1 : 0);
    }

    /**
     * Returns a description of this laptop.
     *
     * @return the device description followed by "This laptop {does/does not} have overclocking."
     */
    @Override
    public String toString() {
        return super.toString() + " This laptop " + (overclockable ? "does" : "does not") + " have overclocking.";
    }
}
