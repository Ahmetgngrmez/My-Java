import java.util.Comparator;

// Helps us decide which comes first
public class PatientComparator implements Comparator<Patient> {
    @Override
    public int compare(Patient p1, Patient p2) {
        // First compare priority
        if (p1.getPriority() != p2.getPriority()) {
            return p1.getPriority() - p2.getPriority();
        } else {
            return p2.getArrivalOrder() - p1.getArrivalOrder();
        }
    }
}