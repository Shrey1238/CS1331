/**
 * Represents a cell phone device that tracks how many tasks it has completed.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public class CellPhone extends Device {
    private int tasksCompleted;

    /**
     * Creates a cell phone with the given serial number, CPU capacity, and task array length.
     *
     * @param serialNumber the unique identifier of this cell phone
     * @param cpuCapacity  the total processing power of this cell phone
     * @param length       the length of the tasks array
     */
    public CellPhone(int serialNumber, int cpuCapacity, int length) {
        super(serialNumber, cpuCapacity, length);
        this.tasksCompleted = 0;
    }

    /**
     * Creates a cell phone with the given serial number and CPU capacity, and a task array of length 10.
     *
     * @param serialNumber the unique identifier of this cell phone
     * @param cpuCapacity  the total processing power of this cell phone
     */
    public CellPhone(int serialNumber, int cpuCapacity) {
        this(serialNumber, cpuCapacity, 10);
    }

    /**
     * Returns whether the given task can be added: there must be an empty slot and enough CPU remaining.
     *
     * @param task the task to check
     * @return true if the task can be added
     */
    @Override
    public boolean canAddTask(Task task) {
        return firstEmptySlot() != -1 && cpuRemaining >= task.getCpuCost();
    }

    /**
     * Adds the given task at the first empty slot if it can be added, updating the CPU remaining.
     *
     * @param task the task to add
     * @return true if the task was added successfully
     */
    @Override
    public boolean addTask(Task task) {
        if (!canAddTask(task)) {
            return false;
        }
        storeTask(task);
        return true;
    }

    /**
     * Processes the given task and counts it as completed if it was processed successfully.
     *
     * @param task the task to process
     * @return true if an equal task was found and processed
     */
    @Override
    public boolean processTask(Task task) {
        boolean processed = super.processTask(task);
        if (processed) {
            tasksCompleted++;
        }
        return processed;
    }

    /**
     * Two cell phones are equal if they have the same serial number, CPU capacity, CPU remaining,
     * and tasks completed.
     *
     * @param o the object to compare to
     * @return true if o is an equal cell phone
     */
    @Override
    public boolean equals(Object o) {
        return super.equals(o) && tasksCompleted == ((CellPhone) o).tasksCompleted;
    }

    /**
     * Returns a hash code consistent with equals.
     *
     * @return the hash code of this cell phone
     */
    @Override
    public int hashCode() {
        return 31 * super.hashCode() + tasksCompleted;
    }

    /**
     * Returns a description of this cell phone.
     *
     * @return the device description followed by "It has completed {tasksCompleted} tasks."
     */
    @Override
    public String toString() {
        return super.toString() + " It has completed " + tasksCompleted + " tasks.";
    }
}
