package modelo;
// Generated 22-may-2018 12:22:28 by Hibernate Tools 4.3.1



/**
 * AsignacionAulas generated by hbm2java
 */
public class AsignacionAulas  implements java.io.Serializable {
    private Integer codigo;
    private String codigo_aula;
    private String nombre_aula;
    private String codigo_grupo;
    private String nombre_grupo;
    private Aulas aulas;
    private Grupos grupos;

    public AsignacionAulas() {
    }

    public AsignacionAulas(Aulas aulas, Grupos grupos) {
       this.aulas = aulas;
       this.grupos = grupos;
    }
    
    public AsignacionAulas(int registro, String codigo_aula, String nombre, String codigo_grupo, String nombre_grupo){
        this.codigo=registro;
        this.codigo_aula=codigo_aula;
        this.nombre_aula=nombre;
        this.codigo_grupo=codigo_grupo;
        this.nombre_grupo=nombre_grupo;
    }
   
    public Integer getCodigo() {
        return this.codigo;
    }
    
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }
    public Aulas getAulas() {
        return this.aulas;
    }
    
    public void setAulas(Aulas aulas) {
        this.aulas = aulas;
    }
    public Grupos getGrupos() {
        return this.grupos;
    }
    
    public void setGrupos(Grupos grupos) {
        this.grupos = grupos;
    }

    public String getCodigo_aula() {
        return codigo_aula;
    }

    public void setCodigo_aula(String codigo_aula) {
        this.codigo_aula = codigo_aula;
    }
    
    public String getNombre_aula() {
        return nombre_aula;
    }

    public void setNombre_aula(String nombre) {
        this.nombre_aula = nombre;
    }
    
    public String getCodigo_grupo() {
        return codigo_grupo;
    }

    public void setCodigo_grupo(String codigo_grupo) {
        this.codigo_grupo = codigo_grupo;
    }
    
    public String getNombre_grupo() {
        return nombre_grupo;
    }

    public void setNombre_grupo(String nombre_grupo) {
        this.nombre_grupo = nombre_grupo;
    }
}