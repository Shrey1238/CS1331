/**
 * Represents an abstract device that holds and processes tasks within its CPU capacity.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public abstract class Device {
    private final int serialNumber;
    protected final int cpuCapacity;
    protected int cpuRemaining;
    protected Task[] tasks;

    /**
     * Creates a device with the given serial number, CPU capacity, and task array length.
     *
     * @param serialNumber the unique identifier of this device
     * @param cpuCapacity  the total processing power of this device
     * @param length       the length of the tasks array
     */
    public Device(int serialNumber, int cpuCapacity, int length) {
        this.serialNumber = serialNumber;
        this.cpuCapacity = cpuCapacity;
        this.cpuRemaining = cpuCapacity;
        this.tasks = new Task[length];
    }

    /**
     * Creates a device with the given serial number and task array length, and a CPU capacity of 512.
     *
     * @param serialNumber the unique identifier of this device
     * @param length       the length of the tasks array
     */
    public Device(int serialNumber, int length) {
        this(serialNumber, 512, length);
    }

    /**
     * Returns whether the given task can be added to this device's tasks array.
     *
     * @param task the task to check
     * @return true if the task can be added
     */
    public abstract boolean canAddTask(Task task);

    /**
     * Adds the given task to this device's tasks array if possible.
     *
     * @param task the task to add
     * @return true if the task was added successfully
     */
    public abstract boolean addTask(Task task);

    /**
     * Processes the first task in the tasks array equal to the given task, removing it and
     * freeing its CPU cost.
     *
     * @param task the task to process
     * @return true if an equal task was found and processed
     */
    public boolean processTask(Task task) {
        if (task == null) {
            return false;
        }
        for (int i = 0; i < tasks.length; i++) {
            if (task.equals(tasks[i])) {
                Task removed = tasks[i];
                tasks[i] = null;
                cpuRemaining += removed.getCpuCost();
                System.out.println("Processed: " + removed);
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the index of the first empty slot in the tasks array.
     *
     * @return the index of the first null element, or -1 if the array is full
     */
    protected int firstEmptySlot() {
        for (int i = 0; i < tasks.length; i++) {
            if (tasks[i] == null) {
                return i;
            }
        }
        return -1;
    }

    /**
     * Returns the number of empty slots in the tasks array.
     *
     * @return the number of null elements in the tasks array
     */
    protected int emptySlotCount() {
        int count = 0;
        for (Task t : tasks) {
            if (t == null) {
                count++;
            }
        }
        return count;
    }

    /**
     * Places the given task in the first empty slot and deducts its cost from the CPU remaining.
     *
     * @param task the task to store
     */
    protected void storeTask(Task task) {
        tasks[firstEmptySlot()] = task;
        cpuRemaining -= task.getCpuCost();
    }

    /**
     * Two devices are equal if they have the same serial number, CPU capacity, and CPU remaining.
     *
     * @param o the object to compare to
     * @return true if o is the same type of device with the same serial number, CPU capacity,
     *         and CPU remaining
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Device other = (Device) o;
        return serialNumber == other.serialNumber
            && cpuCapacity == other.cpuCapacity
            && cpuRemaining == other.cpuRemaining;
    }

    /**
     * Returns a hash code consistent with equals.
     *
     * @return the hash code of this device
     */
    @Override
    public int hashCode() {
        return 31 * (31 * serialNumber + cpuCapacity) + cpuRemaining;
    }

    /**
     * Returns a description of this device.
     *
     * @return "Device with serial number {serialNumber} has {cpuRemaining} of {cpuCapacity} CPU remaining."
     */
    @Override
    public String toString() {
        return "Device with serial number " + serialNumber + " has " + cpuRemaining + " of "
            + cpuCapacity + " CPU remaining.";
    }
}
