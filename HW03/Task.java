/**
 * Represents a processing task with a name and a CPU cost that a Device can handle.
 *
 * @author Shreyan Kothari
 * @version 1.0
 */
public final class Task {
    private final String name;
    private final int cpuCost;

    /**
     * Creates a task with the given name and CPU cost.
     *
     * @param name    the description of this task; defaults to "GEN_TASK" if null
     * @param cpuCost the processing cost of this task; set to 8 if less than 8
     */
    public Task(String name, int cpuCost) {
        this.name = (name == null) ? "GEN_TASK" : name;
        this.cpuCost = Math.max(cpuCost, 8);
    }

    /**
     * Returns the CPU cost of this task.
     *
     * @return the CPU cost of this task
     */
    public int getCpuCost() {
        return cpuCost;
    }

    /**
     * Two tasks are equal if they have the same name and CPU cost.
     *
     * @param o the object to compare to
     * @return true if o is a Task with the same name and CPU cost
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Task)) {
            return false;
        }
        Task other = (Task) o;
        return name.equals(other.name) && cpuCost == other.cpuCost;
    }

    /**
     * Returns a hash code consistent with equals.
     *
     * @return the hash code of this task
     */
    @Override
    public int hashCode() {
        return 31 * name.hashCode() + cpuCost;
    }

    /**
     * Returns a description of this task.
     *
     * @return "{name} has CPU cost of {cpuCost}"
     */
    @Override
    public String toString() {
        return name + " has CPU cost of " + cpuCost;
    }
}
