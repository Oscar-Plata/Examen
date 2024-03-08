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
    public void navegarXHTML(String destino){
        try {
            FacesContext.getCurrentInstance().getExternalContext().redirect(FacesContext.getCurrentInstance().getExternalContext().getRequestContextPath() + destino);
        } catch (IOException ex) {
            System.out.println("Error: "+ex);
        }
    }
}
