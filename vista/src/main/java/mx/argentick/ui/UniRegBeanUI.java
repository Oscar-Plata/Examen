/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.ui;

import com.sun.xml.internal.ws.util.StringUtils;
import java.io.Serializable;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.argentick.entidad.Unidad;
import mx.argentick.helper.UnidadHelper;

/**
 *
 * @author Lenovo PC
 */
@ManagedBean(name = "unidadUI")
@SessionScoped
public class UniRegBeanUI implements Serializable {

    private UnidadHelper helper;
    private Unidad unidad;

    public UniRegBeanUI() {
        helper = new UnidadHelper();
    }

    @PostConstruct
    public void init() {
        unidad = new Unidad();
        unidad.setHorasClase(0);
        unidad.setHorasTaller(0);
        unidad.setHorasLab(0);
        unidad.setNombre("");
    }

    public void registrarUnidad() {
        //Valores por defecto para nuevo registro
        unidad.setIdUnidad(0);
        unidad.setProfesorList(new ArrayList());
        unidad.setNombre(StringUtils.capitalize(unidad.getNombre()));
        try {
            //Registrar unidad en base de datos
            int res = helper.guardarUnidad(unidad);
            if (res != -1) {
                //Mensaje de exito
                System.out.println("Unidad Registrada:" + unidad);
                mensajeInfo("Unidad Registrada", unidad.getNombre(), FacesMessage.SEVERITY_INFO);
                unidad.setHorasClase(0);
                unidad.setHorasTaller(0);
                unidad.setHorasLab(0);
                unidad.setNombre("");
            } else {
                //Mensaje de fallo
                System.out.println("Unidad no se registro" + unidad);
                mensajeInfo("Error", "Unidad no se registro", FacesMessage.SEVERITY_WARN);

            }
        } catch (Exception e) {
            //Mesaje de error interno
            System.out.println("Error: " + e);
            mensajeInfo("FATAL ERROR", e.toString(), FacesMessage.SEVERITY_FATAL);
        }
    }

    private void mensajeInfo(String titulo, String texto, FacesMessage.Severity tipo) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, "\t" + titulo, texto));
    }

    public Unidad getUnidad() {
        return unidad;
    }

    public void setUnidad(Unidad unidad) {
        this.unidad = unidad;
    }

}
