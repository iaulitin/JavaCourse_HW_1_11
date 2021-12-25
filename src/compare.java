import java.sql.SQLException;

public class compare {
    public static void main(String[] args) throws SQLException {
        System.out.println(dataBase.compareTables("Dogs1", "Dogs2", "dogs", "dogs2", "name", "color", "owner_id"));
    }
}
