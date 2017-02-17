
package br.cesjf.lppo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ListaRegistros {
    public static void main(String[] args) {
         try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
             String url = "jdbc:derby://localhost:1527//lppo-2017-1";  
             Connection conexao = DriverManager.getConnection(url, "usuario", "usuario");
             System.out.println("Conexao aberta com sucesso");
             
             String sql = "SELECT nome,qtd,atualizado FROM produto";
             Statement operacao = conexao.createStatement();
             ResultSet resultado = operacao.executeQuery(sql);
             System.out.println("Consulta realizada!");
             System.out.println("Nome \t\t QTD \t Atualizado");
             while(resultado.next()) {
                 System.out.print(resultado.getString("nome"));
                 System.out.print("\t");
                 System.out.print(resultado.getInt("qtd"));
                 System.out.print("\t");
                 System.out.println(resultado.getTimestamp("atualizado"));
             }
             
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver Indisponiovel");
            Logger.getLogger(CarregaDriver.class.getName()).log(Level.SEVERE, null, ex);
            
            
        } catch (SQLException ex) {
            System.err.println("Problema ao gravar no banco ");
            Logger.getLogger(ListaRegistros.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
