/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Timer;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class Gestor extends javax.swing.JFrame {
    int estadoMenu1=0;
    int estadoMenu2=0;
    int estadoMenu3=0;
    Timer timer1;
    Timer timer2;
    Timer timer3;
    int a;
    /**
     * Creates new form GesCursos
     */
    public Gestor() {
        initComponents();
        
    }
    
    public JTable getTablaAlumnos() {
        return tablaAlumnos;
    }
    
    public JScrollPane getScrollAlumnos() {
        return scrollAlumnos;
    }
    
    public JTable getTablaAulas() {
        return tablaAulas;
    }
    
    public JScrollPane getScrollAulas() {
        return scrollAulas;
    }
    
    public JTable getTablaAsignaciones() {
        return tablaAsignacion;
    }
    
    public JScrollPane getScrollAsignaciones() {
        return scrollAsignacion;
    }
    
    public JTable getTablaCursos() {
        return tablaCursos;
    }
    
    public JScrollPane getScrollCursos() {
        return scrollCursos;
    }
    
    public JTable getTablaDepartamentos() {
        return tablaDepartamentos;
    }
    
    public JScrollPane getScrollDepartamentos() {
        return scrollDepartamentos;
    }
    
    public JTable getTablaGrupos() {
        return tablaGrupos;
    }
    
    public JScrollPane getScrollGrupos() {
        return scrollGrupos;
    }
    
    public JTable getTablaHorarios() {
        return tablaHorarios;
    }
    
    public JScrollPane getScrollHorarios() {
        return scrollHorarios;
    }
    
    public JTable getTablaProfesores() {
        return tablaProfesores;
    }
    
    public JScrollPane getScrollProfesores() {
        return scrollProfesores;
    }
    
    public JTable getTablaAsignaturas() {
        return tablaAsignaturas;
    }
    
    public JScrollPane getScrollAsignaturas() {
        return scrollAsignaturas;
    }
    
    public JTable getTablaTutorias() {
        return tablaTutorias;
    }
    
    public JScrollPane getScrollTutorias() {
        return scrollTutorias;
    }
    
    public JButton getBotonInicio() {
        return botonInicio;
    }
    
    public JButton getBotonCentro() {
        return botonCentro;
    }
    
    public JButton getBotonAlumnado() {
        return botonAlumnado;
    }
    
    public JButton getBotonProfesorado() {
        return botonProfesorado;
    }
    
    public JButton getBotonSalir() {
        return botonSalir;
    }
    
    public JButton getBotonCursos() {
        return opcionCursos;
    }
    
    public JButton getBotonHorarios() {
        return opcionHorarios;
    }
    
    public JButton getBotonAulas() {
        return opcionAulas;
    }
    
    public JButton getBotonAlumnos() {
        return opcionAlumnos;
    }
    
    public JButton getBotonGrupos() {
        return opcionGrupos;
    }
    
    public JButton getBotonAsignaturas() {
        return opcionAsignaturas;
    }
    
    public JButton getBotonProfesores() {
        return opcionProfesores;
    }
    
    public JButton getBotonDepartamentos() {
        return opcionDepartamentos;
    }
    
    public JButton getBotonTutorias() {
        return opcionTutorias;
    }
    
    public JButton getBotonAlumnosInsertar() {
        return botonAlumnosInsertar;
    }
    
    public JButton getBotonAlumnosBorrar() {
        return botonAlumnosBorrar;
    }
    
    public JButton getBotonAlumnosModificar() {
        return botonAlumnosModificar;
    }
    
    public JButton getBotonAlumnosExportar() {
        return botonAlumnosExportar;
    }
    
    public JButton getBotonAulasInsertar() {
        return botonAulasInsertar;
    }
    
    public JButton getBotonAulasBorrar() {
        return botonAulasBorrar;
    }
    
    public JButton getBotonAulasModificar() {
        return botonAulasModificar;
    }
    
    public JButton getBotonAulasExportar() {
        return botonExportarAulas;
    }
    
    public JButton getBotonAulasSeleccionar() {
        return botonAulasSeleccionar;
    }
    
    public JButton getBotonCursosInsertar() {
        return botonCursosInsertar;
    }
    
    public JButton getBotonCursosBorrar() {
        return botonCursosBorrar;
    }
    
    public JButton getBotonCursosModificar() {
        return botonCursosModificar;
    }
    
    public JButton getBotonCursosExportar() {
        return botonCursosExportar;
    }
    
    public JButton getBotonDepartamentosInsertar() {
        return botonDepartamentosInsertar;
    }
    
    public JButton getBotonDepartamentosBorrar() {
        return botonDepartamentosBorrar;
    }
    
    public JButton getBotonDepartamentosModificar() {
        return botonDepartamentosModificar;
    }
    
    public JButton getBotonDepartamentosSeleccionar() {
        return botonDepartamentosSeleccionar;
    }
    
    public JButton getBotonDepartamentosExportar() {
        return botonDepartamentosExportar;
    }
    
    public JButton getBotonGruposInsertar() {
        return botonGruposInsertar;
    }
    
    public JButton getBotonGruposBorrar() {
        return botonGruposBorrar;
    }
    
    public JButton getBotonGruposModificar() {
        return botonGruposModificar;
    }
    
    public JButton getBotonGruposExportar() {
        return botonGruposExportar;
    }
    
    public JButton getBotonGruposSeleccionar() {
        return botonGruposSeleccionar;
    }
    
    public JButton getBotonHorariosInsertar() {
        return botonHorariosInsertar;
    }
    
    public JButton getBotonHorariosBorrar() {
        return botonHorariosBorrar;
    }
    
    public JButton getBotonHorariosModificar() {
        return botonHorariosModificar;
    }
    
    public JButton getBotonHorariosExportar() {
        return botonHorariosExportar;
    }
    
    public JButton getBotonHorariosSeleccionar() {
        return botonHorariosSeleccionar;
    }
    
    public JButton getBotonProfesoresInsertar() {
        return botonProfesoresInsertar;
    }
    
    public JButton getBotonProfesoresBorrar() {
        return botonProfesoresBorrar;
    }
    
    public JButton getBotonProfesoresModificar() {
        return botonProfesoresModificar;
    }
    
    public JButton getBotonProfesoresExportar() {
        return botonProfesoresExportar;
    }
    
    public JButton getBotonProfesoresSeleccionar() {
        return botonProfesoresSeleccionar;
    }
    
    public JButton getBotonAsignaturasInsertar() {
        return botonAsignaturasInsertar;
    }
    
    public JButton getBotonAsignaturasBorrar() {
        return botonAsignaturasBorrar;
    }
    
    public JButton getBotonAsignaturasModificar() {
        return botonAsignaturasModificar;
    }
    
    public JButton getBotonAsignaturasExportar() {
        return botonAsignaturasExportar;
    }
    
    public JButton getBotonAsignaturasSeleccionar() {
        return botonAsignaturasSeleccionar;
    }
    
    public JButton getBotonTutoriasInsertar() {
        return botonTutoriasInsertar;
    }
    
    public JButton getBotonTutoriasBorrar() {
        return botonTutoriasBorrar;
    }
    
    public JButton getBotonTutoriasModificar() {
        return botonTutoriasModificar;
    }
    
    public JButton getBotonTutoriasExportar() {
        return campoTutoriasExportar;
    }
    
    public JTextField getCampoGruposNombre() {
        return campoGruposNombre;
    }
    
    public JTextField getCampoGruposCurso() {
        return campoGruposCurso;
    }
    
    public JTextField getCampoGruposCodigo() {
        return campoGruposCodigo;
    }
    
    public JButton getBotonAsignacionesInsertar() {
        return botonInsertarAsignacion;
    }
    
    public JButton getBotonAsignacionesBorrar() {
        return botonBorrarAsignacion;
    }
    
    public JButton getBotonAsignacionesExportar() {
        return botonExportarAsignacion;
    }
    
    public JButton getBotonAsignacionesModificar() {
        return botonModificarAsignacion;
    }
    
    public JButton getBotonAsignacionesSeleccionar() {
        return botonSeleccionarAsignacion;
    }
    
    public JButton getBotonRegistrarUsuario() {
        return BotonRegistrarUsuario;
    }
    
    public JButton getBotonIdentificarUsuario() {
        return BotonIdentificarUsuario;
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        panel = new javax.swing.JLayeredPane();
        panelInicioSesion = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        usuario = new javax.swing.JLabel();
        password = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        BotonIdentificarUsuario = new javax.swing.JButton();
        tituloInicioSesion = new javax.swing.JLabel();
        BotonRegistrarUsuario = new javax.swing.JButton();
        campoPassword = new javax.swing.JPasswordField();
        jLabel17 = new javax.swing.JLabel();
        opcionesProfesorado = new javax.swing.JPanel();
        opcionTutorias = new javax.swing.JButton();
        opcionProfesores = new javax.swing.JButton();
        opcionDepartamentos = new javax.swing.JButton();
        opcionesCentro = new javax.swing.JPanel();
        opcionCursos = new javax.swing.JButton();
        opcionHorarios = new javax.swing.JButton();
        opcionAulas = new javax.swing.JButton();
        opcionesAlumnado = new javax.swing.JPanel();
        opcionGrupos = new javax.swing.JButton();
        opcionAlumnos = new javax.swing.JButton();
        opcionAsignaturas = new javax.swing.JButton();
        panelInicio = new javax.swing.JPanel();
        barraInicio = new javax.swing.JPanel();
        botonInicio = new javax.swing.JButton();
        botonProfesorado = new javax.swing.JButton();
        botonSalir = new javax.swing.JButton();
        botonAlumnado = new javax.swing.JButton();
        botonCentro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        capas = new javax.swing.JLayeredPane();
        panelHorarios = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        scrollHorarios = new javax.swing.JScrollPane();
        tablaHorarios = new javax.swing.JTable();
        botonHorariosInsertar = new javax.swing.JButton();
        botonHorariosBorrar = new javax.swing.JButton();
        botonHorariosModificar = new javax.swing.JButton();
        botonHorariosSeleccionar = new javax.swing.JButton();
        jLabelGruposCurso5 = new javax.swing.JLabel();
        jLabelGruposNombre8 = new javax.swing.JLabel();
        jLabelGruposTutor4 = new javax.swing.JLabel();
        campoHorariosCodigo_asignatura = new javax.swing.JTextField();
        jLabelGruposCodigo7 = new javax.swing.JLabel();
        campoHorariosCodigo = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        campoHorariosBuscar = new javax.swing.JTextField();
        jLabelGruposNombre9 = new javax.swing.JLabel();
        campoHorariosDia = new javax.swing.JComboBox<>();
        campoHorariosFin = new javax.swing.JComboBox<>();
        campoHorariosComienzo = new javax.swing.JComboBox<>();
        campoHorariosBuscarCategorias = new javax.swing.JComboBox<>();
        botonHorariosExportar = new javax.swing.JButton();
        panelBienvenida = new javax.swing.JPanel();
        bienvenida = new javax.swing.JLabel();
        imagen = new javax.swing.JLabel();
        panelCentro = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane3 = new javax.swing.JTextPane();
        panelAulas = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        scrollAulas = new javax.swing.JScrollPane();
        tablaAulas = new javax.swing.JTable();
        botonAulasInsertar = new javax.swing.JButton();
        botonAulasBorrar = new javax.swing.JButton();
        botonAulasModificar = new javax.swing.JButton();
        botonAulasSeleccionar = new javax.swing.JButton();
        jLabelAulasNombre = new javax.swing.JLabel();
        jLabelAulasTutor = new javax.swing.JLabel();
        campoAsignacionCodigo_aula = new javax.swing.JTextField();
        campoAsignacionCodigo_grupo = new javax.swing.JTextField();
        jLabelAulasCodigo = new javax.swing.JLabel();
        campoAulasNombre = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        campoAulasBuscar = new javax.swing.JTextField();
        botonInsertarAsignacion = new javax.swing.JButton();
        botonSeleccionarAsignacion = new javax.swing.JButton();
        botonModificarAsignacion = new javax.swing.JButton();
        botonBorrarAsignacion = new javax.swing.JButton();
        scrollAsignacion = new javax.swing.JScrollPane();
        tablaAsignacion = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        campoAsignacionBuscar = new javax.swing.JTextField();
        campoAsignacionesBuscarCategorias = new javax.swing.JComboBox<>();
        campoAulasBuscarCategorias = new javax.swing.JComboBox<>();
        botonExportarAsignacion = new javax.swing.JButton();
        botonExportarAulas = new javax.swing.JButton();
        panelCursos = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        scrollCursos = new javax.swing.JScrollPane();
        tablaCursos = new javax.swing.JTable();
        botonCursosInsertar = new javax.swing.JButton();
        botonCursosBorrar = new javax.swing.JButton();
        botonCursosModificar = new javax.swing.JButton();
        jLabelCursosNombre = new javax.swing.JLabel();
        campoCursosNombre = new javax.swing.JTextField();
        jLabelCursosCodigo = new javax.swing.JLabel();
        campoCursosCodigo = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        campoCursosBuscar = new javax.swing.JTextField();
        campoCursosBuscarCategorias = new javax.swing.JComboBox<>();
        botonCursosExportar = new javax.swing.JButton();
        panelAlumnado = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        panelAlumnos = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        scrollAlumnos = new javax.swing.JScrollPane();
        tablaAlumnos = new javax.swing.JTable();
        botonAlumnosInsertar = new javax.swing.JButton();
        botonAlumnosBorrar = new javax.swing.JButton();
        botonAlumnosModificar = new javax.swing.JButton();
        jLabelGruposCurso1 = new javax.swing.JLabel();
        jLabelGruposNombre1 = new javax.swing.JLabel();
        jLabelGruposTutor1 = new javax.swing.JLabel();
        campoAlumnosApellido1 = new javax.swing.JTextField();
        campoAlumnosDNI = new javax.swing.JTextField();
        campoAlumnosApellido2 = new javax.swing.JTextField();
        jLabelGruposCodigo1 = new javax.swing.JLabel();
        campoAlumnosCodigo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        campoAlumnosBuscar = new javax.swing.JTextField();
        jLabelGruposNombre2 = new javax.swing.JLabel();
        campoAlumnosGrupo = new javax.swing.JTextField();
        campoAlumnosNombre = new javax.swing.JTextField();
        jLabelGruposCodigo2 = new javax.swing.JLabel();
        campoAlumnosBuscarCategorias = new javax.swing.JComboBox<>();
        botonAlumnosExportar = new javax.swing.JButton();
        panelGrupos = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        scrollGrupos = new javax.swing.JScrollPane();
        tablaGrupos = new javax.swing.JTable();
        botonGruposInsertar = new javax.swing.JButton();
        botonGruposBorrar = new javax.swing.JButton();
        botonGruposModificar = new javax.swing.JButton();
        botonGruposSeleccionar = new javax.swing.JButton();
        jLabelGruposCurso = new javax.swing.JLabel();
        jLabelGruposNombre = new javax.swing.JLabel();
        jLabelGruposTutor = new javax.swing.JLabel();
        campoGruposCurso = new javax.swing.JTextField();
        campoGruposNombre = new javax.swing.JTextField();
        campoGruposTutor = new javax.swing.JTextField();
        jLabelGruposCodigo = new javax.swing.JLabel();
        campoGruposCodigo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoGruposBuscar = new javax.swing.JTextField();
        campoGruposBuscarCategorias = new javax.swing.JComboBox<>();
        botonGruposExportar = new javax.swing.JButton();
        panelAsignaturas = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        scrollAsignaturas = new javax.swing.JScrollPane();
        tablaAsignaturas = new javax.swing.JTable();
        botonAsignaturasInsertar = new javax.swing.JButton();
        botonAsignaturasBorrar = new javax.swing.JButton();
        botonAsignaturasModificar = new javax.swing.JButton();
        botonAsignaturasSeleccionar = new javax.swing.JButton();
        Código = new javax.swing.JLabel();
        jLabelTuhorarioNombre = new javax.swing.JLabel();
        jLabelTuhorarioTutor = new javax.swing.JLabel();
        campoAsignaturasCodigo = new javax.swing.JTextField();
        campoAsignaturasProfesor = new javax.swing.JTextField();
        jLabelTuhorarioCodigo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        campoAsignaturasBuscar = new javax.swing.JTextField();
        campoAsignaturasCurso = new javax.swing.JTextField();
        campoAsignaturasNombre = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        campoAsignaturasGrupo = new javax.swing.JTextField();
        campoAsignaturasBuscarCategorias = new javax.swing.JComboBox<>();
        botonAsignaturasExportar = new javax.swing.JButton();
        panelProfesorado = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane2 = new javax.swing.JTextPane();
        panelProfesores = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        scrollProfesores = new javax.swing.JScrollPane();
        tablaProfesores = new javax.swing.JTable();
        botonProfesoresInsertar = new javax.swing.JButton();
        botonProfesoresBorrar = new javax.swing.JButton();
        botonProfesoresModificar = new javax.swing.JButton();
        botonProfesoresSeleccionar = new javax.swing.JButton();
        jLabelGruposCurso2 = new javax.swing.JLabel();
        jLabelGruposNombre3 = new javax.swing.JLabel();
        jLabelGruposTutor2 = new javax.swing.JLabel();
        campoProfesoresApellido1 = new javax.swing.JTextField();
        campoProfesoresDNI = new javax.swing.JTextField();
        campoProfesoresApellido2 = new javax.swing.JTextField();
        jLabelGruposCodigo3 = new javax.swing.JLabel();
        campoProfesoresCodigo = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        campoProfesoresBuscar = new javax.swing.JTextField();
        jLabelGruposNombre4 = new javax.swing.JLabel();
        campoProfesoresDepartamento = new javax.swing.JTextField();
        campoProfesoresNombre = new javax.swing.JTextField();
        jLabelGruposCodigo4 = new javax.swing.JLabel();
        campoProfesoresBuscarCategorias = new javax.swing.JComboBox<>();
        botonProfesoresExportar = new javax.swing.JButton();
        panelDepartamentos = new javax.swing.JPanel();
        jLabel18 = new javax.swing.JLabel();
        scrollDepartamentos = new javax.swing.JScrollPane();
        tablaDepartamentos = new javax.swing.JTable();
        botonDepartamentosInsertar = new javax.swing.JButton();
        botonDepartamentosBorrar = new javax.swing.JButton();
        botonDepartamentosModificar = new javax.swing.JButton();
        botonDepartamentosSeleccionar = new javax.swing.JButton();
        jLabelGruposCurso3 = new javax.swing.JLabel();
        jLabelGruposNombre5 = new javax.swing.JLabel();
        campoDepartamentosDirector = new javax.swing.JTextField();
        campoDepartamentosNombre = new javax.swing.JTextField();
        jLabelGruposCodigo5 = new javax.swing.JLabel();
        campoDepartamentosCodigo = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        campoDepartamentosBuscar = new javax.swing.JTextField();
        campoDepartamentosBuscarCategorias = new javax.swing.JComboBox<>();
        botonDepartamentosExportar = new javax.swing.JButton();
        panelTutorias = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        scrollTutorias = new javax.swing.JScrollPane();
        tablaTutorias = new javax.swing.JTable();
        botonTutoriasInsertar = new javax.swing.JButton();
        botonTutoriasBorrar = new javax.swing.JButton();
        botonTutoriasModificar = new javax.swing.JButton();
        jLabelGruposCurso4 = new javax.swing.JLabel();
        jLabelGruposNombre6 = new javax.swing.JLabel();
        jLabelGruposTutor3 = new javax.swing.JLabel();
        campoTutoriasCodigo_profesor = new javax.swing.JTextField();
        jLabelGruposCodigo6 = new javax.swing.JLabel();
        campoTutoriasCodigo = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        campoTutoriasBuscar = new javax.swing.JTextField();
        jLabelGruposNombre7 = new javax.swing.JLabel();
        campoTutoriasDia = new javax.swing.JComboBox<>();
        campoTutoriasFin = new javax.swing.JComboBox<>();
        campoTutoriasComienzo = new javax.swing.JComboBox<>();
        campoTutoriasBuscarCategorias = new javax.swing.JComboBox<>();
        campoTutoriasExportar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(204, 204, 204));

        jScrollPane4.setBorder(null);
        jScrollPane4.setPreferredSize(new java.awt.Dimension(762, 469));

        jPanel1.setPreferredSize(new java.awt.Dimension(600, 400));

        panelInicioSesion.setBackground(new java.awt.Color(255, 255, 255));
        panelInicioSesion.setForeground(new java.awt.Color(255, 255, 255));
        panelInicioSesion.setLayout(new java.awt.GridBagLayout());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black, java.awt.Color.black)));
        jPanel2.setLayout(new java.awt.GridBagLayout());

        usuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usuario.setText("Nombre de usuario");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(25, 25, 5, 5);
        jPanel2.add(usuario, gridBagConstraints);

        password.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        password.setText("Contraseña");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 5);
        jPanel2.add(password, gridBagConstraints);

        campoUsuario.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(204, 204, 204)));
        campoUsuario.setPreferredSize(new java.awt.Dimension(20, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 25);
        jPanel2.add(campoUsuario, gridBagConstraints);

        BotonIdentificarUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotonIdentificarUsuario.setText("Entrar");
        BotonIdentificarUsuario.setPreferredSize(new java.awt.Dimension(115, 25));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 5, 25, 35);
        jPanel2.add(BotonIdentificarUsuario, gridBagConstraints);

        tituloInicioSesion.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        tituloInicioSesion.setForeground(new java.awt.Color(0, 102, 0));
        tituloInicioSesion.setText("Iniciar sesión");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.FIRST_LINE_START;
        gridBagConstraints.insets = new java.awt.Insets(25, 25, 5, 0);
        jPanel2.add(tituloInicioSesion, gridBagConstraints);

        BotonRegistrarUsuario.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        BotonRegistrarUsuario.setText("Registrarse");
        BotonRegistrarUsuario.setPreferredSize(new java.awt.Dimension(115, 25));
        BotonRegistrarUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotonRegistrarUsuarioActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(15, 35, 25, 5);
        jPanel2.add(BotonRegistrarUsuario, gridBagConstraints);

        campoPassword.setForeground(new java.awt.Color(204, 204, 204));
        campoPassword.setPreferredSize(new java.awt.Dimension(111, 30));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.insets = new java.awt.Insets(5, 25, 5, 25);
        jPanel2.add(campoPassword, gridBagConstraints);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelInicioSesion.add(jPanel2, gridBagConstraints);

        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.jpg"))); // NOI18N
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        panelInicioSesion.add(jLabel17, gridBagConstraints);

        opcionesProfesorado.setOpaque(false);
        opcionesProfesorado.setPreferredSize(new java.awt.Dimension(140, 73));

        opcionTutorias.setBackground(new java.awt.Color(225, 225, 225));
        opcionTutorias.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        opcionTutorias.setForeground(java.awt.Color.gray);
        opcionTutorias.setText("TUTORÍAS");
        opcionTutorias.setBorderPainted(false);
        opcionTutorias.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcionTutorias.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        opcionTutorias.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionTutoriasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionTutoriasMouseExited(evt);
            }
        });
        opcionTutorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionTutoriasActionPerformed(evt);
            }
        });

        opcionProfesores.setBackground(new java.awt.Color(225, 225, 225));
        opcionProfesores.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        opcionProfesores.setForeground(java.awt.Color.gray);
        opcionProfesores.setText("PROFESORES");
        opcionProfesores.setBorderPainted(false);
        opcionProfesores.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcionProfesores.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        opcionProfesores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionProfesoresMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionProfesoresMouseExited(evt);
            }
        });
        opcionProfesores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionProfesoresActionPerformed(evt);
            }
        });

        opcionDepartamentos.setBackground(new java.awt.Color(224, 224, 224));
        opcionDepartamentos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        opcionDepartamentos.setForeground(java.awt.Color.gray);
        opcionDepartamentos.setText("DEPARTAMENTOS");
        opcionDepartamentos.setBorderPainted(false);
        opcionDepartamentos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcionDepartamentos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        opcionDepartamentos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionDepartamentosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionDepartamentosMouseExited(evt);
            }
        });
        opcionDepartamentos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionDepartamentosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout opcionesProfesoradoLayout = new javax.swing.GroupLayout(opcionesProfesorado);
        opcionesProfesorado.setLayout(opcionesProfesoradoLayout);
        opcionesProfesoradoLayout.setHorizontalGroup(
            opcionesProfesoradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesProfesoradoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(opcionesProfesoradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(opcionProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionTutorias, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(opcionDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );
        opcionesProfesoradoLayout.setVerticalGroup(
            opcionesProfesoradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesProfesoradoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(opcionProfesores))
            .addGroup(opcionesProfesoradoLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(opcionTutorias))
            .addGroup(opcionesProfesoradoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(opcionDepartamentos))
        );

        opcionesCentro.setBackground(new java.awt.Color(255, 255, 255));

        opcionCursos.setBackground(new java.awt.Color(225, 225, 225));
        opcionCursos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        opcionCursos.setForeground(java.awt.Color.gray);
        opcionCursos.setText("CURSOS");
        opcionCursos.setBorderPainted(false);
        opcionCursos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcionCursos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        opcionCursos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionCursosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionCursosMouseExited(evt);
            }
        });

        opcionHorarios.setBackground(new java.awt.Color(225, 225, 225));
        opcionHorarios.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        opcionHorarios.setForeground(java.awt.Color.gray);
        opcionHorarios.setText("HORARIOS");
        opcionHorarios.setBorderPainted(false);
        opcionHorarios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcionHorarios.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        opcionHorarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionHorariosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionHorariosMouseExited(evt);
            }
        });
        opcionHorarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionHorariosActionPerformed(evt);
            }
        });

        opcionAulas.setBackground(new java.awt.Color(224, 224, 224));
        opcionAulas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        opcionAulas.setForeground(java.awt.Color.gray);
        opcionAulas.setText("AULAS");
        opcionAulas.setBorderPainted(false);
        opcionAulas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcionAulas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        opcionAulas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionAulasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionAulasMouseExited(evt);
            }
        });

        javax.swing.GroupLayout opcionesCentroLayout = new javax.swing.GroupLayout(opcionesCentro);
        opcionesCentro.setLayout(opcionesCentroLayout);
        opcionesCentroLayout.setHorizontalGroup(
            opcionesCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(opcionAulas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(opcionesCentroLayout.createSequentialGroup()
                .addComponent(opcionHorarios)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(opcionCursos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        opcionesCentroLayout.setVerticalGroup(
            opcionesCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesCentroLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(opcionHorarios))
            .addGroup(opcionesCentroLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(opcionCursos))
            .addGroup(opcionesCentroLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(opcionAulas))
        );

        opcionesAlumnado.setOpaque(false);
        opcionesAlumnado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionesAlumnadoMouseExited(evt);
            }
        });

        opcionGrupos.setBackground(new java.awt.Color(224, 224, 224));
        opcionGrupos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        opcionGrupos.setForeground(java.awt.Color.gray);
        opcionGrupos.setText("GRUPOS");
        opcionGrupos.setBorderPainted(false);
        opcionGrupos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcionGrupos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        opcionGrupos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionGruposMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionGruposMouseExited(evt);
            }
        });
        opcionGrupos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionGruposActionPerformed(evt);
            }
        });

        opcionAlumnos.setBackground(new java.awt.Color(225, 225, 225));
        opcionAlumnos.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        opcionAlumnos.setForeground(java.awt.Color.gray);
        opcionAlumnos.setText("ALUMNOS");
        opcionAlumnos.setBorderPainted(false);
        opcionAlumnos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcionAlumnos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        opcionAlumnos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionAlumnosMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionAlumnosMouseExited(evt);
            }
        });
        opcionAlumnos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionAlumnosActionPerformed(evt);
            }
        });

        opcionAsignaturas.setBackground(new java.awt.Color(225, 225, 225));
        opcionAsignaturas.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        opcionAsignaturas.setForeground(java.awt.Color.gray);
        opcionAsignaturas.setText("ASIGNATURAS");
        opcionAsignaturas.setBorderPainted(false);
        opcionAsignaturas.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        opcionAsignaturas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        opcionAsignaturas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                opcionAsignaturasMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                opcionAsignaturasMouseExited(evt);
            }
        });
        opcionAsignaturas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opcionAsignaturasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout opcionesAlumnadoLayout = new javax.swing.GroupLayout(opcionesAlumnado);
        opcionesAlumnado.setLayout(opcionesAlumnadoLayout);
        opcionesAlumnadoLayout.setHorizontalGroup(
            opcionesAlumnadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesAlumnadoLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addGroup(opcionesAlumnadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(opcionAlumnos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opcionGrupos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(opcionAsignaturas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(51, Short.MAX_VALUE))
        );
        opcionesAlumnadoLayout.setVerticalGroup(
            opcionesAlumnadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(opcionesAlumnadoLayout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(opcionAlumnos)
                .addGap(17, 17, 17)
                .addComponent(opcionAsignaturas))
            .addGroup(opcionesAlumnadoLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(opcionGrupos))
        );

        panelInicio.setBackground(new java.awt.Color(255, 255, 255));

        barraInicio.setBackground(new java.awt.Color(255, 255, 255));

        botonInicio.setBackground(new java.awt.Color(255, 255, 255));
        botonInicio.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonInicio.setForeground(java.awt.Color.gray);
        botonInicio.setText("INICIO");
        botonInicio.setBorderPainted(false);
        botonInicio.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonInicio.setFocusPainted(false);
        botonInicio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonInicioMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonInicioMouseExited(evt);
            }
        });

        botonProfesorado.setBackground(new java.awt.Color(255, 255, 255));
        botonProfesorado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonProfesorado.setForeground(java.awt.Color.gray);
        botonProfesorado.setText("PROFESORADO");
        botonProfesorado.setBorderPainted(false);
        botonProfesorado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonProfesorado.setFocusPainted(false);
        botonProfesorado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonProfesoradoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonProfesoradoMouseExited(evt);
            }
        });

        botonSalir.setBackground(new java.awt.Color(255, 255, 255));
        botonSalir.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonSalir.setForeground(java.awt.Color.gray);
        botonSalir.setText("SALIR");
        botonSalir.setBorderPainted(false);
        botonSalir.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonSalir.setFocusPainted(false);
        botonSalir.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonSalirMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonSalirMouseExited(evt);
            }
        });
        botonSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSalirActionPerformed(evt);
            }
        });

        botonAlumnado.setBackground(new java.awt.Color(255, 255, 255));
        botonAlumnado.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonAlumnado.setForeground(java.awt.Color.gray);
        botonAlumnado.setText("ALUMNADO");
        botonAlumnado.setBorderPainted(false);
        botonAlumnado.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonAlumnado.setFocusPainted(false);
        botonAlumnado.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonAlumnadoMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonAlumnadoMouseExited(evt);
            }
        });

        botonCentro.setBackground(new java.awt.Color(255, 255, 255));
        botonCentro.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        botonCentro.setForeground(java.awt.Color.gray);
        botonCentro.setText("NUESTRO CENTRO");
        botonCentro.setBorderPainted(false);
        botonCentro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        botonCentro.setFocusPainted(false);
        botonCentro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                botonCentroMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                botonCentroMouseExited(evt);
            }
        });
        botonCentro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCentroActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout barraInicioLayout = new javax.swing.GroupLayout(barraInicio);
        barraInicio.setLayout(barraInicioLayout);
        barraInicioLayout.setHorizontalGroup(
            barraInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraInicioLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botonInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonCentro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonAlumnado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonProfesorado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        barraInicioLayout.setVerticalGroup(
            barraInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(barraInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(botonInicio)
                .addComponent(botonCentro)
                .addComponent(botonAlumnado)
                .addComponent(botonProfesorado)
                .addComponent(botonSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(0, 153, 0));
        jLabel1.setText("I.E.S. El Rincón");

        javax.swing.GroupLayout panelInicioLayout = new javax.swing.GroupLayout(panelInicio);
        panelInicio.setLayout(panelInicioLayout);
        panelInicioLayout.setHorizontalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelInicioLayout.createSequentialGroup()
                    .addGap(19, 19, 19)
                    .addComponent(barraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(23, Short.MAX_VALUE)))
        );
        panelInicioLayout.setVerticalGroup(
            panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelInicioLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(panelInicioLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelInicioLayout.createSequentialGroup()
                    .addGap(62, 62, 62)
                    .addComponent(barraInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(319, Short.MAX_VALUE)))
        );

        capas.setPreferredSize(new java.awt.Dimension(500, 325));

        panelHorarios.setBackground(new java.awt.Color(255, 255, 255));
        panelHorarios.setMinimumSize(new java.awt.Dimension(484, 153));
        panelHorarios.setPreferredSize(new java.awt.Dimension(0, 0));
        panelHorarios.setLayout(new java.awt.GridBagLayout());

        jLabel24.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 153, 0));
        jLabel24.setText("HORARIOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.ipadx = 35;
        gridBagConstraints.insets = new java.awt.Insets(2, 11, 0, 0);
        panelHorarios.add(jLabel24, gridBagConstraints);

        scrollHorarios.setBorder(null);
        scrollHorarios.setPreferredSize(new java.awt.Dimension(402, 402));

        tablaHorarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaHorarios.getTableHeader().setReorderingAllowed(false);
        scrollHorarios.setViewportView(tablaHorarios);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 0, 5);
        panelHorarios.add(scrollHorarios, gridBagConstraints);

        botonHorariosInsertar.setText("Insertar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelHorarios.add(botonHorariosInsertar, gridBagConstraints);

        botonHorariosBorrar.setText("Borrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelHorarios.add(botonHorariosBorrar, gridBagConstraints);

        botonHorariosModificar.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelHorarios.add(botonHorariosModificar, gridBagConstraints);

        botonHorariosSeleccionar.setText("Ver asignatura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelHorarios.add(botonHorariosSeleccionar, gridBagConstraints);

        jLabelGruposCurso5.setText("Hora de finalización");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelHorarios.add(jLabelGruposCurso5, gridBagConstraints);

        jLabelGruposNombre8.setText("Hora de comienzo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelHorarios.add(jLabelGruposNombre8, gridBagConstraints);

        jLabelGruposTutor4.setText("Código de la asignatura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelHorarios.add(jLabelGruposTutor4, gridBagConstraints);

        campoHorariosCodigo_asignatura.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelHorarios.add(campoHorariosCodigo_asignatura, gridBagConstraints);

        jLabelGruposCodigo7.setText("Código");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelHorarios.add(jLabelGruposCodigo7, gridBagConstraints);

        campoHorariosCodigo.setColumns(10);
        campoHorariosCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoHorariosCodigoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelHorarios.add(campoHorariosCodigo, gridBagConstraints);

        jLabel25.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        panelHorarios.add(jLabel25, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(1, 5, 0, 5);
        panelHorarios.add(campoHorariosBuscar, gridBagConstraints);

        jLabelGruposNombre9.setText("Día");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelHorarios.add(jLabelGruposNombre9, gridBagConstraints);

        campoHorariosDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelHorarios.add(campoHorariosDia, gridBagConstraints);

        campoHorariosFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelHorarios.add(campoHorariosFin, gridBagConstraints);

        campoHorariosComienzo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelHorarios.add(campoHorariosComienzo, gridBagConstraints);

        campoHorariosBuscarCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los campos", "Código del horario", "Día", "Comienzo", "Fin", "Código de la asignatura", "Nombre de la asignatura" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelHorarios.add(campoHorariosBuscarCategorias, gridBagConstraints);

        botonHorariosExportar.setText("Imprimir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelHorarios.add(botonHorariosExportar, gridBagConstraints);

        panelBienvenida.setBackground(new java.awt.Color(255, 255, 255));
        panelBienvenida.setPreferredSize(new java.awt.Dimension(456, 22));

        bienvenida.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        bienvenida.setForeground(new java.awt.Color(0, 153, 0));
        bienvenida.setText("Bienvenido al gestor de la base de datos del I.E.S El Rincón");

        imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/logo.jpg"))); // NOI18N
        imagen.setToolTipText("");
        imagen.setAlignmentY(0.0F);
        imagen.setHorizontalTextPosition(javax.swing.SwingConstants.LEADING);
        imagen.setInheritsPopupMenu(false);
        imagen.setVerticalTextPosition(javax.swing.SwingConstants.TOP);

        javax.swing.GroupLayout panelBienvenidaLayout = new javax.swing.GroupLayout(panelBienvenida);
        panelBienvenida.setLayout(panelBienvenidaLayout);
        panelBienvenidaLayout.setHorizontalGroup(
            panelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(bienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
            .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelBienvenidaLayout.setVerticalGroup(
            panelBienvenidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBienvenidaLayout.createSequentialGroup()
                .addComponent(bienvenida, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagen, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
        );

        panelCentro.setBackground(new java.awt.Color(255, 255, 255));

        jScrollPane3.setBorder(null);
        jScrollPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jTextPane3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextPane3.setText("NUESTRO CENTRO\n\nEn esta sección podrás consultar el listado de cursos, horarios por grupos, aulas y asignaciones de aulas. Si hacemos doble click en un aula podrá ver los datos de los grupos que hacen uso de dicha aula. Si hacemos doble click en un horario podrá consultar los datos de la asignatura que le corresponde. Si hacemos doble click en una asignación podrá consultar los datos del grupo asignado.\n\nNOTA ACLARATORIA: \n\nPara la utilización del programa debemos tener en cuenta que:\n\n1. Para insertar asignaciones de aulas deben existir previamente un aula y un grupo al que hacemos referencia. Para insertar un nuevo grupo vaya a la sección ALUMNADO y al apartado de GRUPOS.\n\n2. Para insertar horarios debe existir una asignatura previamente a la que hacemos referencia. Para insertar una nueva asignatura vaya a la sección ALUMNADO y al apartado ASIGNATURAS.\n\n3. En caso de duda puede consultar las notas aclaratorias de las correspondientes secciones.");
        jTextPane3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane3.setViewportView(jTextPane3);

        javax.swing.GroupLayout panelCentroLayout = new javax.swing.GroupLayout(panelCentro);
        panelCentro.setLayout(panelCentroLayout);
        panelCentroLayout.setHorizontalGroup(
            panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelCentroLayout.setVerticalGroup(
            panelCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
        );

        panelAulas.setBackground(new java.awt.Color(255, 255, 255));
        panelAulas.setLayout(new java.awt.GridBagLayout());

        jLabel8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 153, 0));
        jLabel8.setText("AULAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        panelAulas.add(jLabel8, gridBagConstraints);

        scrollAulas.setPreferredSize(new java.awt.Dimension(402, 402));

        tablaAulas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollAulas.setViewportView(tablaAulas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weighty = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 0, 5);
        panelAulas.add(scrollAulas, gridBagConstraints);

        botonAulasInsertar.setText("Insertar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(botonAulasInsertar, gridBagConstraints);

        botonAulasBorrar.setText("Borrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(botonAulasBorrar, gridBagConstraints);

        botonAulasModificar.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(botonAulasModificar, gridBagConstraints);

        botonAulasSeleccionar.setText("Ver uso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(botonAulasSeleccionar, gridBagConstraints);

        jLabelAulasNombre.setText("Código del grupo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(jLabelAulasNombre, gridBagConstraints);

        jLabelAulasTutor.setText("Código del aula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(jLabelAulasTutor, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(campoAsignacionCodigo_aula, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 4.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(campoAsignacionCodigo_grupo, gridBagConstraints);

        jLabelAulasCodigo.setText("Nombre del aula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(jLabelAulasCodigo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(campoAulasNombre, gridBagConstraints);

        jLabel9.setText("Buscar aula");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        panelAulas.add(jLabel9, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(campoAulasBuscar, gridBagConstraints);

        botonInsertarAsignacion.setText("Insertar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(botonInsertarAsignacion, gridBagConstraints);

        botonSeleccionarAsignacion.setText("Ver grupo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(botonSeleccionarAsignacion, gridBagConstraints);

        botonModificarAsignacion.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(botonModificarAsignacion, gridBagConstraints);

        botonBorrarAsignacion.setText("Borrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 17;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(botonBorrarAsignacion, gridBagConstraints);

        scrollAsignacion.setPreferredSize(new java.awt.Dimension(402, 402));

        tablaAsignacion.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollAsignacion.setViewportView(tablaAsignacion);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.gridheight = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.weighty = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 0, 5);
        panelAulas.add(scrollAsignacion, gridBagConstraints);

        jLabel10.setText("Buscar asignación");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        panelAulas.add(jLabel10, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 5;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.weightx = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(campoAsignacionBuscar, gridBagConstraints);

        campoAsignacionesBuscarCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los campos", "Código de asignación", "Código del aula", "Nombre del aula", "Código del grupo", "Nombre del grupo" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelAulas.add(campoAsignacionesBuscarCategorias, gridBagConstraints);

        campoAulasBuscarCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los campos", "Código del aula", "Nombre del aula" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelAulas.add(campoAulasBuscarCategorias, gridBagConstraints);

        botonExportarAsignacion.setText("Imprimir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(botonExportarAsignacion, gridBagConstraints);

        botonExportarAulas.setText("Imprimir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 3;
        gridBagConstraints.gridy = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAulas.add(botonExportarAulas, gridBagConstraints);

        panelCursos.setBackground(new java.awt.Color(255, 255, 255));
        panelCursos.setLayout(new java.awt.GridBagLayout());

        jLabel6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(0, 153, 0));
        jLabel6.setText("CURSOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelCursos.add(jLabel6, gridBagConstraints);

        scrollCursos.setPreferredSize(new java.awt.Dimension(402, 402));

        tablaCursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollCursos.setViewportView(tablaCursos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 434;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 0, 5);
        panelCursos.add(scrollCursos, gridBagConstraints);

        botonCursosInsertar.setText("Insertar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelCursos.add(botonCursosInsertar, gridBagConstraints);

        botonCursosBorrar.setText("Borrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelCursos.add(botonCursosBorrar, gridBagConstraints);

        botonCursosModificar.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelCursos.add(botonCursosModificar, gridBagConstraints);

        jLabelCursosNombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelCursos.add(jLabelCursosNombre, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelCursos.add(campoCursosNombre, gridBagConstraints);

        jLabelCursosCodigo.setText("Código");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelCursos.add(jLabelCursosCodigo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelCursos.add(campoCursosCodigo, gridBagConstraints);

        jLabel7.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        panelCursos.add(jLabel7, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelCursos.add(campoCursosBuscar, gridBagConstraints);

        campoCursosBuscarCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los campos", "Código del curso", "Nombre del curso" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelCursos.add(campoCursosBuscarCategorias, gridBagConstraints);

        botonCursosExportar.setText("Imprimir");
        botonCursosExportar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonCursosExportarActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelCursos.add(botonCursosExportar, gridBagConstraints);

        jScrollPane1.setBorder(null);

        jTextPane1.setBorder(null);
        jTextPane1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextPane1.setText("ALUMNADO\n\nEn esta sección podrás consultar los listados de los grupos del centro y los alumnos que forman parte de ellos, así como consultar el listado de asignaturas por grupo y curso. Si hacemos doble click en un grupo podrá ver que alumnos pertenecen a dicho grupo. Si hacemos doble click en una asignatura podrá consultar el horario de la misma.\n\nNOTA ACLARATORIA: \n\nPara la utilización del programa debemos tener en cuenta que:\n\n1. Para insertar nuevos alumnos deben existir previamente los grupos a los que pertenecen. Para insertar un nuevo grupo vaya a la sección ALUMNADO y al apartado de GRUPOS.\n\n2. Para insertar grupos, en caso de insertar un tutor, este debe de estar registrado como profesor. Para insertar un nuevo profesor vaya a la sección PROFESORADO y al apartado PROFESORES. En cualquier caso insertar un tutor no es necesario por lo que su valor por defecto es nulo.\n\n3. Para insertar una nueva asignatura deben estar registrado el curso, el grupo y el profesor al que pertenece. Para insertar un nuevo curso vaya a la sección NUESTRO CENTRO y al apartado de CURSOS.  Para insertar un nuevo grupo vaya a la sección ALUMNADO y al apartado de GRUPOS. Para insertar un nuevo profesor vata a la sección PROFESORADO y al apartado PROFESORES.\n\n4. En caso de duda puede consultar las notas aclaratorias de las correspondientes secciones.");
        jTextPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane1.setViewportView(jTextPane1);

        javax.swing.GroupLayout panelAlumnadoLayout = new javax.swing.GroupLayout(panelAlumnado);
        panelAlumnado.setLayout(panelAlumnadoLayout);
        panelAlumnadoLayout.setHorizontalGroup(
            panelAlumnadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelAlumnadoLayout.setVerticalGroup(
            panelAlumnadoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
        );

        panelAlumnos.setBackground(new java.awt.Color(255, 255, 255));
        panelAlumnos.setLayout(new java.awt.GridBagLayout());

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 153, 0));
        jLabel4.setText("ALUMNOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelAlumnos.add(jLabel4, gridBagConstraints);

        scrollAlumnos.setPreferredSize(new java.awt.Dimension(402, 402));

        tablaAlumnos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaAlumnos.getTableHeader().setReorderingAllowed(false);
        scrollAlumnos.setViewportView(tablaAlumnos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 434;
        gridBagConstraints.ipady = 28;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 0, 5);
        panelAlumnos.add(scrollAlumnos, gridBagConstraints);

        botonAlumnosInsertar.setText("Insertar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(botonAlumnosInsertar, gridBagConstraints);

        botonAlumnosBorrar.setText("Borrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(botonAlumnosBorrar, gridBagConstraints);

        botonAlumnosModificar.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(botonAlumnosModificar, gridBagConstraints);

        jLabelGruposCurso1.setText("Primer apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(jLabelGruposCurso1, gridBagConstraints);

        jLabelGruposNombre1.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(jLabelGruposNombre1, gridBagConstraints);

        jLabelGruposTutor1.setText("Segundo apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(jLabelGruposTutor1, gridBagConstraints);

        campoAlumnosApellido1.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(campoAlumnosApellido1, gridBagConstraints);

        campoAlumnosDNI.setColumns(10);
        campoAlumnosDNI.setAutoscrolls(false);
        campoAlumnosDNI.setMaximumSize(new java.awt.Dimension(6, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(campoAlumnosDNI, gridBagConstraints);

        campoAlumnosApellido2.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(campoAlumnosApellido2, gridBagConstraints);

        jLabelGruposCodigo1.setText("Código");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(jLabelGruposCodigo1, gridBagConstraints);

        campoAlumnosCodigo.setColumns(10);
        campoAlumnosCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoAlumnosCodigoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(campoAlumnosCodigo, gridBagConstraints);

        jLabel5.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        panelAlumnos.add(jLabel5, gridBagConstraints);

        campoAlumnosBuscar.setColumns(100);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelAlumnos.add(campoAlumnosBuscar, gridBagConstraints);

        jLabelGruposNombre2.setText("DNI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(jLabelGruposNombre2, gridBagConstraints);

        campoAlumnosGrupo.setColumns(10);
        campoAlumnosGrupo.setAutoscrolls(false);
        campoAlumnosGrupo.setMaximumSize(new java.awt.Dimension(6, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
        panelAlumnos.add(campoAlumnosGrupo, gridBagConstraints);

        campoAlumnosNombre.setColumns(10);
        campoAlumnosNombre.setAutoscrolls(false);
        campoAlumnosNombre.setMaximumSize(new java.awt.Dimension(6, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 10.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(campoAlumnosNombre, gridBagConstraints);

        jLabelGruposCodigo2.setText("Código de grupo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.insets = new java.awt.Insets(3, 5, 0, 5);
        panelAlumnos.add(jLabelGruposCodigo2, gridBagConstraints);

        campoAlumnosBuscarCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los campos", "Código del alumno", "DNI del alumno", "Nombre del alumno", "Primer apellido del alumno", "Segundo apellido del alumno", "Código de grupo", "Nombre de grupo" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelAlumnos.add(campoAlumnosBuscarCategorias, gridBagConstraints);

        botonAlumnosExportar.setText("Imprimir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 11;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAlumnos.add(botonAlumnosExportar, gridBagConstraints);

        panelGrupos.setBackground(new java.awt.Color(255, 255, 255));
        panelGrupos.setLayout(new java.awt.GridBagLayout());

        jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 153, 0));
        jLabel2.setText("GRUPOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelGrupos.add(jLabel2, gridBagConstraints);

        scrollGrupos.setPreferredSize(new java.awt.Dimension(402, 402));

        tablaGrupos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaGrupos.getTableHeader().setReorderingAllowed(false);
        scrollGrupos.setViewportView(tablaGrupos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 451;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 0, 5);
        panelGrupos.add(scrollGrupos, gridBagConstraints);

        botonGruposInsertar.setText("Insertar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelGrupos.add(botonGruposInsertar, gridBagConstraints);

        botonGruposBorrar.setText("Borrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelGrupos.add(botonGruposBorrar, gridBagConstraints);

        botonGruposModificar.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelGrupos.add(botonGruposModificar, gridBagConstraints);

        botonGruposSeleccionar.setText("Ver alumnos");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelGrupos.add(botonGruposSeleccionar, gridBagConstraints);

        jLabelGruposCurso.setText("Código del curso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelGrupos.add(jLabelGruposCurso, gridBagConstraints);

        jLabelGruposNombre.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelGrupos.add(jLabelGruposNombre, gridBagConstraints);

        jLabelGruposTutor.setText("Código del tutor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelGrupos.add(jLabelGruposTutor, gridBagConstraints);

        campoGruposCurso.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelGrupos.add(campoGruposCurso, gridBagConstraints);

        campoGruposNombre.setColumns(10);
        campoGruposNombre.setAutoscrolls(false);
        campoGruposNombre.setMaximumSize(new java.awt.Dimension(6, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelGrupos.add(campoGruposNombre, gridBagConstraints);

        campoGruposTutor.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 0.5;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelGrupos.add(campoGruposTutor, gridBagConstraints);

        jLabelGruposCodigo.setText("Código");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelGrupos.add(jLabelGruposCodigo, gridBagConstraints);

        campoGruposCodigo.setColumns(10);
        campoGruposCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoGruposCodigoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelGrupos.add(campoGruposCodigo, gridBagConstraints);

        jLabel3.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        panelGrupos.add(jLabel3, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelGrupos.add(campoGruposBuscar, gridBagConstraints);

        campoGruposBuscarCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los campos", "Código del grupo", "Nombre del grupo", "Codigo del curso", "Nombre del curso", "Codigo del tutor", "Nombre del tutor" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelGrupos.add(campoGruposBuscarCategorias, gridBagConstraints);

        botonGruposExportar.setText("Imprimir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 7;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelGrupos.add(botonGruposExportar, gridBagConstraints);

        panelAsignaturas.setBackground(new java.awt.Color(255, 255, 255));
        java.awt.GridBagLayout panelAsignaturasLayout = new java.awt.GridBagLayout();
        panelAsignaturasLayout.columnWidths = new int[] {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        panelAsignaturasLayout.rowHeights = new int[] {0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0, 5, 0};
        panelAsignaturas.setLayout(panelAsignaturasLayout);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(0, 153, 0));
        jLabel12.setText("ASIGNATURAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelAsignaturas.add(jLabel12, gridBagConstraints);

        scrollAsignaturas.setPreferredSize(new java.awt.Dimension(402, 402));

        tablaAsignaturas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        scrollAsignaturas.setViewportView(tablaAsignaturas);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 1;
        gridBagConstraints.ipady = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(scrollAsignaturas, gridBagConstraints);

        botonAsignaturasInsertar.setText("Insertar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(botonAsignaturasInsertar, gridBagConstraints);

        botonAsignaturasBorrar.setText("Borrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(botonAsignaturasBorrar, gridBagConstraints);

        botonAsignaturasModificar.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(botonAsignaturasModificar, gridBagConstraints);

        botonAsignaturasSeleccionar.setText("Ver horarios");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(botonAsignaturasSeleccionar, gridBagConstraints);

        Código.setText("Curso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(Código, gridBagConstraints);

        jLabelTuhorarioNombre.setText("Código del profesor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(jLabelTuhorarioNombre, gridBagConstraints);

        jLabelTuhorarioTutor.setText("Nombre de la asignatura");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(jLabelTuhorarioTutor, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(campoAsignaturasCodigo, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 10;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(campoAsignaturasProfesor, gridBagConstraints);

        jLabelTuhorarioCodigo.setText("Código del curso");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(jLabelTuhorarioCodigo, gridBagConstraints);

        jLabel13.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        panelAsignaturas.add(jLabel13, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 8;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelAsignaturas.add(campoAsignaturasBuscar, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(2, 5, 2, 5);
        panelAsignaturas.add(campoAsignaturasCurso, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(campoAsignaturasNombre, gridBagConstraints);

        jLabel14.setText("Código del grupo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(jLabel14, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 12;
        gridBagConstraints.gridwidth = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(campoAsignaturasGrupo, gridBagConstraints);

        campoAsignaturasBuscarCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los campos", "Código de la asignatura", "Nombre de la asignatura", "Código del profesor", "Nombre del profesor", "Primer apellido del profesor", "Segundo apellido del profesor", "DNI del profesor", "Código del grupo", "Nombre del grupo", "Código del curso", "Nombre del curso" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelAsignaturas.add(campoAsignaturasBuscarCategorias, gridBagConstraints);

        botonAsignaturasExportar.setText("Imprimir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelAsignaturas.add(botonAsignaturasExportar, gridBagConstraints);

        panelProfesorado.setBackground(new java.awt.Color(255, 255, 255));
        panelProfesorado.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jScrollPane2.setBorder(null);

        jTextPane2.setBorder(null);
        jTextPane2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jTextPane2.setText("PROFESORADO\n\nEn esta sección podrás consultar los listados de los departamentos y sus profesores adscritos, así como el horario de tutorías de los profesores. Si hacemos doble click en un departamento podrá consultar los profesores que forman parte de el. Si hacemos doble click en un profesor podrá ver que horario de tutorías posee.\n\nNOTA ACLARATORIA: \n\nPara la utilización del programa debemos tener en cuenta que:\n\n1. Para insertar nuevos profesores deben existir previamente los departamentos de los que forman parte. Para insertar un nuevo departamento vaya a la sección PROFESORADO y al apartado de DEPARTAMENTOS.\n\n2. Para insertar departamentos, en caso de insertar un director, este debe de estar registrado como profesor. Para insertar un nuevo profesor vaya a la sección PROFESORADO y al apartado PROFESORES. En cualquier caso insertar un director no es necesario por lo que su valor por defecto es nulo.\n\n3. Para insertar un nuevo horario de tutorías debe estar registrado el profesor al que corresponde. Para insertar un nuevo profesor vaya a la sección PROFESORADO y al apartado PROFESORES.\n\n4. En caso de duda puede consultar las notas aclaratorias de las correspondientes secciones.");
        jTextPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jScrollPane2.setViewportView(jTextPane2);

        javax.swing.GroupLayout panelProfesoradoLayout = new javax.swing.GroupLayout(panelProfesorado);
        panelProfesorado.setLayout(panelProfesoradoLayout);
        panelProfesoradoLayout.setHorizontalGroup(
            panelProfesoradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        panelProfesoradoLayout.setVerticalGroup(
            panelProfesoradoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
        );

        panelProfesores.setBackground(new java.awt.Color(255, 255, 255));
        panelProfesores.setLayout(new java.awt.GridBagLayout());

        jLabel20.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 153, 0));
        jLabel20.setText("PROFESORES");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        panelProfesores.add(jLabel20, gridBagConstraints);

        scrollProfesores.setPreferredSize(new java.awt.Dimension(402, 402));

        tablaProfesores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaProfesores.getTableHeader().setReorderingAllowed(false);
        scrollProfesores.setViewportView(tablaProfesores);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 458;
        gridBagConstraints.ipady = 12;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 0, 5);
        panelProfesores.add(scrollProfesores, gridBagConstraints);

        botonProfesoresInsertar.setText("Insertar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(botonProfesoresInsertar, gridBagConstraints);

        botonProfesoresBorrar.setText("Borrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(botonProfesoresBorrar, gridBagConstraints);

        botonProfesoresModificar.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(botonProfesoresModificar, gridBagConstraints);

        botonProfesoresSeleccionar.setText("Ver tutorías");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(botonProfesoresSeleccionar, gridBagConstraints);

        jLabelGruposCurso2.setText("Primer apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(jLabelGruposCurso2, gridBagConstraints);

        jLabelGruposNombre3.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(jLabelGruposNombre3, gridBagConstraints);

        jLabelGruposTutor2.setText("Segundo apellido");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(jLabelGruposTutor2, gridBagConstraints);

        campoProfesoresApellido1.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(campoProfesoresApellido1, gridBagConstraints);

        campoProfesoresDNI.setColumns(10);
        campoProfesoresDNI.setAutoscrolls(false);
        campoProfesoresDNI.setMaximumSize(new java.awt.Dimension(6, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(campoProfesoresDNI, gridBagConstraints);

        campoProfesoresApellido2.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(campoProfesoresApellido2, gridBagConstraints);

        jLabelGruposCodigo3.setText("Código");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(jLabelGruposCodigo3, gridBagConstraints);

        campoProfesoresCodigo.setColumns(10);
        campoProfesoresCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoProfesoresCodigoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(campoProfesoresCodigo, gridBagConstraints);

        jLabel21.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        panelProfesores.add(jLabel21, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 10;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelProfesores.add(campoProfesoresBuscar, gridBagConstraints);

        jLabelGruposNombre4.setText("DNI");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(jLabelGruposNombre4, gridBagConstraints);

        campoProfesoresDepartamento.setColumns(10);
        campoProfesoresDepartamento.setAutoscrolls(false);
        campoProfesoresDepartamento.setMaximumSize(new java.awt.Dimension(6, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelProfesores.add(campoProfesoresDepartamento, gridBagConstraints);

        campoProfesoresNombre.setColumns(10);
        campoProfesoresNombre.setAutoscrolls(false);
        campoProfesoresNombre.setMaximumSize(new java.awt.Dimension(6, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 13;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(campoProfesoresNombre, gridBagConstraints);

        jLabelGruposCodigo4.setText("Código de departamento");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelProfesores.add(jLabelGruposCodigo4, gridBagConstraints);

        campoProfesoresBuscarCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los campos", "Código del profesor", "DNI del profesor", "Nombre del profesor", "Primer apellido del profesor", "Segundo apellido del profesor", "Código del departamento", "Nombre del departamento" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelProfesores.add(campoProfesoresBuscarCategorias, gridBagConstraints);

        botonProfesoresExportar.setText("Imprimir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 14;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelProfesores.add(botonProfesoresExportar, gridBagConstraints);

        panelDepartamentos.setBackground(new java.awt.Color(255, 255, 255));
        panelDepartamentos.setLayout(new java.awt.GridBagLayout());

        jLabel18.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 153, 0));
        jLabel18.setText("DEPARTAMENTOS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.insets = new java.awt.Insets(1, 10, 0, 0);
        panelDepartamentos.add(jLabel18, gridBagConstraints);

        scrollDepartamentos.setPreferredSize(new java.awt.Dimension(402, 402));

        tablaDepartamentos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaDepartamentos.getTableHeader().setReorderingAllowed(false);
        scrollDepartamentos.setViewportView(tablaDepartamentos);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 521;
        gridBagConstraints.ipady = 97;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 0, 5);
        panelDepartamentos.add(scrollDepartamentos, gridBagConstraints);

        botonDepartamentosInsertar.setText("Insertar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelDepartamentos.add(botonDepartamentosInsertar, gridBagConstraints);

        botonDepartamentosBorrar.setText("Borrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelDepartamentos.add(botonDepartamentosBorrar, gridBagConstraints);

        botonDepartamentosModificar.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelDepartamentos.add(botonDepartamentosModificar, gridBagConstraints);

        botonDepartamentosSeleccionar.setText("Ver profesores");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelDepartamentos.add(botonDepartamentosSeleccionar, gridBagConstraints);

        jLabelGruposCurso3.setText("Código del director");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelDepartamentos.add(jLabelGruposCurso3, gridBagConstraints);

        jLabelGruposNombre5.setText("Nombre");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelDepartamentos.add(jLabelGruposNombre5, gridBagConstraints);

        campoDepartamentosDirector.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelDepartamentos.add(campoDepartamentosDirector, gridBagConstraints);

        campoDepartamentosNombre.setColumns(10);
        campoDepartamentosNombre.setAutoscrolls(false);
        campoDepartamentosNombre.setMaximumSize(new java.awt.Dimension(6, 20));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelDepartamentos.add(campoDepartamentosNombre, gridBagConstraints);

        jLabelGruposCodigo5.setText("Código");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelDepartamentos.add(jLabelGruposCodigo5, gridBagConstraints);

        campoDepartamentosCodigo.setColumns(10);
        campoDepartamentosCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoDepartamentosCodigoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 14;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelDepartamentos.add(campoDepartamentosCodigo, gridBagConstraints);

        jLabel19.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        panelDepartamentos.add(jLabel19, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 4;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 11;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelDepartamentos.add(campoDepartamentosBuscar, gridBagConstraints);

        campoDepartamentosBuscarCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los campos", "Código del departamento", "Nombre del departamento", "Código del director", "Nombre del director", "Primer apellido del director", "Segundo apellido del director", "DNI del director" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelDepartamentos.add(campoDepartamentosBuscarCategorias, gridBagConstraints);

        botonDepartamentosExportar.setText("Imprimir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 15;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelDepartamentos.add(botonDepartamentosExportar, gridBagConstraints);

        panelTutorias.setBackground(new java.awt.Color(255, 255, 255));
        panelTutorias.setLayout(new java.awt.GridBagLayout());

        jLabel22.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 153, 0));
        jLabel22.setText("TUTORÍAS");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridheight = 2;
        gridBagConstraints.ipadx = 40;
        gridBagConstraints.insets = new java.awt.Insets(1, 10, 0, 0);
        panelTutorias.add(jLabel22, gridBagConstraints);

        scrollTutorias.setPreferredSize(new java.awt.Dimension(402, 402));

        tablaTutorias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tablaTutorias.getTableHeader().setReorderingAllowed(false);
        scrollTutorias.setViewportView(tablaTutorias);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.gridwidth = 18;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.ipadx = 521;
        gridBagConstraints.ipady = 45;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTHWEST;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 2.0;
        gridBagConstraints.insets = new java.awt.Insets(6, 5, 0, 5);
        panelTutorias.add(scrollTutorias, gridBagConstraints);

        botonTutoriasInsertar.setText("Insertar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelTutorias.add(botonTutoriasInsertar, gridBagConstraints);

        botonTutoriasBorrar.setText("Borrar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelTutorias.add(botonTutoriasBorrar, gridBagConstraints);

        botonTutoriasModificar.setText("Modificar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelTutorias.add(botonTutoriasModificar, gridBagConstraints);

        jLabelGruposCurso4.setText("Hora de finalización");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelTutorias.add(jLabelGruposCurso4, gridBagConstraints);

        jLabelGruposNombre6.setText("Hora de comienzo");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelTutorias.add(jLabelGruposNombre6, gridBagConstraints);

        jLabelGruposTutor3.setText("Código del profesor");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelTutorias.add(jLabelGruposTutor3, gridBagConstraints);

        campoTutoriasCodigo_profesor.setColumns(10);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 9;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelTutorias.add(campoTutoriasCodigo_profesor, gridBagConstraints);

        jLabelGruposCodigo6.setText("Código");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelTutorias.add(jLabelGruposCodigo6, gridBagConstraints);

        campoTutoriasCodigo.setColumns(10);
        campoTutoriasCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                campoTutoriasCodigoActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelTutorias.add(campoTutoriasCodigo, gridBagConstraints);

        jLabel23.setText("Buscar");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.insets = new java.awt.Insets(0, 50, 0, 10);
        panelTutorias.add(jLabel23, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 2;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 15;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelTutorias.add(campoTutoriasBuscar, gridBagConstraints);

        jLabelGruposNombre7.setText("Día");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelTutorias.add(jLabelGruposNombre7, gridBagConstraints);

        campoTutoriasDia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Lunes", "Martes", "Miércoles", "Jueves", "Viernes" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelTutorias.add(campoTutoriasDia, gridBagConstraints);

        campoTutoriasFin.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30", "20:00" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelTutorias.add(campoTutoriasFin, gridBagConstraints);

        campoTutoriasComienzo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "08:00", "08:30", "09:00", "09:30", "10:00", "10:30", "11:00", "11:30", "12:00", "12:30", "13:00", "13:30", "14:00", "14:30", "15:00", "15:30", "16:00", "16:30", "17:00", "17:30", "18:00", "18:30", "19:00", "19:30" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 7;
        gridBagConstraints.gridwidth = 16;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.BASELINE_LEADING;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.insets = new java.awt.Insets(5, 5, 0, 5);
        panelTutorias.add(campoTutoriasComienzo, gridBagConstraints);

        campoTutoriasBuscarCategorias.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Todos los campos", "Código de tutoría", "Día", "Comienzo", "Fin", "Código del profesor", "Nombre del profesor", "Primer apellido del profesor", "Segundo apellido del profesor", "DNI del profesor" }));
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 5);
        panelTutorias.add(campoTutoriasBuscarCategorias, gridBagConstraints);

        campoTutoriasExportar.setText("Imprimir");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 17;
        gridBagConstraints.gridy = 8;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(0, 5, 0, 5);
        panelTutorias.add(campoTutoriasExportar, gridBagConstraints);

        capas.setLayer(panelHorarios, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(panelBienvenida, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(panelCentro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(panelAulas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(panelCursos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(panelAlumnado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(panelAlumnos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(panelGrupos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(panelAsignaturas, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(panelProfesorado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(panelProfesores, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(panelDepartamentos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        capas.setLayer(panelTutorias, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout capasLayout = new javax.swing.GroupLayout(capas);
        capas.setLayout(capasLayout);
        capasLayout.setHorizontalGroup(
            capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelTutorias, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelProfesorado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAsignaturas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelAlumnos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelAlumnado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelAulas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelCentro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBienvenida, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(capasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, 544, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        capasLayout.setVerticalGroup(
            capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(capasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(panelDepartamentos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelProfesores, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelTutorias, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelProfesorado, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelAsignaturas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelGrupos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelAlumnos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelAlumnado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelCursos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(panelAulas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)
                    .addComponent(panelCentro, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(panelBienvenida, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 272, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(capasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(capasLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(panelHorarios, javax.swing.GroupLayout.DEFAULT_SIZE, 303, Short.MAX_VALUE)
                    .addContainerGap()))
        );

        panel.setLayer(panelInicioSesion, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(opcionesProfesorado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(opcionesCentro, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(opcionesAlumnado, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(panelInicio, javax.swing.JLayeredPane.DEFAULT_LAYER);
        panel.setLayer(capas, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(260, 260, 260)
                                .addComponent(opcionesAlumnado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(130, 130, 130)
                                .addComponent(opcionesCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelLayout.createSequentialGroup()
                                .addGap(360, 360, 360)
                                .addComponent(opcionesProfesorado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 112, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(capas, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 602, Short.MAX_VALUE)
                            .addComponent(panelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(90, 90, 90)
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(opcionesAlumnado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opcionesCentro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(opcionesProfesorado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 254, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(panelInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(capas, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(panelInicioSesion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel)
        );

        jScrollPane4.setViewportView(jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 622, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 428, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botonInicioMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonInicioMouseExited
        // Cuando quitamos el foco del botón el color d ela fuente cambia a gris.
        botonInicio.setForeground(Color.GRAY);
    }//GEN-LAST:event_botonInicioMouseExited

    private void botonInicioMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonInicioMouseEntered
        // Cuando quitamos el foco del botón el color d ela fuente cambia a negro.
        botonInicio.setForeground(Color.BLACK);
    }//GEN-LAST:event_botonInicioMouseEntered

    private void botonAlumnadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAlumnadoMouseExited
        // Cuando quitamos el foco del botón el color d ela fuente cambia a gris.
        botonAlumnado.setForeground(Color.GRAY);
            estadoMenu1=1;
            timer1 = new Timer(10, new ActionListener() {
                int crono1=0;
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    crono1++;
                    if(crono1>10 && estadoMenu1==1){
                        opcionesAlumnado.setVisible(false);
                        estadoMenu1=0;
                    }
                    else if(crono1>10){
                        crono1=0;
                    }
                }
            });
            timer1.setRepeats(true);
            timer1.start();
            
            opcionAlumnos.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    timer1.stop();
                }
                @Override
                public void mouseExited(MouseEvent e){
                    timer1.start();
                }
            });
            opcionGrupos.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    timer1.stop();
                }
                @Override
                public void mouseExited(MouseEvent e){
                    timer1.start();
                }
            });
            opcionAsignaturas.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    timer1.stop();
                }
                @Override
                public void mouseExited(MouseEvent e){
                    timer1.start();
                }
            });
    }//GEN-LAST:event_botonAlumnadoMouseExited

    private void botonAlumnadoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonAlumnadoMouseEntered
        // Cuando quitamos el foco del botón el color d ela fuente cambia a negro.
        botonAlumnado.setForeground(Color.BLACK);
        opcionesAlumnado.setVisible(true);
        if(timer1!=null){timer1.stop();}
    }//GEN-LAST:event_botonAlumnadoMouseEntered

    private void botonProfesoradoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonProfesoradoMouseExited
        // Cuando quitamos el foco del botón el color d ela fuente cambia a gris.
        botonProfesorado.setForeground(Color.GRAY);
            estadoMenu2=1;
            timer2 = new Timer(10, new ActionListener() {
                int crono2=0;
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    crono2++;
                    if(crono2>10 && estadoMenu2==1){
                        opcionesProfesorado.setVisible(false);
                        estadoMenu2=0;
                    }
                    else if(crono2>10){
                        crono2=0;
                    }
                }
            });
            timer2.setRepeats(true);
            timer2.start();
            
            opcionProfesores.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    timer2.stop();
                }
                @Override
                public void mouseExited(MouseEvent e){
                    timer2.start();
                }
            });
            opcionDepartamentos.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    timer2.stop();
                }
                @Override
                public void mouseExited(MouseEvent e){
                    timer2.start();
                }
            });
            opcionTutorias.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    timer2.stop();
                }
                @Override
                public void mouseExited(MouseEvent e){
                    timer2.start();
                }
            });
    }//GEN-LAST:event_botonProfesoradoMouseExited

    private void botonProfesoradoMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonProfesoradoMouseEntered
        // Cuando quitamos el foco del botón el color d ela fuente cambia a negro.
        botonProfesorado.setForeground(Color.BLACK);
        opcionesProfesorado.setVisible(true);
        if(timer2!=null){timer2.stop();}
    }//GEN-LAST:event_botonProfesoradoMouseEntered

    private void botonCentroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCentroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCentroActionPerformed

    private void botonCentroMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCentroMouseExited
        // Cuando quitamos el foco del botón el color d ela fuente cambia a gris.
        botonCentro.setForeground(Color.GRAY);
        estadoMenu3=1;
            timer3 = new Timer(10, new ActionListener() {
                int crono3=0;
                
                @Override
                public void actionPerformed(ActionEvent e) {
                    crono3++;
                    if(crono3>10 && estadoMenu3==1){
                        opcionesCentro.setVisible(false);
                        estadoMenu3=0;
                    }
                    else if(crono3>10){
                        crono3=0;
                    }
                }
            });
            timer3.setRepeats(true);
            timer3.start();
            
            opcionHorarios.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    timer3.stop();
                }
                @Override
                public void mouseExited(MouseEvent e){
                    timer3.start();
                }
            });
            opcionAulas.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    timer3.stop();
                }
                @Override
                public void mouseExited(MouseEvent e){
                    timer3.start();
                }
            });
            opcionCursos.addMouseListener(new MouseAdapter(){
                @Override
                public void mouseEntered(MouseEvent e){
                    timer3.stop();
                }
                @Override
                public void mouseExited(MouseEvent e){
                    timer3.start();
                }
            });
    }//GEN-LAST:event_botonCentroMouseExited

    private void botonCentroMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonCentroMouseEntered
        // Cuando quitamos el foco del botón el color d ela fuente cambia a negro.
        botonCentro.setForeground(Color.BLACK);
        opcionesCentro.setVisible(true);
        if(timer3!=null){timer3.stop();}
    }//GEN-LAST:event_botonCentroMouseEntered

    private void botonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonSalirActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonSalirActionPerformed

    private void botonSalirMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSalirMouseExited
        // Cuando quitamos el foco del botón el color d ela fuente cambia a gris.
        botonSalir.setForeground(Color.GRAY);
    }//GEN-LAST:event_botonSalirMouseExited

    private void botonSalirMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botonSalirMouseEntered
        // Cuando quitamos el foco del botón el color d ela fuente cambia a negro.
        botonSalir.setForeground(Color.BLACK);
    }//GEN-LAST:event_botonSalirMouseEntered

    private void opcionHorariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionHorariosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionHorariosActionPerformed

    private void opcionAlumnosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionAlumnosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionAlumnosActionPerformed

    private void opcionAsignaturasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionAsignaturasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionAsignaturasActionPerformed

    private void opcionProfesoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionProfesoresActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionProfesoresActionPerformed

    private void opcionProfesoresMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionProfesoresMouseEntered
        opcionProfesores.setForeground(Color.BLACK);
    }//GEN-LAST:event_opcionProfesoresMouseEntered

    private void opcionProfesoresMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionProfesoresMouseExited
        opcionProfesores.setForeground(Color.GRAY);
    }//GEN-LAST:event_opcionProfesoresMouseExited

    private void opcionDepartamentosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionDepartamentosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionDepartamentosActionPerformed

    private void opcionDepartamentosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionDepartamentosMouseEntered
        opcionDepartamentos.setForeground(Color.BLACK);
    }//GEN-LAST:event_opcionDepartamentosMouseEntered

    private void opcionDepartamentosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionDepartamentosMouseExited
        opcionDepartamentos.setForeground(Color.GRAY);
    }//GEN-LAST:event_opcionDepartamentosMouseExited

    private void opcionTutoriasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionTutoriasMouseEntered
        opcionTutorias.setForeground(Color.BLACK);
    }//GEN-LAST:event_opcionTutoriasMouseEntered

    private void opcionTutoriasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionTutoriasMouseExited
        opcionTutorias.setForeground(Color.GRAY);
    }//GEN-LAST:event_opcionTutoriasMouseExited

    private void opcionTutoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionTutoriasActionPerformed
        
    }//GEN-LAST:event_opcionTutoriasActionPerformed

    private void opcionesAlumnadoMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionesAlumnadoMouseExited
        
    }//GEN-LAST:event_opcionesAlumnadoMouseExited

    private void opcionAlumnosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAlumnosMouseEntered
        opcionAlumnos.setForeground(Color.BLACK);
    }//GEN-LAST:event_opcionAlumnosMouseEntered

    private void opcionAlumnosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAlumnosMouseExited
        opcionAlumnos.setForeground(Color.GRAY);
    }//GEN-LAST:event_opcionAlumnosMouseExited

    private void opcionGruposMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionGruposMouseEntered
        opcionGrupos.setForeground(Color.BLACK);
    }//GEN-LAST:event_opcionGruposMouseEntered

    private void opcionGruposMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionGruposMouseExited
        opcionGrupos.setForeground(Color.GRAY);
    }//GEN-LAST:event_opcionGruposMouseExited

    private void opcionAsignaturasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAsignaturasMouseEntered
        opcionAsignaturas.setForeground(Color.BLACK);
    }//GEN-LAST:event_opcionAsignaturasMouseEntered

    private void opcionAsignaturasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAsignaturasMouseExited
        opcionAsignaturas.setForeground(Color.GRAY);
    }//GEN-LAST:event_opcionAsignaturasMouseExited

    private void opcionHorariosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionHorariosMouseEntered
        opcionHorarios.setForeground(Color.BLACK);
    }//GEN-LAST:event_opcionHorariosMouseEntered

    private void opcionHorariosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionHorariosMouseExited
        opcionHorarios.setForeground(Color.GRAY);
    }//GEN-LAST:event_opcionHorariosMouseExited

    private void opcionAulasMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAulasMouseEntered
        opcionAulas.setForeground(Color.BLACK);
    }//GEN-LAST:event_opcionAulasMouseEntered

    private void opcionAulasMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionAulasMouseExited
        opcionAulas.setForeground(Color.GRAY);
    }//GEN-LAST:event_opcionAulasMouseExited

    private void opcionCursosMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionCursosMouseEntered
        opcionCursos.setForeground(Color.BLACK);
    }//GEN-LAST:event_opcionCursosMouseEntered

    private void opcionCursosMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_opcionCursosMouseExited
        opcionCursos.setForeground(Color.GRAY);
    }//GEN-LAST:event_opcionCursosMouseExited

    private void opcionGruposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opcionGruposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opcionGruposActionPerformed

    private void campoGruposCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoGruposCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoGruposCodigoActionPerformed

    private void campoAlumnosCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoAlumnosCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoAlumnosCodigoActionPerformed

    private void campoProfesoresCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoProfesoresCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoProfesoresCodigoActionPerformed

    private void campoDepartamentosCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoDepartamentosCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoDepartamentosCodigoActionPerformed

    private void campoTutoriasCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoTutoriasCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoTutoriasCodigoActionPerformed

    private void campoHorariosCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_campoHorariosCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_campoHorariosCodigoActionPerformed

    private void botonCursosExportarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botonCursosExportarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botonCursosExportarActionPerformed

    private void BotonRegistrarUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotonRegistrarUsuarioActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BotonRegistrarUsuarioActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton BotonIdentificarUsuario;
    public javax.swing.JButton BotonRegistrarUsuario;
    private javax.swing.JLabel Código;
    public javax.swing.JPanel barraInicio;
    public javax.swing.JLabel bienvenida;
    public javax.swing.JButton botonAlumnado;
    public javax.swing.JButton botonAlumnosBorrar;
    public javax.swing.JButton botonAlumnosExportar;
    public javax.swing.JButton botonAlumnosInsertar;
    public javax.swing.JButton botonAlumnosModificar;
    public javax.swing.JButton botonAsignaturasBorrar;
    public javax.swing.JButton botonAsignaturasExportar;
    public javax.swing.JButton botonAsignaturasInsertar;
    public javax.swing.JButton botonAsignaturasModificar;
    public javax.swing.JButton botonAsignaturasSeleccionar;
    public javax.swing.JButton botonAulasBorrar;
    public javax.swing.JButton botonAulasInsertar;
    public javax.swing.JButton botonAulasModificar;
    public javax.swing.JButton botonAulasSeleccionar;
    public javax.swing.JButton botonBorrarAsignacion;
    public javax.swing.JButton botonCentro;
    public javax.swing.JButton botonCursosBorrar;
    public javax.swing.JButton botonCursosExportar;
    public javax.swing.JButton botonCursosInsertar;
    public javax.swing.JButton botonCursosModificar;
    public javax.swing.JButton botonDepartamentosBorrar;
    public javax.swing.JButton botonDepartamentosExportar;
    public javax.swing.JButton botonDepartamentosInsertar;
    public javax.swing.JButton botonDepartamentosModificar;
    public javax.swing.JButton botonDepartamentosSeleccionar;
    public javax.swing.JButton botonExportarAsignacion;
    public javax.swing.JButton botonExportarAulas;
    public javax.swing.JButton botonGruposBorrar;
    public javax.swing.JButton botonGruposExportar;
    public javax.swing.JButton botonGruposInsertar;
    public javax.swing.JButton botonGruposModificar;
    public javax.swing.JButton botonGruposSeleccionar;
    public javax.swing.JButton botonHorariosBorrar;
    private javax.swing.JButton botonHorariosExportar;
    public javax.swing.JButton botonHorariosInsertar;
    public javax.swing.JButton botonHorariosModificar;
    public javax.swing.JButton botonHorariosSeleccionar;
    public javax.swing.JButton botonInicio;
    public javax.swing.JButton botonInsertarAsignacion;
    public javax.swing.JButton botonModificarAsignacion;
    public javax.swing.JButton botonProfesorado;
    public javax.swing.JButton botonProfesoresBorrar;
    public javax.swing.JButton botonProfesoresExportar;
    public javax.swing.JButton botonProfesoresInsertar;
    public javax.swing.JButton botonProfesoresModificar;
    public javax.swing.JButton botonProfesoresSeleccionar;
    public javax.swing.JButton botonSalir;
    public javax.swing.JButton botonSeleccionarAsignacion;
    public javax.swing.JButton botonTutoriasBorrar;
    public javax.swing.JButton botonTutoriasInsertar;
    public javax.swing.JButton botonTutoriasModificar;
    public javax.swing.JTextField campoAlumnosApellido1;
    public javax.swing.JTextField campoAlumnosApellido2;
    public javax.swing.JTextField campoAlumnosBuscar;
    public javax.swing.JComboBox<String> campoAlumnosBuscarCategorias;
    public javax.swing.JTextField campoAlumnosCodigo;
    public javax.swing.JTextField campoAlumnosDNI;
    public javax.swing.JTextField campoAlumnosGrupo;
    public javax.swing.JTextField campoAlumnosNombre;
    public javax.swing.JTextField campoAsignacionBuscar;
    public javax.swing.JTextField campoAsignacionCodigo_aula;
    public javax.swing.JTextField campoAsignacionCodigo_grupo;
    public javax.swing.JComboBox<String> campoAsignacionesBuscarCategorias;
    public javax.swing.JTextField campoAsignaturasBuscar;
    public javax.swing.JComboBox<String> campoAsignaturasBuscarCategorias;
    public javax.swing.JTextField campoAsignaturasCodigo;
    public javax.swing.JTextField campoAsignaturasCurso;
    public javax.swing.JTextField campoAsignaturasGrupo;
    public javax.swing.JTextField campoAsignaturasNombre;
    public javax.swing.JTextField campoAsignaturasProfesor;
    public javax.swing.JTextField campoAulasBuscar;
    public javax.swing.JComboBox<String> campoAulasBuscarCategorias;
    public javax.swing.JTextField campoAulasNombre;
    public javax.swing.JTextField campoCursosBuscar;
    public javax.swing.JComboBox<String> campoCursosBuscarCategorias;
    public javax.swing.JTextField campoCursosCodigo;
    public javax.swing.JTextField campoCursosNombre;
    public javax.swing.JTextField campoDepartamentosBuscar;
    public javax.swing.JComboBox<String> campoDepartamentosBuscarCategorias;
    public javax.swing.JTextField campoDepartamentosCodigo;
    public javax.swing.JTextField campoDepartamentosDirector;
    public javax.swing.JTextField campoDepartamentosNombre;
    public javax.swing.JTextField campoGruposBuscar;
    public javax.swing.JComboBox<String> campoGruposBuscarCategorias;
    public javax.swing.JTextField campoGruposCodigo;
    public javax.swing.JTextField campoGruposCurso;
    public javax.swing.JTextField campoGruposNombre;
    public javax.swing.JTextField campoGruposTutor;
    public javax.swing.JTextField campoHorariosBuscar;
    public javax.swing.JComboBox<String> campoHorariosBuscarCategorias;
    public javax.swing.JTextField campoHorariosCodigo;
    public javax.swing.JTextField campoHorariosCodigo_asignatura;
    public javax.swing.JComboBox<String> campoHorariosComienzo;
    public javax.swing.JComboBox<String> campoHorariosDia;
    public javax.swing.JComboBox<String> campoHorariosFin;
    public javax.swing.JPasswordField campoPassword;
    public javax.swing.JTextField campoProfesoresApellido1;
    public javax.swing.JTextField campoProfesoresApellido2;
    public javax.swing.JTextField campoProfesoresBuscar;
    public javax.swing.JComboBox<String> campoProfesoresBuscarCategorias;
    public javax.swing.JTextField campoProfesoresCodigo;
    public javax.swing.JTextField campoProfesoresDNI;
    public javax.swing.JTextField campoProfesoresDepartamento;
    public javax.swing.JTextField campoProfesoresNombre;
    public javax.swing.JTextField campoTutoriasBuscar;
    public javax.swing.JComboBox<String> campoTutoriasBuscarCategorias;
    public javax.swing.JTextField campoTutoriasCodigo;
    public javax.swing.JTextField campoTutoriasCodigo_profesor;
    public javax.swing.JComboBox<String> campoTutoriasComienzo;
    public javax.swing.JComboBox<String> campoTutoriasDia;
    public javax.swing.JButton campoTutoriasExportar;
    public javax.swing.JComboBox<String> campoTutoriasFin;
    public javax.swing.JTextField campoUsuario;
    public javax.swing.JLayeredPane capas;
    public javax.swing.JLabel imagen;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabelAulasCodigo;
    private javax.swing.JLabel jLabelAulasNombre;
    private javax.swing.JLabel jLabelAulasTutor;
    private javax.swing.JLabel jLabelCursosCodigo;
    private javax.swing.JLabel jLabelCursosNombre;
    private javax.swing.JLabel jLabelGruposCodigo;
    private javax.swing.JLabel jLabelGruposCodigo1;
    private javax.swing.JLabel jLabelGruposCodigo2;
    private javax.swing.JLabel jLabelGruposCodigo3;
    private javax.swing.JLabel jLabelGruposCodigo4;
    private javax.swing.JLabel jLabelGruposCodigo5;
    private javax.swing.JLabel jLabelGruposCodigo6;
    private javax.swing.JLabel jLabelGruposCodigo7;
    private javax.swing.JLabel jLabelGruposCurso;
    private javax.swing.JLabel jLabelGruposCurso1;
    private javax.swing.JLabel jLabelGruposCurso2;
    private javax.swing.JLabel jLabelGruposCurso3;
    private javax.swing.JLabel jLabelGruposCurso4;
    private javax.swing.JLabel jLabelGruposCurso5;
    private javax.swing.JLabel jLabelGruposNombre;
    public javax.swing.JLabel jLabelGruposNombre1;
    private javax.swing.JLabel jLabelGruposNombre2;
    private javax.swing.JLabel jLabelGruposNombre3;
    private javax.swing.JLabel jLabelGruposNombre4;
    private javax.swing.JLabel jLabelGruposNombre5;
    private javax.swing.JLabel jLabelGruposNombre6;
    private javax.swing.JLabel jLabelGruposNombre7;
    private javax.swing.JLabel jLabelGruposNombre8;
    private javax.swing.JLabel jLabelGruposNombre9;
    private javax.swing.JLabel jLabelGruposTutor;
    private javax.swing.JLabel jLabelGruposTutor1;
    private javax.swing.JLabel jLabelGruposTutor2;
    private javax.swing.JLabel jLabelGruposTutor3;
    private javax.swing.JLabel jLabelGruposTutor4;
    private javax.swing.JLabel jLabelTuhorarioCodigo;
    private javax.swing.JLabel jLabelTuhorarioNombre;
    private javax.swing.JLabel jLabelTuhorarioTutor;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane jTextPane2;
    private javax.swing.JTextPane jTextPane3;
    public javax.swing.JButton opcionAlumnos;
    private javax.swing.JButton opcionAsignaturas;
    private javax.swing.JButton opcionAulas;
    private javax.swing.JButton opcionCursos;
    private javax.swing.JButton opcionDepartamentos;
    private javax.swing.JButton opcionGrupos;
    private javax.swing.JButton opcionHorarios;
    private javax.swing.JButton opcionProfesores;
    private javax.swing.JButton opcionTutorias;
    public javax.swing.JPanel opcionesAlumnado;
    public javax.swing.JPanel opcionesCentro;
    public javax.swing.JPanel opcionesProfesorado;
    public javax.swing.JLayeredPane panel;
    public javax.swing.JPanel panelAlumnado;
    public javax.swing.JPanel panelAlumnos;
    public javax.swing.JPanel panelAsignaturas;
    public javax.swing.JPanel panelAulas;
    public javax.swing.JPanel panelBienvenida;
    public javax.swing.JPanel panelCentro;
    public javax.swing.JPanel panelCursos;
    public javax.swing.JPanel panelDepartamentos;
    public javax.swing.JPanel panelGrupos;
    public javax.swing.JPanel panelHorarios;
    public javax.swing.JPanel panelInicio;
    public javax.swing.JPanel panelInicioSesion;
    public javax.swing.JPanel panelProfesorado;
    public javax.swing.JPanel panelProfesores;
    public javax.swing.JPanel panelTutorias;
    public javax.swing.JLabel password;
    public javax.swing.JScrollPane scrollAlumnos;
    public javax.swing.JScrollPane scrollAsignacion;
    public javax.swing.JScrollPane scrollAsignaturas;
    public javax.swing.JScrollPane scrollAulas;
    public javax.swing.JScrollPane scrollCursos;
    public javax.swing.JScrollPane scrollDepartamentos;
    public javax.swing.JScrollPane scrollGrupos;
    public javax.swing.JScrollPane scrollHorarios;
    public javax.swing.JScrollPane scrollProfesores;
    public javax.swing.JScrollPane scrollTutorias;
    public javax.swing.JTable tablaAlumnos;
    public javax.swing.JTable tablaAsignacion;
    public javax.swing.JTable tablaAsignaturas;
    public javax.swing.JTable tablaAulas;
    public javax.swing.JTable tablaCursos;
    public javax.swing.JTable tablaDepartamentos;
    public javax.swing.JTable tablaGrupos;
    public javax.swing.JTable tablaHorarios;
    public javax.swing.JTable tablaProfesores;
    public javax.swing.JTable tablaTutorias;
    public javax.swing.JLabel tituloInicioSesion;
    public javax.swing.JLabel usuario;
    // End of variables declaration//GEN-END:variables
}
