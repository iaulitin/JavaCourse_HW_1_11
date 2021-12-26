package tkhorzhevskiy;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) throws SQLException {
        System.out.println(gaymers.compareTables("gaymers", "alternate_unviverse_gaymers", "gaymers", "alternate_unviverse_gaymers", "id"));
        System.out.println(gaymers.compareTables("gaymers", "alternate_unviverse_gaymers", "gaymers", "alternate_unviverse_gaymers", "name"));
        System.out.println(gaymers.compareTables("gaymers", "alternate_unviverse_gaymers", "gaymers", "alternate_unviverse_gaymers", "discordtag"));
        System.out.println(gaymers.compareTables("gaymers", "alternate_unviverse_gaymers", "gaymers", "alternate_unviverse_gaymers", "favouritegame"));
    }
}
