/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Connection.ConnectionFactory;
import java.sql.*;
import java.sql.Connection;
import javax.swing.JOptionPane;


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
            pstm.setString(1, Login.getUsuario());
            pstm.setString(2, Login.getSenha());
            
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
    
    public boolean testelogin(String user, String senha){
        
        
        String sql = "SELECT * FROM login WHERE user = ?  and senha = ?";
        Boolean teste = false;
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet rset = null;
        
        try{
            
            con = ConnectionFactory.createConnectionToMySQL();
            pstm = con.prepareStatement(sql);
            
            pstm.setString(1, user);
            pstm.setString(2, senha);
            
            rset = pstm.executeQuery();
            
            if (rset.next()){
                
                teste = true;
                
            } else{
                
                JOptionPane.showMessageDialog(null, "Usuario ou senha incorretos");
                
            }
            
        }catch(Exception e){
            
        }finally {
            //fechar as conexões
            try {
                if (rset != null) {
                    rset.close();
                }
                if (pstm != null) {
                    pstm.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return teste;
    }
    
}
