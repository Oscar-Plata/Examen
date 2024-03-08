/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.validation.constraints.Size;
import mx.argentick.entidad.Profesor;
import mx.argentick.entidad.Unidad;
import mx.argentick.helper.ProfesorHelper;
import mx.argentick.helper.UnidadHelper;

/**
 *
 * @author Lenovo PC
 */
@ManagedBean(name = "profUI")
@SessionScoped

public class ProfRegBeanUI implements Serializable {

    private ProfesorHelper helperProfesor;
    private UnidadHelper helperUnidad;
    private Profesor profesor;
    private String[] materiasSeleccionadas;
    private List<Unidad> materias;
    private List<Unidad> materiasAsignadas;

    public ProfRegBeanUI() {
        helperProfesor = new ProfesorHelper();
        helperUnidad = new UnidadHelper();
    }

    @PostConstruct
    public void init() {
        profesor = new Profesor();
        materias = new ArrayList<>();
        recargarMaterias();
    }

    public void recargarMaterias() {
        System.out.println("Cargando materias desde BD");
        try {
            materias = helperUnidad.obtenerTodas();
            System.out.println("materias " + materias.size());
            mensajeInfo("Unidades de aprendizaje", "Disponibles: "+materias.size(), FacesMessage.SEVERITY_INFO);

        } catch (Exception e) {
            System.out.println("error " + e);
            mensajeInfo("Unidades de aprendizaje", "Sin existencia", FacesMessage.SEVERITY_WARN);
        }
    }

    public void registrarProfesor() {
        //Crear nuevo profesor -nombre,apellido y rfc viene de xhtml
        profesor.setIdProfesor(0);
        profesor.setUnidadList(new ArrayList());
        profesor.setNombre(capitalize(profesor.getNombre()));
        profesor.setApellidos(capitalize(profesor.getApellidos()));
        profesor.setRfc(mayusculasConNumeros(profesor.getRfc()));
        System.out.println("REGMA"+ Arrays.toString(materiasSeleccionadas));
        try {
            //Revisar  que no se ingrese un rfc registrado
            if (helperProfesor.buscarPorParametro(profesor.getRfc(), "rfc").isEmpty()) {

                //Registrar Profesor en tabla Profesor
                int res = helperProfesor.guardarProfesor(profesor);

                //Registro de profesor Exitoso
                if (res != -1) {
                    mensajeInfo("Profesor Registrado con Exito.", profesor.getNombre()+" "+profesor.getApellidos(), FacesMessage.SEVERITY_INFO);
                    System.out.println("Profesor Registrado: " + profesor);
                }

                // Obtener ID del profesor registrado
                List<Profesor> auxiliar = helperProfesor.buscarPorParametro(profesor.getRfc(), "rfc");
                if (auxiliar != null && auxiliar.size() > 0) {
                    profesor = auxiliar.get(0);
                    recargarMaterias();
                    //Obtener Unidades a partir de los Checkboxes
                    materiasAsignadas = obtenerUnidadesCheckbox(materiasSeleccionadas, materias, profesor);
                    //Asignar Unidades al profesor
                    profesor.setUnidadList(materiasAsignadas);
                    System.out.println("Prof uns: " + profesor.getUnidadList());
                    helperProfesor.actualizarProfesor(profesor);
                    materiasSeleccionadas = new String[]{};
                    profesor.setNombre("");
                    profesor.setApellidos("");
                    profesor.setRfc("");
                }
            } else {
                //Mensaje de Registro fallido - duplicado rfc
                mensajeInfo("Registro Fallido", "RFC Repetido", FacesMessage.SEVERITY_WARN);
            }
        } catch (Exception e) {
            mensajeInfo("FATAL ERROR", e.toString(), FacesMessage.SEVERITY_FATAL);
        }
    }

    private void mensajeInfo(String titulo, String texto, Severity tipo) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, "\t"+titulo, texto));
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
    
    private String capitalize(String s){
        return s.substring(0, 1).toUpperCase()+s.substring(1);
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

    public Profesor getProfesor() {
        return profesor;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public String[] getMateriasSeleccionadas() {
        return materiasSeleccionadas;
    }

    public void setMateriasSeleccionadas(String[] materiasSeleccionadas) {
        this.materiasSeleccionadas = materiasSeleccionadas;
    }

    public List<Unidad> getMaterias() {
        return materias;
    }

    public void setMaterias(List<Unidad> materias) {
        this.materias = materias;
    }

}
