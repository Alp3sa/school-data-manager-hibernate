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
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import modelo.Profesores;
import modelo.Tutorias;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vista.Gestor;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class ControladorTutorias implements ActionListener {
    
    // Llamamos a esta clase desde la clase inicio para mostrar el menú principal.
    // Para mostrar el menú principal debemos crear un objeto menuTutorias.
    private Gestor menuTutorias = null;
    
    private ControladorTabla rsmodel;
    
    private Tutorias modeloTutorias; //La clase del Modelo
    
    private Tutorias actual; //Define al alumno actual.
    // Variables para el campo buscar en el panel de grupo
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;
    // Inicializamos la variable para personalizar los mensajes de las excepciones.
    String exc;
    
    ControladorMenu _escuchador;
    
    List rs;
    
    public void ControladorTutorias(Gestor menu,ControladorMenu escuchador){
        menuTutorias=menu;
        ocultarTodo();
        
        _escuchador=escuchador;
        if(escuchador.getEscuchadorTutorias()==false){
            escuchador.setEscuchadorTutorias(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de tutorias cargando los datos mediante la API JDBC.
        menuTutorias.getScrollTutorias().setBackground(Color.white);
        menuTutorias.getScrollTutorias().getViewport().setBackground(Color.white);
        menuTutorias.getScrollTutorias().setBorder(createEmptyBorder());
        JTableHeader header = menuTutorias.getTablaTutorias().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuTutorias.getTablaTutorias().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuTutorias.botonTutoriasInsertar.setEnabled(false);
        menuTutorias.botonTutoriasModificar.setEnabled(false);
        menuTutorias.botonTutoriasBorrar.setEnabled(false);
            
        InicializarTabla(_escuchador.session,null);
            
        // Mostramos el contenido.
            
        menuTutorias.panelTutorias.setVisible(true);
    }
    
    public void ControladorTutorias(Gestor menu,String consultaTutorias,ControladorMenu escuchador){
        menuTutorias=menu;
        ocultarTodo();
        
        _escuchador=escuchador;
        if(escuchador.getEscuchadorTutorias()==false){
            escuchador.setEscuchadorTutorias(true);
            RegistrarEventos();
        }
        // Damos formato e inicializamos la tabla de tutorias cargando los datos mediante la API JDBC.
        menuTutorias.getScrollTutorias().setBackground(Color.white);
        menuTutorias.getScrollTutorias().getViewport().setBackground(Color.white);
        menuTutorias.getScrollTutorias().setBorder(createEmptyBorder());
        JTableHeader header = menuTutorias.getTablaTutorias().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuTutorias.getTablaTutorias().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuTutorias.botonTutoriasInsertar.setEnabled(false);
        menuTutorias.botonTutoriasModificar.setEnabled(false);
        menuTutorias.botonTutoriasBorrar.setEnabled(false);
            
        try {
            /*Query q = _escuchador.session.createSQLQuery("SELECT tutorias.codigo,tutorias.dia,"
                + "tutorias.comienzo,tutorias.fin,tutorias.codigo_profesor,"
                + "profesores.nombre,profesores.apellido1,profesores.apellido2,"
                + "profesores.dni"
                + " FROM tutorias"
                + " JOIN profesores"
                + " ON tutorias.codigo_profesor=profesores.codigo"
                + " WHERE tutorias.codigo_profesor='"+consultaTutorias+"'"
            );*/
            Query q = _escuchador.session.createQuery("SELECT a.codigo,a.dia,a.comienzo,a.fin,"
                    + "b.codigo,b.nombre,b.apellido1,b.apellido2,b.dni"
                    + " from Tutorias a,Profesores b"
                    + " where a.profesores=b.codigo and a.profesores='"+consultaTutorias+"'");

            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,q);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
        
        // Mostramos el contenido.
            
        menuTutorias.panelTutorias.setVisible(true);
    }
    
    protected void InicializarTabla(Session session,Query q) {
        try {
            Transaction tx = session.beginTransaction();
            if(q==null){
                /*q = session.createSQLQuery(""
                        + "SELECT tutorias.codigo,tutorias.dia,tutorias.comienzo,tutorias.fin,tutorias.codigo_profesor,"
                        + "profesores.nombre,profesores.apellido1,profesores.apellido2,profesores.dni"
                        + " FROM tutorias"
                        + " JOIN profesores ON tutorias.codigo_profesor=profesores.codigo"
                );*/
                
                q = session.createQuery("SELECT a.codigo,a.dia,a.comienzo,a.fin,"
                    + "b.codigo,b.nombre,b.apellido1,b.apellido2,b.dni"
                    + " from Tutorias a,Profesores b"
                    + " where a.profesores=b.codigo");
            }
            List<Object[]> listaAux = q.list();
            
            List <Tutorias> lista = new ArrayList();
            if(!listaAux.isEmpty()){
                for(Object[] obj : listaAux) {
                    int codTut = Integer.parseInt(obj[0].toString());
                    String diaTut = String.valueOf(obj[1]);
                    String comTut = String.valueOf(obj[2]);
                    String finTut = String.valueOf(obj[3]);
                    String codPro = String.valueOf(obj[4]);
                    String nomPro = String.valueOf(obj[5]);
                    String ap1Pro = String.valueOf(obj[6]);
                    String ap2Pro = String.valueOf(obj[7]);
                    String dniPro = String.valueOf(obj[8]);

                    lista.add(new Tutorias(codTut,diaTut,comTut,finTut,codPro,nomPro,ap1Pro,ap2Pro,dniPro));
                }
            }
            else{
                lista.add(new Tutorias());
            }
            rs=lista;
            tx.commit();
            rsmodel = new ControladorTabla(lista); //Asigna la clase CtrlTablaAlumno a la variable rsmodel del mismo tipo

            menuTutorias.getTablaTutorias().setModel(rsmodel); //Cargo en el Jtable TablaAlumnos el contenido de select realizado en negalumnos.actualizar
            
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
    
 //Procedimiento que busca en la tabla de tutorias algun valor introducido en el jtexfield campoTutoriasBuscar
    public void BuscarGrupo() {
        try {
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,null);
            Transaction tx = _escuchador.session.beginTransaction();
            List<Tutorias> tabla=rsmodel.lista;
            List<Tutorias> borrados = new <Tutorias>ArrayList();
            if(menuTutorias.campoTutoriasBuscarCategorias.getSelectedItem().toString().equals("Todos los campos")){
                for(Tutorias obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase()) && 
                       !obj.getDia().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase()) && 
                       !obj.getComienzo().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase()) && 
                       !obj.getFin().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase()) && 
                       !obj.getCodigo_profesor().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase()) && 
                       !obj.getNombre_profesor().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase()) && 
                       !obj.getApellido1_profesor().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase()) && 
                       !obj.getApellido2_profesor().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase()) && 
                       !obj.getDNI_profesor().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase())
                    ){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuTutorias.campoTutoriasBuscarCategorias.getSelectedItem().toString().equals("Código de tutoría")){
                for(Tutorias obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuTutorias.campoTutoriasBuscarCategorias.getSelectedItem().toString().equals("Día")){
                for(Tutorias obj : tabla) {
                    if(!obj.getDia().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuTutorias.campoTutoriasBuscarCategorias.getSelectedItem().toString().equals("Comienzo")){
                for(Tutorias obj : tabla) {
                    if(!obj.getComienzo().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuTutorias.campoTutoriasBuscarCategorias.getSelectedItem().toString().equals("Fin")){
                for(Tutorias obj : tabla) {
                    if(!obj.getFin().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuTutorias.campoTutoriasBuscarCategorias.getSelectedItem().toString().equals("Código del profesor")){
                for(Tutorias obj : tabla) {
                    if(!obj.getCodigo_profesor().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuTutorias.campoTutoriasBuscarCategorias.getSelectedItem().toString().equals("Nombre del profesor")){
                for(Tutorias obj : tabla) {
                    if(!obj.getNombre_profesor().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuTutorias.campoTutoriasBuscarCategorias.getSelectedItem().toString().equals("Primer apellido del profesor")){
                for(Tutorias obj : tabla) {
                    if(!obj.getApellido1_profesor().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuTutorias.campoTutoriasBuscarCategorias.getSelectedItem().toString().equals("Segundo apellido del profesor")){
                for(Tutorias obj : tabla) {
                    if(!obj.getApellido2_profesor().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuTutorias.campoTutoriasBuscarCategorias.getSelectedItem().toString().equals("DNI del profesor")){
                for(Tutorias obj : tabla) {
                    if(!obj.getDNI_profesor().toLowerCase().contains(menuTutorias.campoTutoriasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            tabla.removeAll(borrados);
            tx.commit();
            if(tabla.isEmpty()){tabla.add(new Tutorias());}
            rs=tabla;
            ControladorTabla registrosBuscados = new ControladorTabla(tabla);
            menuTutorias.getTablaTutorias().setModel(registrosBuscados);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//Es función controla si el botón btnAltas esta activo o no  si los jtextfiel estan vacios o no.
//https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    public DocumentListener HabilitarBotonesTutorias() { 

        DocumentListener documento;

        documento = new DocumentListener() {
            public void HayCambio() {
             
                menuTutorias.botonTutoriasInsertar.setEnabled(
                    !menuTutorias.campoTutoriasDia.getSelectedItem().toString().isEmpty() && 
                    !menuTutorias.campoTutoriasComienzo.getSelectedItem().toString().isEmpty() && 
                    !menuTutorias.campoTutoriasFin.getSelectedItem().toString().isEmpty() && 
                    !menuTutorias.campoTutoriasCodigo_profesor.getText().isEmpty()
                );
                
                menuTutorias.botonTutoriasModificar.setEnabled(
                    !menuTutorias.campoTutoriasDia.getSelectedItem().toString().isEmpty() && 
                    !menuTutorias.campoTutoriasComienzo.getSelectedItem().toString().isEmpty() && 
                    !menuTutorias.campoTutoriasFin.getSelectedItem().toString().isEmpty() && 
                    !menuTutorias.campoTutoriasCodigo_profesor.getText().isEmpty()
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
        int fila = menuTutorias.tablaTutorias.getSelectedRow();
        try {
            actual=(Tutorias) rs.get(fila);
            if(actual.getCodigo()!=null){
                MostrarRegistro();
                menuTutorias.botonTutoriasBorrar.setEnabled(fila != -1);
                menuTutorias.botonTutoriasModificar.setEnabled(fila != -1);
            }
        } catch (Exception e) {
            actual = null;
        }
    }
    
    //Muestra en los JtextField de la sección de tutorias los datos que hemos seleccionado en el Jtable.
    public void MostrarRegistro() {
        menuTutorias.campoTutoriasCodigo.setText(actual != null ? Integer.toString(actual.getCodigo()) : "");
        menuTutorias.campoTutoriasDia.setSelectedItem(actual != null ? "" + actual.getDia() : "");
        menuTutorias.campoTutoriasComienzo.setSelectedItem(actual != null ? actual.getComienzo() : "");
        menuTutorias.campoTutoriasFin.setSelectedItem(actual != null ? actual.getFin() : "");
        menuTutorias.campoTutoriasCodigo_profesor.setText(actual != null ? actual.getCodigo_profesor() : "");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Sección de tutorias:
        if(e.getSource() == menuTutorias.getBotonTutoriasInsertar()) {
            exc="";
            if(menuTutorias.campoTutoriasDia.getSelectedItem().toString().length()==0){exc="Introduzca el día.";}
            else if(menuTutorias.campoTutoriasDia.getSelectedItem().toString().length()>50){exc="Introduzca un día válido.";}
            else if(menuTutorias.campoTutoriasComienzo.getSelectedItem().toString().length()==0){exc="Introduzca una hora de comienzo.";}
            else if(menuTutorias.campoTutoriasComienzo.getSelectedItem().toString().length()>50){exc="Introduzca una hora de comienzo válida.";}
            else if(menuTutorias.campoTutoriasFin.getSelectedItem().toString().length()==0){exc="Introduzca una hora de finalización.";}
            else if(menuTutorias.campoTutoriasFin.getSelectedItem().toString().length()>50){exc="Introduzca una hora de finalización válida.";}
            else if(String.valueOf(menuTutorias.campoTutoriasCodigo_profesor.getText()).length()==0){exc="Introduzca el código del profesor.";}
            else if(!String.valueOf(menuTutorias.campoTutoriasCodigo_profesor.getText()).matches("[0-9]*")){exc="El código del profesor sólo puede contener números. Introduzca uno válido.";}
            else if(menuTutorias.campoTutoriasComienzo.getSelectedIndex()>menuTutorias.campoTutoriasFin.getSelectedIndex()){exc="La hora de inicio debe anteceder a la hora de finalización.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try {
                    /*Query q =_escuchador.session.createSQLQuery(""
                        + "INSERT INTO tutorias VALUES( "
                        + "null, "
                        + "'" + menuTutorias.campoTutoriasDia.getSelectedItem().toString() + "', "
                        + "'" + menuTutorias.campoTutoriasComienzo.getSelectedItem().toString() + "', "
                        + "'" + menuTutorias.campoTutoriasFin.getSelectedItem().toString() + "',"
                        + "'" + menuTutorias.campoTutoriasCodigo_profesor.getText() + "')"
                    );
                    q.executeUpdate();*/
                    
                    Profesores obj = new Profesores();
                    obj.setCodigo(Integer.parseInt(menuTutorias.campoTutoriasCodigo_profesor.getText()));
                    Tutorias obj2 = new Tutorias(
                            obj,
                            menuTutorias.campoTutoriasDia.getSelectedItem().toString(),
                            menuTutorias.campoTutoriasComienzo.getSelectedItem().toString(),
                            menuTutorias.campoTutoriasFin.getSelectedItem().toString()
                    );
                    
                    _escuchador.session.save(obj2);
                    
                    tx.commit();
                } catch (Exception ex) {
                    tx.rollback();
                    ex.printStackTrace();
                    String error="Se ha producido un error. Posiblemente el profesor al que hace referencia no existe.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session,null);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuTutorias.getBotonTutoriasBorrar()) {
            Transaction tx = _escuchador.session.beginTransaction();
            try {
                if (JOptionPane.showConfirmDialog(menuTutorias,
                 "¿Está seguro que desea borrar el registro seleccionado?",
                 "Atención",
                 JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                    /*
                    Query q =_escuchador.session.createSQLQuery("DELETE FROM tutorias "
                + "WHERE codigo = " + actual.getCodigo());
                    
                    q.executeUpdate();*/
                    
                    Profesores obj = new Profesores();
                    obj.setCodigo(Integer.parseInt(menuTutorias.campoTutoriasCodigo_profesor.getText()));
                    
                    actual.setProfesores(obj);
                    actual.setDia(menuTutorias.campoTutoriasDia.getSelectedItem().toString());
                    actual.setComienzo(menuTutorias.campoTutoriasComienzo.getSelectedItem().toString());
                    actual.setFin(menuTutorias.campoTutoriasFin.getSelectedItem().toString());
                    
                    _escuchador.session.delete(actual);
                    
                    tx.commit();
                } else{
                    tx.rollback();
                    JOptionPane.showMessageDialog(menuTutorias, "La baja no se ha realizado"); 
                }
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
                String error="Se ha producido un error. No es posible eliminar esta tutoría.";
                VentanaMensajeError(error);
            }
            _escuchador.session.clear();
            InicializarTabla(_escuchador.session,null);
        }
        else if(e.getSource() == menuTutorias.getBotonTutoriasModificar()) {
            exc="";
            if(menuTutorias.campoTutoriasDia.getSelectedItem().toString().length()==0){exc="Introduzca el día.";}
            else if(menuTutorias.campoTutoriasDia.getSelectedItem().toString().length()>50){exc="Introduzca un día válido.";}
            else if(menuTutorias.campoTutoriasComienzo.getSelectedItem().toString().length()==0){exc="Introduzca una hora de comienzo.";}
            else if(menuTutorias.campoTutoriasComienzo.getSelectedItem().toString().length()>50){exc="Introduzca una hora de comienzo válida.";}
            else if(menuTutorias.campoTutoriasFin.getSelectedItem().toString().length()==0){exc="Introduzca una hora de finalización.";}
            else if(menuTutorias.campoTutoriasFin.getSelectedItem().toString().length()>50){exc="Introduzca una hora de finalización válida.";}
            else if(String.valueOf(menuTutorias.campoTutoriasCodigo_profesor.getText()).length()==0){exc="Introduzca el código del profesor.";}
            else if(!String.valueOf(menuTutorias.campoTutoriasCodigo_profesor.getText()).matches("[0-9]*")){exc="El código del profesor sólo puede contener números. Introduzca uno válido.";}
            else if(menuTutorias.campoTutoriasComienzo.getSelectedIndex()>menuTutorias.campoTutoriasFin.getSelectedIndex()){exc="La hora de inicio debe anteceder a la hora de finalización.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try{
                    if (JOptionPane.showConfirmDialog(menuTutorias,
                    "¿Está seguro que desea modificar el registro seleccionado?",
                    "Atención",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                        /*
                        Query q = _escuchador.session.createSQLQuery("UPDATE tutorias SET "
                        + "dia='" + menuTutorias.campoTutoriasDia.getSelectedItem().toString() + "', "
                        + "comienzo='" + menuTutorias.campoTutoriasComienzo.getSelectedItem().toString() + "', "
                        + "fin='" + menuTutorias.campoTutoriasFin.getSelectedItem().toString() + "', "
                        + "codigo_profesor='" + menuTutorias.campoTutoriasCodigo_profesor.getText() + "' "
                        + "WHERE codigo=" + actual.getCodigo());
                        
                        q.executeUpdate();*/
                    
                        Profesores obj = new Profesores();
                        obj.setCodigo(Integer.parseInt(menuTutorias.campoTutoriasCodigo_profesor.getText()));

                        actual.setProfesores(obj);
                        actual.setDia(menuTutorias.campoTutoriasDia.getSelectedItem().toString());
                        actual.setComienzo(menuTutorias.campoTutoriasComienzo.getSelectedItem().toString());
                        actual.setFin(menuTutorias.campoTutoriasFin.getSelectedItem().toString());

                        _escuchador.session.update(actual);
                        
                        tx.commit();
                    }
                    else{
                        tx.rollback();
                        JOptionPane.showMessageDialog(menuTutorias,"La modificación no se ha realizado"); 
                    }
                } catch (Exception ex) {
                    tx.rollback();
                    ex.printStackTrace();
                    String error="Se ha producido un error. Posiblemente el curso o el tutor al que hace referencia no existen.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session,null);
                resetCombobox();
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuTutorias.getBotonTutoriasExportar()) {
            MessageFormat header = new MessageFormat("Lista de tutorias");
            MessageFormat footer = new MessageFormat("Página{0,number,integer}");
            try {
                menuTutorias.getTablaTutorias().print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (PrinterException ex) {
                Logger.getLogger(ControladorTutorias.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void resetCombobox(){
        menuTutorias.campoTutoriasDia.setSelectedIndex(0);
        menuTutorias.campoTutoriasComienzo.setSelectedIndex(0);
        menuTutorias.campoTutoriasFin.setSelectedIndex(0);
    }
    
    public void VentanaMensajeError(String ex) {
        JOptionPane.showMessageDialog(null, ex, "Excepción", JOptionPane.ERROR_MESSAGE);
    }
    
    public void ocultarTodo(){
        //Agrega un oyente a la lista que se notifica cada vez que se produce un cambio en el modelo de datos.
        menuTutorias.tablaTutorias.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { //Cambios que se produce en el Jtable
                selectionChanged();
            }
        });
    }
    
    public void RegistrarEventos() {
        menuTutorias.getBotonTutoriasInsertar().addActionListener(this);
        menuTutorias.getBotonTutoriasBorrar().addActionListener(this);
        menuTutorias.getBotonTutoriasModificar().addActionListener(this);
        menuTutorias.getBotonTutoriasExportar().addActionListener(this);
        menuTutorias.campoTutoriasCodigo.getDocument().addDocumentListener(HabilitarBotonesTutorias());
        ((JTextField)menuTutorias.campoTutoriasDia.getEditor().getEditorComponent()).getDocument().addDocumentListener(HabilitarBotonesTutorias());
        ((JTextField)menuTutorias.campoTutoriasComienzo.getEditor().getEditorComponent()).getDocument().addDocumentListener(HabilitarBotonesTutorias());
        ((JTextField)menuTutorias.campoTutoriasFin.getEditor().getEditorComponent()).getDocument().addDocumentListener(HabilitarBotonesTutorias());
        menuTutorias.campoTutoriasCodigo_profesor.getDocument().addDocumentListener(HabilitarBotonesTutorias());
        menuTutorias.campoTutoriasBuscar.getDocument().addDocumentListener(ActivarBusqueda());
    }
}