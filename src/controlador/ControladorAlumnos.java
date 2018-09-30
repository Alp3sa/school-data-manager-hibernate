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
import modelo.Alumnos;
import modelo.Grupos;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vista.Gestor;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class ControladorAlumnos implements ActionListener {
    
    // Llamamos a esta clase desde la clase inicio para mostrar el menú principal.
    // Para mostrar el menú principal debemos crear un objeto menuAlumnos.
    private Gestor menuAlumnos = null;
    
    private ControladorTabla rsmodel;
    
    private Alumnos modeloAlumnos; //La clase del Modelo
    
    private Alumnos actual; //Define al alumno actual.
    // Variables para el campo buscar en el panel de grupo
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;
    // Inicializamos la variable para personalizar los mensajes de las excepciones.
    String exc;
    
    ControladorMenu _escuchador;
    
    List rs;
    
    public void ControladorAlumnos(Gestor menu, ControladorMenu escuchador){
        menuAlumnos=menu;
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(escuchador.getEscuchadorAlumnos()==false){
            escuchador.setEscuchadorAlumnos(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de alumnos cargando los datos mediante la API JDBC.
        menuAlumnos.getScrollAlumnos().setBackground(Color.white);
        menuAlumnos.getScrollAlumnos().getViewport().setBackground(Color.white);
        menuAlumnos.getScrollAlumnos().setBorder(createEmptyBorder());
        JTableHeader header = menuAlumnos.getTablaAlumnos().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuAlumnos.getTablaAlumnos().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuAlumnos.botonAlumnosInsertar.setEnabled(false);
        menuAlumnos.botonAlumnosModificar.setEnabled(false);
        menuAlumnos.botonAlumnosBorrar.setEnabled(false);
            
        InicializarTabla(_escuchador.session,null);
            
        // Mostramos el contenido.
            
        menuAlumnos.panelAlumnos.setVisible(true);
    }
    
    public void ControladorAlumnos(Gestor menu,String consultaGrupo,ControladorMenu escuchador){
        menuAlumnos=menu;
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(escuchador.getEscuchadorAlumnos()==false){
            escuchador.setEscuchadorAlumnos(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de alumnos cargando los datos mediante la API JDBC.
        menuAlumnos.getScrollAlumnos().setBackground(Color.white);
        menuAlumnos.getScrollAlumnos().getViewport().setBackground(Color.white);
        menuAlumnos.getScrollAlumnos().setBorder(createEmptyBorder());
        JTableHeader header = menuAlumnos.getTablaAlumnos().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuAlumnos.getTablaAlumnos().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuAlumnos.botonAlumnosInsertar.setEnabled(false);
        menuAlumnos.botonAlumnosModificar.setEnabled(false);
        menuAlumnos.botonAlumnosBorrar.setEnabled(false);
            
        try {
            /*Query q = _escuchador.session.createSQLQuery("SELECT alumnos.codigo,alumnos.dni,alumnos.nombre,"
                + "alumnos.apellido1,alumnos.apellido2,alumnos.codigo_grupo as codigo_grupo,grupos.nombre as nombre_grupo"
                + " FROM alumnos JOIN grupos ON alumnos.codigo_grupo=grupos.codigo"
                + " WHERE grupos.codigo='"+consultaGrupo+"'"
            );*/
            Query q = _escuchador.session.createQuery("SELECT a.codigo,a.dni,a.nombre,"
                    + "a.apellido1,a.apellido2,a.grupos,b.nombre as nombre_grupo"
                    + " from Alumnos a,Grupos b where a.grupos=b.codigo"
                    + " and a.grupos="+Integer.parseInt(consultaGrupo)+"");
            
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,q);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
        // Mostramos el contenido.
        menuAlumnos.panelAlumnos.setVisible(true);
    }
    
    protected void InicializarTabla(Session session,Query q) {
        try {
            Transaction tx = session.beginTransaction();
            if(q==null){
                /*q = session.createSQLQuery(""
                        + "SELECT alumnos.codigo,alumnos.dni,alumnos.nombre,alumnos.apellido1,alumnos.apellido2,"
                        + "alumnos.codigo_grupo,grupos.nombre as nombre_grupo"
                        + " FROM alumnos"
                        + " JOIN grupos"
                        + " ON alumnos.codigo_grupo=grupos.codigo"
                );*/
                q = session.createQuery("SELECT a.codigo,a.dni,a.nombre,"
                    + "a.apellido1,a.apellido2,a.grupos,b.nombre as nombre_grupo"
                    + " from Alumnos a,Grupos b where a.grupos=b.codigo");
            }
            List<Object[]> listaAux = q.list();
            List <Alumnos> lista = new ArrayList();
            if(!listaAux.isEmpty()){
                for(Object[] obj : listaAux) {
                    /*int codAlu = Integer.parseInt(obj[0].toString());
                    String dnialu = String.valueOf(obj[1]);
                    String nomAlu = String.valueOf(obj[2]);
                    String ap1Alu = String.valueOf(obj[3]);
                    String ap2Alu = String.valueOf(obj[4]);
                    String codGru = String.valueOf(obj[5]);
                    String nomGru = String.valueOf(obj[6]);*/
                    
                    int codAlu = Integer.parseInt(obj[0].toString());
                    String dnialu = String.valueOf(obj[1]);
                    String nomAlu = String.valueOf(obj[2]);
                    String ap1Alu = String.valueOf(obj[3]);
                    String ap2Alu = String.valueOf(obj[4]);
                    String codGru = String.valueOf(((Grupos) obj[5]).getCodigo());
                    String nomGru = String.valueOf(obj[6]);

                    lista.add(new Alumnos(codAlu,dnialu,nomAlu,ap1Alu,ap2Alu,codGru,nomGru));
                }
            }
            else{
                lista.add(new Alumnos());
            }
            rs=lista;
            tx.commit();
            rsmodel = new ControladorTabla(lista); //Asigna la clase CtrlTablaAlumno a la variable rsmodel del mismo tipo

            menuAlumnos.getTablaAlumnos().setModel(rsmodel); //Cargo en el Jtable TablaAlumnos el contenido de select realizado en negalumnos.actualizar
            
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
                            BuscarAlumno();
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
    
 //Procedimiento que busca en la tabla de alumnos algun valor introducido en el jtexfield campoAlumnosBuscar
    public void BuscarAlumno() {
        try {
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,null);
            Transaction tx = _escuchador.session.beginTransaction();
            List<Alumnos> tabla=rsmodel.lista;
            List<Alumnos> borrados = new <Alumnos>ArrayList();
            if(menuAlumnos.campoAlumnosBuscarCategorias.getSelectedItem().toString().equals("Todos los campos")){
                for(Alumnos obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase()) && 
                       !obj.getDni().toLowerCase().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase()) && 
                       !obj.getNombre().toLowerCase().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase()) && 
                       !obj.getApellido1().toLowerCase().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase()) && 
                       !obj.getApellido2().toLowerCase().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase()) && 
                       !obj.getGrupo().toLowerCase().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase()) && 
                       !obj.getNombre_grupo().toLowerCase().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase())
                    ){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAlumnos.campoAlumnosBuscarCategorias.getSelectedItem().toString().equals("Código del alumno")){
                for(Alumnos obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAlumnos.campoAlumnosBuscarCategorias.getSelectedItem().toString().equals("DNI del alumno")){
                for(Alumnos obj : tabla) {
                    if(!obj.getDni().toLowerCase().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAlumnos.campoAlumnosBuscarCategorias.getSelectedItem().toString().equals("Nombre del alumno")){
                for(Alumnos obj : tabla) {
                    if(!obj.getNombre().toLowerCase().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAlumnos.campoAlumnosBuscarCategorias.getSelectedItem().toString().equals("Primer apellido del alumno")){
                for(Alumnos obj : tabla) {
                    if(!obj.getApellido1().toLowerCase().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAlumnos.campoAlumnosBuscarCategorias.getSelectedItem().toString().equals("Segundo apellido del alumno")){
                for(Alumnos obj : tabla) {
                    if(!obj.getApellido2().toLowerCase().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAlumnos.campoAlumnosBuscarCategorias.getSelectedItem().toString().equals("Código de grupo")){
                for(Alumnos obj : tabla) {
                    if(!obj.getGrupo().toLowerCase().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuAlumnos.campoAlumnosBuscarCategorias.getSelectedItem().toString().equals("Nombre de grupo")){
                for(Alumnos obj : tabla) {
                    if(!obj.getNombre_grupo().toLowerCase().contains(menuAlumnos.campoAlumnosBuscar.getText().toLowerCase())
                    ){
                        borrados.add(obj);
                    }
                }
            }
            tabla.removeAll(borrados);
            tx.commit();
            if(tabla.isEmpty()){tabla.add(new Alumnos());}
            rs=tabla;
            ControladorTabla registrosBuscados = new ControladorTabla(tabla);
            menuAlumnos.getTablaAlumnos().setModel(registrosBuscados);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//Es función controla si el botón btnAltas esta activo o no  si los jtextfiel estan vacios o no.
//https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    public DocumentListener HabilitarBotonesAlumnos() { 

        DocumentListener documento;

        documento = new DocumentListener() {
            public void HayCambio() {
             
                menuAlumnos.botonAlumnosInsertar.setEnabled(
                    !menuAlumnos.campoAlumnosDNI.getText().isEmpty() && 
                    !menuAlumnos.campoAlumnosNombre.getText().isEmpty() && 
                    !menuAlumnos.campoAlumnosApellido1.getText().isEmpty() && 
                    !menuAlumnos.campoAlumnosApellido2.getText().isEmpty() && 
                    !menuAlumnos.campoAlumnosGrupo.getText().isEmpty()
                );
                
                menuAlumnos.botonAlumnosModificar.setEnabled(
                    !menuAlumnos.campoAlumnosCodigo.getText().isEmpty() && 
                    !menuAlumnos.campoAlumnosDNI.getText().isEmpty() && 
                    !menuAlumnos.campoAlumnosNombre.getText().isEmpty() && 
                    !menuAlumnos.campoAlumnosApellido1.getText().isEmpty() && 
                    !menuAlumnos.campoAlumnosApellido2.getText().isEmpty() && 
                    !menuAlumnos.campoAlumnosGrupo.getText().isEmpty()
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
        int fila = menuAlumnos.tablaAlumnos.getSelectedRow();
        try {
            actual=(Alumnos) rs.get(fila);
            if(actual.getCodigo()!=null){
                MostrarRegistro();
                menuAlumnos.botonAlumnosBorrar.setEnabled(fila != -1);
                menuAlumnos.botonAlumnosModificar.setEnabled(fila != -1);
            }
        } catch (Exception e) {
            actual = null;
        }
    }
    
    //Muestra en los JtextField de la sección de alumnos los datos que hemos seleccionado en el Jtable.
    public void MostrarRegistro() {
        menuAlumnos.campoAlumnosCodigo.setText(actual != null ? Integer.toString(actual.getCodigo()) : "");
        menuAlumnos.campoAlumnosDNI.setText(actual != null ? "" + actual.getDni(): "");
        menuAlumnos.campoAlumnosNombre.setText(actual != null ? actual.getNombre() : "");
        menuAlumnos.campoAlumnosApellido1.setText(actual != null ? actual.getApellido1() : "");
        menuAlumnos.campoAlumnosApellido2.setText(actual != null ? actual.getApellido2() : "");
        menuAlumnos.campoAlumnosGrupo.setText(actual != null ? actual.getGrupo() : "");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Sección de alumnos:
        if(e.getSource() == menuAlumnos.getBotonAlumnosInsertar()) {
            exc="";
            if(menuAlumnos.campoAlumnosNombre.getText().length()==0){exc="El nombre del alumno está vacío. Introduzca uno válido.";}
            else if(menuAlumnos.campoAlumnosNombre.getText().length()>50){exc="El nombre del alumno es demasiado largo. Introduzca uno válido.";}
            else if(menuAlumnos.campoAlumnosApellido1.getText().length()==0){exc="El primer apellido del alumno está vacío. Introduzca uno válido.";}
            else if(menuAlumnos.campoAlumnosApellido1.getText().length()>50){exc="El primer apellido del alumno es demasiado largo. Introduzca uno válido.";}
            else if(menuAlumnos.campoAlumnosApellido2.getText().length()==0){exc="El segundo apellido del alumno está vacío. Introduzca uno válido.";}
            else if(menuAlumnos.campoAlumnosApellido2.getText().length()>50){exc="El segundo apellido del alumno es demasiado largo. Introduzca uno válido.";}
            else if(menuAlumnos.campoAlumnosDNI.getText().length()==0){exc="El DNI del alumno está vacío. Introduzca uno válido.";}
            else if(!menuAlumnos.campoAlumnosDNI.getText().toLowerCase().matches("[0-9]{8}[a-z]{1}")){exc="El DNI del alumno está compuesto de 8 números y una letra. Introduzca uno válido.";}
            else if(String.valueOf(menuAlumnos.campoAlumnosGrupo.getText()).length()==0){exc="El código de grupo del alumno está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuAlumnos.campoAlumnosGrupo.getText()).matches("[0-9]*")){exc="El código del grupo sólo puede contener números. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try {
                    /*Query q =_escuchador.session.createSQLQuery(""
                        + "INSERT INTO alumnos VALUES( "
                        + "null, "
                        + "'" + menuAlumnos.campoAlumnosDNI.getText() + "', "
                        + "'" + menuAlumnos.campoAlumnosNombre.getText() + "', "
                        + "'" + menuAlumnos.campoAlumnosApellido1.getText() + "',"
                        + "'" + menuAlumnos.campoAlumnosApellido2.getText() + "',"
                        + "'" + menuAlumnos.campoAlumnosGrupo.getText() + "')"
                    );
                    q.executeUpdate();*/
                    
                    Grupos obj = new Grupos();
                    obj.setCodigo(Integer.parseInt(menuAlumnos.campoAlumnosGrupo.getText()));
                    Alumnos obj2 = new Alumnos(
                            obj,
                            menuAlumnos.campoAlumnosDNI.getText(),
                            menuAlumnos.campoAlumnosNombre.getText(),
                            menuAlumnos.campoAlumnosApellido1.getText(),
                            menuAlumnos.campoAlumnosApellido2.getText()
                    );
                    
                    _escuchador.session.save(obj2);
                    
                    tx.commit();
                } catch (Exception ex) {
                    tx.rollback();
                    ex.printStackTrace();
                    String error="Se ha producido un error. Posiblemente el grupo al que hace referencia no existe o el DNI introducido ya existe.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session,null);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuAlumnos.getBotonAlumnosBorrar()) {
            Transaction tx = _escuchador.session.beginTransaction();
            try {
                if (JOptionPane.showConfirmDialog(menuAlumnos,
                 "¿Está seguro que desea borrar el registro seleccionado?",
                 "Atención",
                 JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                    /*
                    Query q =_escuchador.session.createSQLQuery("DELETE FROM alumnos "
                    + "WHERE codigo = " + actual.getCodigo());
                    
                    q.executeUpdate();*/
                    
                    Grupos obj = new Grupos();
                    obj.setCodigo(Integer.parseInt(menuAlumnos.campoAlumnosGrupo.getText()));
                    actual.setGrupos(obj);
                    
                    _escuchador.session.delete(actual);
                    
                    tx.commit();
                } else{
                    tx.rollback();
                    JOptionPane.showMessageDialog(menuAlumnos, "La baja no se ha realizado"); 
                }
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
                String error="Se ha producido un error. No ha sido posible eliminar el registro.";
                VentanaMensajeError(error);
            }
            _escuchador.session.clear();
            InicializarTabla(_escuchador.session,null);
        }
        else if(e.getSource() == menuAlumnos.getBotonAlumnosModificar()) {
            exc="";
            if(menuAlumnos.campoAlumnosNombre.getText().length()==0){exc="El nombre del alumno está vacío. Introduzca uno válido.";}
            else if(menuAlumnos.campoAlumnosNombre.getText().length()>50){exc="El nombre del alumno es demasiado largo. Introduzca uno válido.";}
            else if(menuAlumnos.campoAlumnosApellido1.getText().length()==0){exc="El primer apellido del alumno está vacío. Introduzca uno válido.";}
            else if(menuAlumnos.campoAlumnosApellido1.getText().length()>50){exc="El primer apellido del alumno es demasiado largo. Introduzca uno válido.";}
            else if(menuAlumnos.campoAlumnosApellido2.getText().length()==0){exc="El segundo apellido del alumno está vacío. Introduzca uno válido.";}
            else if(menuAlumnos.campoAlumnosApellido2.getText().length()>50){exc="El segundo apellido del alumno es demasiado largo. Introduzca uno válido.";}
            else if(menuAlumnos.campoAlumnosDNI.getText().length()==0){exc="El DNI del alumno está vacío. Introduzca uno válido.";}
            else if(!menuAlumnos.campoAlumnosDNI.getText().toLowerCase().matches("[0-9]{8}[a-z]{1}")){exc="El DNI del alumno está compuesto de 8 números y una letra. Introduzca uno válido.";}
            else if(String.valueOf(menuAlumnos.campoAlumnosGrupo.getText()).length()==0){exc="El código de grupo del alumno está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuAlumnos.campoAlumnosGrupo.getText()).matches("[0-9]*")){exc="El código del grupo sólo puede contener números. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try{
                    if (JOptionPane.showConfirmDialog(menuAlumnos,
                    "¿Está seguro que desea modificar el registro seleccionado?",
                    "Atención",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                        /*
                        Query q = _escuchador.session.createSQLQuery("UPDATE alumnos SET "
                        + "dni='" + menuAlumnos.campoAlumnosDNI.getText() + "', "
                        + "nombre='" + menuAlumnos.campoAlumnosNombre.getText() + "', "
                        + "apellido1='" + menuAlumnos.campoAlumnosApellido1.getText() + "', "
                        + "apellido2='" + menuAlumnos.campoAlumnosApellido2.getText() + "', "
                        + "codigo_grupo='" + menuAlumnos.campoAlumnosGrupo.getText() + "' "   
                        + "WHERE codigo=" + actual.getCodigo());
                        
                        q.executeUpdate();*/
                        
                        Grupos obj = new Grupos();
                        obj.setCodigo(Integer.parseInt(menuAlumnos.campoAlumnosGrupo.getText()));
                        
                        actual.setGrupos(obj);
                        actual.setDni(menuAlumnos.campoAlumnosDNI.getText());
                        actual.setNombre(menuAlumnos.campoAlumnosNombre.getText());
                        actual.setApellido1(menuAlumnos.campoAlumnosApellido1.getText());
                        actual.setApellido2(menuAlumnos.campoAlumnosApellido2.getText());
                        
                        _escuchador.session.update(actual);
                    
                        tx.commit();
                    }
                    else{
                        tx.rollback();
                        JOptionPane.showMessageDialog(menuAlumnos,"La modificación no se ha realizado"); 
                    }
                } catch (Exception ex) {
                    tx.rollback();
                    String error="Se ha producido un error. Posiblemente el grupo al que hace referencia no existe o el DNI introducido ya existe.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session,null);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuAlumnos.getBotonAlumnosExportar()) {
            MessageFormat header = new MessageFormat("Lista de alumnos");
            MessageFormat footer = new MessageFormat("Página{0,number,integer}");
            try {
                menuAlumnos.getTablaAlumnos().print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (PrinterException ex) {
                Logger.getLogger(ControladorCursos.class.getName()).log(Level.SEVERE, null, ex);
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
        menu.panelAsignaturas.setVisible(false);
        menu.panelGrupos.setVisible(false);
        menu.panelProfesorado.setVisible(false);
        menu.panelDepartamentos.setVisible(false);
        menu.panelTutorias.setVisible(false);
        menu.imagen.setVisible(false);
        menu.bienvenida.setVisible(false);
        
        //Agrega un oyente a la lista que se notifica cada vez que se produce un cambio en el modelo de datos.
        menuAlumnos.tablaAlumnos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { //Cambios que se produce en el Jtable
                selectionChanged();
            }
        });
    }
    
    public void RegistrarEventos() {
        menuAlumnos.getBotonAlumnosInsertar().addActionListener(this);
        menuAlumnos.getBotonAlumnosBorrar().addActionListener(this);
        menuAlumnos.getBotonAlumnosModificar().addActionListener(this);
        menuAlumnos.getBotonAlumnosExportar().addActionListener(this);
        menuAlumnos.campoAlumnosCodigo.getDocument().addDocumentListener(HabilitarBotonesAlumnos());
        menuAlumnos.campoAlumnosDNI.getDocument().addDocumentListener(HabilitarBotonesAlumnos());
        menuAlumnos.campoAlumnosNombre.getDocument().addDocumentListener(HabilitarBotonesAlumnos());
        menuAlumnos.campoAlumnosApellido1.getDocument().addDocumentListener(HabilitarBotonesAlumnos());
        menuAlumnos.campoAlumnosApellido2.getDocument().addDocumentListener(HabilitarBotonesAlumnos());
        menuAlumnos.campoAlumnosGrupo.getDocument().addDocumentListener(HabilitarBotonesAlumnos());
        menuAlumnos.campoAlumnosBuscar.getDocument().addDocumentListener(ActivarBusqueda());
    }
}