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
import modelo.Departamentos;
import modelo.Profesores;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import vista.Gestor;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class ControladorProfesores implements ActionListener {
    
    // Llamamos a esta clase desde la clase inicio para mostrar el menú principal.
    // Para mostrar el menú principal debemos crear un objeto menuProfesores.
    private Gestor menuProfesores = null;
    
    private ControladorTabla rsmodel;
    
    private Profesores modeloProfesores; //La clase del Modelo
    
    private Profesores actual; //Define al alumno actual.
    // Variables para el campo buscar en el panel de grupo
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;
    // Inicializamos la variable para personalizar los mensajes de las excepciones.
    String exc;
    
    ControladorMenu _escuchador;
    
    List rs;
    
    public void ControladorProfesores(Gestor menu,ControladorMenu escuchador){
        menuProfesores=menu;
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(_escuchador.getEscuchadorProfesores()==false){
            _escuchador.setEscuchadorProfesores(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de profesores cargando los datos mediante la API JDBC.
        menuProfesores.getScrollProfesores().setBackground(Color.white);
        menuProfesores.getScrollProfesores().getViewport().setBackground(Color.white);
        menuProfesores.getScrollProfesores().setBorder(createEmptyBorder());
        JTableHeader header = menuProfesores.getTablaProfesores().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuProfesores.getTablaProfesores().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuProfesores.botonProfesoresInsertar.setEnabled(false);
        menuProfesores.botonProfesoresModificar.setEnabled(false);
        menuProfesores.botonProfesoresBorrar.setEnabled(false);
        menuProfesores.botonProfesoresSeleccionar.setEnabled(false);
            
        InicializarTabla(escuchador.session,null);
            
        // Mostramos el contenido.
            
        menuProfesores.panelProfesores.setVisible(true);
        menuProfesores.tablaProfesores.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    ConsultarTutorias();
                }
            }
        }
        );
    }
    
    public void ControladorProfesores(Gestor menu,String consultaProfesor,ControladorMenu escuchador){
        menuProfesores=menu;
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(escuchador.getEscuchadorProfesores()==false){
            escuchador.setEscuchadorProfesores(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de profesores cargando los datos mediante la API JDBC.
        menuProfesores.getScrollProfesores().setBackground(Color.white);
        menuProfesores.getScrollProfesores().getViewport().setBackground(Color.white);
        menuProfesores.getScrollProfesores().setBorder(createEmptyBorder());
        JTableHeader header = menuProfesores.getTablaProfesores().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuProfesores.getTablaProfesores().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuProfesores.botonProfesoresInsertar.setEnabled(false);
        menuProfesores.botonProfesoresModificar.setEnabled(false);
        menuProfesores.botonProfesoresBorrar.setEnabled(false);
        menuProfesores.botonProfesoresSeleccionar.setEnabled(false);
            
        
        try {
            /*Query q = _escuchador.session.createSQLQuery("SELECT profesores.codigo,profesores.dni,"
                + "profesores.nombre,profesores.apellido1,profesores.apellido2,"
                + "profesores.codigo_departamento,departamentos.nombre as nombre_departamento"
                + " FROM profesores"
                + " JOIN departamentos"
                + " ON profesores.codigo_departamento=departamentos.codigo"
                + " WHERE departamentos.codigo='"+consultaProfesor+"'");*/
            
            Query q = _escuchador.session.createQuery("SELECT a.codigo,a.dni,a.nombre,a.apellido1,a.apellido2,"
                + "b.codigo,b.nombre"
                + " from Profesores a,Departamentos b"
                + " where a.departamentos=b.codigo and b.codigo='"+consultaProfesor+"'");
            
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,q);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
        // Mostramos el contenido.
        menuProfesores.panelProfesores.setVisible(true);
    }
    
    protected void ConsultarTutorias(){
        ControladorTutorias mostrarTutorias = new ControladorTutorias();
        String consultaTutorias=menuProfesores.tablaProfesores.getValueAt(menuProfesores.tablaProfesores.getSelectedRow(),0).toString();
        menuProfesores.panelProfesores.setVisible(false);
        mostrarTutorias.ControladorTutorias(menuProfesores,consultaTutorias,_escuchador);
    }
    
    protected void InicializarTabla(Session session,Query q) {
        try {
            Transaction tx = session.beginTransaction();
            if(q==null){
                /*q = session.createSQLQuery(""
                        + "SELECT profesores.codigo,profesores.dni,profesores.nombre,profesores.apellido1,"
                        + "profesores.apellido2,profesores.codigo_departamento,departamentos.nombre as nombre_departamento"
                        + " FROM profesores"
                        + " JOIN departamentos ON profesores.codigo_departamento=departamentos.codigo"
                );*/
                
                q = session.createQuery("SELECT a.codigo,a.dni,a.nombre,a.apellido1,a.apellido2,"
                    + "b.codigo,b.nombre"
                    + " from Profesores a,Departamentos b"
                    + " where a.departamentos=b.codigo");
            }
            List<Object[]> listaAux = q.list();
            
            List <Profesores> lista = new ArrayList();
            if(!listaAux.isEmpty()){
                for(Object[] obj : listaAux) {
                    int codPro = Integer.parseInt(obj[0].toString());
                    String dniPro = String.valueOf(obj[1]);
                    String nomPro = String.valueOf(obj[2]);
                    String ap1Pro = String.valueOf(obj[3]);
                    String ap2Pro = String.valueOf(obj[4]);
                    String codDep = String.valueOf(obj[5]);
                    String nomDep = String.valueOf(obj[6]);

                    lista.add(new Profesores(codPro,dniPro,nomPro,ap1Pro,ap2Pro,codDep,nomDep));
                }
            }
            else{
                lista.add(new Profesores());
            }
            rs=lista;
            tx.commit();
            rsmodel = new ControladorTabla(lista); //Asigna la clase CtrlTablaAlumno a la variable rsmodel del mismo tipo

            menuProfesores.getTablaProfesores().setModel(rsmodel); //Cargo en el Jtable TablaAlumnos el contenido de select realizado en negalumnos.actualizar
            
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
    
 //Procedimiento que busca en la tabla de profesores algun valor introducido en el jtexfield campoProfesoresBuscar
    public void BuscarGrupo() {
        try {
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session,null);
            Transaction tx = _escuchador.session.beginTransaction();
            List<Profesores> tabla=rsmodel.lista;
            List<Profesores> borrados = new <Profesores>ArrayList();
            if(menuProfesores.campoProfesoresBuscarCategorias.getSelectedItem().toString().equals("Todos los campos")){
                for(Profesores obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase()) && 
                       !obj.getDni().toLowerCase().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase()) && 
                       !obj.getNombre().toLowerCase().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase()) && 
                       !obj.getApellido1().toLowerCase().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase()) && 
                       !obj.getApellido2().toLowerCase().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase()) && 
                       !obj.getDepartamento().toLowerCase().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase()) && 
                       !obj.getNombre_departamento().toLowerCase().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase())
                    ){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuProfesores.campoProfesoresBuscarCategorias.getSelectedItem().toString().equals("Código del profesor")){
                for(Profesores obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuProfesores.campoProfesoresBuscarCategorias.getSelectedItem().toString().equals("DNI del profesor")){
                for(Profesores obj : tabla) {
                    if(!obj.getDni().toLowerCase().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuProfesores.campoProfesoresBuscarCategorias.getSelectedItem().toString().equals("Nombre del profesor")){
                for(Profesores obj : tabla) {
                    if(!obj.getNombre().toLowerCase().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuProfesores.campoProfesoresBuscarCategorias.getSelectedItem().toString().equals("Primer apellido del profesor")){
                for(Profesores obj : tabla) {
                    if(!obj.getApellido1().toLowerCase().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuProfesores.campoProfesoresBuscarCategorias.getSelectedItem().toString().equals("Segundo apellido del profesor")){
                for(Profesores obj : tabla) {
                    if(!obj.getApellido2().toLowerCase().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuProfesores.campoProfesoresBuscarCategorias.getSelectedItem().toString().equals("Código del departamento")){
                for(Profesores obj : tabla) {
                    if(!obj.getDepartamento().toLowerCase().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuProfesores.campoProfesoresBuscarCategorias.getSelectedItem().toString().equals("Nombre del departamento")){
                for(Profesores obj : tabla) {
                    if(!obj.getNombre_departamento().toLowerCase().contains(menuProfesores.campoProfesoresBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            tabla.removeAll(borrados);
            tx.commit();
            if(tabla.isEmpty()){tabla.add(new Profesores());}
            rs=tabla;
            ControladorTabla registrosBuscados = new ControladorTabla(tabla);
            menuProfesores.getTablaProfesores().setModel(registrosBuscados);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//Es función controla si el botón btnAltas esta activo o no  si los jtextfiel estan vacios o no.
//https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    public DocumentListener HabilitarBotonesProfesores() { 

        DocumentListener documento;

        documento = new DocumentListener() {
            public void HayCambio() {
             
                menuProfesores.botonProfesoresInsertar.setEnabled(
                    !menuProfesores.campoProfesoresDNI.getText().isEmpty() && 
                    !menuProfesores.campoProfesoresNombre.getText().isEmpty() && 
                    !menuProfesores.campoProfesoresApellido1.getText().isEmpty() && 
                    !menuProfesores.campoProfesoresApellido2.getText().isEmpty() && 
                    !menuProfesores.campoProfesoresDepartamento.getText().isEmpty()
                );
                menuProfesores.botonProfesoresSeleccionar.setEnabled(
                    !menuProfesores.campoProfesoresCodigo.getText().isEmpty()
                );
                
                menuProfesores.botonProfesoresModificar.setEnabled(
                    !menuProfesores.campoProfesoresCodigo.getText().isEmpty() && 
                    !menuProfesores.campoProfesoresDNI.getText().isEmpty() && 
                    !menuProfesores.campoProfesoresNombre.getText().isEmpty() && 
                    !menuProfesores.campoProfesoresApellido1.getText().isEmpty() && 
                    !menuProfesores.campoProfesoresApellido2.getText().isEmpty() && 
                    !menuProfesores.campoProfesoresDepartamento.getText().isEmpty()
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
        int fila = menuProfesores.tablaProfesores.getSelectedRow();
        try {
            actual=(Profesores) rs.get(fila);
            if(actual.getCodigo()!=null){
                MostrarRegistro();
                menuProfesores.botonProfesoresBorrar.setEnabled(fila != -1);
                menuProfesores.botonProfesoresModificar.setEnabled(fila != -1);
            }
        } catch (Exception e) {
            actual = null;
        }
    }
    
    //Muestra en los JtextField de la sección de profesores los datos que hemos seleccionado en el Jtable.
    public void MostrarRegistro() {
        menuProfesores.campoProfesoresCodigo.setText(actual != null ? Integer.toString(actual.getCodigo()) : "");
        menuProfesores.campoProfesoresDNI.setText(actual != null ? "" + actual.getDni(): "");
        menuProfesores.campoProfesoresNombre.setText(actual != null ? actual.getNombre() : "");
        menuProfesores.campoProfesoresApellido1.setText(actual != null ? actual.getApellido1() : "");
        menuProfesores.campoProfesoresApellido2.setText(actual != null ? actual.getApellido2() : "");
        menuProfesores.campoProfesoresDepartamento.setText(actual != null ? actual.getDepartamento() : "");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Sección de profesores:
        if(e.getSource() == menuProfesores.getBotonProfesoresInsertar()) {
            exc="";
            if(menuProfesores.campoProfesoresNombre.getText().length()==0){exc="El nombre del profesor está vacío. Introduzca uno válido.";}
            else if(menuProfesores.campoProfesoresNombre.getText().length()>50){exc="El nombre del profesor es demasiado largo. Introduzca uno válido.";}
            else if(menuProfesores.campoProfesoresApellido1.getText().length()==0){exc="El primer apellido del profesor está vacío. Introduzca uno válido.";}
            else if(menuProfesores.campoProfesoresApellido1.getText().length()>50){exc="El primer apellido del profesor es demasiado largo. Introduzca uno válido.";}
            else if(menuProfesores.campoProfesoresApellido2.getText().length()==0){exc="El segundo apellido del profesor está vacío. Introduzca uno válido.";}
            else if(menuProfesores.campoProfesoresApellido2.getText().length()>50){exc="El segundo apellido del profesor es demasiado largo. Introduzca uno válido.";}
            else if(menuProfesores.campoProfesoresDNI.getText().length()==0){exc="El DNI del profesor está vacío. Introduzca uno válido.";}
            else if(!menuProfesores.campoProfesoresDNI.getText().toLowerCase().matches("[0-9]{8}[a-z]{1}")){exc="El DNI del profesor está compuesto de 8 números y una letra. Introduzca uno válido.";}
            else if(String.valueOf(menuProfesores.campoProfesoresDepartamento.getText()).length()==0){exc="El código del departamento del profesor está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuProfesores.campoProfesoresDepartamento.getText()).matches("[0-9]*")){exc="El código del departamento sólo puede contener números. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try {
                    /*Query q =_escuchador.session.createSQLQuery(""
                        + "INSERT INTO profesores VALUES( "
                        + "null, "
                        + "'" + menuProfesores.campoProfesoresDNI.getText() + "', "
                        + "'" + menuProfesores.campoProfesoresNombre.getText() + "', "
                        + "'" + menuProfesores.campoProfesoresApellido1.getText() + "',"
                        + "'" + menuProfesores.campoProfesoresApellido2.getText() + "',"
                        + "'" + menuProfesores.campoProfesoresDepartamento.getText() + "')"
                    );
                    q.executeUpdate();*/
                    
                    Departamentos obj = new Departamentos();
                    obj.setCodigo(Integer.parseInt(menuProfesores.campoProfesoresDepartamento.getText()));
                    Profesores obj2 = new Profesores(
                            obj,
                            menuProfesores.campoProfesoresDNI.getText(),
                            menuProfesores.campoProfesoresNombre.getText(),
                            menuProfesores.campoProfesoresApellido1.getText(),
                            menuProfesores.campoProfesoresApellido2.getText()
                    );
                    
                    _escuchador.session.save(obj2);
                    
                    tx.commit();
                } catch (Exception ex) {
                    tx.rollback();
                    ex.printStackTrace();
                    String error="Se ha producido un error. Posiblemente el departamento al que hace referencia no existe o el DNI introducido ya existe.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session,null);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuProfesores.getBotonProfesoresBorrar()) {
            Transaction tx = _escuchador.session.beginTransaction();
            try {
                if (JOptionPane.showConfirmDialog(menuProfesores,
                 "¿Está seguro que desea borrar el registro seleccionado?",
                 "Atención",
                 JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                    /*
                    Query q =_escuchador.session.createSQLQuery("DELETE FROM profesores "
                        + "WHERE codigo = " + actual.getCodigo());
                    
                    q.executeUpdate();*/
                    
                    Departamentos obj = new Departamentos();
                    obj.setCodigo(Integer.parseInt(menuProfesores.campoProfesoresDepartamento.getText()));
                    
                    actual.setDepartamentos(obj);
                    actual.setDni(menuProfesores.campoProfesoresDNI.getText());
                    actual.setNombre(menuProfesores.campoProfesoresNombre.getText());
                    actual.setApellido1(menuProfesores.campoProfesoresApellido1.getText());
                    actual.setApellido2(menuProfesores.campoProfesoresApellido2.getText());
                    
                    _escuchador.session.delete(actual);
                    
                    tx.commit();
                } else{
                    JOptionPane.showMessageDialog(menuProfesores, "La baja no se ha realizado"); 
                }
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
                String error="Se ha producido un error. Posiblemente el profesor que intenta eliminar tiene tutorías asignadas o es director de departamento.";
                VentanaMensajeError(error);
            }
            _escuchador.session.clear();
            InicializarTabla(_escuchador.session,null);
        }
        else if(e.getSource() == menuProfesores.getBotonProfesoresModificar()) {
            exc="";
            if(menuProfesores.campoProfesoresNombre.getText().length()==0){exc="El nombre del profesor está vacío. Introduzca uno válido.";}
            else if(menuProfesores.campoProfesoresNombre.getText().length()>50){exc="El nombre del profesor es demasiado largo. Introduzca uno válido.";}
            else if(menuProfesores.campoProfesoresApellido1.getText().length()==0){exc="El primer apellido del profesor está vacío. Introduzca uno válido.";}
            else if(menuProfesores.campoProfesoresApellido1.getText().length()>50){exc="El primer apellido del profesor es demasiado largo. Introduzca uno válido.";}
            else if(menuProfesores.campoProfesoresApellido2.getText().length()==0){exc="El segundo apellido del profesor está vacío. Introduzca uno válido.";}
            else if(menuProfesores.campoProfesoresApellido2.getText().length()>50){exc="El segundo apellido del profesor es demasiado largo. Introduzca uno válido.";}
            else if(menuProfesores.campoProfesoresDNI.getText().length()==0){exc="El DNI del profesor está vacío. Introduzca uno válido.";}
            else if(!menuProfesores.campoProfesoresDNI.getText().toLowerCase().matches("[0-9]{8}[a-z]{1}")){exc="El DNI del profesor está compuesto de 8 números y una letra. Introduzca uno válido.";}
            else if(String.valueOf(menuProfesores.campoProfesoresDepartamento.getText()).length()==0){exc="El código del departamento del profesor está vacío. Introduzca uno válido.";}
            else if(!String.valueOf(menuProfesores.campoProfesoresDepartamento.getText()).matches("[0-9]*")){exc="El código del departamento sólo puede contener números. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try{
                    if (JOptionPane.showConfirmDialog(menuProfesores,
                    "¿Está seguro que desea modificar el registro seleccionado?",
                    "Atención",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                        /*
                        Query q = _escuchador.session.createSQLQuery("UPDATE profesores SET "
                        + "dni='" + menuProfesores.campoProfesoresDNI.getText() + "', "
                        + "nombre='" + menuProfesores.campoProfesoresNombre.getText() + "', "
                        + "apellido1='" + menuProfesores.campoProfesoresApellido1.getText() + "', "
                        + "apellido2='" + menuProfesores.campoProfesoresApellido2.getText() + "', "
                        + "codigo_departamento='" + menuProfesores.campoProfesoresDepartamento.getText() + "' "   
                        + "WHERE codigo=" + actual.getCodigo());
                        
                        q.executeUpdate();
                        */
                        
                        Departamentos obj = new Departamentos();
                        obj.setCodigo(Integer.parseInt(menuProfesores.campoProfesoresDepartamento.getText()));

                        actual.setDepartamentos(obj);
                        actual.setDni(menuProfesores.campoProfesoresDNI.getText());
                        actual.setNombre(menuProfesores.campoProfesoresNombre.getText());
                        actual.setApellido1(menuProfesores.campoProfesoresApellido1.getText());
                        actual.setApellido2(menuProfesores.campoProfesoresApellido2.getText());

                        _escuchador.session.update(actual);
                        
                        tx.commit();
                    }
                    else{
                        tx.rollback();
                        JOptionPane.showMessageDialog(menuProfesores,"La modificación no se ha realizado"); 
                    }
                } catch (Exception ex) {
                    tx.rollback();
                    ex.printStackTrace();
                    String error="Se ha producido un error. Posiblemente el departamento al que hace referencia no existe o el DNI introducido ya existe.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session,null);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuProfesores.getBotonProfesoresSeleccionar()){
            ConsultarTutorias();
        }
        else if(e.getSource() == menuProfesores.getBotonProfesoresExportar()) {
            MessageFormat header = new MessageFormat("Lista de profesores");
            MessageFormat footer = new MessageFormat("Página{0,number,integer}");
            try {
                menuProfesores.getTablaProfesores().print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (PrinterException ex) {
                Logger.getLogger(ControladorProfesores.class.getName()).log(Level.SEVERE, null, ex);
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
        menu.panelGrupos.setVisible(false);
        menu.panelProfesorado.setVisible(false);
        menu.panelDepartamentos.setVisible(false);
        menu.panelTutorias.setVisible(false);
        menu.imagen.setVisible(false);
        menu.bienvenida.setVisible(false);
        //Agrega un oyente a la lista que se notifica cada vez que se produce un cambio en el modelo de datos.
        menuProfesores.tablaProfesores.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { //Cambios que se produce en el Jtable
                selectionChanged();
            }
        });
    }
    
    public void RegistrarEventos() {
        menuProfesores.getBotonProfesoresInsertar().addActionListener(this);
        menuProfesores.getBotonProfesoresBorrar().addActionListener(this);
        menuProfesores.getBotonProfesoresModificar().addActionListener(this);
        menuProfesores.getBotonProfesoresExportar().addActionListener(this);
        menuProfesores.getBotonProfesoresSeleccionar().addActionListener(this);
        menuProfesores.campoProfesoresCodigo.getDocument().addDocumentListener(HabilitarBotonesProfesores());
        menuProfesores.campoProfesoresDNI.getDocument().addDocumentListener(HabilitarBotonesProfesores());
        menuProfesores.campoProfesoresNombre.getDocument().addDocumentListener(HabilitarBotonesProfesores());
        menuProfesores.campoProfesoresApellido1.getDocument().addDocumentListener(HabilitarBotonesProfesores());
        menuProfesores.campoProfesoresApellido2.getDocument().addDocumentListener(HabilitarBotonesProfesores());
        menuProfesores.campoProfesoresDepartamento.getDocument().addDocumentListener(HabilitarBotonesProfesores());
        menuProfesores.campoProfesoresBuscar.getDocument().addDocumentListener(ActivarBusqueda());
    }
}