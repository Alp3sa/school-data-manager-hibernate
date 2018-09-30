/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
import modelo.Asignaturas;
import modelo.Horarios;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vista.Gestor;
/**
 *
 * @author Alfonso Pérez Santana
 */
public class ControladorHorarios implements ActionListener {
    
    // Llamamos a esta clase desde la clase inicio para mostrar el menú principal.
    // Para mostrar el menú principal debemos crear un objeto menuHorarios.
    private Gestor menuHorarios = null;
    
    private ControladorTabla rsmodel;
    
    private Horarios modeloHorarios; //La clase del Modelo
    
    private Horarios actual; //Define al alumno actual.
    // Variables para el campo buscar en el panel de grupo
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;
    // Inicializamos la variable para personalizar los mensajes de las excepciones.
    String exc;
    
    ControladorMenu _escuchador;
    
    List rs;
    
    public void ControladorHorarios(Gestor menu,ControladorMenu escuchador){
        menuHorarios=menu;
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(escuchador.getEscuchadorHorarios()==false){
            escuchador.setEscuchadorHorarios(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de horarios cargando los datos mediante la API JDBC.
        menuHorarios.getScrollHorarios().setBackground(Color.white);
        menuHorarios.getScrollHorarios().getViewport().setBackground(Color.white);
        menuHorarios.getScrollHorarios().setBorder(createEmptyBorder());
        JTableHeader header = menuHorarios.getTablaHorarios().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuHorarios.getTablaHorarios().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuHorarios.botonHorariosInsertar.setEnabled(false);
        menuHorarios.botonHorariosModificar.setEnabled(false);
        menuHorarios.botonHorariosBorrar.setEnabled(false);
        menuHorarios.botonHorariosSeleccionar.setEnabled(false);
            
        InicializarTabla(escuchador.session,null);
            
        // Mostramos el contenido.
            
        menuHorarios.panelHorarios.setVisible(true);
        
        menuHorarios.tablaHorarios.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    consultarAsignaturas();
                }
            }
        }
        );
    }
    
    public void ControladorHorarios(Gestor menu,String consultaHorarios,ControladorMenu escuchador){
        menuHorarios=menu;
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(escuchador.getEscuchadorHorarios()==false){
            escuchador.setEscuchadorHorarios(true);
            RegistrarEventos();
        }
        // Damos formato e inicializamos la tabla de horarios cargando los datos mediante la API JDBC.
        menuHorarios.getScrollHorarios().setBackground(Color.white);
        menuHorarios.getScrollHorarios().getViewport().setBackground(Color.white);
        menuHorarios.getScrollHorarios().setBorder(createEmptyBorder());
        JTableHeader header = menuHorarios.getTablaHorarios().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuHorarios.getTablaHorarios().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuHorarios.botonHorariosInsertar.setEnabled(false);
        menuHorarios.botonHorariosModificar.setEnabled(false);
        menuHorarios.botonHorariosBorrar.setEnabled(false);
        menuHorarios.botonHorariosSeleccionar.setEnabled(false);
            
        try {
            /*Query q = _escuchador.session.createSQLQuery("SELECT horarios.codigo,horarios.dia,horarios.comienzo,horarios.fin,horarios.codigo_asignatura,asignaturas.nombre"
                + " FROM horarios JOIN asignaturas ON horarios.codigo_asignatura=asignaturas.codigo"
                + " WHERE horarios.codigo_asignatura='"+Integer.parseInt(consultaHorarios)+"'");*/
            
            Query q = _escuchador.session.createQuery("SELECT a.codigo,a.dia,a.comienzo,"
                    + "a.fin,a.asignaturas,b.nombre as nombre_grupo"
                    + " from Horarios a,Asignaturas b"
                    + " where a.asignaturas=b.codigo and a.asignaturas="+Integer.parseInt(consultaHorarios)+"");
            
            //Probando sentencias preparadas: q.setParameter(0, Integer.parseInt(consultaHorarios));
            //Probando a eliminar registros en vez de realizar una consulta nueva: BuscarGrupo(consultaHorarios);
            
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,q);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
        
        // Mostramos el contenido.
            
        menuHorarios.panelHorarios.setVisible(true);
    }
    
    protected void consultarAsignaturas(){
        ControladorAsignaturas mostrarAsignaturas = new ControladorAsignaturas();
        String consultaAsignatura=menuHorarios.tablaHorarios.getValueAt(menuHorarios.tablaHorarios.getSelectedRow(),4).toString();
        menuHorarios.panelHorarios.setVisible(false);
        mostrarAsignaturas.ControladorAsignaturas(menuHorarios,_escuchador,consultaAsignatura);
    }
    
    protected void InicializarTabla(Session session,Query q) {
        try {
            Transaction tx = session.beginTransaction();
            if(q==null){
                /*
                q = session.createSQLQuery(""
                    + "SELECT horarios.codigo,horarios.dia,horarios.comienzo,horarios.fin,"
                    + "horarios.codigo_asignatura,asignaturas.nombre"
                    + " FROM horarios JOIN asignaturas ON horarios.codigo_asignatura=asignaturas.codigo"
                );
                */
                
                q = session.createQuery("SELECT a.codigo,a.dia,a.comienzo,"
                    + "a.fin,a.asignaturas,b.nombre as nombre_grupo"
                    + " from Horarios a,Asignaturas b where a.asignaturas=b.codigo");
            }
            List<Object[]> listaAux = q.list();
            
            List <Horarios> lista = new ArrayList();
            
            if(!listaAux.isEmpty()){
                for(Object[] obj : listaAux) {
                    /*int codHor = Integer.parseInt(obj[0].toString());
                    String diaHor = String.valueOf(obj[1]);
                    String comHor = String.valueOf(obj[2]);
                    String finHor = String.valueOf(obj[3]);
                    String codAsi = String.valueOf(obj[4]);
                    String nomAsi = String.valueOf(obj[5]);*/
                    
                    int codHor = Integer.parseInt(obj[0].toString());
                    String diaHor = String.valueOf(obj[1]);
                    String comHor = String.valueOf(obj[2]);
                    String finHor = String.valueOf(obj[3]);
                    String codAsi = String.valueOf(((Asignaturas) obj[4]).getCodigo());
                    String nomAsi = String.valueOf(obj[5]);

                    lista.add(new Horarios(codHor,diaHor,comHor,finHor,codAsi,nomAsi));
                }
            }
            else{
                lista.add(new Horarios());
            }
            rs=lista;
            tx.commit();
            
            rsmodel = new ControladorTabla(lista); //Asigna la clase CtrlTablaAlumno a la variable rsmodel del mismo tipo

            menuHorarios.getTablaHorarios().setModel(rsmodel); //Cargo en el Jtable TablaAlumnos el contenido de select realizado en negalumnos.actualizar
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//Cuando existe un cambio txt_buscar realiza la busqueda en la tabla alumnos
//https://docs.oracle.com/javase/horariol/uiswing/events/documentlistener.html
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
                            BuscarGrupo(null);
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
    
 //Procedimiento que busca en la tabla de horarios algun valor introducido en el jtexfield campoHorariosBuscar
    public void BuscarGrupo(String consulta) {
        try {
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,null);
            Transaction tx = _escuchador.session.beginTransaction();
            List<Horarios> tabla=rsmodel.lista;
            List<Horarios> borrados = new <Horarios>ArrayList();
            if(consulta==null){
                if(menuHorarios.campoHorariosBuscarCategorias.getSelectedItem().toString().equals("Todos los campos")){
                    for(Horarios obj : tabla) {
                        if(!obj.getCodigo().toString().contains(menuHorarios.campoHorariosBuscar.getText().toLowerCase()) && 
                           !obj.getDia().toLowerCase().contains(menuHorarios.campoHorariosBuscar.getText().toLowerCase()) && 
                           !obj.getComienzo().toLowerCase().contains(menuHorarios.campoHorariosBuscar.getText().toLowerCase()) && 
                           !obj.getFin().toLowerCase().contains(menuHorarios.campoHorariosBuscar.getText().toLowerCase()) && 
                           !obj.getCodigo_asignatura().toLowerCase().contains(menuHorarios.campoHorariosBuscar.getText().toLowerCase()) && 
                           !obj.getNombre_asignatura().toLowerCase().contains(menuHorarios.campoHorariosBuscar.getText().toLowerCase())
                        ){
                            borrados.add(obj);
                        }
                    }
                }
                else if(menuHorarios.campoHorariosBuscarCategorias.getSelectedItem().toString().equals("Código del horario")){
                    for(Horarios obj : tabla) {
                        if(!obj.getCodigo().toString().contains(menuHorarios.campoHorariosBuscar.getText().toLowerCase())){
                            borrados.add(obj);
                        }
                    }
                }
                else if(menuHorarios.campoHorariosBuscarCategorias.getSelectedItem().toString().equals("Día")){
                    for(Horarios obj : tabla) {
                        if(!obj.getDia().toLowerCase().contains(menuHorarios.campoHorariosBuscar.getText().toLowerCase())){
                            borrados.add(obj);
                        }
                    }
                }
                else if(menuHorarios.campoHorariosBuscarCategorias.getSelectedItem().toString().equals("Comienzo")){
                    for(Horarios obj : tabla) {
                        if(!obj.getComienzo().toLowerCase().contains(menuHorarios.campoHorariosBuscar.getText().toLowerCase())){
                            borrados.add(obj);
                        }
                    }
                }
                else if(menuHorarios.campoHorariosBuscarCategorias.getSelectedItem().toString().equals("Fin")){
                    for(Horarios obj : tabla) {
                        if(!obj.getFin().toLowerCase().contains(menuHorarios.campoHorariosBuscar.getText().toLowerCase())){
                            borrados.add(obj);
                        }
                    }
                }
                else if(menuHorarios.campoHorariosBuscarCategorias.getSelectedItem().toString().equals("Código de la asignatura")){
                    for(Horarios obj : tabla) {
                        if(!obj.getCodigo_asignatura().toLowerCase().contains(menuHorarios.campoHorariosBuscar.getText().toLowerCase())){
                            borrados.add(obj);
                        }
                    }
                }
                else if(menuHorarios.campoHorariosBuscarCategorias.getSelectedItem().toString().equals("Nombre de la asignatura")){
                    for(Horarios obj : tabla) {
                        if(!obj.getNombre_asignatura().toLowerCase().contains(menuHorarios.campoHorariosBuscar.getText().toLowerCase())){
                            borrados.add(obj);
                        }
                    }
                }
            }
            else{
                for(Horarios obj : tabla) {
                    if(Integer.parseInt(obj.getCodigo_asignatura())!=Integer.parseInt(consulta)){
                        borrados.add(obj);
                    }
                }
            }
            tabla.removeAll(borrados);
            tx.commit();
            if(tabla.isEmpty()){tabla.add(new Horarios());}
            rs=tabla;
            ControladorTabla registrosBuscados = new ControladorTabla(tabla);
            menuHorarios.getTablaHorarios().setModel(registrosBuscados);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//Es función controla si el botón btnAltas esta activo o no  si los jtextfiel estan vacios o no.
//https://docs.oracle.com/javase/horariol/uiswing/events/documentlistener.html
    public DocumentListener HabilitarBotonesHorarios() { 

        DocumentListener documento;

        documento = new DocumentListener() {
            public void HayCambio() {
             
                menuHorarios.botonHorariosInsertar.setEnabled(
                    !menuHorarios.campoHorariosDia.getSelectedItem().toString().isEmpty() && 
                    !menuHorarios.campoHorariosComienzo.getSelectedItem().toString().isEmpty() && 
                    !menuHorarios.campoHorariosFin.getSelectedItem().toString().isEmpty() && 
                    !menuHorarios.campoHorariosCodigo_asignatura.getText().isEmpty()
                );
                menuHorarios.botonHorariosSeleccionar.setEnabled(
                    !menuHorarios.campoHorariosCodigo_asignatura.getText().isEmpty()
                );
                
                menuHorarios.botonHorariosModificar.setEnabled(
                    !menuHorarios.campoHorariosDia.getSelectedItem().toString().isEmpty() && 
                    !menuHorarios.campoHorariosComienzo.getSelectedItem().toString().isEmpty() && 
                    !menuHorarios.campoHorariosFin.getSelectedItem().toString().isEmpty() && 
                    !menuHorarios.campoHorariosCodigo_asignatura.getText().isEmpty()
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
        int fila = menuHorarios.tablaHorarios.getSelectedRow();
        try {
            actual=(Horarios) rs.get(fila);
            if(actual.getCodigo()!=null){
                MostrarRegistro();
                menuHorarios.botonHorariosBorrar.setEnabled(fila != -1);
                menuHorarios.botonHorariosModificar.setEnabled(fila != -1);
            }
        } catch (Exception e) {
            actual = null;
        }
    }
    
    //Muestra en los JtextField de la sección de horarios los datos que hemos seleccionado en el Jtable.
    public void MostrarRegistro() {
        menuHorarios.campoHorariosCodigo.setText(actual != null ? Integer.toString(actual.getCodigo()) : "");
        menuHorarios.campoHorariosDia.setSelectedItem(actual != null ? "" + actual.getDia() : "");
        menuHorarios.campoHorariosComienzo.setSelectedItem(actual != null ? actual.getComienzo() : "");
        menuHorarios.campoHorariosFin.setSelectedItem(actual != null ? actual.getFin() : "");
        menuHorarios.campoHorariosCodigo_asignatura.setText(actual != null ? actual.getCodigo_asignatura() : "");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Sección de horarios:
        if(e.getSource() == menuHorarios.getBotonHorariosInsertar()) {
            exc="";
            if(menuHorarios.campoHorariosDia.getSelectedItem().toString().length()==0){exc="Introduzca el día.";}
            else if(menuHorarios.campoHorariosDia.getSelectedItem().toString().length()>50){exc="Introduzca un día válido.";}
            else if(menuHorarios.campoHorariosComienzo.getSelectedItem().toString().length()==0){exc="Introduzca una hora de comienzo.";}
            else if(menuHorarios.campoHorariosComienzo.getSelectedItem().toString().length()>50){exc="Introduzca una hora de comienzo válida.";}
            else if(menuHorarios.campoHorariosFin.getSelectedItem().toString().length()==0){exc="Introduzca una hora de finalización.";}
            else if(menuHorarios.campoHorariosFin.getSelectedItem().toString().length()>50){exc="Introduzca una hora de finalización válida.";}
            else if(String.valueOf(menuHorarios.campoHorariosCodigo_asignatura.getText()).length()==0){exc="Introduzca el código de la asignatura.";}
            else if(!String.valueOf(menuHorarios.campoHorariosCodigo_asignatura.getText()).matches("[0-9]*")){exc="El código del asignatura sólo puede contener números. Introduzca uno válido.";}
            else if(menuHorarios.campoHorariosComienzo.getSelectedIndex()>menuHorarios.campoHorariosFin.getSelectedIndex()){exc="La hora de inicio debe anteceder a la hora de finalización.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try {
                    /*
                    Query q =_escuchador.session.createSQLQuery(""
                        + "INSERT INTO horarios VALUES( "
                        + "null, "
                        + "'" + menuHorarios.campoHorariosDia.getSelectedItem().toString() + "', "
                        + "'" + menuHorarios.campoHorariosComienzo.getSelectedItem().toString() + "', "
                        + "'" + menuHorarios.campoHorariosFin.getSelectedItem().toString() + "',"
                        + "'" + menuHorarios.campoHorariosCodigo_asignatura.getText() + "')"
                    );*/
                    
                    Asignaturas obj = new Asignaturas();
                    obj.setCodigo(Integer.parseInt(menuHorarios.campoHorariosCodigo_asignatura.getText()));
                    Horarios obj2 = new Horarios(
                            obj,
                            menuHorarios.campoHorariosDia.getSelectedItem().toString(),
                            menuHorarios.campoHorariosComienzo.getSelectedItem().toString(),
                            menuHorarios.campoHorariosFin.getSelectedItem().toString()
                    );
                    
                    _escuchador.session.save(obj2);
                    
                    //q.executeUpdate();
                    tx.commit();
                } catch (Exception ex) {
                    tx.rollback();
                    String error="Se ha producido un error. Posiblemente la asignatura a la que hace referencia no existe.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session,null);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuHorarios.getBotonHorariosBorrar()) {
            Transaction tx = _escuchador.session.beginTransaction();
            try {
                if (JOptionPane.showConfirmDialog(menuHorarios,
                 "¿Está seguro que desea borrar el registro seleccionado?",
                 "Atención",
                 JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                    /*
                    Query q =_escuchador.session.createSQLQuery(""
                        + "DELETE FROM horarios "
                        + "WHERE codigo = " + actual.getCodigo()
                    );
                    
                    q.executeUpdate();*/
                    
                    Asignaturas obj = new Asignaturas();
                    obj.setCodigo(Integer.parseInt(menuHorarios.campoHorariosCodigo_asignatura.getText()));
                    actual.setAsignaturas(obj);
                    
                    _escuchador.session.delete(actual);
                    
                    tx.commit();
                } else{
                    tx.rollback();
                    JOptionPane.showMessageDialog(menuHorarios, "La baja no se ha realizado"); 
                }
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
                String error="Se ha producido un error. No es posible eliminar ese horario.";
                VentanaMensajeError(error);
            }
            _escuchador.session.clear();
            InicializarTabla(_escuchador.session,null);
        }
        else if(e.getSource() == menuHorarios.getBotonHorariosModificar()) {
            exc="";
            if(menuHorarios.campoHorariosDia.getSelectedItem().toString().length()==0){exc="Introduzca el día.";}
            else if(menuHorarios.campoHorariosDia.getSelectedItem().toString().length()>50){exc="Introduzca un día válido.";}
            else if(menuHorarios.campoHorariosComienzo.getSelectedItem().toString().length()==0){exc="Introduzca una hora de comienzo.";}
            else if(menuHorarios.campoHorariosComienzo.getSelectedItem().toString().length()>50){exc="Introduzca una hora de comienzo válida.";}
            else if(menuHorarios.campoHorariosFin.getSelectedItem().toString().length()==0){exc="Introduzca una hora de finalización.";}
            else if(menuHorarios.campoHorariosFin.getSelectedItem().toString().length()>50){exc="Introduzca una hora de finalización válida.";}
            else if(String.valueOf(menuHorarios.campoHorariosCodigo_asignatura.getText()).length()==0){exc="Introduzca el código de la asignatura.";}
            else if(!String.valueOf(menuHorarios.campoHorariosCodigo_asignatura.getText()).matches("[0-9]*")){exc="El código del asignatura sólo puede contener números. Introduzca uno válido.";}
            else if(menuHorarios.campoHorariosComienzo.getSelectedIndex()>menuHorarios.campoHorariosFin.getSelectedIndex()){exc="La hora de inicio debe anteceder a la hora de finalización.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try{
                    if (JOptionPane.showConfirmDialog(menuHorarios,
                    "¿Está seguro que desea modificar el registro seleccionado?",
                    "Atención",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                        /*
                        Query q = _escuchador.session.createSQLQuery(""
                            + "UPDATE horarios SET "
                            + "dia='" + menuHorarios.campoHorariosDia.getSelectedItem().toString() + "', "
                            + "comienzo='" + menuHorarios.campoHorariosComienzo.getSelectedItem().toString() + "', "
                            + "fin='" + menuHorarios.campoHorariosFin.getSelectedItem().toString() + "', "
                            + "codigo_asignatura='" + menuHorarios.campoHorariosCodigo_asignatura.getText() + "' "
                            + "WHERE codigo=" + actual.getCodigo()
                        );
                        
                        q.executeUpdate();*/
                    
                        Asignaturas obj = new Asignaturas();
                        obj.setCodigo(Integer.parseInt(menuHorarios.campoHorariosCodigo_asignatura.getText()));
                        
                        actual.setAsignaturas(obj);
                        actual.setDia(menuHorarios.campoHorariosDia.getSelectedItem().toString());
                        actual.setComienzo(menuHorarios.campoHorariosComienzo.getSelectedItem().toString());
                        actual.setFin(menuHorarios.campoHorariosFin.getSelectedItem().toString());
                        
                        _escuchador.session.update(actual);
                        
                        tx.commit();
                    }
                    else{
                        tx.rollback();
                        JOptionPane.showMessageDialog(menuHorarios,"La modificación no se ha realizado"); 
                    }
                } catch (Exception ex) {
                    tx.rollback();
                    String error="Se ha producido un error. Posiblemente la asignatura a la que hace referencia no existe.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session,null);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuHorarios.getBotonHorariosSeleccionar()) {
            consultarAsignaturas();
        }
        else if(e.getSource() == menuHorarios.getBotonHorariosExportar()) {
            MessageFormat header = new MessageFormat("Lista de horarios");
            MessageFormat footer = new MessageFormat("Página{0,number,integer}");
            try {
                menuHorarios.getTablaHorarios().print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (PrinterException ex) {
                Logger.getLogger(ControladorHorarios.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void resetCombobox(){
        menuHorarios.campoHorariosDia.setSelectedIndex(0);
        menuHorarios.campoHorariosComienzo.setSelectedIndex(0);
        menuHorarios.campoHorariosFin.setSelectedIndex(0);
    }
    
    public void VentanaMensajeError(String ex) {
        JOptionPane.showMessageDialog(null, ex, "Excepción", JOptionPane.ERROR_MESSAGE);
    }
    
    public void ocultarTodo(Gestor menu){
        menu.opcionesCentro.setVisible(false);
        menu.opcionesAlumnado.setVisible(false);
        menu.opcionesProfesorado.setVisible(false);
        menu.panelCentro.setVisible(false);
        menu.panelDepartamentos.setVisible(false);
        menu.panelAulas.setVisible(false);
        menu.panelCursos.setVisible(false);
        menu.panelAlumnado.setVisible(false);
        menu.panelAlumnos.setVisible(false);
        menu.panelAsignaturas.setVisible(false);
        menu.panelGrupos.setVisible(false);
        menu.panelProfesorado.setVisible(false);
        menu.panelProfesores.setVisible(false);
        menu.panelTutorias.setVisible(false);
        menu.imagen.setVisible(false);
        menu.bienvenida.setVisible(false);
        //Agrega un oyente a la lista que se notifica cada vez que se produce un cambio en el modelo de datos.
        menuHorarios.tablaHorarios.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { //Cambios que se produce en el Jtable
                selectionChanged();
            }
        });
    }
    
    public void RegistrarEventos() {
        menuHorarios.getBotonHorariosInsertar().addActionListener(this);
        menuHorarios.getBotonHorariosBorrar().addActionListener(this);
        menuHorarios.getBotonHorariosModificar().addActionListener(this);
        menuHorarios.getBotonHorariosSeleccionar().addActionListener(this);
        menuHorarios.getBotonHorariosExportar().addActionListener(this);
        menuHorarios.campoHorariosCodigo.getDocument().addDocumentListener(HabilitarBotonesHorarios());
        ((JTextField)menuHorarios.campoHorariosDia.getEditor().getEditorComponent()).getDocument().addDocumentListener(HabilitarBotonesHorarios());
        ((JTextField)menuHorarios.campoHorariosComienzo.getEditor().getEditorComponent()).getDocument().addDocumentListener(HabilitarBotonesHorarios());
        ((JTextField)menuHorarios.campoHorariosFin.getEditor().getEditorComponent()).getDocument().addDocumentListener(HabilitarBotonesHorarios());
        menuHorarios.campoHorariosCodigo_asignatura.getDocument().addDocumentListener(HabilitarBotonesHorarios());
        menuHorarios.campoHorariosBuscar.getDocument().addDocumentListener(ActivarBusqueda());
    }
}