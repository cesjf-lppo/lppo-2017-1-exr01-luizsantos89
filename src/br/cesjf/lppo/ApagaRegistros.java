
package br.cesjf.lppo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ApagaRegistros {
    public static void main(String[] args) {
         try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
             String url = "jdbc:derby://localhost:1527//lppo-2017-1";  
             Connection conexao = DriverManager.getConnection(url, "usuario", "usuario");
             System.out.println("Conexao aberta com sucesso");
             //Delete com where
             String sql = "DELETE FROM produto WHERE qtd<50";
             Statement operacao = conexao.createStatement();
             Integer n = operacao.executeUpdate(sql);
             System.out.println(n + " registro(s) apagados(s)!");
             
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver Indisponiovel");
            Logger.getLogger(CarregaDriver.class.getName()).log(Level.SEVERE, null, ex);
            
            
        } catch (SQLException ex) {
            System.err.println("Problema ao gravar no banco ");
            Logger.getLogger(ApagaRegistros.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
