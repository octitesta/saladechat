/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ventana1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import main.ClienteChat;

/**
 *
 * @author octa
 */
public class MiVentana extends JFrame{
    public MiVentana(){
        iniciarVentana();
        iniciarComponentes();
        setVisible(true);

        
    }
    private void iniciarVentana(){
        this.setTitle("Mi Ventana");
        this.setSize(500,500);
        this.setResizable(false);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
    }
    private void iniciarComponentes(){
        JTextArea area=new JTextArea();
        area.setBounds(20, 20, 460, 350);
        area.setEditable(false);
        ClienteChat chat = new ClienteChat("192.168.61.11", "2000", area);
        chat.conectar();
         
        JTextField escribir=new JTextField();
        escribir.setBounds(20,390,460,25);
        
        JButton borrar=new JButton();
        borrar.setText("Borrar");
        borrar.setBounds(240,430,100,30);
        
        JButton enviar=new JButton();
        enviar.setText("Enviar");
        enviar.setBounds(380,430,100,30);
        
        JButton salir=new JButton();
        salir.setText("Salir");
        salir.setBounds(20,450,80,30);
        
        JCheckBox check=new JCheckBox();
        check.setText("Agregar al final");
        check.setBounds(20,420,200,30);
        check.setSelected(true);
        
        enviar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ea){
                chat.EnviarMensaje("Octi", escribir.getText());
                escribir.setText("");
                /*
                if (check.isSelected()){
                    String guardar = area.getText();
                    area.setText(guardar+"Octi: "+ escribir.getText()+"\n");
                    escribir.setText("");
                }else{
                String guardar = area.getText();
                area.setText("Octi: "+escribir.getText()+"\n"+ guardar);
                escribir.setText("");}*/
            }}
        );
        
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ea){
                int optionPane = JOptionPane.showConfirmDialog(rootPane, "Estas seguro?","Cuidado",JOptionPane.YES_NO_OPTION);
                if(optionPane == JOptionPane.YES_OPTION){
                area.setText("");
                escribir.setText("");
                }
            }}
        );
        
        salir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ea){
                MiVentana.super.dispose();
                Login login=new Login();
                }
            }
        );
        
        add(check);
        add(area);
        add(escribir);
        add(borrar);
        add(enviar);
        add(salir);
    }
    
}

