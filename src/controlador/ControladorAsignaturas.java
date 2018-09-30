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
import modelo.Asignaturas;
import modelo.Profesores;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vista.Gestor;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class ControladorAsignaturas implements ActionListener {
    
    // Llamamos a esta clase desde la clase inicio para mostrar el menú principal.
    // Para mostrar el menú principal debemos crear un objeto menuAsignaturas.
    private Gestor menuAsignaturas = null;
    
    private ControladorTabla rsmodel;
    
    private Asignaturas modeloAsignatura; //La clase del Modelo
    
    private Asignaturas actual; //Define al alumno actual.
    // Variables para el campo buscar en el panel de grupo
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;
    // Inicializamos la variable para personalizar los mensajes de las excepciones.
    String exc;
    
    ControladorMenu _escuchador;
    
    List rs;
    
    public void ControladorAsignaturas(Gestor menu,ControladorMenu escuchador){
        menuAsignaturas=menu;
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(escuchador.getEscuchadorAsignaturas()==false){
            escuchador.setEscuchadorAsignaturas(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de asignaturos cargando los datos mediante la API JDBC.
        menuAsignaturas.getScrollAsignaturas().setBackground(Color.white);
        menuAsignaturas.getScrollAsignaturas().getViewport().setBackground(Color.white);
        menuAsignaturas.getScrollAsignaturas().setBorder(createEmptyBorder());
        JTableHeader header = menuAsignaturas.getTablaAsignaturas().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuAsignaturas.getTablaAsignaturas().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuAsignaturas.botonAsignaturasInsertar.setEnabled(false);
        menuAsignaturas.botonAsignaturasModificar.setEnabled(false);
        menuAsignaturas.botonAsignaturasBorrar.setEnabled(false);
        menuAsignaturas.botonAsignaturasSeleccionar.setEnabled(false);
            
        InicializarTabla(_escuchador.session,null);
            
        // Mostramos el contenido.
            
        menuAsignaturas.panelAsignaturas.setVisible(true);
        
        menuAsignaturas.tablaAsignaturas.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    consultarHorarios();
                }
            }
        }
        );
    }
    
    public void ControladorAsignaturas(Gestor menu, String consultaAsignaturas, ControladorMenu escuchador){
        menuAsignaturas=menu;
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(escuchador.getEscuchadorAsignaturas()==false){
            escuchador.setEscuchadorAsignaturas(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de asignaturos cargando los datos mediante la API JDBC.
        menuAsignaturas.getScrollAsignaturas().setBackground(Color.white);
        menuAsignaturas.getScrollAsignaturas().getViewport().setBackground(Color.white);
        menuAsignaturas.getScrollAsignaturas().setBorder(createEmptyBorder());
        JTableHeader header = menuAsignaturas.getTablaAsignaturas().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuAsignaturas.getTablaAsignaturas().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuAsignaturas.botonAsignaturasInsertar.setEnabled(false);
        menuAsignaturas.botonAsignaturasModificar.setEnabled(false);
        menuAsignaturas.botonAsignaturasBorrar.setEnabled(false);
        menuAsignaturas.botonAsignaturasSeleccionar.setEnabled(false);
        
        // Mostramos el contenido.
        try {
            /*Query q = _escuchador.session.createSQLQuery("SELECT asignaturas.codigo,asignaturas.nombre,"
                + "asignaturas.codigo_profesor,profesores.nombre as nombre_profesor,profesores.apellido1,"
                + "profesores.apellido2,profesores.dni,grupos.codigo as codigo_grupo,grupos.nombre as nombre_grupo,"
                + "cursos.codigo as codigo_curso,cursos.nombre as nombre_curso"
                + " FROM asignaturas JOIN profesores ON asignaturas.codigo_profesor=profesores.codigo JOIN cursos ON"
                + " asignaturas.codigo_curso=cursos.codigo JOIN grupos ON asignaturas.codigo_grupo=grupos.codigo"
                + " WHERE asignaturas.codigo_curso='"+consultaAsignaturas+"'");*/
            Query q = _escuchador.session.createQuery("SELECT a.codigo,a.nombre,b.codigo,"
                + "b.nombre,b.apellido1,b.apellido2,b.dni,d.codigo,d.nombre,c.codigo,c.nombre"
                + " from Asignaturas a,Profesores b, Cursos c, Grupos d"
                + " where a.profesores=b.codigo and a.codigoCurso=c.codigo and a.codigoGrupo=d.codigo and a.codigoCurso='"+consultaAsignaturas+"'");
            
// Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,q);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
        // Mostramos el contenido.
        menuAsignaturas.panelAsignaturas.setVisible(true);
    }
    
    public void ControladorAsignaturas(Gestor menu, ControladorMenu escuchador, String consultaAsignaturas){
        menuAsignaturas=menu;
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(escuchador.getEscuchadorAsignaturas()==false){
            escuchador.setEscuchadorAsignaturas(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de asignaturos cargando los datos mediante la API JDBC.
        menuAsignaturas.getScrollAsignaturas().setBackground(Color.white);
        menuAsignaturas.getScrollAsignaturas().getViewport().setBackground(Color.white);
        menuAsignaturas.getScrollAsignaturas().setBorder(createEmptyBorder());
        JTableHeader header = menuAsignaturas.getTablaAsignaturas().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuAsignaturas.getTablaAsignaturas().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuAsignaturas.botonAsignaturasInsertar.setEnabled(false);
        menuAsignaturas.botonAsignaturasModificar.setEnabled(false);
        menuAsignaturas.botonAsignaturasBorrar.setEnabled(false);
        menuAsignaturas.botonAsignaturasSeleccionar.setEnabled(false);
        
        // Mostramos el contenido.
        try {
            /*Query q = _escuchador.session.createSQLQuery("SELECT asignaturas.codigo,asignaturas.nombre,"
                + "asignaturas.codigo_profesor,profesores.nombre as nombre_profesor,profesores.apellido1,"
                + "profesores.apellido2,profesores.dni,grupos.codigo as codigo_grupo,grupos.nombre as nombre_grupo,"
                + "cursos.codigo as codigo_curso,cursos.nombre as nombre_curso"
                + " FROM asignaturas JOIN profesores ON asignaturas.codigo_profesor=profesores.codigo"
                + " JOIN cursos ON asignaturas.codigo_curso=cursos.codigo"
                + " JOIN grupos ON asignaturas.codigo_grupo=grupos.codigo"
                + " WHERE asignaturas.codigo='"+consultaAsignaturas+"'");*/
            Query q = _escuchador.session.createQuery("SELECT a.codigo,a.nombre,b.codigo,"
                + "b.nombre,b.apellido1,b.apellido2,b.dni,d.codigo,d.nombre,c.codigo,c.nombre"
                + " from Asignaturas a,Profesores b, Cursos c, Grupos d"
                + " where a.profesores=b.codigo and a.codigoCurso=c.codigo and a.codigoGrupo=d.codigo and a.codigo='"+consultaAsignaturas+"'");
            
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,q);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
        // Mostramos el contenido.
        menuAsignaturas.panelAsignaturas.setVisible(true);
    }
    
    protected void consultarHorarios(){
        ControladorHorarios mostrarHorarios = new ControladorHorarios();
        String consultaHorario=menuAsignaturas.tablaAsignaturas.getValueAt(menuAsignaturas.tablaAsignaturas.getSelectedRow(),0).toString();
        menuAsignaturas.panelAsignaturas.setVisible(false);
        mostrarHorarios.ControladorHorarios(menuAsignaturas,consultaHorario,_escuchador);
    }
    
    protected void InicializarTabla(Session session, Query q) {
        try {
            Transaction tx = session.beginTransaction();
            if(q==null){
                /*
                q = session.createSQLQuery(""
                    + "SELECT asignaturas.codigo,asignaturas.nombre,asignaturas.codigo_profesor,profesores.nombre as nombre_profesor,"
                    + "profesores.apellido1,profesores.apellido2,profesores.dni,grupos.codigo as codigo_grupo,grupos.nombre as nombre_grupo,"
                    + "cursos.codigo as codigo_curso,cursos.nombre as nombre_curso"
                    + " FROM asignaturas JOIN profesores ON asignaturas.codigo_profesor=profesores.codigo"
                    + " JOIN cursos ON asignaturas.codigo_curso=cursos.codigo"
                    + " JOIN grupos ON asignaturas.codigo_grupo=grupos.codigo"
                );
                */
                q = session.createQuery("SELECT a.codigo,a.nombre,b.codigo,"
                    + "b.nombre,b.apellido1,b.apellido2,b.dni,d.codigo,d.nombre,c.codigo,c.nombre"
                    + " from Asignaturas a,Profesores b, Cursos c, Grupos d"
                    + " where a.profesores=b.codigo and a.codigoCurso=c.codigo and a.codigoGrupo=d.codigo");
            }
            List<Object[]> listaAux = q.list();
            
            List <Asignaturas> lista = new ArrayList();
            if(!listaAux.isEmpty()){
                for(Object[] obj : listaAux) {
                    int codAsi = Integer.parseInt(obj[0].toString());
                    String nomAsi = String.valueOf(obj[1]);
                    String codPro = String.valueOf(obj[2]);
                    String nomPro = String.valueOf(obj[3]);
                    String ap1Pro = String.valueOf(obj[4]);
                    String ap2Pro = String.valueOf(obj[5]);
                    String dniPro = String.valueOf(obj[6]);
                    String codGru = String.valueOf(obj[7]);
                    String nomGru = String.valueOf(obj[8]);
                    String codCur = String.valueOf(obj[9]);
                    String nomCur = String.valueOf(obj[10]);

                    lista.add(new Asignaturas(codAsi,nomAsi,codPro,nomPro,ap1Pro,ap2Pro,dniPro,codGru,nomGru,codCur,nomCur));
                }
            }
            else{
                lista.add(new Asignaturas());
            }
            rs=lista;
            tx.commit();
            rsmodel = new ControladorTabla(lista); //Asigna la clase CtrlTablaAlumno a la variable rsmodel del mismo tipo

            menuAsignaturas.getTablaAsignaturas().setModel(rsmodel); //Cargo en el Jtable TablaAlumnos el contenido de select realizado en negalumnos.actualizar
            
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
    
 //Procedimiento que busca en la tabla de asignaturos algun valor introducido en el jtexfield campoTuhorarioBuscar
    public void BuscarGrupo() {
        try {
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,null);
            Transaction tx = _escuchador.session.beginTransaction();
            List<Asignaturas> tabla=rsmodel.lista;
            List<Asignaturas> borrados = new <Asignaturas>ArrayList();
            if(menuAsignaturas.campoAsignaturasBuscarCategorias.getSelectedItem().toString().equals("Todos los campos")){
                for(Asignaturas obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase()) && 
                       !obj.getNombre().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase()) && 
                       !obj.getCodigo_profesor().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase()) && 
                       !obj.getNombre_profesor().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase()) && 
                       !obj.getApellido1_profesor().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase()) && 
                       !obj.getApellido2_profesor().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase()) && 
                       !obj.getDNI_profesor().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase()) && 
                       !obj.getCodigo_grupo().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase()) && 
                       !obj.getNombre_grupo().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase()) && 
                       !obj.getCodigo_curso().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase()) && 
                       !obj.getNombre_curso().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase())
                    ){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAsignaturas.campoAsignaturasBuscarCategorias.getSelectedItem().toString().equals("Código de la asignatura")){
                for(Asignaturas obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAsignaturas.campoAsignaturasBuscarCategorias.getSelectedItem().toString().equals("Nombre de la asignatura")){
                for(Asignaturas obj : tabla) {
                    if(!obj.getNombre().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAsignaturas.campoAsignaturasBuscarCategorias.getSelectedItem().toString().equals("Código del profesor")){
                for(Asignaturas obj : tabla) {
                    if(!obj.getCodigo_profesor().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAsignaturas.campoAsignaturasBuscarCategorias.getSelectedItem().toString().equals("Nombre del profesor")){
                for(Asignaturas obj : tabla) {
                    if(!obj.getNombre_profesor().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAsignaturas.campoAsignaturasBuscarCategorias.getSelectedItem().toString().equals("Primer apellido del profesor")){
                for(Asignaturas obj : tabla) {
                    if(!obj.getApellido1_profesor().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAsignaturas.campoAsignaturasBuscarCategorias.getSelectedItem().toString().equals("Segundo apellido del profesor")){
                for(Asignaturas obj : tabla) {
                    if(!obj.getApellido2_profesor().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAsignaturas.campoAsignaturasBuscarCategorias.getSelectedItem().toString().equals("DNI del profesor")){
                for(Asignaturas obj : tabla) {
                    if(!obj.getDNI_profesor().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAsignaturas.campoAsignaturasBuscarCategorias.getSelectedItem().toString().equals("Código del grupo")){
                for(Asignaturas obj : tabla) {
                    if(!obj.getCodigo_grupo().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAsignaturas.campoAsignaturasBuscarCategorias.getSelectedItem().toString().equals("Nombre del grupo")){
                for(Asignaturas obj : tabla) {
                    if(!obj.getNombre_grupo().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAsignaturas.campoAsignaturasBuscarCategorias.getSelectedItem().toString().equals("Código del curso")){
                for(Asignaturas obj : tabla) {
                    if(!obj.getCodigo_curso().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAsignaturas.campoAsignaturasBuscarCategorias.getSelectedItem().toString().equals("Nombre del curso")){
                for(Asignaturas obj : tabla) {
                    if(!obj.getNombre_curso().toLowerCase().contains(menuAsignaturas.campoAsignaturasBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            tabla.removeAll(borrados);
            tx.commit();
            if(tabla.isEmpty()){tabla.add(new Asignaturas());}
            rs=tabla;
            ControladorTabla registrosBuscados = new ControladorTabla(tabla);
            menuAsignaturas.getTablaAsignaturas().setModel(registrosBuscados);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//Es función controla si el botón btnAltas esta activo o no  si los jtextfiel estan vacios o no.
//https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    public DocumentListener HabilitarBotonesAsignaturas() { 

        DocumentListener documento;

        documento = new DocumentListener() {
            public void HayCambio() {
             
                menuAsignaturas.botonAsignaturasInsertar.setEnabled(
                    !menuAsignaturas.campoAsignaturasNombre.getText().isEmpty() && 
                    !menuAsignaturas.campoAsignaturasProfesor.getText().isEmpty() && 
                    !menuAsignaturas.campoAsignaturasGrupo.getText().isEmpty() && 
                    !menuAsignaturas.campoAsignaturasCurso.getText().isEmpty()
                );
                
                menuAsignaturas.botonAsignaturasSeleccionar.setEnabled(
                    !menuAsignaturas.campoAsignaturasCodigo.getText().isEmpty()
                );
                
                menuAsignaturas.botonAsignaturasModificar.setEnabled(
                    !menuAsignaturas.campoAsignaturasCodigo.getText().isEmpty() && 
                    !menuAsignaturas.campoAsignaturasNombre.getText().isEmpty() && 
                    !menuAsignaturas.campoAsignaturasProfesor.getText().isEmpty() && 
                    !menuAsignaturas.campoAsignaturasGrupo.getText().isEmpty() && 
                    !menuAsignaturas.campoAsignaturasCurso.getText().isEmpty()
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
        int fila = menuAsignaturas.tablaAsignaturas.getSelectedRow();
        try {
            actual=(Asignaturas) rs.get(fila);
            if(actual.getCodigo()!=null){
                MostrarRegistro();
                menuAsignaturas.botonAsignaturasBorrar.setEnabled(fila != -1);
                menuAsignaturas.botonAsignaturasModificar.setEnabled(fila != -1);
            }
        } catch (Exception e) {
            actual = null;
        }
    }
    
    //Muestra en los JtextField de la sección de asignaturos los datos que hemos seleccionado en el Jtable.
    public void MostrarRegistro() {
        menuAsignaturas.campoAsignaturasCodigo.setText(actual != null ? Integer.toString(actual.getCodigo()) : "");
        menuAsignaturas.campoAsignaturasNombre.setText(actual != null ? actual.getNombre() : "");
        menuAsignaturas.campoAsignaturasProfesor.setText(actual != null ? actual.getCodigo_profesor() : "");
        menuAsignaturas.campoAsignaturasGrupo.setText(actual != null ? actual.getCodigo_grupo() : "");
        menuAsignaturas.campoAsignaturasCurso.setText(actual != null ? actual.getCodigo_curso() : "");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Sección de asignaturos:
        if(e.getSource() == menuAsignaturas.getBotonAsignaturasInsertar()) {
            exc="";
            if(menuAsignaturas.campoAsignaturasNombre.getText().length()==0){exc="El nombre de la asignatura está vacío. Introduzca uno válido.";}
            else if(menuAsignaturas.campoAsignaturasNombre.getText().length()>50){exc="El nombre de la asignatura debe tener manos de 50 caracteres.";}
            else if(String.valueOf(menuAsignaturas.campoAsignaturasProfesor.getText()).length()==0){exc="El código del profesor está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuAsignaturas.campoAsignaturasProfesor.getText()).matches("[0-9]*")){exc="El código del profesor sólo puede contener números. Introduzca uno válido.";}
            else if(String.valueOf(menuAsignaturas.campoAsignaturasCurso.getText()).length()==0){exc="El código del curso está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuAsignaturas.campoAsignaturasCurso.getText()).matches("[0-9]*")){exc="El código del curso sólo puede contener números. Introduzca uno válido.";}
            else if(String.valueOf(menuAsignaturas.campoAsignaturasGrupo.getText()).length()==0){exc="El código del grupo está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuAsignaturas.campoAsignaturasGrupo.getText()).matches("[0-9]*")){exc="El código del grupo sólo puede contener números. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try {
                    /*Query q =_escuchador.session.createSQLQuery("INSERT INTO asignaturas VALUES( "
                    + "null, "
                    + "'" + menuAsignaturas.campoAsignaturasNombre.getText() + "', "
                    + "'" + menuAsignaturas.campoAsignaturasProfesor.getText() + "', "
                    + "'" + menuAsignaturas.campoAsignaturasCurso.getText() + "', "
                    + "'" + menuAsignaturas.campoAsignaturasGrupo.getText() + "' )"
                    );
                    q.executeUpdate();*/
                    
                    Profesores obj = new Profesores();
                    obj.setCodigo(Integer.parseInt(menuAsignaturas.campoAsignaturasProfesor.getText()));
                    Asignaturas obj2 = new Asignaturas(
                            obj,
                            menuAsignaturas.campoAsignaturasNombre.getText(),
                            Integer.parseInt(menuAsignaturas.campoAsignaturasCurso.getText()),
                            Integer.parseInt(menuAsignaturas.campoAsignaturasGrupo.getText())
                    );
                    
                    _escuchador.session.save(obj2);
                    
                    tx.commit();
                } catch (Exception ex) {
                    tx.rollback();
                    ex.printStackTrace();
                    String error="Se ha producido un error. Posiblemente el profesor, el grupo o el curso al que hace referencia no existen.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session,null);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuAsignaturas.getBotonAsignaturasBorrar()) {
            Transaction tx = _escuchador.session.beginTransaction();
            try {
                if (JOptionPane.showConfirmDialog(menuAsignaturas,
                 "¿Está seguro que desea borrar el registro seleccionado?",
                 "Atención",
                 JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                    /*
                    Query q =_escuchador.session.createSQLQuery("DELETE FROM asignaturas "
                    + "WHERE codigo = " + actual.getCodigo());
                    
                    q.executeUpdate();*/
                    
                    Profesores obj = new Profesores();
                    obj.setCodigo(Integer.parseInt(menuAsignaturas.campoAsignaturasProfesor.getText()));
                    actual.setProfesores(obj);
                    actual.setNombre(menuAsignaturas.campoAsignaturasNombre.getText());
                    actual.setCodigoCurso(Integer.parseInt(menuAsignaturas.campoAsignaturasCurso.getText()));
                    actual.setCodigoGrupo(Integer.parseInt(menuAsignaturas.campoAsignaturasGrupo.getText()));
                    
                    _escuchador.session.delete(actual);
                    
                    tx.commit();
                } else{
                    tx.rollback();
                    JOptionPane.showMessageDialog(menuAsignaturas, "La baja no se ha realizado"); 
                }
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
                String error="Se ha producido un error. Posiblemente la asignatura que intenta borrar posea alumnos u otras referencias. Debe eliminarlos primero.";
                VentanaMensajeError(error);
            }
            _escuchador.session.clear();
            InicializarTabla(_escuchador.session,null);
        }
        else if(e.getSource() == menuAsignaturas.getBotonAsignaturasModificar()) {
            exc="";
            if(menuAsignaturas.campoAsignaturasNombre.getText().length()==0){exc="El nombre de la asignatura está vacío. Introduzca uno válido.";}
            else if(menuAsignaturas.campoAsignaturasNombre.getText().length()>50){exc="El nombre de la asignatura debe tener manos de 50 caracteres.";}
            else if(String.valueOf(menuAsignaturas.campoAsignaturasProfesor.getText()).length()==0){exc="El código del profesor está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuAsignaturas.campoAsignaturasProfesor.getText()).matches("[0-9]*")){exc="El código del profesor sólo puede contener números. Introduzca uno válido.";}
            else if(String.valueOf(menuAsignaturas.campoAsignaturasCurso.getText()).length()==0){exc="El código del curso está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuAsignaturas.campoAsignaturasCurso.getText()).matches("[0-9]*")){exc="El código del curso sólo puede contener números. Introduzca uno válido.";}
            else if(String.valueOf(menuAsignaturas.campoAsignaturasGrupo.getText()).length()==0){exc="El código del grupo está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuAsignaturas.campoAsignaturasGrupo.getText()).matches("[0-9]*")){exc="El código del grupo sólo puede contener números. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try{
                    if (JOptionPane.showConfirmDialog(menuAsignaturas,
                    "¿Está seguro que desea modificar el registro seleccionado?",
                    "Atención",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                        /*
                        Query q = _escuchador.session.createSQLQuery("UPDATE asignaturas SET "
                        + "nombre='" + menuAsignaturas.campoAsignaturasNombre.getText() + "', "
                        + "codigo_profesor='" + menuAsignaturas.campoAsignaturasProfesor.getText() + "', "
                        + "codigo_curso='" + menuAsignaturas.campoAsignaturasCurso.getText() + "', "
                        + "codigo_grupo='" + menuAsignaturas.campoAsignaturasGrupo.getText() + "' "
                        + "WHERE codigo=" + actual.getCodigo());
                        
                        q.executeUpdate();*/
                        
                        Profesores obj = new Profesores();
                        obj.setCodigo(Integer.parseInt(menuAsignaturas.campoAsignaturasProfesor.getText()));
                        actual.setProfesores(obj);
                        actual.setNombre(menuAsignaturas.campoAsignaturasNombre.getText());
                        actual.setCodigoCurso(Integer.parseInt(menuAsignaturas.campoAsignaturasCurso.getText()));
                        actual.setCodigoGrupo(Integer.parseInt(menuAsignaturas.campoAsignaturasGrupo.getText()));

                        _escuchador.session.update(actual);
                    
                        tx.commit();
                    }
                    else{
                        tx.rollback();
                        JOptionPane.showMessageDialog(menuAsignaturas,"La modificación no se ha realizado"); 
                    }
                } catch (Exception ex) {
                    tx.rollback();
                    ex.printStackTrace();
                    String error="Se ha producido un error. Posiblemente el profesor, el grupo o el curso al que hace referencia no existen.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session,null);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuAsignaturas.getBotonAsignaturasSeleccionar()) {
            consultarHorarios();
        }
        else if(e.getSource() == menuAsignaturas.getBotonAsignaturasExportar()) {
            MessageFormat header = new MessageFormat("Lista de asignaturas");
            MessageFormat footer = new MessageFormat("Página{0,number,integer}");
            try {
                menuAsignaturas.getTablaAsignaturas().print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (PrinterException ex) {
                Logger.getLogger(ControladorAsignaturas.class.getName()).log(Level.SEVERE, null, ex);
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
        menuAsignaturas.tablaAsignaturas.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { //Cambios que se produce en el Jtable
                selectionChanged();
            }
        });
    }
    
    public void RegistrarEventos() {
        menuAsignaturas.getBotonAsignaturasInsertar().addActionListener(this);
        menuAsignaturas.getBotonAsignaturasBorrar().addActionListener(this);
        menuAsignaturas.getBotonAsignaturasModificar().addActionListener(this);
        menuAsignaturas.getBotonAsignaturasExportar().addActionListener(this);
        menuAsignaturas.getBotonAsignaturasSeleccionar().addActionListener(this);
        menuAsignaturas.campoAsignaturasCodigo.getDocument().addDocumentListener(HabilitarBotonesAsignaturas());
        menuAsignaturas.campoAsignaturasNombre.getDocument().addDocumentListener(HabilitarBotonesAsignaturas());
        menuAsignaturas.campoAsignaturasProfesor.getDocument().addDocumentListener(HabilitarBotonesAsignaturas());
        menuAsignaturas.campoAsignaturasGrupo.getDocument().addDocumentListener(HabilitarBotonesAsignaturas());
        menuAsignaturas.campoAsignaturasCurso.getDocument().addDocumentListener(HabilitarBotonesAsignaturas());
        menuAsignaturas.campoAsignaturasBuscar.getDocument().addDocumentListener(ActivarBusqueda());
    }
}