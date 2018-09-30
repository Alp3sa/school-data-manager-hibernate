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
public class ControladorGrupos implements ActionListener {
    
    // Llamamos a esta clase desde la clase inicio para mostrar el menú principal.
    // Para mostrar el menú principal debemos crear un objeto menuGrupos.
    protected Gestor menuGrupos = null;
    
    protected ControladorTabla rsmodel;
    
    protected Grupos modeloGrupos; //La clase del Modelo
    
    protected Grupos actual; //Define al grupo actual.
    // Variables para el campo buscar en el panel de grupo
    protected static final int TIEMPOBUSCAR = 300;
    protected Timer timerbuscar;
    // Inicializamos la variable para personalizar los mensajes de las excepciones.
    String exc;
    // La variable siguiente nos servirá para saber si el método ocultarTodo ha sido usado con anterioridad.
    int checkSelectionListener=0;
    
    ControladorMenu _escuchador;
    
    List rs;
    
    public void ControladorGrupos(Gestor menu,ControladorMenu escuchador){
        menuGrupos=menu;
        
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(_escuchador.getEscuchadorGrupos()==false){
            _escuchador.setEscuchadorGrupos(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de grupos cargando los datos mediante la API JDBC.
        menuGrupos.getScrollGrupos().setBackground(Color.white);
        menuGrupos.getScrollGrupos().getViewport().setBackground(Color.white);
        menuGrupos.getScrollGrupos().setBorder(createEmptyBorder());
        JTableHeader header = menuGrupos.getTablaGrupos().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuGrupos.getTablaGrupos().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuGrupos.botonGruposInsertar.setEnabled(false);
        menuGrupos.botonGruposModificar.setEnabled(false);
        menuGrupos.botonGruposBorrar.setEnabled(false);
        menuGrupos.botonGruposSeleccionar.setEnabled(false);
            
        InicializarTabla(_escuchador.session,null);
            
        // Mostramos el contenido.
            
        menuGrupos.panelGrupos.setVisible(true);
        
        menuGrupos.tablaGrupos.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    ConsultarMiembros();
                }
            }
        }
        );
    }
    
    public void ControladorGrupos(Gestor menu,String consulta,ControladorMenu escuchador){
        menuGrupos=menu;
        
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(_escuchador.getEscuchadorGrupos()==false){
            _escuchador.setEscuchadorGrupos(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de grupos cargando los datos mediante la API JDBC.
        menuGrupos.getScrollGrupos().setBackground(Color.white);
        menuGrupos.getScrollGrupos().getViewport().setBackground(Color.white);
        menuGrupos.getScrollGrupos().setBorder(createEmptyBorder());
        JTableHeader header = menuGrupos.getTablaGrupos().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuGrupos.getTablaGrupos().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuGrupos.botonGruposInsertar.setEnabled(false);
        menuGrupos.botonGruposModificar.setEnabled(false);
        menuGrupos.botonGruposBorrar.setEnabled(false);
        menuGrupos.botonGruposSeleccionar.setEnabled(false);
            
        try {
            /*Query q = _escuchador.session.createSQLQuery("SELECT grupos.codigo,grupos.nombre,
            grupos.codigo_curso as codigo_curso,cursos.nombre as nombre_curso,grupos.codigo_tutor,
            profesores.nombre as nombre_tutor FROM grupos"
                    + " JOIN cursos ON grupos.codigo_curso=cursos.codigo"
                    + " JOIN asignacion_aulas ON grupos.codigo=asignacion_aulas.codigo_grupo"
                    + " JOIN aulas ON aulas.codigo=asignacion_aulas.codigo_aula"
                    + " LEFT JOIN profesores ON grupos.codigo_tutor=profesores.codigo"
                    + " WHERE aulas.codigo='"+consulta+"'");*/
            
            Query q = _escuchador.session.createQuery("SELECT a.codigo,a.nombre,a.cursos,"
                    + "b.nombre,a.codigoTutor,d.nombre"
                    + " from Grupos a,Cursos b,AsignacionAulas c,Aulas d"
                    + " where a.cursos=b.codigo and a.codigo=c.grupos and d.codigo=c.aulas"
                    + " and d.codigo='"+consulta+"' group by a.codigo");
            
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,q);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
            
        // Mostramos el contenido.
            
        menuGrupos.panelGrupos.setVisible(true);
        
        menuGrupos.tablaGrupos.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    ConsultarMiembros();
                }
            }
        }
        );
    }
    
    public void ControladorGrupos(Gestor menu,ControladorMenu escuchador,String consulta){
        menuGrupos=menu;
        
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(_escuchador.getEscuchadorGrupos()==false){
            _escuchador.setEscuchadorGrupos(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de grupos cargando los datos mediante la API JDBC.
        menuGrupos.getScrollGrupos().setBackground(Color.white);
        menuGrupos.getScrollGrupos().getViewport().setBackground(Color.white);
        menuGrupos.getScrollGrupos().setBorder(createEmptyBorder());
        JTableHeader header = menuGrupos.getTablaGrupos().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuGrupos.getTablaGrupos().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuGrupos.botonGruposInsertar.setEnabled(false);
        menuGrupos.botonGruposModificar.setEnabled(false);
        menuGrupos.botonGruposBorrar.setEnabled(false);
        menuGrupos.botonGruposSeleccionar.setEnabled(false);
            
        try {
            /*Query q = _escuchador.session.createSQLQuery("SELECT grupos.codigo,grupos.nombre,grupos.codigo_curso as codigo_curso,cursos.nombre as nombre_curso,grupos.codigo_tutor,profesores.nombre as nombre_tutor FROM grupos"
                    + " JOIN cursos ON grupos.codigo_curso=cursos.codigo JOIN asignacion_aulas ON grupos.codigo=asignacion_aulas.codigo_grupo"
                    + " LEFT JOIN profesores ON grupos.codigo_tutor=profesores.codigo WHERE grupos.codigo='"+consulta+"' LIMIT 1");
            */
            Query q = _escuchador.session.createQuery("SELECT a.codigo,a.nombre,a.cursos,"
                    + "b.nombre,a.codigoTutor,c.nombre"
                    + " from Grupos a,Cursos b,Profesores c where a.cursos=b.codigo"
                    + " and a.codigo='"+consulta+"' group by a.codigo");
            q.setMaxResults(1);
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,q);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
            
        // Mostramos el contenido.
            
        menuGrupos.panelGrupos.setVisible(true);
        
        menuGrupos.tablaGrupos.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    ConsultarMiembros();
                }
            }
        }
        );
    }
    
    protected void ConsultarMiembros(){
        ControladorAlumnos mostrarAlumnos = new ControladorAlumnos();
        String consultaGrupo=menuGrupos.tablaGrupos.getValueAt(menuGrupos.tablaGrupos.getSelectedRow(),0).toString();
        menuGrupos.panelGrupos.setVisible(false);
        mostrarAlumnos.ControladorAlumnos(menuGrupos,consultaGrupo,_escuchador);
    }
    
    protected void InicializarTabla(Session session,Query q) {
        try {
            Transaction tx = session.beginTransaction();
            if(q==null){
                /*q = session.createSQLQuery(""
                        + "SELECT grupos.codigo,grupos.nombre,grupos.codigo_curso as codigo_curso,cursos.nombre as nombre_curso,grupos.codigo_tutor,"
                        + "profesores.nombre as nombre_profesor FROM grupos"
                        + " JOIN cursos ON grupos.codigo_curso=cursos.codigo"
                        + " LEFT JOIN profesores"
                        + " ON grupos.codigo_tutor=profesores.codigo"
                );*/
                q = session.createQuery("SELECT a.codigo,a.nombre,a.cursos,"
                    + "b.nombre,a.codigoTutor,c.nombre"
                    + " from Grupos a,Cursos b, Profesores c where a.cursos=b.codigo group by a.codigo");
            }
            List<Object[]> listaAux = q.list();
            
            List <Grupos> lista = new ArrayList();
            if(!listaAux.isEmpty()){
                for(Object[] obj : listaAux) {
                    int codGru = Integer.parseInt(obj[0].toString());
                    String nomGru = String.valueOf(obj[1]);
                    String codCur = String.valueOf(((Cursos) obj[2]).getCodigo());
                    String nomCur = String.valueOf(obj[3]);
                    String codPro = String.valueOf(obj[4]);
                    String nomPro;
                    if(!codPro.contains("null")){
                        nomPro = String.valueOf(obj[5]);
                    }
                    else{
                        codPro = "";
                        nomPro = "";
                    }
                    /*
                    int codGru = Integer.parseInt(obj[0].toString());
                    String nomGru = String.valueOf(obj[1]);
                    String codCur = String.valueOf(obj[2]);
                    String nomCur = String.valueOf(obj[3]);
                    String codPro = String.valueOf(obj[4]);
                    String nomPro;
                    if(!codPro.contains("null")){
                        nomPro = String.valueOf(obj[5]);
                    }
                    else{
                        codPro = "";
                        nomPro = "";
                    }*/

                    lista.add(new Grupos(codGru,nomGru,codCur,nomCur,codPro,nomPro));
                }
            }
            else{
                lista.add(new Grupos());
            }
            rs=lista;
            tx.commit();
            rsmodel = new ControladorTabla(lista); //Asigna la clase CtrlTablaAlumno a la variable rsmodel del mismo tipo

            menuGrupos.getTablaGrupos().setModel(rsmodel); //Cargo en el Jtable TablaAlumnos el contenido de select realizado en negalumnos.actualizar
            
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//Cuando existe un cambio en el buscador
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
    
 //Procedimiento que busca en la tabla de grupos algun valor introducido en el jtexfield campoGruposBuscar
    public void BuscarGrupo() {
        try {
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,null);
            Transaction tx = _escuchador.session.beginTransaction();
            List<Grupos> tabla=rsmodel.lista;
            List<Grupos> borrados = new <Grupos>ArrayList();
            if(menuGrupos.campoGruposBuscarCategorias.getSelectedItem().toString().equals("Todos los campos")){
                for(Grupos obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuGrupos.campoGruposBuscar.getText().toLowerCase()) && 
                       !obj.getNombre().toLowerCase().contains(menuGrupos.campoGruposBuscar.getText().toLowerCase()) && 
                       !obj.getCurso().toLowerCase().contains(menuGrupos.campoGruposBuscar.getText().toLowerCase()) && 
                       !obj.getNombre_curso().toLowerCase().contains(menuGrupos.campoGruposBuscar.getText().toLowerCase()) && 
                       !obj.getTutor().toLowerCase().contains(menuGrupos.campoGruposBuscar.getText().toLowerCase()) && 
                       !obj.getNombre_tutor().toLowerCase().contains(menuGrupos.campoGruposBuscar.getText().toLowerCase())
                    ){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuGrupos.campoGruposBuscarCategorias.getSelectedItem().toString().equals("Código del grupo")){
                for(Grupos obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuGrupos.campoGruposBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuGrupos.campoGruposBuscarCategorias.getSelectedItem().toString().equals("Nombre del grupo")){
                for(Grupos obj : tabla) {
                    if(!obj.getNombre().toLowerCase().contains(menuGrupos.campoGruposBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuGrupos.campoGruposBuscarCategorias.getSelectedItem().toString().equals("Codigo del curso")){
                for(Grupos obj : tabla) {
                    if(!obj.getCurso().toLowerCase().contains(menuGrupos.campoGruposBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuGrupos.campoGruposBuscarCategorias.getSelectedItem().toString().equals("Nombre del curso")){
                for(Grupos obj : tabla) {
                    if(!obj.getNombre_curso().toLowerCase().contains(menuGrupos.campoGruposBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuGrupos.campoGruposBuscarCategorias.getSelectedItem().toString().equals("Codigo del tutor")){
                for(Grupos obj : tabla) {
                    if(!obj.getTutor().toLowerCase().contains(menuGrupos.campoGruposBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuGrupos.campoGruposBuscarCategorias.getSelectedItem().toString().equals("Nombre del tutor")){
                for(Grupos obj : tabla) {
                    if(!obj.getNombre_tutor().toLowerCase().contains(menuGrupos.campoGruposBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            tabla.removeAll(borrados);
            tx.commit();
            if(tabla.isEmpty()){tabla.add(new Grupos());}
            rs=tabla;
            ControladorTabla registrosBuscados = new ControladorTabla(tabla);
            menuGrupos.getTablaGrupos().setModel(registrosBuscados);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//Es función controla si el botón btnAltas esta activo o no  si los jtextfiel estan vacios o no.
//https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    public DocumentListener HabilitarBotonesGrupos() { 

        DocumentListener documento;

        documento = new DocumentListener() {
            public void HayCambio() {
             
                menuGrupos.botonGruposInsertar.setEnabled(
                    !menuGrupos.campoGruposCurso.getText().isEmpty() && 
                    !menuGrupos.campoGruposNombre.getText().isEmpty()
                );
                menuGrupos.botonGruposSeleccionar.setEnabled(
                    !menuGrupos.campoGruposCodigo.getText().isEmpty()
                );
                
                menuGrupos.botonGruposModificar.setEnabled(
                    !menuGrupos.campoGruposCurso.getText().isEmpty() && 
                    !menuGrupos.campoGruposNombre.getText().isEmpty()
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
        int fila = menuGrupos.tablaGrupos.getSelectedRow();
        try {
            actual=(Grupos) rs.get(fila);
            if(actual.getCodigo()!=null){
                MostrarRegistro();
                menuGrupos.botonGruposBorrar.setEnabled(fila != -1);
                menuGrupos.botonGruposModificar.setEnabled(fila != -1);
            }
        } catch (Exception e) {
            actual = null;
        }
    }
    
    //Muestra en los JtextField de la sección de grupos los datos que hemos seleccionado en el Jtable.
    public void MostrarRegistro() {
        menuGrupos.campoGruposCodigo.setText(actual != null ? Integer.toString(actual.getCodigo()) : "");
        menuGrupos.campoGruposCurso.setText(actual != null ? "" + actual.getCurso() : "");
        menuGrupos.campoGruposNombre.setText(actual != null ? actual.getNombre() : "");
        menuGrupos.campoGruposTutor.setText(actual != null ? actual.getTutor() : "");
    }
    int a =0;
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Sección de grupos:
        if(e.getSource() == menuGrupos.getBotonGruposInsertar()) {
            exc="";
            if(menuGrupos.campoGruposNombre.getText().length()==0){exc="El nombre del grupo está vacío. Introduzca uno válido.";}
            else if(menuGrupos.campoGruposNombre.getText().length()>50){exc="El nombre del grupo tiene más de 50 caracteres. Introduzca uno válido.";}
            else if(String.valueOf(menuGrupos.campoGruposCurso.getText()).length()==0){exc="El código del curso está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuGrupos.campoGruposCurso.getText()).matches("[0-9]*")){exc="El código del curso sólo puede contener números. Introduzca uno válido.";}
            else if(!String.valueOf(menuGrupos.campoGruposTutor.getText()).matches("[0-9]*")){exc="El código del tutor sólo puede contener números. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try {
                    
                    /*
                    String tutor="null";
                    if(menuGrupos.campoGruposTutor.getText().length()>0){tutor=menuGrupos.campoGruposTutor.getText();}
                    
                    Query q =_escuchador.session.createSQLQuery(""
                        + "INSERT INTO grupos VALUES("
                        + "null, "
                        + "'" + menuGrupos.campoGruposNombre.getText() + "', "
                        + "" + Integer.parseInt(menuGrupos.campoGruposCurso.getText()) + ", "
                        + "" + tutor + ")"
                    );
                    q.executeUpdate();*/
                    
                    Integer tutor=null;
                    if(menuGrupos.campoGruposTutor.getText().length()>0){tutor=Integer.parseInt(menuGrupos.campoGruposTutor.getText());}
                    
                    Cursos obj = new Cursos();
                    obj.setCodigo(Integer.parseInt(menuGrupos.campoGruposCurso.getText()));
                    Grupos obj2 = new Grupos(
                            obj,
                            menuGrupos.campoGruposNombre.getText(),
                            tutor
                    );
                    
                    _escuchador.session.save(obj2);
                    
                    tx.commit();
                } catch (Exception ex) {
                    tx.rollback();
                    ex.printStackTrace();
                    String error="Se ha producido un error. Posiblemente el curso o el tutor al que hace referencia no existen.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session,null);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuGrupos.getBotonGruposBorrar()) {
            Transaction tx = _escuchador.session.beginTransaction();
            try {
                if (JOptionPane.showConfirmDialog(menuGrupos,
                 "¿Está seguro que desea borrar el registro seleccionado?",
                 "Atención",
                 JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                    /*
                    Query q =_escuchador.session.createSQLQuery("DELETE FROM grupos "
                    + "WHERE codigo = " + actual.getCodigo());
                    
                    q.executeUpdate();
                    */
                    
                    Cursos obj = new Cursos();
                    obj.setCodigo(Integer.parseInt(menuGrupos.campoGruposCurso.getText()));
                    actual.setCursos(obj);
                    actual.setNombre(menuGrupos.campoGruposNombre.getText());
                    String tutor=menuGrupos.campoGruposTutor.getText();
                    if(tutor.length()==0){actual.setCodigoTutor(null);}
                    else{
                    actual.setCodigoTutor(Integer.parseInt(menuGrupos.campoGruposTutor.getText()));
                    }
                    
                    _escuchador.session.delete(actual);
                    
                    tx.commit();
                } else{
                    tx.rollback();
                    JOptionPane.showMessageDialog(menuGrupos, "La baja no se ha realizado"); 
                }
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
                String error="Se ha producido un error. Posiblemente el grupo que intenta borrar posea alumnos. Debe eliminarlos primero.";
                VentanaMensajeError(error);
            }
            _escuchador.session.clear();
            InicializarTabla(_escuchador.session,null);
        }
        else if(e.getSource() == menuGrupos.getBotonGruposModificar()) {
            exc="";
            if(menuGrupos.campoGruposNombre.getText().length()==0){exc="El nombre del grupo está vacío. Introduzca uno válido.";}
            else if(menuGrupos.campoGruposNombre.getText().length()>50){exc="El nombre del grupo tiene más de 50 caracteres. Introduzca uno válido.";}
            else if(String.valueOf(menuGrupos.campoGruposCurso.getText()).length()==0){exc="El código del curso está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuGrupos.campoGruposCurso.getText()).matches("[0-9]*")){exc="El código del curso sólo puede contener números. Introduzca uno válido.";}
            else if(!String.valueOf(menuGrupos.campoGruposTutor.getText()).matches("[0-9]*")){exc="El código del tutor sólo puede contener números. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try{
                    if (JOptionPane.showConfirmDialog(menuGrupos,
                    "¿Está seguro que desea modificar el registro seleccionado?",
                    "Atención",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                        
                        
                        /*
                        Query q = _escuchador.session.createSQLQuery("UPDATE grupos SET "
                        + "nombre='" + menuGrupos.campoGruposNombre.getText() + "', "
                        + "codigo_curso='" + menuGrupos.campoGruposCurso.getText() + "', "
                        + "codigo_tutor=" + tutor + " "   
                        + "WHERE codigo=" + actual.getCodigo());
                        
                        q.executeUpdate();*/
                    
                        
                        String tutor=menuGrupos.campoGruposTutor.getText();
                        if(tutor.length()==0){actual.setCodigoTutor(null);}
                        else{
                            actual.setCodigoTutor(Integer.parseInt(menuGrupos.campoGruposTutor.getText()));
                        }
                        
                        Cursos obj = new Cursos();
                        obj.setCodigo(Integer.parseInt(menuGrupos.campoGruposCurso.getText()));
                        actual.setCursos(obj);
                        
                        actual.setNombre(menuGrupos.campoGruposNombre.getText());
                        
                        _escuchador.session.update(actual);
                        
                        tx.commit();
                    }
                    else{
                        tx.rollback();
                        JOptionPane.showMessageDialog(menuGrupos,"La modificación no se ha realizado"); 
                    }
                } catch (Exception ex) {
                    tx.rollback();
                    ex.printStackTrace();
                    String error="Se ha producido un error. Posiblemente el curso o el tutor al que hace referencia no existen.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session,null);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuGrupos.getBotonGruposSeleccionar()) {
            ConsultarMiembros();
        }
        else if(e.getSource() == menuGrupos.getBotonGruposExportar()) {
            MessageFormat header = new MessageFormat("Lista de grupos");
            MessageFormat footer = new MessageFormat("Página{0,number,integer}");
            try {
                menuGrupos.getTablaGrupos().print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (PrinterException ex) {
                Logger.getLogger(ControladorGrupos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public void VentanaMensajeError(String ex) {
        JOptionPane.showMessageDialog(null,ex, "Excepción", JOptionPane.ERROR_MESSAGE);
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
        menuGrupos.tablaGrupos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { //Cambios que se produce en el Jtable
                selectionChanged();
            }
        });
    }
    
    public void RegistrarEventos() {
        menuGrupos.campoGruposCodigo.getDocument().addDocumentListener(HabilitarBotonesGrupos());
        menuGrupos.campoGruposNombre.getDocument().addDocumentListener(HabilitarBotonesGrupos());
        menuGrupos.campoGruposCurso.getDocument().addDocumentListener(HabilitarBotonesGrupos());
        menuGrupos.campoGruposTutor.getDocument().addDocumentListener(HabilitarBotonesGrupos());
        menuGrupos.campoGruposBuscar.getDocument().addDocumentListener(ActivarBusqueda());
        menuGrupos.getBotonGruposInsertar().addActionListener(this);
        menuGrupos.getBotonGruposBorrar().addActionListener(this);
        menuGrupos.getBotonGruposModificar().addActionListener(this);
        menuGrupos.getBotonGruposExportar().addActionListener(this);
        menuGrupos.getBotonGruposSeleccionar().addActionListener(this);
    }
}