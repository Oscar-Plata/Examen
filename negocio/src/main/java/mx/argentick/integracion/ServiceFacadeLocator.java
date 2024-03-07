/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.integracion;

import mx.argentick.facade.FacadeProfesor;
import mx.argentick.facade.FacadeUnidad;

/**
 *
 * @author Oscar Plata <>
 */
public class ServiceFacadeLocator {
    
    private static FacadeUnidad facadeUnidad;
    private static FacadeProfesor facadeProfesor;
    
    public static FacadeUnidad getInstanceFacadeUnidad() {
        if (facadeUnidad == null) {
            facadeUnidad = new FacadeUnidad();
            return facadeUnidad;
        } else {
            return facadeUnidad;
        }
    }
    
    public static FacadeProfesor getInstanceFacadeProfesor() {
        if (facadeProfesor == null) {
            facadeProfesor = new FacadeProfesor();
            return facadeProfesor;
        } else {
            return facadeProfesor;
        }
    }
}
