import java.util.List;
import java.util.stream.Collectors;

public class Hospital {
    private List<Patient> patients;
    public List<Patient> getPatientsByClass(Class<?> c) {
        return patients.stream().filter(animal -> animal.getClass().equals(c)).collect(Collectors.toList());
    }
}
