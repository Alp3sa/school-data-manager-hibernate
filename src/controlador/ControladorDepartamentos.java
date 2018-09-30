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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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
public class ControladorDepartamentos implements ActionListener {
    
    // Llamamos a esta clase desde la clase inicio para mostrar el menú principal.
    // Para mostrar el menú principal debemos crear un objeto menuDepartamentos.
    private Gestor menuDepartamentos = null;
    
    private ControladorTabla rsmodel;
    
    private Departamentos modeloDepartamentos; //La clase del Modelo
    
    private Departamentos actual; //Define al departamento actual.
    // Variables para el campo buscar
    private static final int TIEMPOBUSCAR = 300;
    private Timer timerbuscar;
    // Inicializamos la variable para personalizar los mensajes de las excepciones.
    String exc;
    
    ControladorMenu _escuchador;
    
    List rs;
    
    public void ControladorDepartamentos(Gestor menu,ControladorMenu escuchador){
        menuDepartamentos=menu;
        ocultarTodo(menu);
        
        _escuchador=escuchador;
        if(_escuchador.getEscuchadorDepartamentos()==false){
            _escuchador.setEscuchadorDepartamentos(true);
            RegistrarEventos();
        }
        
        // Damos formato e inicializamos la tabla de departamentos cargando los datos mediante la API JDBC.
        menuDepartamentos.getScrollDepartamentos().setBackground(Color.white);
        menuDepartamentos.getScrollDepartamentos().getViewport().setBackground(Color.white);
        menuDepartamentos.getScrollDepartamentos().setBorder(createEmptyBorder());
        JTableHeader header = menuDepartamentos.getTablaDepartamentos().getTableHeader();
        header.setBackground(Color.WHITE);
        header.setBorder(createLineBorder(Color.BLACK));
        menuDepartamentos.getTablaDepartamentos().setBorder(BorderFactory.createMatteBorder(0,1,0,0,Color.BLACK));
        menuDepartamentos.botonDepartamentosInsertar.setEnabled(false);
        menuDepartamentos.botonDepartamentosModificar.setEnabled(false);
        menuDepartamentos.botonDepartamentosBorrar.setEnabled(false);
        menuDepartamentos.botonDepartamentosSeleccionar.setEnabled(false);
            
        InicializarTabla(escuchador.session);
            
        // Mostramos el contenido.
            
        menuDepartamentos.panelDepartamentos.setVisible(true);
        
        menuDepartamentos.tablaDepartamentos.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                if (mouseEvent.getClickCount() == 2) {
                    ConsultarMiembros();
                }
            }
        }
        );
    }
    
    protected void ConsultarMiembros(){
        ControladorProfesores mostrarProfesores = new ControladorProfesores();
        String consultaDepartamento=menuDepartamentos.tablaDepartamentos.getValueAt(menuDepartamentos.tablaDepartamentos.getSelectedRow(),0).toString();
        menuDepartamentos.panelDepartamentos.setVisible(false);
        mostrarProfesores.ControladorProfesores(menuDepartamentos,consultaDepartamento,_escuchador);
    }
    
    protected void InicializarTabla(Session session) {
        try {
            Transaction tx = session.beginTransaction();
            
            /*Query q = session.createSQLQuery(""
                    + "SELECT departamentos.codigo,departamentos.nombre,departamentos.codigo_director,profesores.nombre as nombre_director,profesores.apellido1,profesores.apellido2,profesores.dni FROM departamentos"
                    + " LEFT JOIN profesores ON departamentos.codigo_director=profesores.codigo"
            );*/
            Query q = session.createQuery("SELECT a.codigo,a.nombre,b.codigo,"
                + "b.nombre,b.apellido1,b.apellido2,b.dni"
                + " from Departamentos a left join a.profesores b");
              
            
            List<Object[]> listaAux = q.list();
            List <Departamentos> lista = new ArrayList();
            for(Object[] obj : listaAux) {
                int codDep = Integer.parseInt(obj[0].toString());
                String nomDep = String.valueOf(obj[1]);
                String codDir = String.valueOf(obj[2]);
                String nomDir;
                String ape1Dir;
                String ape2Dir;
                String dniDir;
                if(!codDir.contains("null")){
                    nomDir = String.valueOf(obj[3]);
                    ape1Dir = String.valueOf(obj[4]);
                    ape2Dir = String.valueOf(obj[5]);
                    dniDir = String.valueOf(obj[6]);
                }
                else{
                    codDir = "";
                    nomDir = "";
                    ape1Dir = "";
                    ape2Dir = "";
                    dniDir = "";
                }
                
                lista.add(new Departamentos(codDep,nomDep,codDir,nomDir,ape1Dir,ape2Dir,dniDir));
            }
            rs=lista;
            tx.commit();
            
            rsmodel = new ControladorTabla(lista); //Asigna la clase CtrlTablaAlumno a la variable rsmodel del mismo tipo

            menuDepartamentos.getTablaDepartamentos().setModel(rsmodel); //Cargo en el Jtable TablaAlumnos el contenido de select realizado en negalumnos.actualizar
            
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
    
 //Procedimiento que busca en la tabla de departamentos
    public void BuscarGrupo() {
        try {
            // Inicializamos la tabla para refrescar todos los datos contenidos.
            InicializarTabla(_escuchador.session);
            Transaction tx = _escuchador.session.beginTransaction();
            List<Departamentos> tabla=rsmodel.lista;
            List<Departamentos> borrados = new <Departamentos>ArrayList();
            if(menuDepartamentos.campoDepartamentosBuscarCategorias.getSelectedItem().toString().equals("Todos los campos")){
                for(Departamentos obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase()) && 
                       !obj.getNombre().toLowerCase().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase()) && 
                       !obj.getDirector().toLowerCase().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase()) && 
                       !obj.getNombre_director().toLowerCase().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase()) && 
                       !obj.getApellido1_director().toLowerCase().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase()) && 
                       !obj.getApellido2_director().toLowerCase().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase()) && 
                       !obj.getDNI_director().toLowerCase().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase())
                    ){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuDepartamentos.campoDepartamentosBuscarCategorias.getSelectedItem().toString().equals("Código del departamento")){
                for(Departamentos obj : tabla) {
                    if(!obj.getCodigo().toString().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuDepartamentos.campoDepartamentosBuscarCategorias.getSelectedItem().toString().equals("Nombre del departamento")){
                for(Departamentos obj : tabla) {
                    if(!obj.getNombre().toLowerCase().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuDepartamentos.campoDepartamentosBuscarCategorias.getSelectedItem().toString().equals("Código del director")){
                for(Departamentos obj : tabla) {
                    if(!obj.getDirector().toLowerCase().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuDepartamentos.campoDepartamentosBuscarCategorias.getSelectedItem().toString().equals("Nombre del director")){
                for(Departamentos obj : tabla) {
                    if(!obj.getNombre_director().toLowerCase().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuDepartamentos.campoDepartamentosBuscarCategorias.getSelectedItem().toString().equals("Primer apellido del director")){
                for(Departamentos obj : tabla) {
                    if(!obj.getApellido1_director().toLowerCase().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuDepartamentos.campoDepartamentosBuscarCategorias.getSelectedItem().toString().equals("Segundo apellido del director")){
                for(Departamentos obj : tabla) {
                    if(!obj.getApellido2_director().toLowerCase().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            else if(menuDepartamentos.campoDepartamentosBuscarCategorias.getSelectedItem().toString().equals("DNI del director")){
                for(Departamentos obj : tabla) {
                    if(!obj.getDNI_director().toLowerCase().contains(menuDepartamentos.campoDepartamentosBuscar.getText().toLowerCase())){
                        borrados.add(obj);
                    }
                }
            }
            tabla.removeAll(borrados);
            tx.commit();
            if(tabla.isEmpty()){tabla.add(new Departamentos(null));}
            rs=tabla;
            ControladorTabla registrosBuscados = new ControladorTabla(tabla);
            menuDepartamentos.getTablaDepartamentos().setModel(registrosBuscados);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Excepción", JOptionPane.ERROR_MESSAGE);
        }
    }
    
//https://docs.oracle.com/javase/tutorial/uiswing/events/documentlistener.html
    public DocumentListener HabilitarBotonesDepartamentos() { 

        DocumentListener documento;

        documento = new DocumentListener() {
            public void HayCambio() {
             
                menuDepartamentos.botonDepartamentosInsertar.setEnabled(
                    !menuDepartamentos.campoDepartamentosNombre.getText().isEmpty()
                );
                menuDepartamentos.botonDepartamentosSeleccionar.setEnabled(
                    !menuDepartamentos.campoDepartamentosCodigo.getText().isEmpty()
                );
                
                menuDepartamentos.botonDepartamentosModificar.setEnabled(
                    !menuDepartamentos.campoDepartamentosCodigo.getText().isEmpty() && 
                    !menuDepartamentos.campoDepartamentosNombre.getText().isEmpty()
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
        int fila = menuDepartamentos.tablaDepartamentos.getSelectedRow();
        try {
            actual=(Departamentos) rs.get(fila);
            if(actual.getCodigo()!=null){
                MostrarRegistro();
                menuDepartamentos.botonDepartamentosBorrar.setEnabled(fila != -1);
                menuDepartamentos.botonDepartamentosModificar.setEnabled(fila != -1);
            }
        } catch (Exception e) {
            actual = null;
        }
    }
    
    //Muestra en los JtextField de la sección de departamentos los datos que hemos seleccionado en el Jtable.
    public void MostrarRegistro() {
        menuDepartamentos.campoDepartamentosCodigo.setText(actual != null ? Integer.toString(actual.getCodigo()) : "");
        menuDepartamentos.campoDepartamentosNombre.setText(actual != null ? "" + actual.getNombre() : "");
        menuDepartamentos.campoDepartamentosDirector.setText(actual != null ? actual.getDirector() : "");
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        // Sección de departamentos:
        if(e.getSource() == menuDepartamentos.getBotonDepartamentosInsertar()) {
            exc="";
            if(menuDepartamentos.campoDepartamentosNombre.getText().length()==0){exc="El nombre del departamento está vacío. Introduzca uno válido.";}
            else if(menuDepartamentos.campoDepartamentosNombre.getText().length()>50){exc="El nombre del departamento tiene más de 50 caracteres. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try {
                    
                    /*String director="NULL";
                    if(menuDepartamentos.campoDepartamentosDirector.getText().length()>0){director=menuDepartamentos.campoDepartamentosDirector.getText();}
                    
                    Query q =_escuchador.session.createSQLQuery(""
                        + "INSERT INTO departamentos VALUES( "
                        + "null, "
                        + "'" + menuDepartamentos.campoDepartamentosNombre.getText() + "', "
                        + "" + director + " )"
                    );
                    q.executeUpdate();
                    */
                    
                    Integer director=null;
                    if(menuDepartamentos.campoDepartamentosDirector.getText().length()>0){director=Integer.parseInt(menuDepartamentos.campoDepartamentosDirector.getText());}
                    Departamentos obj2;
                    if(director!=null){
                        Profesores obj = new Profesores();
                        obj.setCodigo(director);

                        obj2 = new Departamentos(
                                obj,
                                menuDepartamentos.campoDepartamentosNombre.getText()
                        );
                    }
                    else{
                        obj2 = new Departamentos(
                                menuDepartamentos.campoDepartamentosNombre.getText(),
                                null
                        );
                    }
                    
                    _escuchador.session.save(obj2);
                    
                    tx.commit();
                } catch (Exception ex) {
                    tx.rollback();
                    ex.printStackTrace();
                    String error="Se ha producido un error. Posiblemente el director al que hace referencia no existe.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuDepartamentos.getBotonDepartamentosBorrar()) {
            Transaction tx = _escuchador.session.beginTransaction();
            try {
                if (JOptionPane.showConfirmDialog(menuDepartamentos,
                 "¿Está seguro que desea borrar el registro seleccionado?",
                 "Atención",
                 JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                    
                    /*Query q =_escuchador.session.createSQLQuery("DELETE FROM departamentos "
                + "WHERE codigo = " + actual.getCodigo());
                    
                    q.executeUpdate();*/
                    Integer director=null;
                    if(menuDepartamentos.campoDepartamentosDirector.getText().length()>0){director=Integer.parseInt(menuDepartamentos.campoDepartamentosDirector.getText());}
                    
                    if(director!=null){
                        Profesores obj = new Profesores();
                        obj.setCodigo(director);
                        actual.setProfesores(obj);
                    }
                    else{
                        actual.setDirector(menuDepartamentos.campoDepartamentosDirector.getText());
                    }
                    actual.setNombre(menuDepartamentos.campoDepartamentosNombre.getText());
                    
                    _escuchador.session.delete(actual);
                    
                    tx.commit();
                } else{
                    tx.rollback();
                    JOptionPane.showMessageDialog(menuDepartamentos, "La baja no se ha realizado"); 
                }
            } catch (Exception ex) {
                tx.rollback();
                ex.printStackTrace();
                
                String error="Se ha producido un error. Posiblemente el departamento que intenta borrar posea profesores. Debe eliminarlos primero.";
                VentanaMensajeError(error);
            }
            _escuchador.session.clear();
            InicializarTabla(_escuchador.session);
        }
        else if(e.getSource() == menuDepartamentos.getBotonDepartamentosModificar()) {
            exc="";
            if(menuDepartamentos.campoDepartamentosNombre.getText().length()==0){exc="El nombre del departamento está vacío. Introduzca uno válido.";}
            else if(menuDepartamentos.campoDepartamentosNombre.getText().length()>50){exc="El nombre del departamento tiene más de 50 caracteres. Introduzca uno válido.";}
            
            if(exc.length()==0){
                Transaction tx = _escuchador.session.beginTransaction();
                try{
                    if (JOptionPane.showConfirmDialog(menuDepartamentos,
                    "¿Está seguro que desea modificar el registro seleccionado?",
                    "Atención",
                    JOptionPane.YES_NO_CANCEL_OPTION,
                    JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION) {
                        /*
                        String director=menuDepartamentos.campoDepartamentosDirector.getText();
                        if(director.length()==0){director="NULL";}
                        
                        Query q = _escuchador.session.createSQLQuery("UPDATE departamentos SET "
                        + "nombre='" + menuDepartamentos.campoDepartamentosNombre.getText() + "', "
                        + "codigo_director=" + director + " "   
                        + "WHERE codigo=" + actual.getCodigo());
                        
                        q.executeUpdate();*/
                        
                        Integer director=null;
                        if(menuDepartamentos.campoDepartamentosDirector.getText().length()>0){director=Integer.parseInt(menuDepartamentos.campoDepartamentosDirector.getText());}

                        if(director!=null){
                            Profesores obj = new Profesores();
                            obj.setCodigo(director);
                            actual.setProfesores(obj);
                        }
                        else{
                            actual.setDirector(menuDepartamentos.campoDepartamentosDirector.getText());
                        }
                        actual.setNombre(menuDepartamentos.campoDepartamentosNombre.getText());

                        _escuchador.session.update(actual);
                    
                        tx.commit();
                    }
                    else{
                        tx.rollback();
                        JOptionPane.showMessageDialog(menuDepartamentos,"La modificación no se ha realizado"); 
                    }
                } catch (Exception ex) {
                    tx.rollback();
                    ex.printStackTrace();
                    String error="Se ha producido un error. Posiblemente el director al que hace referencia no existe.";
                    VentanaMensajeError(error);
                }
                _escuchador.session.clear();
                InicializarTabla(_escuchador.session);
            }
            else{
                VentanaMensajeError(exc);
            }
        }
        else if(e.getSource() == menuDepartamentos.getBotonDepartamentosSeleccionar()) {
            ConsultarMiembros();
        }
        else if(e.getSource() == menuDepartamentos.getBotonDepartamentosExportar()) {
            MessageFormat header = new MessageFormat("Lista de departamentos");
            MessageFormat footer = new MessageFormat("Página{0,number,integer}");
            try {
                menuDepartamentos.getTablaDepartamentos().print(JTable.PrintMode.FIT_WIDTH,header,footer);
            } catch (PrinterException ex) {
                Logger.getLogger(ControladorDepartamentos.class.getName()).log(Level.SEVERE, null, ex);
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
        menu.panelProfesores.setVisible(false);
        menu.panelTutorias.setVisible(false);
        menu.imagen.setVisible(false);
        menu.bienvenida.setVisible(false);
        //Agrega un oyente a la lista que se notifica cada vez que se produce un cambio en el modelo de datos.
        menuDepartamentos.tablaDepartamentos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) { //Cambios que se produce en el Jtable
                selectionChanged();
            }
        });
    }
    
    public void RegistrarEventos() {
        menuDepartamentos.getBotonDepartamentosInsertar().addActionListener(this);
        menuDepartamentos.getBotonDepartamentosBorrar().addActionListener(this);
        menuDepartamentos.getBotonDepartamentosModificar().addActionListener(this);
        menuDepartamentos.getBotonDepartamentosExportar().addActionListener(this);
        menuDepartamentos.getBotonDepartamentosSeleccionar().addActionListener(this);
        menuDepartamentos.campoDepartamentosCodigo.getDocument().addDocumentListener(HabilitarBotonesDepartamentos());
        menuDepartamentos.campoDepartamentosNombre.getDocument().addDocumentListener(HabilitarBotonesDepartamentos());
        menuDepartamentos.campoDepartamentosDirector.getDocument().addDocumentListener(HabilitarBotonesDepartamentos());
        menuDepartamentos.campoDepartamentosBuscar.getDocument().addDocumentListener(ActivarBusqueda());
    }
}