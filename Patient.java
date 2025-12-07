public class Patient implements Comparable<Patient> {
    private String name;
    private int priority;
    private int arrivalOrder;

    // Sets up a new patient with their name-priority-order
    public Patient(String name, int priority, int arrivalOrder) {
        this.name = name;
        this.priority = priority;
        this.arrivalOrder = arrivalOrder;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    public int getArrivalOrder() {
        return arrivalOrder;
    }

    // A helper to print the patient's info
    @Override
    public String toString() {
        return name + "(P=" + priority + " and #" + arrivalOrder + ")";
    }

    // Checks who has higher priority so we can sort
    @Override
    public int compareTo(Patient p) {
        if (this.priority > p.priority)
            return 1;
        else if (this.priority < p.priority)
            return -1;
        else
            return 0;
    }
}