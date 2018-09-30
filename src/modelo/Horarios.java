package modelo;
// Generated 22-may-2018 12:22:28 by Hibernate Tools 4.3.1

/**
 * Horarios generated by hbm2java
 */

public class Horarios  implements java.io.Serializable {
    private Integer codigo;
    private Asignaturas asignaturas;
    private String dia;
    private String comienzo;
    private String fin;
    private String codigo_asignatura;
    private String nombre_asignatura;

    public Horarios() {
    }

    public Horarios(Asignaturas asignaturas, String dia, String comienzo, String fin) {
       this.asignaturas = asignaturas;
       this.dia = dia;
       this.comienzo = comienzo;
       this.fin = fin;
    }
    
    public Horarios(int registro, String dia, String comienzo, String fin, String codigo_asignatura, String nombre_asignatura){
        this.codigo=registro;
        this.dia=dia;
        this.comienzo=comienzo;
        this.fin=fin;
        this.codigo_asignatura=codigo_asignatura;
        this.nombre_asignatura=nombre_asignatura;
    }
    
    public Horarios(int registro, String dia, String comienzo, String fin, String codigo_asignatura){
        this.codigo=registro;
        this.dia=dia;
        this.comienzo=comienzo;
        this.fin=fin;
        this.codigo_asignatura=codigo_asignatura;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Asignaturas getAsignaturas() {
        return this.asignaturas;
    }
    
    public void setAsignaturas(Asignaturas asignaturas) {
        this.asignaturas = asignaturas;
    }
    public String getDia() {
        return this.dia;
    }
    
    public void setDia(String dia) {
        this.dia = dia;
    }
    public String getComienzo() {
        return this.comienzo;
    }
    
    public void setComienzo(String comienzo) {
        this.comienzo = comienzo;
    }
    public String getFin() {
        return this.fin;
    }
    
    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getCodigo_asignatura() {
        return codigo_asignatura;
    }

    public void setCodigo_asignatura(String codigo_asignatura) {
        this.codigo_asignatura = codigo_asignatura;
    }
    
    public String getNombre_asignatura() {
        return nombre_asignatura;
    }

    public void setNombre_asignatura(String nombre_asignatura) {
        this.nombre_asignatura = nombre_asignatura;
    }
}