package Model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class EmployeeDB {
    Connection connection = null;

    public EmployeeDB() {
    }

    public Vector<Employee> getList() {
        Vector employees = new Vector();

        try {
            String sql = "SELECT * FROM Emp_ID";
            connection = ConnectDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Vector v = new Vector<>();
                v.add(resultSet.getString(1));
                v.add(resultSet.getString(2));
                v.add(resultSet.getString(3));
                v.add(resultSet.getString(4));
                v.add(resultSet.getString(5));
                employees.add(v);
            }
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employees;
    }

    public int newEmp(String empID, String lastName, String firstName, String gender, String email) {
        int rc = 0;
        try {
            String sql = "INSERT INTO Emp_ID (empID, lastName, firstName, gender, email)VALUES( ?, ?, ?, ?, ?)";
            connection = ConnectDB.getConnection();
            PreparedStatement preparedStatement =
                    connection.prepareStatement(sql);
            preparedStatement.setString(1, empID);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, firstName);
            preparedStatement.setString(4, gender);
            preparedStatement.setString(5, email);
            rc = preparedStatement.executeUpdate();

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rc;

    }

    public Employee getEmployee(String empID) {
        //Kiểm tra trùng khóa
        Employee employee = new Employee();
        try {
            String sql = "SELECT * FROM Emp_ID WHERE empID = " + empID;

            connection = ConnectDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            if (resultSet.next()) {
                ArrayList v = new ArrayList();
                v.add(resultSet.getString(1));
                v.add(resultSet.getString(2));
                v.add(resultSet.getString(3));
                v.add(resultSet.getString(4));
                v.add(resultSet.getString(5));
                employee.add(v);
                return employee;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

