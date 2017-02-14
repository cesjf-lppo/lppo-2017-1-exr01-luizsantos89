
package br.cesjf.lppo;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CarregaDriver {

    
    public static void main(String[] args) {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CarregaDriver.class.getName()).log(Level.SEVERE, null, ex);
            System.err.println("Driver não encontrado");
            
        }
    }
    
}
