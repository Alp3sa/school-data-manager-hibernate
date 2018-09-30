/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import modelo.Usuarios;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vista.Gestor;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class ControladorMenu implements ActionListener{
    Session session;
    
    // Llamamos a esta clase desde la clase inicio para mostrar el menú principal.
    // Para mostrar el menú principal debemos crear un objeto menuGrupos.
    protected Gestor menu = null;
    
    // Control del registro de usuarios
    boolean registrarUsuario=false;
    
    ControladorGrupos mostrarGrupos;
    ControladorDepartamentos mostrarDepartamentos;
    ControladorProfesores mostrarProfesores;
    ControladorAlumnos mostrarAlumnos;
    ControladorTutorias mostrarTutorias;
    ControladorCursos mostrarCursos;
    ControladorAsignaturas mostrarAsignaturas;
    ControladorHorarios mostrarHorarios;
    ControladorAulas mostrarAulas;
    ControladorUsuarios mostrarUsuarios;
    
    boolean escuchadorAulas=false;
    boolean escuchadorHorarios=false;
    boolean escuchadorGrupos=false;
    boolean escuchadorDepartamentos=false;
    boolean escuchadorProfesores=false;
    boolean escuchadorAlumnos=false;
    boolean escuchadorTutorias=false;
    boolean escuchadorCursos=false;
    boolean escuchadorAsignaturas=false;
    boolean escuchadorUsuarios=false;
    
    public boolean getEscuchadorAulas() {
        return escuchadorAulas;
    }
    
    public void setEscuchadorAulas(boolean Escuchador) {
        escuchadorAulas=Escuchador;
    }
    
    public boolean getEscuchadorHorarios() {
        return escuchadorHorarios;
    }
    
    public void setEscuchadorHorarios(boolean Escuchador) {
        escuchadorHorarios=Escuchador;
    }
    
    public boolean getEscuchadorAsignaturas() {
        return escuchadorAsignaturas;
    }
    
    public void setEscuchadorAsignaturas(boolean Escuchador) {
        escuchadorAsignaturas=Escuchador;
    }
    
    public boolean getEscuchadorCursos() {
        return escuchadorCursos;
    }
    
    public void setEscuchadorCursos(boolean Escuchador) {
        escuchadorCursos=Escuchador;
    }
    
    public boolean getEscuchadorGrupos() {
        return escuchadorGrupos;
    }
    
    public void setEscuchadorGrupos(boolean Escuchador) {
        escuchadorGrupos=Escuchador;
    }
    
    public boolean getEscuchadorDepartamentos() {
        return escuchadorDepartamentos;
    }
    
    public void setEscuchadorDepartamentos(boolean Escuchador) {
        escuchadorDepartamentos=Escuchador;
    }
    
    public boolean getEscuchadorProfesores() {
        return escuchadorProfesores;
    }
    
    public void setEscuchadorProfesores(boolean Escuchador) {
        escuchadorProfesores=Escuchador;
    }
    
    public boolean getEscuchadorAlumnos() {
        return escuchadorAlumnos;
    }
    
    public void setEscuchadorAlumnos(boolean Escuchador) {
        escuchadorAlumnos=Escuchador;
    }
    
    public boolean getEscuchadorTutorias() {
        return escuchadorTutorias;
    }
    
    public void setEscuchadorTutorias(boolean Escuchador) {
        escuchadorTutorias=Escuchador;
    }
    
    public boolean getEscuchadorUsuarios() {
        return escuchadorUsuarios;
    }
    
    public void setEscuchadorUsuarios(boolean Escuchador) {
        escuchadorUsuarios=Escuchador;
    }
    
    public boolean getRegistrarUsuario() {
        return registrarUsuario;
    }
    
    public void setRegistrarUsuario(boolean registrar) {
        registrarUsuario=registrar;
    }
    
    public ControladorMenu() {
        // Mostramos la interfaz
        menu = new Gestor();
        
        // Maximizamos la ventana
        GraphicsEnvironment env = GraphicsEnvironment.getLocalGraphicsEnvironment();
        menu.setMaximizedBounds(env.getMaximumWindowBounds());
        menu.setExtendedState(menu.getExtendedState() | menu.MAXIMIZED_BOTH);
        // Dejamos como nulo el posicionamiento de la ventana
        menu.setLocationRelativeTo(null);
        // Permitimos redimensionar la ventana
        menu.setResizable(true);
        // Establecemos el título de la ventana
        menu.setTitle("Gestor de datos | I.E.S. El Rincón");
        // Establecemos el icono del programa
        try{
            menu.setIconImage(new ImageIcon(getClass().getResource("/Imagenes/icono.jpg")).getImage());
        }
        catch(Exception e){System.out.println("Icono no encontrado");}
        // Colocamos al mismo nivel todas las capas de los diferentes apartados dentro del LeyeredPanel
        menu.panel.setComponentZOrder(menu.panelInicioSesion, 0);
        menu.panel.setComponentZOrder(menu.opcionesCentro, 0);
        menu.panel.setComponentZOrder(menu.opcionesAlumnado, 0);
        menu.panel.setComponentZOrder(menu.opcionesProfesorado, 0);
        menu.capas.setComponentZOrder(menu.panelHorarios, 0);
        menu.capas.setComponentZOrder(menu.panelAulas, 0);
        menu.capas.setComponentZOrder(menu.panelCursos, 0);
        menu.capas.setComponentZOrder(menu.panelAlumnos, 0);
        menu.capas.setComponentZOrder(menu.panelGrupos, 0);
        menu.capas.setComponentZOrder(menu.panelAsignaturas, 0);
        menu.capas.setComponentZOrder(menu.panelProfesores, 0);
        menu.capas.setComponentZOrder(menu.panelDepartamentos, 0);
        menu.capas.setComponentZOrder(menu.panelTutorias, 0);
        // Ocultamos todas las capas
        ocultarTodo();
        // Añadimos los oyentes de los botones
        RegistrarEventos();
        // Mostramos el menu sin la cabecera
        menu.barraInicio.setVisible(false);
        menu.jLabel1.setVisible(false);
        
        
        // Mostramos el icono de carga
        //menu.imagen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/carga.gif")));
        //menu.imagen.setHorizontalAlignment(menu.imagen.CENTER);
        //menu.imagen.setVisible(false);
        
        
        
        menu.panelInicioSesion.setVisible(true);
        menu.BotonIdentificarUsuario.setEnabled(false);
        mostrarUsuarios = new ControladorUsuarios();
        mostrarUsuarios.ControladorUsuarios(menu,this);
        
        // Mostramos el apartado de inicio
        //menu.barraInicio.setVisible(true);
        //menu.jLabel1.setVisible(true);
        //menu.imagen.setHorizontalAlignment(menu.imagen.LEFT);
        //menu.imagen.setIcon(new ImageIcon(getClass().getResource("/Imagenes/logo.jpg")));
        //menu.bienvenida.setVisible(true);
        
        
        
        // Iniciamos hibernate
        NewHibernateUtil.buildSessionFactory();

        try {
            NewHibernateUtil.openSessionAndBindToThread();
            this.session = NewHibernateUtil.getSessionFactory().getCurrentSession();
        }
        catch(Exception e){
            System.out.println("Error al crear SessionFactory");
        }
        
        menu.setVisible(true);
        /*
        UIManager.put("ToolTip.background", Color.WHITE);
        UIManager.put("ToolTip.border", Color.BLACK);
        menu.campoUsuario.setToolTipText("<html><head></head><body><span style='font-weight:bold;color:green;'>"
                + "Introduzca un nombre de usuario de como máximo 20 caracteres."
                + "</span></body></html>");*/
        menu.campoUsuario.setToolTipText("Introduzca un nombre de usuario de como máximo 20 caracteres.");
        menu.campoPassword.setToolTipText("Introduzca una contraseña de como máximo 20 caracteres.");
    }

    private void RegistrarEventos() {
        menu.getBotonRegistrarUsuario().addActionListener(this);
        menu.getBotonIdentificarUsuario().addActionListener(this);
        
        menu.getBotonInicio().addActionListener(this);
        menu.getBotonCentro().addActionListener(this);
        menu.getBotonAlumnado().addActionListener(this);
        menu.getBotonProfesorado().addActionListener(this);
        menu.getBotonSalir().addActionListener(this);
        
        menu.getBotonCursos().addActionListener(this);
        menu.getBotonHorarios().addActionListener(this);
        menu.getBotonAulas().addActionListener(this);
        
        menu.getBotonAlumnos().addActionListener(this);
        menu.getBotonGrupos().addActionListener(this);
        menu.getBotonAsignaturas().addActionListener(this);
        
        menu.getBotonProfesores().addActionListener(this);
        menu.getBotonDepartamentos().addActionListener(this);
        menu.getBotonTutorias().addActionListener(this);
    }
    
    private void ocultarTodo(){
        menu.opcionesCentro.setVisible(false);
        menu.opcionesAlumnado.setVisible(false);
        menu.opcionesProfesorado.setVisible(false);
        menu.panelCentro.setVisible(false);
        menu.panelHorarios.setVisible(false);
        menu.panelAulas.setVisible(false);
        menu.panelCursos.setVisible(false);
        menu.panelAlumnado.setVisible(false);
        menu.panelAlumnos.setVisible(false);
        menu.panelAsignaturas.setVisible(false);
        menu.panelGrupos.setVisible(false);
        menu.panelProfesorado.setVisible(false);
        menu.panelProfesores.setVisible(false);
        menu.panelDepartamentos.setVisible(false);
        menu.panelTutorias.setVisible(false);
        menu.imagen.setVisible(false);
        menu.bienvenida.setVisible(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        /* 
        Gestionamos la elección de los diferentes botones.
        En función de la elección se mostrará un panel y otro y se ocultará el resto.
        */
        if(e.getSource() == menu.getBotonRegistrarUsuario()) {
            
        }
        else if(e.getSource() == menu.getBotonIdentificarUsuario()) {
            
        }
        else if(e.getSource() == menu.getBotonInicio()) {
            ocultarTodo();
            menu.imagen.setVisible(true);
            menu.bienvenida.setVisible(true);
        }
        else if (e.getSource() == menu.getBotonCentro()) {
            ocultarTodo();
            menu.panelCentro.setVisible(true);
        }
        else if (e.getSource() == menu.getBotonAlumnado()) {
            ocultarTodo();
            menu.panelAlumnado.setVisible(true);
        }
        else if (e.getSource() == menu.getBotonProfesorado()) {
            ocultarTodo();
            menu.panelProfesorado.setVisible(true);
        }
        else if (e.getSource() == menu.getBotonSalir()) {
            try {
                // Cerrar la base de datos.
                NewHibernateUtil.closeSessionFactory();
            } catch (Exception a) {
                NewHibernateUtil.closeSessionFactory();
            }
            System.exit(0);
        }
        else if (e.getSource() == menu.getBotonHorarios()) {
            ocultarTodo();
            mostrarHorarios = new ControladorHorarios();
            mostrarHorarios.ControladorHorarios(menu,this);
        }
        else if (e.getSource() == menu.getBotonAulas()) {
            ocultarTodo();
            mostrarAulas = new ControladorAulas();
            mostrarAulas.ControladorAulas(menu,this);
        }
        else if (e.getSource() == menu.getBotonCursos()) {
            ocultarTodo();
            mostrarCursos = new ControladorCursos();
            mostrarCursos.ControladorCursos(menu,this);
            
        }
        else if (e.getSource() == menu.getBotonAlumnos()) {
            ocultarTodo();
            mostrarAlumnos = new ControladorAlumnos();
            mostrarAlumnos.ControladorAlumnos(menu,this);
        }
        else if (e.getSource() == menu.getBotonGrupos()) {
            ocultarTodo();
            mostrarGrupos = new ControladorGrupos();
            mostrarGrupos.ControladorGrupos(menu,this);
        }
        else if (e.getSource() == menu.getBotonAsignaturas()) {
            ocultarTodo();
            mostrarAsignaturas = new ControladorAsignaturas();
            mostrarAsignaturas.ControladorAsignaturas(menu,this);
        }
        else if (e.getSource() == menu.getBotonProfesores()) {
            ocultarTodo();
            mostrarProfesores = new ControladorProfesores();
            mostrarProfesores.ControladorProfesores(menu,this);
        }
        else if (e.getSource() == menu.getBotonDepartamentos()) {
            ocultarTodo();
            mostrarDepartamentos = new ControladorDepartamentos();
            mostrarDepartamentos.ControladorDepartamentos(menu,this);
        }
        else if (e.getSource() == menu.getBotonTutorias()) {
            ocultarTodo();
            mostrarTutorias = new ControladorTutorias();
            mostrarTutorias.ControladorTutorias(menu,this);
        }
    }
}
