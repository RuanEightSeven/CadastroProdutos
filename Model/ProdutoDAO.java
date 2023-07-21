/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Connection.ConnectionFactory;
import java.sql.*;

/**
 *
 * @author 55119
 */
public class ProdutoDAO {
    
    // criando o metodo de salvar informações no banco de dados
    public void save(ProdutoModel Produto){
        // statement pra executar na query e adicionar os valores
        String sql = "INSERT INTO produtos (nome, codigo, valor) VALUES (?, ?, ?) ";
        
        Connection con = null;
        PreparedStatement pstm = null;
        
        try{
            con = ConnectionFactory.createConnectionToMySQL();
            //instanciar a conexão
            pstm = con.prepareStatement(sql);
            pstm.setString(1, Produto.getNome_produto());
            pstm.setInt(2, Produto.getCodigo_Produto());
            pstm.setDouble(3, Produto.getValor_Produto());
            pstm.execute();
            
            
        } catch(Exception e){
            e.printStackTrace();
        }finally{
            try{
                if(pstm !=null){
                    pstm.close();
                }
                if(con !=null){
                    con.close();
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }        
    }
}
