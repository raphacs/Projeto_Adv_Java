/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConexaoAccess;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author rapha
 */
public class BancoAccess {
    static Connection con = null;
    static String driver = "net.ucanaccess.jdbc.UcanaccessDriver";
    static String url = "jdbc:ucanaccess://C:\\Users\\rapha\\Desktop\\projeto mae\\clientes.mdb";
    
    
    public static Connection obtendoConexao(){
       try{
           if(con == null){
               Class.forName(driver);
               con = DriverManager.getConnection(url);
               JOptionPane.showMessageDialog(null, "Conexão correta");
           }
       } catch(Exception ex){
           ex.printStackTrace();
           con = null;
       }
       return con;
    }
    public static void main(String[] args) throws SQLException {
        Connection cn = BancoAccess.obtendoConexao();
        
        PreparedStatement pesquisa = con.prepareStatement("SELECT * FROM CLIENTES");
        ResultSet resultado = pesquisa.executeQuery();
        while(resultado.next()){
            String nome = resultado.getString("NOME");
            resultado.updateRow();
            
            System.out.println("Nome:"+nome);
        }
    }
}
