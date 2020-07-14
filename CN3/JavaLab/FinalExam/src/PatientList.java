import java.io.*;
import java.util.ArrayList;

public class PatientList {
    public static void writeFile(ArrayList<Patient> Pa) {
        File data = new File("patient.dat");
        if (data.exists()) {
            data.delete();
        }
        try {
            FileOutputStream fos = new FileOutputStream("Patient.dat");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            for (Patient si : Pa) {
                oos.writeObject(si);
            }
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public static void readFile(String FileName) {
        Patient pa = new Patient();
        ArrayList<Patient> paList = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream("Patient.dat");
            ObjectInputStream ois = new ObjectInputStream(fis);
            pa = (Patient) ois.readObject();
            paList.add(pa);
            while (pa != null) {
                pa = (Patient) ois.readObject();
                paList.add(pa);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public int isExist(String code,ArrayList<Patient> a) {
        for(int i=0;i<a.size();i++) {
            if(a.get(i).getCode().equals(code)) {
                return i;
            }
        }
        return -1;
    }
    public void searchPatient() {
        System.out.print("Please enter patient's code to search: ");
        String code = Validation.checkInputCode();
        int check = isExist(code,outPatientList);
        if(check==-1) System.out.println("Patient not found!");
        else {
            System.out.println("out-Patient found!");
            System.out.printf("%-4s %-20s %-10s %-6s %-10s %-10s %-10s %-10s %-10s\n", "Code", "Fullname", "HospitDate","phone",
                    "Gender", "MediCost", "ExamFee", "TestFee", "Hospital Fee");
            outPatientList.get(check).printData();
        }
        int check1 = isExist(code,inPatientList);
        if(check==-1) System.out.println("Patient not found!");
        else {
            System.out.println("in-Patient found!");
            System.out.printf("%-4s %-20s %-10s %-6s %-10s %-10s %-10s %-20s %-20s\n", "Code", "Fullname", "HospitDate",
                    "Gender", "HospitalFee", "DailyFee","MedicineCost", "Phone number","Treatment days");
            inPatientList.get(check1).printData();
        }
    }
public void create(){
    while (true) {
        switch (Hospital.get) {
            case "lion":
                Patient.addAnimal(new Lion());
                return;

            case "elephant":
                Patient.addAnimal(new Elephant());
                return;


            case "Patient":
                System.out.println("Please specify patient type.");
        }
    }
}
}
