package test.your.knowladge;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database {

    private final String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";
    private final String USER = System.getenv("user");
    private final String PASS = System.getenv("pass");
    private final String URL=System.getenv("url");
    private Connection conn;
    private static Database db;
    PreparedStatement stmt;

    private Database() {
        try {
            Class.forName(JDBC_DRIVER);
            // connect to the database
            conn = DriverManager.getConnection(URL, USER, PASS);
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }

    }

    public Connection getConn() {
        return conn;
    }

    public static Database getInstance() {
        if (db == null) {
            db = new Database();
        }
        return db;
    }

    public ResultSet questionQuery(int index) throws SQLException {
        String SearchQuery = "select qestion,a,b,c,d from qes where qestion_num = ?";
        stmt = conn.prepareStatement(SearchQuery);
        stmt.setInt(1, index);
        ResultSet rs = stmt.executeQuery();
        return rs;
    }

    public ResultSet resultQuery(int index) throws SQLException {
        String SearchQuery = "select answer from qes where qestion_num = ?";
        stmt = conn.prepareStatement(SearchQuery);
        stmt.setInt(1, index);
        ResultSet rs = stmt.executeQuery();
        return rs;
    }
}
