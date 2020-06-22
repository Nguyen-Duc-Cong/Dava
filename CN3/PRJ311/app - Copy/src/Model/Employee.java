package Model;

import java.util.ArrayList;
import java.util.Vector;

public class Employee {
    private String empID;
    private String lastName;
    private String firstName;
    private String gender;
    private String email;

    public Employee() {
    }

    public Employee(String empID, String lastName, String firstName, String gender, String email) {
        this.empID = empID;
        this.lastName = lastName;
        this.firstName = firstName;
        this.gender = gender;
        this.email = email;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void add(ArrayList v) {
        this.empID = (String) v.get(0);
        this.lastName= (String) v.get(1);
        this.firstName= (String) v.get(2);
        this.gender= (String) v.get(3);
        this.email= (String) v.get(4);
    }
}
