/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Connection;
import java.sql.*;
/**
 *
 * @author 55119
 */
public class ConnectionFactory {
    //conectar com os dados do banco no computador e inserir o link para o banco que iremos usar
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/estoque_produtos";
    
    public static Connection createConnectionToMySQL() throws Exception{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        return connection;
    }
    public static void main (String[] args) throws Exception{
        Connection con = createConnectionToMySQL();
        if (con != null){
            System.out.println("connection sucessfull");
            con.close();
        }
        
    }
   
}
