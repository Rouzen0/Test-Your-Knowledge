package test.your.knowladge;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {

    private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String USER = "scott";
    private final String PASS = "tiger";
    private Connection conn;
    private static Database db;

    private Database() {
        try {
            Class.forName(JDBC_DRIVER);
            // connect the database
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", USER, PASS);
        } catch (Exception ex) {
           System.err.println(ex.getMessage());
        }

    }

    public static Database getInstance() {
        if(db==null){
        db=new Database();
        }
        return db;
    }
}
