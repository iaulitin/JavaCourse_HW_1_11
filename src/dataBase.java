import java.sql.*;

public class dataBase {

    public static boolean compareTables(String db1, String db2, String table1, String table2, String... rows) throws SQLException {
        try (Connection conn1 = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/" + db1,
                "postgres", "6580");
             Statement stmt1 = conn1.createStatement();
             Connection conn2 = DriverManager.getConnection(
                     "jdbc:postgresql://localhost:5432/" + db2,
                     "postgres", "6580");
             Statement stmt2 = conn2.createStatement()) {

            Class.forName("org.postgresql.Driver");

            ResultSet rs1 = stmt1.executeQuery("SELECT * FROM " + table1 + " ORDER BY " + rows[0]);
            ResultSet rs2 = stmt2.executeQuery("SELECT * FROM " + table2 + " ORDER BY " + rows[0]);

            while (rs1.next() & rs2.next()) {
                for (String row : rows) {
                    if (!rs1.getObject(row).equals(rs2.getObject(row))) {
                        return false;
                    }

                }

            }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
