package mx.argentick.ui;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import mx.argentick.entidad.Profesor;
import mx.argentick.entidad.Unidad;
import mx.argentick.helper.UnidadHelper;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo PC
 */
@ManagedBean(name = "uniCons")
@SessionScoped
public class UniConsBeanUI implements Serializable {

    private List<Unidad> lista;
    private UnidadHelper helper;

    public UniConsBeanUI() {
        helper = new UnidadHelper();
    }

    @PostConstruct
    public void init() {
        lista = new ArrayList<>();
        recargarLista();
    }

    public void recargarLista() {
        System.out.println("Cargando lista de profesores");
        try {
            lista = helper.obtenerTodas();
            System.out.println(lista);
            if (lista.size() > 0) {
                mensajeInfo("Tabla Actualizada", "Unidades: " + lista.size(), FacesMessage.SEVERITY_INFO);
            } else {
                mensajeInfo("Aviso", "No hay unidades registrados", FacesMessage.SEVERITY_WARN);
            }
        } catch (Exception e) {
            System.out.println("Error fatal: " + e);
            mensajeInfo("Error Interno", e.toString(), FacesMessage.SEVERITY_FATAL);
        }
    }

    public String nombreCompleto(Profesor p) {
        System.out.println(p);
        if (p != null) {
            return p.getNombre();
        } else {
            return " ";
        }
    }

    private void mensajeInfo(String titulo, String texto, FacesMessage.Severity tipo) {
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(tipo, "\t" + titulo, texto));
    }

    public List<Unidad> getLista() {
        return lista;
    }

    public void setLista(List<Unidad> lista) {
        this.lista = lista;
    }

}
