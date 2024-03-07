/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.entidad;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lenovo PC
 */
@Entity
@Table(name = "unidad")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unidad.findAll", query = "SELECT u FROM Unidad u")
    , @NamedQuery(name = "Unidad.findByIdUnidad", query = "SELECT u FROM Unidad u WHERE u.idUnidad = :idUnidad")
    , @NamedQuery(name = "Unidad.findByNombre", query = "SELECT u FROM Unidad u WHERE u.nombre = :nombre")
    , @NamedQuery(name = "Unidad.findByHorasClase", query = "SELECT u FROM Unidad u WHERE u.horasClase = :horasClase")
    , @NamedQuery(name = "Unidad.findByHorasTaller", query = "SELECT u FROM Unidad u WHERE u.horasTaller = :horasTaller")
    , @NamedQuery(name = "Unidad.findByHorasLab", query = "SELECT u FROM Unidad u WHERE u.horasLab = :horasLab")})
public class Unidad implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idUnidad")
    private Integer idUnidad;
    @Basic(optional = false)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "horasClase")
    private int horasClase;
    @Basic(optional = false)
    @Column(name = "horasTaller")
    private int horasTaller;
    @Basic(optional = false)
    @Column(name = "horasLab")
    private int horasLab;
    @JoinTable(name = "asignacion", joinColumns = {
        @JoinColumn(name = "idUnidad", referencedColumnName = "idUnidad")}, inverseJoinColumns = {
        @JoinColumn(name = "idProfesor", referencedColumnName = "idProfesor")})
    @ManyToMany
    private List<Profesor> profesorList;

    public Unidad() {
    }

    public Unidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public Unidad(Integer idUnidad, String nombre, int horasClase, int horasTaller, int horasLab) {
        this.idUnidad = idUnidad;
        this.nombre = nombre;
        this.horasClase = horasClase;
        this.horasTaller = horasTaller;
        this.horasLab = horasLab;
    }

    public Integer getIdUnidad() {
        return idUnidad;
    }

    public void setIdUnidad(Integer idUnidad) {
        this.idUnidad = idUnidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getHorasClase() {
        return horasClase;
    }

    public void setHorasClase(int horasClase) {
        this.horasClase = horasClase;
    }

    public int getHorasTaller() {
        return horasTaller;
    }

    public void setHorasTaller(int horasTaller) {
        this.horasTaller = horasTaller;
    }

    public int getHorasLab() {
        return horasLab;
    }

    public void setHorasLab(int horasLab) {
        this.horasLab = horasLab;
    }

    @XmlTransient
    public List<Profesor> getProfesorList() {
        return profesorList;
    }

    public void setProfesorList(List<Profesor> profesorList) {
        this.profesorList = profesorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUnidad != null ? idUnidad.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Unidad)) {
            return false;
        }
        Unidad other = (Unidad) object;
        if ((this.idUnidad == null && other.idUnidad != null) || (this.idUnidad != null && !this.idUnidad.equals(other.idUnidad))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Unidad[idUnidad=" + idUnidad + ", nombre=" + nombre + ", horasClase=" + horasClase + ", horasTaller=" + horasTaller + ", horasLab=" + horasLab + ']';
    }
}
