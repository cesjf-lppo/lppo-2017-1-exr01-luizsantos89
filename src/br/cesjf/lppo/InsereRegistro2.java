
package br.cesjf.lppo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;


public class InsereRegistro2 {
    public static void main(String[] args) {
         try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
             String url = "jdbc:derby://localhost:1527//lppo-2017-1";  
             Connection conexao = DriverManager.getConnection(url, "usuario", "usuario");
             System.out.println("Conexao aberta com sucesso");
             Random rnd = new Random();
             String sql = "INSERT INTO produto(nome,qtd) VALUES('Produto " + rnd.nextInt(100) + "'," + 
                                                                               rnd.nextInt(200) + ")";
             Statement operacao = conexao.createStatement();
             operacao.executeUpdate(sql);
             System.out.println("Registro inserido!");
             
        } catch (ClassNotFoundException ex) {
            System.err.println("Driver Indisponiovel");
            Logger.getLogger(CarregaDriver.class.getName()).log(Level.SEVERE, null, ex);
            
            
        } catch (SQLException ex) {
            System.err.println("Problema ao gravar no banco ");
            Logger.getLogger(InsereRegistro2.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }
}
