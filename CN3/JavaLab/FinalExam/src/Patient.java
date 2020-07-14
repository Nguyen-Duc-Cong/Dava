import java.util.Date;

public class Patient implements IPatient {
    private String code;
    private String fullname;
    private Date hospitalizedDate;
    private String phone;
    private String gender;
    private double medicineCost;

    public Patient() {
    }
    public static Class<?> getAnimalClass() {
        while (true) {
            String type = Validation.getString("Input type(In Patient/Out Patient): ");

            switch (type.toLowerCase()) {
                case "in patient":
                    return In_Patient.class;

                case "out patient":
                    return Out_Patient.class;
            }
        }
    }
    public Patient(String code, String fullname, Date hospitalizedDate, String phone, String gender, double medicineCost) {
        this.code = code;
        this.fullname = fullname;
        this.hospitalizedDate = hospitalizedDate;
        this.phone = phone;
        this.gender = gender;
        this.medicineCost = medicineCost;
    }

    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public String getFullname() {
        return fullname;
    }
    public void setFullname(String fullname) {
        this.fullname = fullname;
    }
    public Date getHospitalizedDate() {
        return hospitalizedDate;
    }
    public void setHospitalizedDate(Date hospitalizedDate) {
        this.hospitalizedDate = hospitalizedDate;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public double getMedicineCost() {
        return medicineCost;
    }
    public void setMedicineCost(double medicineCost) {
        this.medicineCost = medicineCost;
    }

    @Override
    public double getHospitalFee() {
        return 0;
    }

    @Override
    public Patient inputData() {
        return null;
    }

    @Override
    public void printData() {

    }

    @Override
    public Date getDischargedDate() {
        Date d = new Date();
        return d;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "code='" + code + '\'' +
                ", fullname='" + fullname + '\'' +
                ", hospitalizedDate=" + hospitalizedDate +
                ", phone='" + phone + '\'' +
                ", gender='" + gender + '\'' +
                ", medicineCost=" + medicineCost +
                '}';
    }
}
