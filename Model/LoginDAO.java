/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author 55119
 */
public class LoginDAO {
    
    public void save(LoginModel Login){
        
        String sql = "INSERT INTO login (user, senha) VALUES (?, ?) ";
        
        Connection con = null;
        PreparedStatement pstm = null;
        
        try{
            con = ConnectionFactory.createConnectionToMySQL();
            //instanciar a conexão
            pstm = con.prepareStatement(sql);
            pstm.setString(0, Login.getUsuario());
            pstm.setString(1, Login.getSenha());
            pstm.execute();
            
            
        } catch(Exception e){
        }finally{
            try{
                if(pstm !=null){
                    pstm.close();
                }
                if(con !=null){
                    con.close();
                }
            }catch(SQLException e){
            }
        }
    }
    
}
