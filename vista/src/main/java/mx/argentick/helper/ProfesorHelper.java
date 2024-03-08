/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.helper;

import java.io.Serializable;
import java.util.List;
import mx.argentick.entidad.Profesor;
import mx.argentick.integracion.ServiceFacadeLocator;

/**
 *
 * @author Oscar Plata
 */
public class ProfesorHelper implements Serializable{
    public int guardarProfesor(Profesor p){
        return ServiceFacadeLocator.getInstanceFacadeProfesor().guardarProfesor(p);       
    }
    
     public void actualizarProfesor(Profesor p){
         ServiceFacadeLocator.getInstanceFacadeProfesor().actualizarProfesor(p);
     }
     
     public List<Profesor> buscarPorParametro(String v, String p){
         return ServiceFacadeLocator.getInstanceFacadeProfesor().buscarPorParametro(v, p);
     }
     
    public Profesor buscarPorId(int i){
        return ServiceFacadeLocator.getInstanceFacadeProfesor().buscarPorId(i);
    }
    
    /**
     * 
     * @return 
     */
    public List<Profesor> obtenerTodos(){
        return ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerTodos();
    }
    
    /**
     * 
     * @param profesor 
     */
    public void eliminarProfesor(Profesor profesor){
        ServiceFacadeLocator.getInstanceFacadeProfesor().eliminarProfesor(profesor);
    }
    
    /**
     * 
     * @return 
     */
    public List<Profesor> obtenerTodosOrden(){
        return ServiceFacadeLocator.getInstanceFacadeProfesor().obtenerTodosOrden();
    }
}
