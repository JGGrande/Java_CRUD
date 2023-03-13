package models;

import com.mysql.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;

public class dbConection {

    //nome do usuario
    private static final String USERNAME = "root";
    //senha do nanco
    private static final String PASSWORD = "1234";
    //caminho do banco
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/teste_gazin";

    public static Connection createConnectionToMySql() throws Exception {
       Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);

        return connection;
    }

    public static void main(String[] args) throws Exception {
        Connection con = createConnectionToMySql();

        if (con != null){
            System.out.println("Conecção bem sucedida");
            con.close();
        }
    }

}
