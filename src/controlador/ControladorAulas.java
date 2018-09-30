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
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.JTableHeader;
import modelo.AsignacionAulas;
import modelo.Aulas;
import modelo.Cursos;
import modelo.Grupos;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vista.Gestor;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class ControladorAulas implements ActionListener {
    
    // Llamamos a esta clase desde la clase inicio para mostrar el menú principal.
    // Para mostrar el menú principal debemos crear un objeto menuAulas.
    private Gestor menuAulas = null;
    
    private ControladorTabla rsmodelAulas;
    private ControladorTabla rsmodelAsignaciones;
    
    private Aulas modeloAulas; //La clase del Modelo Aula
    private AsignacionAulas modeloAsignaciones; //La clase del Modelo Aula
    
    private Aulas aulaActual; //Define al aula actual.
    private AsignacionAulas asignacionActual; //Define la asignacion actual.
    
    // Variables para el campo buscar en el panel de aulas
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;
    
    String exc;
    // La variable siguiente nos servirá para saber si el método ocultarTodo ha sido usado con anterioridad.
    int checkSelectionListener=0;
    
    ControladorMenu _escuchador;
    
    List rsAulas;
    List rsAsignaciones;
    
    public void ControladorAulas(Gestor menu,ControladorMenu escuchador){
        menuAulas=menu;
        ocultarTodo();
        
        _escuchador=escuchador;
        if(_escuchador.getEscuchadorAulas()==false){
            _escuchador.setEscuchadorAulas(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos las tablas de aulas y asignaciones cargando los datos mediante la API JDBC.
        menuAulas.getScrollAulas().setBackground(Color.white);
        menuAulas.getScrollAulas().getViewport().setBackground(Color.white);
        menuAulas.getScrollAulas().setBorder(createEmptyBorder());
        JTableHeader headerAulas = menuAulas.getTablaAulas().getTableHeader();
        headerAulas.setBackground(Color.WHITE);
        headerAulas.setBorder(createLineBorder(Color.BLACK));
        menuAulas.getTablaAulas().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuAulas.botonAulasInsertar.setEnabled(false);
        menuAulas.botonAulasModificar.setEnabled(false);
        menuAulas.botonAulasBorrar.setEnabled(false);
        menuAulas.botonAulasSeleccionar.setEnabled(false);
        
        menuAulas.getScrollAsignaciones().setBackground(Color.white);
        menuAulas.getScrollAsignaciones().getViewport().setBackground(Color.white);
        menuAulas.getScrollAsignaciones().setBorder(createEmptyBorder());
        JTableHeader headerAsignaciones = menuAulas.getTablaAsignaciones().getTableHeader();
        headerAsignaciones.setBackground(Color.WHITE);
        headerAsignaciones.setBorder(createLineBorder(Color.BLACK));
        menuAulas.getTablaAsignaciones().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuAulas.botonInsertarAsignacion.setEnabled(false);
        menuAulas.botonModificarAsignacion.setEnabled(false);
        menuAulas.botonBorrarAsignacion.setEnabled(false);
        menuAulas.botonSeleccionarAsignacion.setEnabled(false);
            
        InicializarTablaAulas(_escuchador.session);
        InicializarTablaAsignaciones(_escuchador.session);
        // Mostramos el contenido.
            
        menuAulas.panelAulas.setVisible(true);
        menuAulas.tablaAulas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    consultarGruposPorAulas();
                }
            }
        }
        );
        menuAulas.tablaAsignacion.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    consultarUso();
                }
            }
        }
        );
    }
    
    protected void consultarGruposPorAulas(){
        ControladorGrupos mostrarUso = new ControladorGrupos();
        String consultaGrupo=menuAulas.tablaAulas.getValueAt(menuAulas.tablaAulas.getSelectedRow(),0).toString();
        menuAulas.panelGrupos.setVisible(false);
        mostrarUso.ControladorGrupos(menuAulas,consultaGrupo,_escuchador);
    }
    
    protected void consultarUso(){
        ControladorGrupos mostrarGruposPorAulas = new ControladorGrupos();
        String consultaGrupo=menuAulas.tablaAsignacion.getValueAt(menuAulas.tablaAsignacion.getSelectedRow(),3).toString();
        menuAulas.panelGrupos.setVisible(false);
        mostrarGruposPorAulas.ControladorGrupos(menuAulas,_escuchador,consultaGrupo);
    }
    
    protected void InicializarTablaAulas(Session session) {
       try {
            Transaction tx = session.beginTransaction();
            /*
            Query q = session.createSQLQuery("SELECT * FROM aulas");
            List<Object[]> listaAux = q.list();
            List <Aulas> lista = new ArrayList();
            for(Object[] obj : listaAux) {
                int codAul = Integer.parseInt(String.valueOf(obj[0]));
                String nomAul = String.valueOf(obj[1]);
                
                lista.add(new Aulas(codAul,nomAul));
            }
            */
            Query q = session.createQuery("from Aulas");
            List<Cursos> lista = q.list();
            
            rsAulas=lista;
            tx.commit();
            rsmodelAulas = new ControladorTabla(lista);

            menuAulas.getTablaAulas().setModel(rsmodelAulas);
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    protected void InicializarTablaAsignaciones(Session session) {
        try {
            Transaction tx = session.beginTransaction();
            /*
            Query q = session.createSQLQuery(""
                    + "SELECT asignacion_aulas.codigo,asignacion_aulas.codigo_aula,aulas.nombre,"
                    + "asignacion_aulas.codigo_grupo,grupos.nombre as nombre_grupo"
                    + " FROM asignacion_aulas JOIN aulas ON asignacion_aulas.codigo_aula=aulas.codigo"
                    + " JOIN grupos ON asignacion_aulas.codigo_grupo=grupos.codigo"
            );

            List<Object[]> listaAux = q.list();
            List <AsignacionAulas> lista = new ArrayList();
            for(Object[] obj : listaAux) {
                int codAsi = Integer.parseInt(obj[0].toString());
                String codAul = String.valueOf(obj[1]);
                String nomAul = String.valueOf(obj[2]);
                String codGru = String.valueOf(obj[3]);
                String nomGru = String.valueOf(obj[4]);
                
                lista.add(new AsignacionAulas(codAsi,codAul,nomAul,codGru,nomGru));
            }
            */
            
            Query q = session.createQuery("SELECT a.codigo,a.aulas,c.nombre,"
                    + "a.grupos,b.nombre as nombre_grupo"
                    + " from AsignacionAulas a,Grupos b,Aulas c where a.grupos=b.codigo and a.aulas=c.codigo");
            
            List<Object[]> listaAux = q.list();
            List <AsignacionAulas> lista = new ArrayList();
            for(Object[] obj : listaAux) {
                int codAsi = Integer.parseInt(obj[0].toString());
                String codAul = String.valueOf(((Aulas) obj[1]).getCodigo());
                String nomAul = String.valueOf(obj[2]);
                String codGru = String.valueOf(((Grupos) obj[3]).getCodigo());
                String nomGru = String.valueOf(obj[4]);
                
                lista.add(new AsignacionAulas(codAsi,codAul,nomAul,codGru,nomGru));
            }
            rsAsignaciones=lista;
            tx.commit();
            
            rsmodelAsignaciones = new ControladorTabla(lista); //Asigna la clase CtrlTablaAlumno a la variable rsmodel del mismo tipo
            menuAulas.getTablaAsignaciones().setModel(rsmodelAsignaciones); //Cargo en el Jtable TablaAlumnos el contenido de select realizado en negalumnos.actualizar
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//Cuando existe un cambio en los campos buscar aulas
//https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    public DocumentListener ActivarBusquedaAulas() { 
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
                            BuscarAula();
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
 
 //Cuando existe un cambio en los campos buscar asignación
//https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    public DocumentListener ActivarBusquedaAsignaciones() { 
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
                            BuscarAsignacion();
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
    
 //Procedimiento que busca en la tabla de aulas algun valor introducido en el jtexfield campoAulasBuscar
    public void BuscarAula() {
        try {
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTablaAulas(_escuchador.session);
            Transaction tx = _escuchador.session.beginTransaction();
            List<Aulas> tabla=rsmodelAulas.lista;
            List<Aulas> borrados = new <Aulas>ArrayList();
            if(menuAulas.campoAulasBuscarCategorias.getSelectedItem().toString().equals("Todos los campos")){
                for(Aulas obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuAulas.campoAulasBuscar.getText().toLowerCase()) && 
                       !obj.getNombre().toLowerCase().contains(menuAulas.campoAulasBuscar.getText().toLowerCase())
                    ){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAulas.campoAulasBuscarCategorias.getSelectedItem().toString().equals("Código del aula")){
                for(Aulas obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuAulas.campoAulasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAulas.campoAulasBuscarCategorias.getSelectedItem().toString().equals("Nombre del aula")){
                for(Aulas obj : tabla) {
                    if(!obj.getNombre().toLowerCase().contains(menuAulas.campoAulasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            tabla.removeAll(borrados);
            tx.commit();
            if(tabla.isEmpty()){tabla.add(new Aulas());}
            rsAulas=tabla;
            ControladorTabla registrosBuscados = new ControladorTabla(tabla);
            menuAulas.getTablaAulas().setModel(registrosBuscados);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
 
 //Procedimiento que busca en la tabla de asignaciones algun valor introducido en el jtexfield campoAsignacionesBuscar
    public void BuscarAsignacion() {
        try {
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTablaAsignaciones(_escuchador.session);
            Transaction tx = _escuchador.session.beginTransaction();
            List<AsignacionAulas> tabla=rsmodelAsignaciones.lista;
            List<AsignacionAulas> borrados = new <AsignacionAulas>ArrayList();
            
            if(menuAulas.campoAsignacionesBuscarCategorias.getSelectedItem().toString().equals("Todos los campos")){
                
                for(AsignacionAulas obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuAulas.campoAsignacionBuscar.getText().toLowerCase()) && 
                       !obj.getCodigo_aula().toLowerCase().contains(menuAulas.campoAsignacionBuscar.getText().toLowerCase()) && 
                       !obj.getNombre_aula().toLowerCase().contains(menuAulas.campoAsignacionBuscar.getText().toLowerCase()) && 
                       !obj.getCodigo_grupo().toLowerCase().contains(menuAulas.campoAsignacionBuscar.getText().toLowerCase()) && 
                       !obj.getNombre_grupo().toLowerCase().contains(menuAulas.campoAsignacionBuscar.getText().toLowerCase())
                    ){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAulas.campoAsignacionesBuscarCategorias.getSelectedItem().toString().equals("Código de asignación")){
                for(AsignacionAulas obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuAulas.campoAsignacionBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAulas.campoAsignacionesBuscarCategorias.getSelectedItem().toString().equals("Código del aula")){
                for(AsignacionAulas obj : tabla) {
                    if(!obj.getCodigo_aula().toLowerCase().contains(menuAulas.campoAsignacionBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAulas.campoAsignacionesBuscarCategorias.getSelectedItem().toString().equals("Nombre del aula")){
                for(AsignacionAulas obj : tabla) {
                    if(!obj.getNombre_aula().toLowerCase().contains(menuAulas.campoAsignacionBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAulas.campoAsignacionesBuscarCategorias.getSelectedItem().toString().equals("Código del grupo")){
                for(AsignacionAulas obj : tabla) {
                    if(!obj.getCodigo_grupo().toLowerCase().contains(menuAulas.campoAsignacionBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAulas.campoAsignacionesBuscarCategorias.getSelectedItem().toString().equals("Nombre del grupo")){
                for(AsignacionAulas obj : tabla) {
                    if(!obj.getNombre_grupo().toLowerCase().contains(menuAulas.campoAsignacionBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            tabla.removeAll(borrados);
            tx.commit();
            if(tabla.isEmpty()){tabla.add(new AsignacionAulas());}
            rsAsignaciones=tabla;
            ControladorTabla registrosBuscados = new ControladorTabla(tabla);
            menuAulas.getTablaAsignaciones().setModel(registrosBuscados);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//Es función controla si el botón botonAltas esta activo o no  si los jtextfiel estan vacios o no.
//https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    public DocumentListener HabilitarBotonesAulas() { 

        DocumentListener documento;

        documento = new DocumentListener() {
            public void HayCambio() {
             
                menuAulas.botonAulasInsertar.setEnabled(
                    !menuAulas.campoAulasNombre.getText().isEmpty()
                );
                menuAulas.botonAulasSeleccionar.setEnabled(
                    !menuAulas.campoAulasNombre.getText().isEmpty()
                );
                
                menuAulas.botonAulasModificar.setEnabled(
                    !menuAulas.campoAulasNombre.getText().isEmpty()
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
    
    //Es función controla si el botón btnAltas esta activo o no  si los jtextfiel estan vacios o no.
//https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    public DocumentListener HabilitarBotonesAsignaciones() { 

        DocumentListener documento;

        documento = new DocumentListener() {
            public void HayCambio() {
             
                menuAulas.botonInsertarAsignacion.setEnabled(
                    !menuAulas.campoAsignacionCodigo_aula.getText().isEmpty() &&
                    !menuAulas.campoAsignacionCodigo_grupo.getText().isEmpty()
                );
                menuAulas.botonSeleccionarAsignacion.setEnabled(
                    !menuAulas.campoAsignacionCodigo_aula.getText().isEmpty() &&
                    !menuAulas.campoAsignacionCodigo_grupo.getText().isEmpty()
                );
                
                menuAulas.botonModificarAsignacion.setEnabled(
                    !menuAulas.campoAsignacionCodigo_aula.getText().isEmpty() &&
                    !menuAulas.campoAsignacionCodigo_grupo.getText().isEmpty()
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
    
    //El procedimiento ocurre cuando selecciono un registro de la tabla Aulas
    public void selectionChangedAulas() { 
        int fila = menuAulas.tablaAulas.getSelectedRow();
        try {
            aulaActual=(Aulas) rsAulas.get(fila);
            if(aulaActual.getCodigo()!=null){
                MostrarAulas();
                menuAulas.botonAulasBorrar.setEnabled(fila != -1);
                menuAulas.botonAulasModificar.setEnabled(fila != -1);
            }
        } catch (Exception e) {
            aulaActual = null;
        }
    }
    
    //El procedimiento ocurre cuando selecciono un registro de la tabla Asignacion
    public void selectionChangedAsignaciones() { 
        int fila = menuAulas.tablaAsignacion.getSelectedRow();
        try {
            asignacionActual=(AsignacionAulas) rsAsignaciones.get(fila);
            if(asignacionActual.getCodigo()!=null){
                MostrarAsignaciones();
                menuAulas.botonBorrarAsignacion.setEnabled(fila != -1);
                menuAulas.botonModificarAsignacion.setEnabled(fila != -1);
            }
        } catch (Exception e) {
            asignacionActual = null;
        }
    }
    
    //Muestra en los JtextField de la sección de aulas los datos que hemos seleccionado en el Jtable.
    public void MostrarAulas() {
        menuAulas.campoAulasNombre.setText(aulaActual != null ? aulaActual.getNombre() : "");
    }
    //Muestra en los JtextField de la sección de asignaciones los datos que hemos seleccionado en el Jtable.
    public void MostrarAsignaciones() {
        menuAulas.campoAsignacionCodigo_aula.setText(asignacionActual != null ? asignacionActual.getCodigo_aula() : "");
        menuAulas.campoAsignacionCodigo_grupo.setText(asignacionActual != null ? asignacionActual.getCodigo_grupo() : "");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Sección de aulas:
        if(e.getSource() == menuAulas.getBotonAulasInsertar()) {
            Transaction tx = _escuchador.session.beginTransaction();
                try {
                    /*
                    Query q =_escuchador.session.createSQLQuery(""
                        + "INSERT INTO aulas VALUES(null, "
                        + "'" + menuAulas.campoAulasNombre.getText() + "')"
                    );
                    
                    q.executeUpdate();
                    */
                    Aulas obj = new Aulas();
                    obj.setNombre(menuAulas.campoAulasNombre.getText());
                    _escuchador.session.save(obj);
                    
                    tx.commit();
                } catch (Exception ex) {
                    tx.rollback();
                    String error="Se ha producido un error. El aula no se ha podido registrar correctamente.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTablaAulas(_escuchador.session);
        }
        else if(e.getSource() == menuAulas.getBotonAulasBorrar()) {
            Transaction tx = _escuchador.session.beginTransaction();
            try {
                if (JOptionPane.showConfirmDialog(menuAulas,
                 "¿Está seguro que desea borrar el registro seleccionado?",
                 "Atención",
                 JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                    /*
                    Query q =_escuchador.session.createSQLQuery(""
                        + "DELETE FROM aulas "
                        + "WHERE codigo = " + aulaActual.getCodigo()
                    );
                    
                    q.executeUpdate();
                    */
                    _escuchador.session.delete(aulaActual);
                    tx.commit();
                } else{
                    tx.rollback();
                    JOptionPane.showMessageDialog(menuAulas, "La baja no se ha realizado"); 
                }
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
                String error="Se ha producido un error. Posiblemente el aula que intenta borrar este asignada a algún grupo. Debe eliminar todas las referencias.";
                VentanaMensajeError(error);
            }
            _escuchador.session.clear();
            InicializarTablaAulas(_escuchador.session);
        }
        else if(e.getSource() == menuAulas.getBotonAulasModificar()) {
            exc="";
            if(menuAulas.campoAulasNombre.getText().length()==0){exc="El nombre del aula está vacío. Introduzca uno válido.";}
            else if(menuAulas.campoAulasNombre.getText().length()>50){exc="El nombre del aula debe tener menos de 50 caracteres.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try{
                    if (JOptionPane.showConfirmDialog(menuAulas,
                    "¿Está seguro que desea modificar el registro seleccionado?",
                    "Atención",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                        /*
                        Query q = _escuchador.session.createSQLQuery(""
                            + "UPDATE aulas SET "
                            + "nombre='" + menuAulas.campoAulasNombre.getText() + "' "
                            + "WHERE codigo=" + aulaActual.getCodigo()
                        );
                        
                        q.executeUpdate();
                        */
                        aulaActual.setNombre(menuAulas.campoAulasNombre.getText());
                        _escuchador.session.save(aulaActual);
                        
                        tx.commit();
                    }
                    else{
                        tx.rollback();
                        JOptionPane.showMessageDialog(menuAulas,"La modificación no se ha realizado"); 
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    tx.rollback();
                    String error="Se ha producido un error. El registro no ha podido ser modificado.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTablaAulas(_escuchador.session);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuAulas.getBotonAulasSeleccionar()) {
            consultarGruposPorAulas();
        }
        else if(e.getSource() == menuAulas.getBotonAsignacionesInsertar()) {
            exc="";
            if(String.valueOf(menuAulas.campoAsignacionCodigo_aula.getText()).length()==0){exc="El código del aula está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuAulas.campoAsignacionCodigo_aula.getText()).matches("[0-9]*")){exc="El código del aula sólo puede contener números. Introduzca uno válido.";}
            else if(String.valueOf(menuAulas.campoAsignacionCodigo_grupo.getText()).length()==0){exc="El código del grupo está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuAulas.campoAsignacionCodigo_grupo.getText()).matches("[0-9]*")){exc="El código del grupo sólo puede contener números. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try {
                    /*
                    Query q =_escuchador.session.createSQLQuery("INSERT INTO asignacion_aulas VALUES( "
                    + "null, "
                    + menuAulas.campoAsignacionCodigo_aula.getText() + ","
                    + menuAulas.campoAsignacionCodigo_grupo.getText() + ")"
                    );
                    
                    q.executeUpdate();
                    */
                    AsignacionAulas obj = new AsignacionAulas();
                    Aulas obj2 = new Aulas();
                    Grupos obj3 = new Grupos();
                    obj2.setCodigo(Integer.parseInt(menuAulas.campoAsignacionCodigo_aula.getText()));
                    obj3.setCodigo(Integer.parseInt(menuAulas.campoAsignacionCodigo_grupo.getText()));
                    obj.setAulas(obj2);
                    obj.setGrupos(obj3);
                    _escuchador.session.save(obj);
                    
                    tx.commit();
                } catch (Exception ex) {
                    tx.rollback();
                    String error="Se ha producido un error. Posiblemente el aula o el grupo al que hace referencia no existen.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTablaAsignaciones(_escuchador.session);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuAulas.getBotonAsignacionesBorrar()) {
            Transaction tx = _escuchador.session.beginTransaction();
            try {
                if (JOptionPane.showConfirmDialog(menuAulas,
                 "¿Está seguro que desea borrar el registro seleccionado?",
                 "Atención",
                 JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                    /*
                    Query q =_escuchador.session.createSQLQuery("DELETE FROM asignacion_aulas "
                        + "WHERE codigo = " + asignacionActual.getCodigo()
                    );
                    
                    q.executeUpdate();
                    */
                    Aulas obj2 = new Aulas();
                    Grupos obj3 = new Grupos();
                    obj2.setCodigo(Integer.parseInt(menuAulas.campoAsignacionCodigo_aula.getText()));
                    obj3.setCodigo(Integer.parseInt(menuAulas.campoAsignacionCodigo_grupo.getText()));
                    asignacionActual.setAulas(obj2);
                    asignacionActual.setGrupos(obj3);
                    
                    _escuchador.session.delete(asignacionActual);
                    
                    tx.commit();
                } else{
                    tx.rollback();
                    JOptionPane.showMessageDialog(menuAulas, "La baja no se ha realizado"); 
                }
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
                String error="Se ha producido un error. La asignación no ha podido ser borrada.";
                VentanaMensajeError(error);
            }
            _escuchador.session.clear();
            InicializarTablaAsignaciones(_escuchador.session);
        }
        else if(e.getSource() == menuAulas.getBotonAsignacionesModificar()) {
            exc="";
            if(String.valueOf(menuAulas.campoAsignacionCodigo_aula.getText()).length()==0){exc="El código del aula está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuAulas.campoAsignacionCodigo_aula.getText()).matches("[0-9]*")){exc="El código del aula sólo puede contener números. Introduzca uno válido.";}
            else if(String.valueOf(menuAulas.campoAsignacionCodigo_grupo.getText()).length()==0){exc="El código del grupo está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuAulas.campoAsignacionCodigo_grupo.getText()).matches("[0-9]*")){exc="El código del grupo sólo puede contener números. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try{
                    if (JOptionPane.showConfirmDialog(menuAulas,
                    "¿Está seguro que desea modificar el registro seleccionado?",
                    "Atención",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                        /*
                        Query q = _escuchador.session.createSQLQuery("UPDATE asignacion_aulas SET "
                            + "codigo_aula=" + menuAulas.campoAsignacionCodigo_aula.getText() + ", "
                            + "codigo_grupo=" + menuAulas.campoAsignacionCodigo_grupo.getText() + " "
                            + "WHERE codigo=" + asignacionActual.getCodigo());
                        
                        q.executeUpdate();
                        */
                    
                        Aulas obj2 = new Aulas();
                        Grupos obj3 = new Grupos();
                        obj2.setCodigo(Integer.parseInt(menuAulas.campoAsignacionCodigo_aula.getText()));
                        obj3.setCodigo(Integer.parseInt(menuAulas.campoAsignacionCodigo_grupo.getText()));
                        asignacionActual.setAulas(obj2);
                        asignacionActual.setGrupos(obj3);
                        
                        _escuchador.session.update(asignacionActual);
                        
                        tx.commit();
                    }
                    else{
                        tx.rollback();
                        JOptionPane.showMessageDialog(menuAulas,"La modificación no se ha realizado"); 
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    tx.rollback();
                    String error="Se ha producido un error. Posiblemente el aula o el grupo al que hace referencia no existen.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTablaAsignaciones(_escuchador.session);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuAulas.getBotonAsignacionesSeleccionar()) {
            consultarUso();
        }
        else if(e.getSource() == menuAulas.getBotonAulasExportar()) {
            MessageFormat header = new MessageFormat("Lista de aulas");
            MessageFormat footer = new MessageFormat("Página{0,number,integer}");
            try {
                menuAulas.getTablaAulas().print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (PrinterException ex) {
                Logger.getLogger(ControladorAulas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else if(e.getSource() == menuAulas.getBotonAsignacionesExportar()) {
            MessageFormat header = new MessageFormat("Lista de asignaciones");
            MessageFormat footer = new MessageFormat("Página{0,number,integer}");
            try {
                menuAulas.getTablaAsignaciones().print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (PrinterException ex) {
                Logger.getLogger(ControladorAulas.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void VentanaMensajeError(String ex) {
        JOptionPane.showMessageDialog(null,ex, "Excepción", JOptionPane.ERROR_MESSAGE);
    }
    
    public void ocultarTodo(){
        //Agrega un oyente a la lista que se notifica cada vez que se produce un cambio en el modelo de datos.
        menuAulas.tablaAulas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { //Cambios que se produce en el Jtable
                selectionChangedAulas();
            }
        });
        
        menuAulas.tablaAsignacion.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { //Cambios que se produce en el Jtable
                selectionChangedAsignaciones();
            }
        });
    }
    
    public void RegistrarEventos() {
        menuAulas.getBotonAulasInsertar().addActionListener(this);
        menuAulas.getBotonAulasBorrar().addActionListener(this);
        menuAulas.getBotonAulasModificar().addActionListener(this);
        menuAulas.getBotonAulasSeleccionar().addActionListener(this);
        menuAulas.getBotonAulasExportar().addActionListener(this);
        menuAulas.getBotonAsignacionesInsertar().addActionListener(this);
        menuAulas.getBotonAsignacionesBorrar().addActionListener(this);
        menuAulas.getBotonAsignacionesModificar().addActionListener(this);
        menuAulas.getBotonAsignacionesSeleccionar().addActionListener(this);
        menuAulas.getBotonAsignacionesExportar().addActionListener(this);
        menuAulas.campoAulasNombre.getDocument().addDocumentListener(HabilitarBotonesAulas());
        menuAulas.campoAulasBuscar.getDocument().addDocumentListener(ActivarBusquedaAulas());
        menuAulas.campoAsignacionCodigo_aula.getDocument().addDocumentListener(HabilitarBotonesAsignaciones());
        menuAulas.campoAsignacionCodigo_grupo.getDocument().addDocumentListener(HabilitarBotonesAsignaciones());
        menuAulas.campoAsignacionBuscar.getDocument().addDocumentListener(ActivarBusquedaAsignaciones());
    }
}