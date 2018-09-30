/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import modelo.Usuarios;
import org.hibernate.Query;
import org.hibernate.Transaction;
import vista.Gestor;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class ControladorUsuarios implements ActionListener {
    // Llamamos a esta clase desde la clase inicio para mostrar el menú principal.
    // Para mostrar el menú principal debemos crear un objeto menuCursos.
    protected Gestor menuUsuarios = null;
    // Inicializamos la variable para personalizar los mensajes de las excepciones.
    String exc;
    
    ControladorMenu _escuchador;
    
    boolean registrarUsuario;
    
    public void ControladorUsuarios(Gestor menu,ControladorMenu escuchador){
        menuUsuarios=menu;
        _escuchador=escuchador;
        
        if(_escuchador.getEscuchadorUsuarios()==false){
            _escuchador.setEscuchadorUsuarios(true);
            RegistrarEventos();
        }
        
        boolean registrarUsuario=_escuchador.registrarUsuario;
    }
    
    //Es función controla si el botón btnAltas esta activo o no  si los jtextfiel estan vacios o no.
//https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    public DocumentListener HabilitarBotonesUsuarios() { 

        DocumentListener documento;

        documento = new DocumentListener() {
            public void HayCambio() {
            
                menuUsuarios.BotonIdentificarUsuario.setEnabled(
                    (registrarUsuario==true) || 
                    (!menuUsuarios.campoUsuario.getText().isEmpty() &&
                    !String.valueOf(menuUsuarios.campoPassword.getPassword()).isEmpty() && 
                    registrarUsuario==false)
                );
                
                menuUsuarios.BotonRegistrarUsuario.setEnabled(
                    (registrarUsuario==false) || 
                    (!menuUsuarios.campoUsuario.getText().isEmpty() &&
                    !String.valueOf(menuUsuarios.campoPassword.getPassword()).isEmpty() && 
                    registrarUsuario==true)
                );
            
            }

            @Override
            public void insertUpdate(DocumentEvent e) { //Se invoca cuando  se inserta en el documento escuchado
                HayCambio();
            }

            @Override
            public void removeUpdate(DocumentEvent e) { //Se invoca cuando se elimina texto del documento escuchado
                HayCambio();
            }

            @Override
            public void changedUpdate(DocumentEvent e) { //Se invoca cuando cambia el documento que escucha
                HayCambio();
            }
        };
        return documento;
    }
    
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==menuUsuarios.getBotonRegistrarUsuario()){
            if(registrarUsuario==false){
                registrarUsuario=true;
                menuUsuarios.tituloInicioSesion.setText("Registrar usuario");
                menuUsuarios.usuario.setText("Introduce tu nombre de usuario");
                menuUsuarios.password.setText("Introduce tu contraseña");
                menuUsuarios.BotonRegistrarUsuario.setText("Crear");
                menuUsuarios.BotonIdentificarUsuario.setText("Cancelar");
                menuUsuarios.campoUsuario.setText("");
                menuUsuarios.campoPassword.setText("");
                menuUsuarios.BotonIdentificarUsuario.setEnabled(true);
                menuUsuarios.BotonRegistrarUsuario.setEnabled(false);
            }
            else{
                exc="";
                if(menuUsuarios.campoUsuario.getText().trim().length()==0){exc="El nombre de usuario está vacío. Introduzca uno válido.";}
                else if(menuUsuarios.campoUsuario.getText().trim().length()>20){exc="El nombre de usuario tiene más de 20 caracteres. Introduzca uno válido.";}
                if(String.valueOf(menuUsuarios.campoPassword.getPassword()).trim().length()==0){exc="La contraseña está vacía. Introduzca una válida.";}
                else if(String.valueOf(menuUsuarios.campoPassword.getPassword()).trim().length()>20){exc="La contraseña tiene más de 20 caracteres. Introduzca una válida.";}
                
                if(exc.length()==0){
                    Transaction tx = _escuchador.session.beginTransaction();
                    try {
                        String nombreUsuario = menuUsuarios.campoUsuario.getText();

                        byte[] salt = new byte[16];
                        //Genera sal aleatoriamente
                        //new Random().nextBytes(salt);
                        Arrays.fill(salt, (byte) 0);

                        KeySpec key = new PBEKeySpec(menuUsuarios.campoPassword.getPassword(), salt, 10000, 128);
                        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                        byte[] hash = f.generateSecret(key).getEncoded();

                        Base64.Encoder enc = Base64.getEncoder();
                        System.out.println(enc.encodeToString(hash));

                        Usuarios usuario = new Usuarios(nombreUsuario,enc.encodeToString(hash));
                        _escuchador.session.save(usuario);
                        tx.commit();
                        registrarUsuario=false;
                        menuUsuarios.tituloInicioSesion.setText("Iniciar sesión");
                        menuUsuarios.usuario.setText("Nombre de usuario");
                        menuUsuarios.password.setText("Contraseña");
                        menuUsuarios.BotonRegistrarUsuario.setText("Registrarse");
                        menuUsuarios.BotonIdentificarUsuario.setText("Entrar");
                        menuUsuarios.campoUsuario.setText("");
                        menuUsuarios.campoPassword.setText("");
                        String aviso="Se ha registrado correctamente.";
                        VentanaMensajeAviso(aviso);
                    } catch (Exception ex) {
                        tx.rollback();
                        ex.printStackTrace();
                        String error="El nombre introducido ya existe. Introduzca uno diferente.";
                        VentanaMensajeError(error);
                    }
                    _escuchador.session.clear();
                }
                else{
                    VentanaMensajeError(exc);
                }
            }
        }
        else if(e.getSource()==menuUsuarios.getBotonIdentificarUsuario()){
            if(registrarUsuario==false){
                exc="";
                if(menuUsuarios.campoUsuario.getText().trim().length()==0){exc="El nombre de usuario está vacío. Introduzca uno válido.";}
                else if(menuUsuarios.campoUsuario.getText().trim().length()>20){exc="El nombre de usuario tiene más de 20 caracteres. Introduzca uno válido.";}
                if(String.valueOf(menuUsuarios.campoPassword.getPassword()).trim().length()==0){exc="La contraseña está vacía. Introduzca una válida.";}
                else if(String.valueOf(menuUsuarios.campoPassword.getPassword()).trim().length()>20){exc="La contraseña tiene más de 20 caracteres. Introduzca una válida.";}
                
                if(exc.length()==0){
                    Transaction tx = _escuchador.session.beginTransaction();
                    try {
                        String nombreUsuario = menuUsuarios.campoUsuario.getText();
                        
                        // Realizamos la consulta de la contraseña correspondiente al nombre de usuario que acabamos de introducir.
                        Query q = _escuchador.session.createQuery("from Usuarios where usuario='"+nombreUsuario+"'");
                        List<Usuarios> lista = q.list();
                        
                        String pass = lista.get(0).getPassword();
                        
                        tx.commit();
                        
                        byte[] salt = new byte[16];
                        //Genera sal aleatoriamente
                        //new Random().nextBytes(salt);
                        //En este caso crearemos la sal de forma predeterminada como un conjunto de ceros.
                        Arrays.fill(salt, (byte) 0);
                        
                        // Establecemos el tipo de hash
                        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
                        // Hash de la contraseña introducida.
                        KeySpec myKey = new PBEKeySpec(menuUsuarios.campoPassword.getPassword(), salt, 10000, 128);
                        byte[] myHash = f.generateSecret(myKey).getEncoded();
                        
                        // Declaramos codificador base64 para convertir los arrays de bytes a string.
                        Base64.Encoder enc = Base64.getEncoder();
                        
                        // Comparar el hash calculado con el almacenado en la base de datos.
                        if(pass.equals(enc.encodeToString(myHash))){
                            menuUsuarios.panelInicioSesion.setVisible(false);
                            menuUsuarios.barraInicio.setVisible(true);
                            menuUsuarios.jLabel1.setVisible(true);
                            menuUsuarios.bienvenida.setVisible(true);
                            menuUsuarios.imagen.setVisible(true);
                        }
                        else{
                            exc="Contraseña incorrecta.";
                            VentanaMensajeError(exc);
                        }
                        
                    } catch (Exception ex) {
                        tx.rollback();
                        ex.printStackTrace();
                        String error="El nombre introducido no existe.";
                        VentanaMensajeError(error);
                    }
                    _escuchador.session.clear();
                }
                else{
                    VentanaMensajeError(exc);
                }
            }
            else{
                registrarUsuario=false;
                menuUsuarios.tituloInicioSesion.setText("Iniciar sesión");
                menuUsuarios.usuario.setText("Nombre de usuario");
                menuUsuarios.password.setText("Contraseña");
                menuUsuarios.BotonRegistrarUsuario.setText("Registrarse");
                menuUsuarios.BotonIdentificarUsuario.setText("Entrar");
                menuUsuarios.campoUsuario.setText("");
                menuUsuarios.campoPassword.setText("");
                menuUsuarios.BotonIdentificarUsuario.setEnabled(false);
                menuUsuarios.BotonRegistrarUsuario.setEnabled(true);
            }
        }
    }
    
    public void VentanaMensajeError(String ex) {
        JOptionPane.showMessageDialog(null, ex, "Excepción", JOptionPane.ERROR_MESSAGE);
    }
    
    public void VentanaMensajeAviso(String av) {
        JOptionPane.showMessageDialog(null, av, "Excepción", JOptionPane.INFORMATION_MESSAGE);
    }
    
    public void RegistrarEventos() {
        menuUsuarios.getBotonRegistrarUsuario().addActionListener(this);
        menuUsuarios.getBotonIdentificarUsuario().addActionListener(this);
        menuUsuarios.campoUsuario.getDocument().addDocumentListener(HabilitarBotonesUsuarios());
        menuUsuarios.campoPassword.getDocument().addDocumentListener(HabilitarBotonesUsuarios());
    }
}
