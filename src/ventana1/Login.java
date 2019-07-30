
package ventana1;

import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;


public class Login {
    JTextField username = new JTextField();
JTextField password = new JPasswordField();
Object[] message = {
    "Username:", username,
    "Password:", password
};
public Login(){
iniciar();
}

private void iniciar(){
    int option = JOptionPane.showConfirmDialog(null, message, "Login", JOptionPane.OK_CANCEL_OPTION);
    if (option == JOptionPane.OK_OPTION) {
        if (username.getText().equals("Octi") && password.getText().equals("talleres")) {
            System.out.println("Login successful");
            MiVentana ventanita = new MiVentana();
        } else {
            System.out.println("login failed");
            }
    } else {
        System.out.println("Login canceled");
    }
}
    }
    
    

