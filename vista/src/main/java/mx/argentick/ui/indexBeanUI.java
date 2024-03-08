/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.ui;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author Lenovo PC
 */
@ManagedBean(name="indexUI")
@SessionScoped
public class indexBeanUI {
    public indexBeanUI(){
    }
    
    @PostConstruct
    public void init(){
        
    }
    public void navegarXHTML(int opc){
        String destino="";
        switch(opc){
            case 1:
                destino="/registroProfesores.xhtml";
                break;
            case 2:
                destino="/registroUnidades.xhtml";
                break;
            case 3:
                destino="/consultaProfesores.xhtml";
                break;
            case 4:
                destino="/consultaUnidades.xhtml";
                break;
            case 5:
                destino="/modificarProfesor.xhtml";
                break;
            
        }
        try {
            
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + destino);
        } catch (IOException ex) {
            System.out.println("Error: "+ex);
        }
    }
}
