import java.sql.SQLException;

public class compare {
    public static void main(String[] args) throws SQLException {
        System.out.println(DataBase.compareTables("postgres", "postgres", "Dogs1", "Dogs2", "dogs", "dogs2", "owner_id", "name", "color"));
        }
}
