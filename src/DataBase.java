import java.sql.*;

public class DataBase {
    private static String getQuery(String table, String... columns) {
        StringBuilder query = new StringBuilder("SELECT ");
        for (String column : columns) {
            query.append(column).append(", ");
        }
        query.deleteCharAt(query.length() - 2);
        query.append("FROM ").append(table).append(" ORDER BY ");
        for (String column : columns) {
            query.append(column).append(", ");
        }
        query.deleteCharAt(query.length() - 2);
        return query.toString();
    }

    private static boolean privateCompareTables(Statement stmt1, Statement stmt2, String table1, String table2, String... columns) throws SQLException, ClassNotFoundException {
        Class.forName("org.postgresql.Driver");

        ResultSet rs1 = stmt1.executeQuery(getQuery(table1, columns));
        ResultSet rs2 = stmt2.executeQuery(getQuery(table2, columns));

        // че не получилось придумать, что можно сделать со вложенностью
        while (rs1.next() & rs2.next()) {
            for (String column : columns) {
                if (!rs1.getObject(column).equals(rs2.getObject(column))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean compareTables(String login, String password, String db1, String db2, String table1, String table2, String... columns) {
        try (Connection conn1 = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/" + db1,
                login, password);
             Statement stmt1 = conn1.createStatement();
             Connection conn2 = DriverManager.getConnection(
                     "jdbc:postgresql://localhost:5432/" + db2,
                     login, password);
             Statement stmt2 = conn2.createStatement()) {

            return privateCompareTables(stmt1, stmt2, table1, table2, columns);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return true;
    }
}
