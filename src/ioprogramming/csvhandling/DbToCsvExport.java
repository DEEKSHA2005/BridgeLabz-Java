package ioprogramming.csvhandling;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.sql.*;

public class DbToCsvExport {

    public static void main(String[] args) {

        String url = "jdbc:h2:mem:testdb";
        String user = "sa";
        String password = "";

        try (
                Connection con = DriverManager.getConnection(url, user, password);
                Statement st = con.createStatement();
                BufferedWriter bw = new BufferedWriter(new FileWriter("db_employees.csv"))
        ) {

            // Create table
            st.execute("CREATE TABLE employees (" +
                    "id INT PRIMARY KEY, " +
                    "name VARCHAR(50), " +
                    "department VARCHAR(50), " +
                    "salary DOUBLE)");

            // Insert sample data
            st.execute("INSERT INTO employees VALUES (1,'Ravi','IT',70000)");
            st.execute("INSERT INTO employees VALUES (2,'Asha','HR',50000)");
            st.execute("INSERT INTO employees VALUES (3,'Kiran','Finance',80000)");

            // Fetch records
            ResultSet rs = st.executeQuery("SELECT * FROM employees");

            // Write CSV header
            bw.write("ID,Name,Department,Salary");
            bw.newLine();

            // Write data
            while (rs.next()) {

                bw.write(
                        rs.getInt("id") + "," +
                                rs.getString("name") + "," +
                                rs.getString("department") + "," +
                                rs.getDouble("salary")
                );

                bw.newLine();
            }

            rs.close();

            System.out.println("✅ CSV exported successfully using H2!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

