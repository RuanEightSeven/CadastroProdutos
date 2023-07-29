/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;
import Connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
    public void delete(ProdutoModel Produto){
       
        
        Connection con = null;
        PreparedStatement pstm = null;
        
        try{
            String sql = "DELETE FROM produtos WHERE codigo = ?";
            con = ConnectionFactory.createConnectionToMySQL();
            pstm = con.prepareStatement(sql);
            pstm.setInt(1, Produto.getCodigo_Produto());
            pstm.execute();
            
        }catch(Exception e){
            
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
    
    public void atualizar(ProdutoModel Produto){
        
        Connection con = null;
        PreparedStatement pstm = null;
        
        try{
            String sql = "UPDATE produtos set nome = ?, valor = ?  WHERE codigo = ?";
            con = ConnectionFactory.createConnectionToMySQL();
            pstm = con.prepareStatement(sql);
            pstm.setString(1, Produto.getNome_produto());
            pstm.setDouble(2, Produto.getValor_Produto());
            pstm.setInt(3, Produto.getCodigo_Produto());
            pstm.execute();
            
            
        }catch(Exception e){
            
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
    
        public List<ProdutoModel> getProdutos()  {
            
            Connection con = null;
            PreparedStatement pstm = null;
            ResultSet rset = null;
            
            
            ArrayList<ProdutoModel> produtos = new ArrayList<>();
            // iniciando a comunicação
            try{
            String sql = "SELECT * FROM produtos";
            con = ConnectionFactory.createConnectionToMySQL();
            pstm = (PreparedStatement) con.prepareStatement(sql);
            rset = pstm.executeQuery();
            
            while(rset.next()){
                
                ProdutoModel produto = new ProdutoModel();
                
                produto.setNome_produto(rset.getString("nome"));
                produto.setCodigo_Produto(rset.getInt("codigo"));
                produto.setValor_Produto(rset.getDouble("valor"));
                produtos.add(produto);
                
            }
            } catch(Exception ex){
               
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
            return produtos;
        }
}
