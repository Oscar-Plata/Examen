/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.ui;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.argentick.entidad.Profesor;
import mx.argentick.helper.ProfRegHelper;

/**
 *
 * @author Lenovo PC
 */
@ManagedBean(name = "profCons")
@SessionScoped
public class ProfConsBeanUI implements Serializable {

    private List<Profesor> lista;
    private ProfRegHelper helper;

    public ProfConsBeanUI() {
        helper = new ProfRegHelper();
    }

    @PostConstruct
    public void init() {
        lista = new ArrayList<>();
        recargarLista();
    }

    public void recargarLista() {
        System.out.println("Cargando lista de profesores");
        try {
            lista = helper.obtenerTodosOrden();
            System.out.println(lista);
            if (lista.size() > 0) {
                mensajeInfo("Tabla Actualizada", "Profesores: " + lista.size(), FacesMessage.SEVERITY_INFO);
            } else {
                mensajeInfo("Aviso", "No hay profesores registrados", FacesMessage.SEVERITY_WARN);
            }
        } catch (Exception e) {
            System.out.println("Error fatal: " + e);
            mensajeInfo("Error Interno", e.toString(), FacesMessage.SEVERITY_FATAL);
        }
    }

    private void mensajeInfo(String titulo, String texto, FacesMessage.Severity tipo) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, "\t" + titulo, texto));
    }

    public List<Profesor> getLista() {
        return lista;
    }

    public void setLista(List<Profesor> lista) {
        this.lista = lista;
    }

}
