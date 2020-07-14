import java.io.Serializable;
import java.util.Date;

public class In_Patient extends Patient implements Serializable {
    private static final long serialVersionUID = 1L;
    private double dailyFee;
    private Date dissDate;

    public In_Patient() {
    }

    public In_Patient(String code, String fullname, Date hospitalizedDate, String phone, String gender, double medicineCost, double dailyFee, Date dissDate) {
        super(code, fullname, hospitalizedDate, phone, gender, medicineCost);
        this.dailyFee = dailyFee;
        this.dissDate = dissDate;
    }
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }
    public double getDailyFee() {
        return dailyFee;
    }
    public void setDailyFee(double dailyFee) {
        this.dailyFee = dailyFee;
    }
    public Date getDissDate() {
        return dissDate;
    }
    public void setDissDate(Date dissDate) {
        this.dissDate = dissDate;
    }
    @Override
    public double getHospitalFee() {
        int numDates= (int)((dissDate.getTime()-super.getHospitalizedDate().getTime())/(1000 * 60 * 60 * 24));
        double medicineFee = super.getMedicineCost()*numDates;
        return dailyFee*numDates+medicineFee;
    }
    @Override
    public void printData() {
        System.out.printf("%-4s %-20s %2td/%2tm/%4tY %-12s %-10s %-10.2f %-10.2f %2td/%2tm/%4tY %10.2f\n",super.getCode(),super.getFullname(),
                super.getHospitalizedDate(),super.getHospitalizedDate(),super.getHospitalizedDate(),super.getGender(),super.getPhone(),super.getMedicineCost(),
                getDailyFee(),getDischargedDate(),getDischargedDate(),getDischargedDate(),getHospitalFee());
    }
}
