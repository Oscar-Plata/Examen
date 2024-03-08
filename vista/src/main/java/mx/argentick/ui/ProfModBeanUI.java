/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.argentick.entidad.Profesor;
import mx.argentick.entidad.Unidad;
import mx.argentick.helper.ProfesorHelper;
import mx.argentick.helper.UnidadHelper;

/**
 *
 * @author Lenovo PC
 */
@ManagedBean(name = "modProf")
@SessionScoped
public class ProfModBeanUI {

    private ProfesorHelper helperProfesor;
    private UnidadHelper helperUnidad;
    private List<Unidad> unidades;
    private Unidad unidadSel;
    private List<Profesor> profesores;
    private Profesor profesorSel;
    private int idUnidadSel;
    private int idProfesorSel;
    private List<Unidad> materiasAsignadas;
    private String[] materiasSeleccionadas;

    public ProfModBeanUI() {
        helperProfesor = new ProfesorHelper();
        helperUnidad = new UnidadHelper();
    }

    @PostConstruct
    public void init() {
        unidades = new ArrayList<>();
        profesores = new ArrayList<>();
        profesorSel = new Profesor();
        unidadSel = new Unidad();
        recargarUnidades();
        idUnidadSel = 0;
        idProfesorSel = 0;
    }

    /**
     *
     */
    public void recargarUnidades() {
        System.out.println("Cargando materias desde BD");
        try {
            unidades = helperUnidad.obtenerTodas();
            System.out.println("materias " + unidades.size());
            mensajeInfo("Unidades de aprendizaje", "Disponibles: " + unidades.size(), FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
            System.out.println("error " + e);
            mensajeInfo("Unidades de aprendizaje", "Sin existencia", FacesMessage.SEVERITY_WARN);
        }
    }

    /**
     *
     */
    public void cargarProfesores() {
        if (idUnidadSel > 0) {
            for (Unidad uni : unidades) {
                if (uni.getIdUnidad().equals(idUnidadSel)) {
                    unidadSel = uni;
                    break;
                }
            }
            System.out.println("Unisel: " + unidadSel);
            profesores = unidadSel.getProfesorList();
        } else if (idUnidadSel == -1) {
            profesores = helperProfesor.obtenerTodosOrden();
        } else {
            mensajeInfo("Seleccion Invalida", "Selecciona una unidad de aprendizaje", FacesMessage.SEVERITY_WARN);
            profesores = new ArrayList<>();
        }
    }

    /**
     *
     */
    public void editarProfesor() {
        //SE OBTIENE EL ID DEL PROFESOR SELECCIONADO AL PULSAR EL BOTON DE UNA FILA 
        if (idProfesorSel != 0) {
            System.out.println("ID del profesor seleccionado: " + idProfesorSel);
            //SE GUARDA EL OBJETO PROFESOR
            for (Profesor pro : profesores) {
                if (pro.getIdProfesor().equals(idProfesorSel)) {
                    profesorSel = pro;
                    break;
                }
            }
            //SE ALMACENAN LAS MATERIAS QUE EL PROFESOR TIENE ASIGNADAS
            materiasAsignadas = profesorSel.getUnidadList();
            int cantidadAsigandas = materiasAsignadas.size();
            materiasSeleccionadas = new String[cantidadAsigandas];
            //SE PREPARA EL ARRAY PARA LOS CHECKBOXES
            int i = 0;
            for (Unidad ma : materiasAsignadas) {
                materiasSeleccionadas[i] = ma.getIdUnidad().toString();
                i++;
            }
            //SE NAVEGA A LA PANTALLA DE MODIFICACION
            try {
                FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + "/actualizarProfesor.xhtml");
            } catch (IOException ex) {
                mensajeInfo("Error de navegacion", ex.toString(), FacesMessage.SEVERITY_ERROR);
            }
        }
    }

    public void actulizarProfesor() {
        try {
            //Desasignar materias
            for (Unidad uAsignada : profesorSel.getUnidadList()) {
                uAsignada.getProfesorList().remove(profesorSel);
                helperUnidad.actualizarUnidad(uAsignada);
            }
            profesorSel.setUnidadList(new ArrayList(0));
//            System.out.println("P:" + profesorSel);
            //Reasignar Materias seleccionadas
            profesorSel.setNombre(capitalize(profesorSel.getNombre()));
            profesorSel.setApellidos(capitalize(profesorSel.getApellidos()));
            profesorSel.setRfc(mayusculasConNumeros(profesorSel.getRfc()));
//            System.out.println("SEMAT: " + Arrays.toString(materiasSeleccionadas));
            profesorSel.setUnidadList(obtenerUnidadesCheckbox(materiasSeleccionadas, unidades, profesorSel));
//            System.out.println("P:" + profesorSel);
           //ACTUALIZAR REGiSTRO
            helperProfesor.actualizarProfesor(profesorSel);
            //MENSAJE DE EXITO
             mensajeInfo("Profesor Actualizado", profesorSel.getNombreCompleto(), FacesMessage.SEVERITY_INFO);
        } catch (Exception e) {
             mensajeInfo("Error ", "Algo salio mal :(", FacesMessage.SEVERITY_ERROR);
        }

    }
    
    public void eliminarProfesor(){
        System.out.println(idProfesorSel);
    }

    /**
     * Metodo que asigna el profesor actual a las unidades seleccionadas
     * mediante el grid de checkboxes
     *
     * @param listaCheckbox Lista de Id's de unidades seleccionadas
     * @param unidadesCargadas Lista de unidades en base de datos
     * @param asignado Profesor asignado que impartira la unidad
     * @return Lista de unidades actualizadas para asignar al profesor
     */
    private List<Unidad> obtenerUnidadesCheckbox(String[] listaCheckbox, List<Unidad> unidadesCargadas, Profesor asignado) {
        System.out.println("TRANSFORMANDO");
        List<Unidad> uac = new ArrayList<>();
        for (String m : listaCheckbox) {
            for (Unidad u : unidadesCargadas) {
                if (u.getIdUnidad().equals(Integer.valueOf(m))) {
                    //Asignar profesor obtenido a las materias seleccionadas
                    if (u.getProfesorList() != null && !u.getProfesorList().contains(asignado)) {
                        u.getProfesorList().add(asignado);
                    }
                    System.out.println("~~~: " + u);
                    uac.add(u);
                    break;
                }
            }
        }
        return uac;
    }

    private String capitalize(String s) {
        return s.substring(0, 1).toUpperCase() + s.substring(1);
    }

    private String mayusculasConNumeros(String input) {
        StringBuilder result = new StringBuilder();

        for (char ch : input.toCharArray()) {
            if (Character.isLetter(ch)) {
                // Convertir letras a mayúsculas
                result.append(Character.toUpperCase(ch));
            } else {
                // Mantener números intactos
                result.append(ch);
            }
        }
        return result.toString();
    }

    /**
     *
     * @param titulo
     * @param texto
     * @param tipo
     */
    private void mensajeInfo(String titulo, String texto, FacesMessage.Severity tipo) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, "\t" + titulo, texto));
    }

    public List<Unidad> getUnidades() {
        return unidades;
    }

    public void setUnidades(List<Unidad> unidades) {
        this.unidades = unidades;
    }

    public Unidad getUnidadSel() {
        return unidadSel;
    }

    public void setUnidadSel(Unidad unidadSel) {
        this.unidadSel = unidadSel;
    }

    public List<Profesor> getProfesores() {
        return profesores;
    }

    public void setProfesores(List<Profesor> profesores) {
        this.profesores = profesores;
    }

    public Profesor getProfesorSel() {
        return profesorSel;
    }

    public void setProfesorSel(Profesor profesorSel) {
        this.profesorSel = profesorSel;
    }

    public int getIdUnidadSel() {
        return idUnidadSel;
    }

    public void setIdUnidadSel(int idUnidadSel) {
        this.idUnidadSel = idUnidadSel;
    }

    public int getIdProfesorSel() {
        return idProfesorSel;
    }

    public void setIdProfesorSel(int idProfesorSel) {
        this.idProfesorSel = idProfesorSel;
    }

    public List<Unidad> getMateriasAsignadas() {
        return materiasAsignadas;
    }

    public void setMateriasAsignadas(List<Unidad> materiasAsignadas) {
        this.materiasAsignadas = materiasAsignadas;
    }

    public String[] getMateriasSeleccionadas() {
        return materiasSeleccionadas;
    }

    public void setMateriasSeleccionadas(String[] materiasSeleccionadas) {
        this.materiasSeleccionadas = materiasSeleccionadas;
    }

}
