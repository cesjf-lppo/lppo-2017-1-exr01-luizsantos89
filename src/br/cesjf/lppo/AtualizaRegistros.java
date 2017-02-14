
package br.cesjf.lppo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class AtualizaRegistros {
    public static void main(String[] args) {
         try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
             String url = "jdbc:derby://localhost:1527//lppo-2017-1";  
             Connection conexao = DriverManager.getConnection(url, "usuario", "usuario");
             System.out.println("Conexao aberta com sucesso");
             
             String sql = "UPDATE produto SET qtd=qtd-1, atualizado = CURRENT_TIMESTAMP WHERE qtd>=100";
             Statement operacao = conexao.createStatement();
             Integer n = operacao.executeUpdate(sql);
             System.out.println(n + " registro(s) atualizado(s)!");
             
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver Indisponiovel");
            Logger.getLogger(CarregaDriver.class.getName()).log(Level.SEVERE, null, ex);
            
            
        } catch (SQLException ex) {
            System.err.println("Problema ao gravar no banco ");
            Logger.getLogger(AtualizaRegistros.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
