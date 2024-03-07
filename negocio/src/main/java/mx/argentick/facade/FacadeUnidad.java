/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.facade;

import java.util.List;
import mx.argentick.delegate.DelegateUnidad;
import mx.argentick.entidad.Unidad;

/**
 *
 * @author Oscar Plata <>
 */
public class FacadeUnidad {
    
    private final DelegateUnidad delegateUnidad;

    public FacadeUnidad() {
        this.delegateUnidad = new DelegateUnidad();
    }
    
    /**
     * Metodo de ejemplo para guardar una unidad
     * @param usuario de tipo usuario con id 0 para poder que se cree un id nuevo
     */
    public int guardarUnidad(Unidad unidad){
        return delegateUnidad.guardarUnidad(unidad);
    }
    
    /**
     * 
     * @param unidad 
     */
    public void actualizarUnidad(Unidad unidad){
        delegateUnidad.actualizarUnidad(unidad);
    }
    
    /**
     * 
     * @param valor
     * @param parametro
     * @return 
     */
    public List<Unidad> buscarPorParametro(String valor, String parametro){
        return delegateUnidad.buscarPorParametro(valor, parametro);
    }
    
    /**
     * 
     * @param i
     * @return 
     */
    public Unidad buscarPorId(int i){
        return delegateUnidad.buscarPorId(i);
    }
    
    /**
     * 
     * @return 
     */
    public List<Unidad> obtenerTodas(){
        return delegateUnidad.obtenerTodas();
    }
    
    /**
     * 
     * @param unidad 
     */
    public void eliminarUnidad(Unidad unidad){
        delegateUnidad.eliminarUnidad(unidad);
    }
}
