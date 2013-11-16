package com.santiago.biblioteca.bean;
// Generated 06/11/2013 04:56:16 AM by Hibernate Tools 3.6.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * Autor generated by hbm2java
 */
@Entity
@Table(name = "autor", catalog = "biblioteca"
)
public class Autor implements java.io.Serializable {

    private Integer id;
    private String nombre;
    private String apellidos;
    private String pais;
    
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fechaNacimiento;
    private Set libros = new HashSet(0);

    public Autor() {
    }

    public Autor(String nombre, String apellidos, String pais, Date fechaNacimiento, Set libros) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.pais = pais;
        this.fechaNacimiento = fechaNacimiento;
        this.libros = libros;
    }

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "nombre", length = 45)
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Column(name = "apellidos", length = 45)
    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Column(name = "pais", length = 45)
    public String getPais() {
        return this.pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fechaNacimiento", length = 10)
    public Date getFechaNacimiento() {
        return this.fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

//@OneToMany(fetch=FetchType.LAZY, mappedBy="autor")
//    public Set getLibros() {
//        return this.libros;
//    }
//    
//    public void setLibros(Set libros) {
//        this.libros = libros;
//    }
    @Override
    public String toString() {
        return nombre + " " + apellidos;
    }
    
}
