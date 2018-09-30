package modelo;
// Generated 22-may-2018 12:22:28 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Alumnos generated by hbm2java
 */
public class Alumnos  implements java.io.Serializable {
    private Integer codigo;
    private Grupos grupos;
    private String dni;
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String grupo;
    private String nombre_grupo;
    private Set matriculases = new HashSet(0);

    public Alumnos() {
    }
	
    public Alumnos(Grupos grupos, String dni, String nombre, String apellido1, String apellido2) {
        this.grupos = grupos;
        this.dni = dni;
        this.nombre = nombre;
        this.apellido1 = apellido1;
        this.apellido2 = apellido2;
    }
    public Alumnos(Grupos grupos, String dni, String nombre, String apellido1, String apellido2, Set matriculases) {
       this.grupos = grupos;
       this.dni = dni;
       this.nombre = nombre;
       this.apellido1 = apellido1;
       this.apellido2 = apellido2;
       this.matriculases = matriculases;
    }
    
    public Alumnos(int registro, String dni, String nombre, String apellido1, String apellido2, String grupo, String nombre_grupo){
        this.codigo=registro;
        this.dni=dni;
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.grupo=grupo;
        this.nombre_grupo=nombre_grupo;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Grupos getGrupos() {
        return this.grupos;
    }
    
    public void setGrupos(Grupos grupos) {
        this.grupos = grupos;
    }
    public String getDni() {
        return this.dni;
    }
    
    public void setDni(String dni) {
        this.dni = dni;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getApellido1() {
        return this.apellido1;
    }
    
    public void setApellido1(String apellido1) {
        this.apellido1 = apellido1;
    }
    public String getApellido2() {
        return this.apellido2;
    }
    
    public void setApellido2(String apellido2) {
        this.apellido2 = apellido2;
    }
    public Set getMatriculases() {
        return this.matriculases;
    }
    
    public void setMatriculases(Set matriculases) {
        this.matriculases = matriculases;
    }

    public String getGrupo() {
        return grupo;
    }

    public void setGrupo(String grupo) {
        this.grupo = grupo;
    }
    
    public String getNombre_grupo() {
        return nombre_grupo;
    }
    
    public void setNombre_grupo(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }
}


