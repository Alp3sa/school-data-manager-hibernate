package modelo;
// Generated 22-may-2018 12:22:28 by Hibernate Tools 4.3.1



/**
 * Matriculas generated by hbm2java
 */
public class Matriculas  implements java.io.Serializable {


     private MatriculasId id;
     private Alumnos alumnos;
     private Asignaturas asignaturas;

    public Matriculas() {
    }

    public Matriculas(MatriculasId id, Alumnos alumnos, Asignaturas asignaturas) {
       this.id = id;
       this.alumnos = alumnos;
       this.asignaturas = asignaturas;
    }
   
    public MatriculasId getId() {
        return this.id;
    }
    
    public void setId(MatriculasId id) {
        this.id = id;
    }
    public Alumnos getAlumnos() {
        return this.alumnos;
    }
    
    public void setAlumnos(Alumnos alumnos) {
        this.alumnos = alumnos;
    }
    public Asignaturas getAsignaturas() {
        return this.asignaturas;
    }
    
    public void setAsignaturas(Asignaturas asignaturas) {
        this.asignaturas = asignaturas;
    }




}


