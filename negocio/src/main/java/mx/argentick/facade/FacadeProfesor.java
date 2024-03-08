/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.facade;

import java.util.List;
import mx.argentick.delegate.DelegateProfesor;
import mx.argentick.entidad.Profesor;

/**
 *
 * @author Oscar Plata <>
 */
public class FacadeProfesor {
    
    private final DelegateProfesor delegateProfesor;

    public FacadeProfesor() {
        this.delegateProfesor = new DelegateProfesor();
    }
    
    /**
     * 
     * @param profesor 
     * @return  
     */
    public int guardarProfesor(Profesor profesor){
        return delegateProfesor.guardarProfesor(profesor);
    }
    
    /**
     * 
     * @param profesor 
     */
    public void actualizarProfesor(Profesor profesor){
        delegateProfesor.actualizarProfesor(profesor);
    }
    
    /**
     * 
     * @param valor
     * @param parametro
     * @return 
     */
    public List<Profesor> buscarPorParametro(String valor, String parametro){
        return delegateProfesor.buscarPorParametro(valor, parametro);
    }
    
    /**
     * 
     * @param i
     * @return 
     */
    public Profesor buscarPorId(int i){
        return delegateProfesor.buscarPorId(i);
    }
    
    /**
     * 
     * @return 
     */
    public List<Profesor> obtenerTodos(){
        return delegateProfesor.obtenerTodos();
    }
    
    /**
     * 
     * @param profesor 
     */
    public void eliminarProfesor(Profesor profesor){
        delegateProfesor.eliminarProfesor(profesor);
    }
    
    /**
     * 
     * @return 
     */
    public List<Profesor> obtenerTodosOrden(){
        return delegateProfesor.obtenerTodosOrden();
    }
}
