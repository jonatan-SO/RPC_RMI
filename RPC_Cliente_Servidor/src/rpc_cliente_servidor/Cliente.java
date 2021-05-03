
package rpc_cliente_servidor;

import java.util.Vector;
import javax.swing.JOptionPane;
import org.apache.xmlrpc.XmlRpcClient;

public class Cliente {
    public static void main(String[] args) {

        String x="", y="";
        
        Object resultado;
        
        try{
            XmlRpcClient cliente = new XmlRpcClient("http://192.168.1.74:8080");
            Vector<String> parametros = new Vector<String>();
            
            JOptionPane.showMessageDialog(null,"El cliente se ha conectado");
            
            while(true){
                String menu = JOptionPane.showInputDialog(null, "Suma de dos numeros\n"
                + "1.- Sumar\n"
                + "2.- Salir\n", "Cliente Servidor RPC", JOptionPane.DEFAULT_OPTION);
                switch(menu){
                    case "1":
                        x = JOptionPane.showInputDialog(null, "Primer Numero", "suma", JOptionPane.QUESTION_MESSAGE);
                        y = JOptionPane.showInputDialog(null, "Segundo Numero", "suma", JOptionPane.QUESTION_MESSAGE);
                        
                        parametros.addElement(x);
                        parametros.addElement(y);
                        
                        resultado = cliente.execute("miServidorRPC.suma", parametros);
                        
                        JOptionPane.showMessageDialog(null, "La suma es: " + resultado);
                        parametros.clear();
                        
                        break;
                    case "2":
                        JOptionPane.showMessageDialog(null,"Saliendo", null, JOptionPane.WARNING_MESSAGE);
                        System.exit(0);
                    break;
                }                      

            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
        }
    }
    
}
