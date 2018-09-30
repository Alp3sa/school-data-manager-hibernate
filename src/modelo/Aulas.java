package modelo;
// Generated 22-may-2018 12:22:28 by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;

/**
 * Aulas generated by hbm2java
 */
public class Aulas  implements java.io.Serializable {


     private Integer codigo;
     private String nombre;
     private Set asignacionAulases = new HashSet(0);

    public Aulas() {
    }

    public Aulas(String nombre) {
        this.nombre = nombre;
    }
    public Aulas(String nombre, Set asignacionAulases) {
       this.nombre = nombre;
       this.asignacionAulases = asignacionAulases;
    }
    
    public Aulas(int registro, String nombre){
        this.codigo=registro;
        this.nombre=nombre;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return this.nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public Set getAsignacionAulases() {
        return this.asignacionAulases;
    }
    
    public void setAsignacionAulases(Set asignacionAulases) {
        this.asignacionAulases = asignacionAulases;
    }




}

