/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.sql.ResultSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.table.AbstractTableModel;
import modelo.*;

/**
 *
 * @author Alfonso Pérez Santana
 */
public class ControladorTabla extends AbstractTableModel{
    //Clase controladora de la carga del  JTable partiendo de la clase abstracta AbstractTableModel
//https://docs.oracle.com/javase/7/docs/api/javax/swing/table/AbstractTableModel.html
  
    private int ultimaFila=-1;
    private Alumnos alumno;
    private AsignacionAulas asignacionAula;
    private Asignaturas asignatura;
    private Aulas aula;
    private Cursos curso;
    private Departamentos departamento;
    private Grupos grupo;
    private Horarios horario;
    private Profesores profesor;
    private Tutorias tutoria;
    Set s;
    public String[] _columnas;
    
    List lista;
    String nombreClase;
    
    public ControladorTabla(List<?> lista) {
        try{
            this.lista=lista;
            if(!lista.isEmpty()){
                this.nombreClase=lista.get(0).getClass().getSimpleName();
                s = new HashSet(lista);
                if(this.nombreClase.contains("Alumnos")){
                    _columnas = new String[]{
                        "Código",
                        "DNI",
                        "Nombre",
                        "1er apellido",
                        "2o apellido",
                        "Código de grupo",
                        "Nombre de grupo"
                    };
                }
                else if(this.nombreClase.contains("AsignacionAulas")){
                    _columnas = new String[]{
                        "Código",
                        "Código del aula",
                        "Nombre del aula",
                        "Código del grupo",
                        "Nombre del grupo"
                    };
                }
                else if(this.nombreClase.contains("Asignaturas")){
                    _columnas = new String[]{
                        "Código",
                        "Asignatura",
                        "Código del profesor",
                        "Nombre",
                        "Primer apellido",
                        "Segundo apellido",
                        "DNI",
                        "Código del grupo",
                        "Nombre del grupo",
                        "Código del curso",
                        "Nombre del curso"
                    };
                }
                else if(this.nombreClase.contains("Aulas")){
                    _columnas = new String[]{
                        "Código",
                        "Nombre"
                    };
                }
                else if(this.nombreClase.contains("Cursos")){
                    _columnas = new String[]{
                        "Código",
                        "Nombre"
                    };
                }
                else if(this.nombreClase.contains("Departamentos")){
                    _columnas = new String[]{
                        "Código",
                        "Nombre",
                        "Código del director",
                        "Nombre",
                        "1er apellido",
                        "2o apellido",
                        "DNI"
                    };
                }
                else if(this.nombreClase.contains("Grupos")){
                    _columnas = new String[]{
                        "Código",
                        "Nombre",
                        "Codigo del curso",
                        "Nombre del curso",
                        "Codigo del tutor",
                        "Nombre del tutor"
                    };
                }
                else if(this.nombreClase.contains("Horarios")){
                    _columnas = new String[]{
                        "Código",
                        "Día",
                        "Comienzo",
                        "Fin",
                        "Código de la asignatura",
                        "Nombre de la asignatura"
                    };
                }
                else if(this.nombreClase.contains("Profesores")){
                    _columnas = new String[]{
                        "Código",
                        "DNI",
                        "Nombre",
                        "1er apellido",
                        "2o apellido",
                        "Código dpto.",
                        "Nombre dpto."
                    };
                }
                else if(this.nombreClase.contains("Tutorias")){
                    _columnas = new String[]{
                        "Código",
                        "Día",
                        "Comienzo",
                        "Fin",
                        "C. profesor",
                        "Nombre",
                        "1er Apellido",
                        "2o Apellido",
                        "DNI"
                    };
                }
            }
        }
        catch(Exception e){System.out.println("Clase no encontrada.");}
    }
    // Indica el número de filas que tendrá la tabla
    @Override
    public int getRowCount() {
        try {
            return s.size();
        } catch (Exception e) {
        }
        return 0;
    }

    //Indica el número de campos a mostrar en la tabla
    
    @Override
    public int getColumnCount() {
        return _columnas.length;
    }

    //Carga el valor en la fila y columna correspondiente
    //atención es +1 pq los metadatos trabajan en arry base 1 y yo espero en base 0
    //voy a comentar el que puse inicialmente y voy a poner un array para cargar los datos
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex >= 0) {
            try {
                if(rowIndex != ultimaFila){
                    if (lista.get(rowIndex)!=null) {
                        
                        if(this.nombreClase.contains("Alumnos")){
                            alumno = new Alumnos();
                            alumno=(Alumnos) lista.get(rowIndex);
                            switch (columnIndex) {
                                case 0:
                                    return alumno.getCodigo();
                                case 1:
                                    return alumno.getDni();
                                case 2:
                                    return alumno.getNombre();
                                case 3:
                                    return alumno.getApellido1();
                                case 4:
                                    return alumno.getApellido2();
                                case 5:
                                    return alumno.getGrupo();
                                case 6:
                                    return alumno.getNombre_grupo();
                            }
                        }
                        else if(this.nombreClase.contains("AsignacionAulas")){
                            asignacionAula = new AsignacionAulas();
                            asignacionAula=(AsignacionAulas) lista.get(rowIndex);
                            switch (columnIndex) {
                                case 0:
                                    return asignacionAula.getCodigo();
                                case 1:
                                    return asignacionAula.getCodigo_aula();
                                case 2:
                                    return asignacionAula.getNombre_aula();
                                case 3:
                                    return asignacionAula.getCodigo_grupo();
                                case 4:
                                    return asignacionAula.getNombre_grupo();
                            }
                        }
                        else if(this.nombreClase.contains("Asignaturas")){
                            asignatura = new Asignaturas();
                            asignatura=(Asignaturas) lista.get(rowIndex);
                            switch (columnIndex) {
                                case 0:
                                    return asignatura.getCodigo();
                                case 1:
                                    return asignatura.getNombre();
                                case 2:
                                    return asignatura.getCodigo_profesor();
                                case 3:
                                    return asignatura.getNombre_profesor();
                                case 4:
                                    return asignatura.getApellido1_profesor();
                                case 5:
                                    return asignatura.getApellido2_profesor();
                                case 6:
                                    return asignatura.getDNI_profesor();
                                case 7:
                                    return asignatura.getCodigo_grupo();
                                case 8:
                                    return asignatura.getNombre_grupo();
                                case 9:
                                    return asignatura.getCodigo_curso();
                                case 10:
                                    return asignatura.getNombre_curso();
                            }
                        }
                        else if(this.nombreClase.contains("Aulas")){
                            aula = new Aulas();
                            aula=(Aulas) lista.get(rowIndex);
                            switch (columnIndex) {
                                case 0:
                                    return aula.getCodigo();
                                case 1:
                                    return aula.getNombre();
                            }
                        }
                        else if(this.nombreClase.contains("Cursos")){
                            curso = new Cursos();
                            curso=(Cursos) lista.get(rowIndex);
                            switch (columnIndex) {
                                case 0:
                                    return curso.getCodigo();
                                case 1:
                                    return curso.getNombre();
                            }
                        }
                        else if(this.nombreClase.contains("Departamentos")){
                            departamento = new Departamentos();
                            departamento=(Departamentos) lista.get(rowIndex);
                            switch (columnIndex) {
                                case 0:
                                    return departamento.getCodigo();
                                case 1:
                                    return departamento.getNombre();
                                case 2:
                                    return departamento.getDirector();
                                case 3:
                                    return departamento.getNombre_director();
                                case 4:
                                    return departamento.getApellido1_director();
                                case 5:
                                    return departamento.getApellido2_director();
                                case 6:
                                    return departamento.getDNI_director();
                            }
                        }
                        else if(this.nombreClase.contains("Grupos")){
                            grupo = new Grupos();
                            grupo=(Grupos) lista.get(rowIndex);
                            switch (columnIndex) {
                                case 0:
                                    return grupo.getCodigo();
                                case 1:
                                    return grupo.getNombre();
                                case 2:
                                    return grupo.getCurso();
                                case 3:
                                    return grupo.getNombre_curso();
                                case 4:
                                    return grupo.getTutor();
                                case 5:
                                    return grupo.getNombre_tutor();
                            }
                        }
                        else if(this.nombreClase.contains("Horarios")){
                            horario = new Horarios();
                            horario=(Horarios) lista.get(rowIndex);
                            switch (columnIndex) {
                                case 0:
                                    return horario.getCodigo();
                                case 1:
                                    return horario.getDia();
                                case 2:
                                    return horario.getComienzo();
                                case 3:
                                    return horario.getFin();
                                case 4:
                                    return horario.getCodigo_asignatura();
                                case 5:
                                    return horario.getNombre_asignatura();
                            }
                        }
                        else if(this.nombreClase.contains("Profesores")){
                            profesor = new Profesores();
                            profesor=(Profesores) lista.get(rowIndex);
                            switch (columnIndex) {
                                case 0:
                                    return profesor.getCodigo();
                                case 1:
                                    return profesor.getDni();
                                case 2:
                                    return profesor.getNombre();
                                case 3:
                                    return profesor.getApellido1();
                                case 4:
                                    return profesor.getApellido2();
                                case 5:
                                    return profesor.getDepartamento();
                                case 6:
                                    return profesor.getNombre_departamento();
                            }
                        }
                        else if(this.nombreClase.contains("Tutorias")){
                            tutoria = new Tutorias();
                            tutoria=(Tutorias) lista.get(rowIndex);
                            switch (columnIndex) {
                                case 0:
                                    return tutoria.getCodigo();
                                case 1:
                                    return tutoria.getDia();
                                case 2:
                                    return tutoria.getComienzo();
                                case 3:
                                    return tutoria.getFin();
                                case 4:
                                    return tutoria.getCodigo_profesor();
                                case 5:
                                    return tutoria.getNombre_profesor();
                                case 6:
                                    return tutoria.getApellido1_profesor();
                                case 7:
                                    return tutoria.getApellido2_profesor();
                                case 8:
                                    return tutoria.getDNI_profesor();
                            }
                        }
                    }
                    ultimaFila=rowIndex;
                }
            } catch (Exception e) {
                System.out.println(e.toString());
            }
        }
        return "";
    }

    //Indica el nombre de la columna según array _columnas
    @Override
    public String getColumnName(int columnIndex) {
        return _columnas[columnIndex];
    }

    //Indica si las celldas del Jtable son editable o no. En este caso ningun campo es editable
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }
}
