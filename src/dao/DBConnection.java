package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
        private static Connection firstInstance = setConnection();

        private static Connection setConnection() {
            Connection connection = null;
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:resources/librarydb.db");
            } catch (ClassNotFoundException | SQLException e) {
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }
            return connection;
        }

        public static Connection getConnection() throws ClassNotFoundException, SQLException {
            return firstInstance;
        }
}

