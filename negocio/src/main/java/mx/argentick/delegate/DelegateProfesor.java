/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.delegate;

import java.util.List;
import mx.argentick.entidad.Profesor;
import mx.argentick.integracion.ServiceLocator;

/**
 *
 * @author Oscar Plata
 */
public class DelegateProfesor {
    
    /**
     * Metodo de para guardar Profesor
     * @param profesor
     * @return  indicador de guardado
     */
    public int guardarProfesor(Profesor profesor){
        return ServiceLocator.getInstanceProfesorDAO().save(profesor);
    }
    
    /**
     * 
     * @param profesor 
     */
    public void actualizarProfesor(Profesor profesor){
        ServiceLocator.getInstanceProfesorDAO().update(profesor);
    }
    
    /**
     * 
     * @param valor
     * @param parametro
     * @return 
     */
    public List<Profesor> buscarPorParametro(String valor, String parametro){
        return ServiceLocator.getInstanceProfesorDAO().findByOneParameter(valor, parametro);
    }
    
    /**
     * 
     * @param i
     * @return 
     */
    public Profesor buscarPorId(int i){
        return ServiceLocator.getInstanceProfesorDAO().find(i);
    }
    
    /**
     * 
     * @return 
     */
    public List<Profesor> obtenerTodos(){
        return ServiceLocator.getInstanceProfesorDAO().findAll();
    }
    
    /**
     * 
     * @param profesor 
     */
    public void eliminarProfesor(Profesor profesor){
        ServiceLocator.getInstanceProfesorDAO().delete(profesor);
    }
    
    
    
}
