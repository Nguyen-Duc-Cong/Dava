import java.io.Serializable;
import java.util.Date;

public class Out_Patient extends Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    private double examFee;
    private double testFee;

    public Out_Patient() {
    }

    public Out_Patient(String code, String fullname, Date hospitalizedDate, String phone, String gender, double medicineCost, double examFee, double testFee) {
        super(code, fullname, hospitalizedDate, phone, gender, medicineCost);
        this.examFee = examFee;
        this.testFee = testFee;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public double getExamFee() {
        return examFee;
    }
    public void setExamFee(double examFee) {
        this.examFee = examFee;
    }
    public double getTestFee() {
        return testFee;
    }
    public void setTestFee(double testFee) {
        this.testFee = testFee;
    }

    @Override
    public double getHospitalFee() {
        double medicineFee = super.getMedicineCost();
        return examFee+testFee+medicineFee;
    }

    @Override
    public void printData() {
        System.out.printf("%-4s %-20s %2td/%2tm/%4tY %-10s %-12s %-10.2f %-10.2f %-10.2f %10.2f\n",super.getCode(),super.getFullname(),
                super.getHospitalizedDate(),super.getHospitalizedDate(),super.getHospitalizedDate(),super.getGender(),super.getPhone(),super.getMedicineCost(),
                getExamFee(),getTestFee(),getHospitalFee());
    }
}
