
import java.sql.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/college",
                "root",
                "your_password"
            );

            int choice;

            do {
                System.out.println("\n--- Student CRUD Menu ---");
                System.out.println("1. Insert Student");
                System.out.println("2. Display Students");
                System.out.println("3. Update Student");
                System.out.println("4. Delete Student");
                System.out.println("5. Exit");
                System.out.print("Enter Choice: ");

                choice = sc.nextInt();

                if (choice == 1) {
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Marks: ");
                    int marks = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                        "INSERT INTO Student VALUES(?, ?, ?)"
                    );

                    ps.setInt(1, id);
                    ps.setString(2, name);
                    ps.setInt(3, marks);

                    int rows = ps.executeUpdate();
                    System.out.println(rows + " row inserted.");
                    ps.close();

                } else if (choice == 2) {
                    Statement st = con.createStatement();
                    ResultSet rs = st.executeQuery(
                        "SELECT * FROM Student"
                    );

                    while (rs.next()) {
                        System.out.println(
                            rs.getInt("id") + " " +
                            rs.getString("name") + " " +
                            rs.getInt("marks")
                        );
                    }

                    rs.close();
                    st.close();

                } else if (choice == 3) {
                    System.out.print("Enter ID to update: ");
                    int id = sc.nextInt();

                    System.out.print("Enter new marks: ");
                    int marks = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                        "UPDATE Student SET marks=? WHERE id=?"
                    );

                    ps.setInt(1, marks);
                    ps.setInt(2, id);

                    int rows = ps.executeUpdate();
                    System.out.println(rows + " row updated.");
                    ps.close();

                } else if (choice == 4) {
                    System.out.print("Enter ID to delete: ");
                    int id = sc.nextInt();

                    PreparedStatement ps = con.prepareStatement(
                        "DELETE FROM Student WHERE id=?"
                    );

                    ps.setInt(1, id);

                    int rows = ps.executeUpdate();
                    System.out.println(rows + " row deleted.");
                    ps.close();

                } else if (choice == 5) {
                    System.out.println("Program Exited.");

                } else {
                    System.out.println("Invalid Choice.");
                }

            } while (choice != 5);

            con.close();

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
