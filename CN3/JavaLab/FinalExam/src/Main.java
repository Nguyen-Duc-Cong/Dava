public class Main {
    public static void main(String[] args) throws IOException {
        PatientList pl = new PatientList();
        while (true) {
            int choice = Mesenger.menu();
            switch (choice) {
                case 1: System.out.println("1-Add inpatient:");
                    pl.createInPatient();
                    break;
                case 2: System.out.println("2-Add outpatient:");
                    pl.createOutPatient();
                    break;
                case 3: System.out.println("3-Display list of patients");
                    pl.listOutPatient();
                    break;
                case 4: System.out.println("4-Search patient");
                    pl.searchPatient();
                    break;
                case 5: System.out.println("5-Remove the inpatients after specified date");
                    pl.removePatient();
                    break;
                case 6:
                    PatientList.WriteObjectFile(pl.inPatientList);
                    PatientList.WriteObjectFile(pl.outPatientList);
                    System.out.println("Done");
                    try {
                        PatientList.ReadObjectFile("Patient.dat");
                    } catch (Exception e){
                        System.out.println(" "+e);}
                    System.out.println("done");
                    break;
                case 7:
                    return;
            }
        }
}
