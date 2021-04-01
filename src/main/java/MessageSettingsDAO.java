import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageSettingsDAO {

    public static void createDBStructure() {
        Connection connection = getDBConnection();
        PreparedStatement createPreparedStatement = null;
        PreparedStatement insertPreparedStatement = null;
        String create_sql = "Create table MESSAGE_COUNTER(counter int)";
        String insert_sql = "Insert into MESSAGE_COUNTER(counter) values (5)";

        try {
            connection.setAutoCommit(false);
            createPreparedStatement = connection.prepareStatement(create_sql);
            createPreparedStatement.executeUpdate();
            createPreparedStatement.close();

            insertPreparedStatement = connection.prepareStatement(insert_sql);
            insertPreparedStatement.executeUpdate();
            insertPreparedStatement.close();

        } catch (SQLException e) {
            System.out.println("Exception Message " + e.getLocalizedMessage());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                System.out.println("Exception Message " + e.getLocalizedMessage());
            }
        }
    }

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        String dbDriverProperty = Utils.getProperty("db_driver");
        String dbConnectionProperty = Utils.getProperty("db_connection");
        String dbUserProperty = Utils.getProperty("db_user");
        String dbpasswordProperty = Utils.getProperty("db_password");
        try {
            Class.forName(dbDriverProperty);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(dbConnectionProperty, dbUserProperty, dbpasswordProperty);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

}
