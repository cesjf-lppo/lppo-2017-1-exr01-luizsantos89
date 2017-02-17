
package br.cesjf.lppo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ListaRegistros2 {
    public static void main(String[] args) {
         try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
             String url = "jdbc:derby://localhost:1527//lppo-2017-1";  
             Connection conexao = DriverManager.getConnection(url, "usuario", "usuario");
             System.out.println("Conexao aberta com sucesso");
             
             String sql = "SELECT nome,200-qtd as qtd FROM produto WHERE qtd>=100";
             Statement operacao = conexao.createStatement();
             ResultSet resultado = operacao.executeQuery(sql);
             System.out.println("Consulta realizada!");
             System.out.println("Nome \t\t A Comprar");
             while(resultado.next()) {
                 System.out.print(resultado.getString(1));
                 System.out.print("\t");
                 System.out.println(resultado.getInt(2));
             }
             
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver Indisponiovel");
            Logger.getLogger(CarregaDriver.class.getName()).log(Level.SEVERE, null, ex);
            
            
        } catch (SQLException ex) {
            System.err.println("Problema ao gravar no banco ");
            Logger.getLogger(ListaRegistros2.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
