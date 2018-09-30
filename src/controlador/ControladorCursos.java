/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import static javax.swing.BorderFactory.createEmptyBorder;
import static javax.swing.BorderFactory.createLineBorder;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import modelo.Cursos;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vista.Gestor;

/**
 *
 * @author Alfonso Pérez Santana
 */

public class ControladorCursos implements ActionListener {
    // Llamamos a esta clase desde la clase inicio para mostrar el menú principal.
    // Para mostrar el menú principal debemos crear un objeto menuCursos.
    protected Gestor menuCursos = null;
    
    protected ControladorTabla rsmodel;

    protected Cursos modeloCursos; //La clase del Modelo
    
    protected Cursos actual; //Define al curso actual.
    // Variables para el campo buscar en el panel de grupo
    protected static final int TIEMPOBUSCAR = 300;
    protected Timer timerbuscar;
    // Inicializamos la variable para personalizar los mensajes de las excepciones.
    String exc;
    // La variable siguiente nos servirá para saber si el método ocultarTodo ha sido usado con anterioridad.
    int checkSelectionListener=0;
    
    ControladorMenu _escuchador;
    
    List rs;
    
    public void ControladorCursos(Gestor menu,ControladorMenu escuchador){
        menuCursos=menu;
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(_escuchador.getEscuchadorGrupos()==false){
            _escuchador.setEscuchadorGrupos(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de cursos cargando los datos mediante la API JDBC.
        menuCursos.getScrollCursos().setBackground(Color.white);
        menuCursos.getScrollCursos().getViewport().setBackground(Color.white);
        menuCursos.getScrollCursos().setBorder(createEmptyBorder());
        JTableHeader header = menuCursos.getTablaCursos().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuCursos.getTablaCursos().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuCursos.botonCursosInsertar.setEnabled(false);
        menuCursos.botonCursosModificar.setEnabled(false);
        menuCursos.botonCursosBorrar.setEnabled(false);

        InicializarTabla(escuchador.session);
            
        // Mostramos el contenido.
        menuCursos.panelCursos.setVisible(true);
    }
    
    protected void ConsultarAsignaturas(){
        ControladorAsignaturas mostrarAsignaturas = new ControladorAsignaturas();
        String consultaCurso=menuCursos.tablaCursos.getValueAt(menuCursos.tablaCursos.getSelectedRow(),0).toString();
        menuCursos.panelCursos.setVisible(false);
        //mostrarAsignaturas.ControladorAsignaturas(menuCursos,consultaCurso,_escuchador);
    }
    
    protected void InicializarTabla(Session session) {
        try {
            Transaction tx = session.beginTransaction();
            Query q = session.createQuery("from Cursos");
            List<Cursos> lista = q.list();
            
            tx.commit();
            
            rs=lista;
            rsmodel = new ControladorTabla(lista); //Asigna la clase CtrlTablaAlumno a la variable rsmodel del mismo tipo

            menuCursos.getTablaCursos().setModel(rsmodel); //Cargo en el Jtable TablaAlumnos el contenido de select realizado en negalumnos.actualizar
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//Cuando existe un cambio txt_buscar realiza la busqueda en la tabla alumnos
//https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    public DocumentListener ActivarBusqueda() { 
        DocumentListener documento;

        documento = new DocumentListener() {

            private void ActivoTimer() {

                if ((timerbuscar != null) && timerbuscar.isRunning()) {
                    timerbuscar.restart();
                } else {
                    timerbuscar = new Timer(TIEMPOBUSCAR, new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            timerbuscar = null;
                            BuscarGrupo();
                        }
                    });
                    timerbuscar.setRepeats(false); //no queremos que sea repetitivo
                    timerbuscar.start();// el timer comienza a contar
                }
            }

            @Override
            public void insertUpdate(DocumentEvent e) {//Se invoca cuando  se inserta en el documento escuchado
                ActivoTimer();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {//Se invoca cuando se elimina texto del documento escuchado
                ActivoTimer();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {//Se invoca cuando cambia el documento que escucha
                ActivoTimer();
            }
        };

        return documento;

    }
    
 //Procedimiento que busca en la tabla de cursos algun valor introducido en el jtexfield campoCursosBuscar
    public void BuscarGrupo() {
        try {
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session);
            Transaction tx = _escuchador.session.beginTransaction();
            List<Cursos> tabla=rsmodel.lista;
            List<Cursos> borrados = new <Cursos>ArrayList();
            if(menuCursos.campoCursosBuscarCategorias.getSelectedItem().toString().equals("Todos los campos")){
                for(Cursos obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuCursos.campoCursosBuscar.getText().toLowerCase()) && !obj.getNombre().toLowerCase().contains(menuCursos.campoCursosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuCursos.campoCursosBuscarCategorias.getSelectedItem().toString().equals("Código del curso")){
                for(Cursos obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuCursos.campoCursosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuCursos.campoCursosBuscarCategorias.getSelectedItem().toString().equals("Nombre del curso")){
                for(Cursos obj : tabla) {
                    if(!obj.getNombre().toLowerCase().contains(menuCursos.campoCursosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            tabla.removeAll(borrados);
            tx.commit();
            if(tabla.isEmpty()){tabla.add(new Cursos(null));}
            rs=tabla;
            ControladorTabla registrosBuscados = new ControladorTabla(tabla);
            menuCursos.getTablaCursos().setModel(registrosBuscados);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//Es función controla si el botón btnAltas esta activo o no  si los jtextfiel estan vacios o no.
//https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    public DocumentListener HabilitarBotonesCursos() { 

        DocumentListener documento;

        documento = new DocumentListener() {
            public void HayCambio() {
             
                menuCursos.botonCursosInsertar.setEnabled(
                    !menuCursos.campoCursosNombre.getText().isEmpty()
                );
                
                menuCursos.botonCursosModificar.setEnabled(
                    !menuCursos.campoCursosNombre.getText().isEmpty()
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
    
    //El procedimiento ocurre cuando selecciono un registro del Jtable
    public void selectionChanged() {
        int fila = menuCursos.tablaCursos.getSelectedRow();
        try {
            actual=(Cursos) rs.get(fila);
            if(actual.getCodigo()!=null){
                MostrarRegistro();
                menuCursos.botonCursosBorrar.setEnabled(fila != -1);
                menuCursos.botonCursosModificar.setEnabled(fila != -1);
            }
        } catch (Exception e) {
            actual = null;
        }
    }
    
    //Muestra en los JtextField de la sección de cursos los datos que hemos seleccionado en el Jtable.
    public void MostrarRegistro() {
        menuCursos.campoCursosCodigo.setText(actual != null ? Integer.toString(actual.getCodigo()) : "");
        menuCursos.campoCursosNombre.setText(actual != null ? actual.getNombre() : "");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Sección de cursos:
        if(e.getSource() == menuCursos.getBotonCursosInsertar()) {
            exc="";
            if(menuCursos.campoCursosNombre.getText().length()==0){exc="El nombre del curso está vacío. Introduzca uno válido.";}
            else if(menuCursos.campoCursosNombre.getText().length()>50){exc="El nombre del curso tiene más de 50 caracteres. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try {
                    Cursos obj = new Cursos();
                    obj.setNombre(menuCursos.campoCursosNombre.getText());
                    _escuchador.session.save(obj);
                    tx.commit();
                } catch (Exception ex) {
                    tx.rollback();
                    
                    String error="Se ha producido un error. Compruebe que no existe un curso con el mismo nombre.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuCursos.getBotonCursosBorrar()) {
            Transaction tx = _escuchador.session.beginTransaction();
            try {
                if (JOptionPane.showConfirmDialog(menuCursos,
                 "¿Está seguro que desea borrar el registro seleccionado?",
                 "Atención",
                 JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                    _escuchador.session.delete(actual);
                    tx.commit();
                } else{
                    tx.rollback();
                    JOptionPane.showMessageDialog(menuCursos, "La baja no se ha realizado"); 
                }
            } catch (Exception ex) {
                tx.rollback();
                String error="Se ha producido un error. Posiblemente el curso que intenta borrar tiene datos referenciados.";
                VentanaMensajeError(error);
            }
            _escuchador.session.clear();
            InicializarTabla(_escuchador.session);
        }
        else if(e.getSource() == menuCursos.getBotonCursosModificar()) {
            exc="";
            if(menuCursos.campoCursosNombre.getText().length()==0){exc="El nombre del curso está vacío. Introduzca uno válido.";}
            else if(menuCursos.campoCursosNombre.getText().length()>50){exc="El nombre del curso tiene más de 50 caracteres. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try{
                    if (JOptionPane.showConfirmDialog(menuCursos,
                    "¿Está seguro que desea modificar el registro seleccionado?",
                    "Atención",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                        actual.setNombre(menuCursos.campoCursosNombre.getText());
                        _escuchador.session.update(actual);
                        tx.commit();
                    }
                    else{
                        tx.rollback();
                        JOptionPane.showMessageDialog(menuCursos, "La modificación no se ha realizado"); 
                    }
                } catch (Exception ex) {
                    tx.rollback();
                    String error="Se ha producido un error. Compruebe que no existe un curso con el mismo nombre.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuCursos.getBotonCursosExportar()) {
            MessageFormat header = new MessageFormat("Lista de cursos");
            MessageFormat footer = new MessageFormat("Página{0,number,integer}");
            try {
                menuCursos.getTablaCursos().print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (PrinterException ex) {
                Logger.getLogger(ControladorCursos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void VentanaMensajeError(String ex) {
        JOptionPane.showMessageDialog(null, ex, "Excepción", JOptionPane.ERROR_MESSAGE);
    }
    
    public void ocultarTodo(Gestor menu){
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
        menu.panelProfesorado.setVisible(false);
        menu.panelProfesores.setVisible(false);
        menu.panelDepartamentos.setVisible(false);
        menu.panelTutorias.setVisible(false);
        menu.imagen.setVisible(false);
        menu.bienvenida.setVisible(false);
        //Agrega un oyente a la lista que se notifica cada vez que se produce un cambio en el modelo de datos.
        menuCursos.tablaCursos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { //Cambios que se produce en el Jtable
                selectionChanged();
            }
        });
    }
    
    public void RegistrarEventos() {
        menuCursos.getBotonCursosInsertar().addActionListener(this);
        menuCursos.getBotonCursosBorrar().addActionListener(this);
        menuCursos.getBotonCursosModificar().addActionListener(this);
        menuCursos.getBotonCursosExportar().addActionListener(this);
        menuCursos.campoCursosCodigo.getDocument().addDocumentListener(HabilitarBotonesCursos());
        menuCursos.campoCursosNombre.getDocument().addDocumentListener(HabilitarBotonesCursos());
        menuCursos.campoCursosBuscar.getDocument().addDocumentListener(ActivarBusqueda());
    }
}