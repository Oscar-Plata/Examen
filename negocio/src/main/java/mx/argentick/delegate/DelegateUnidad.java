/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.delegate;

import java.util.List;
import mx.argentick.entidad.Unidad;
import mx.argentick.integracion.ServiceLocator;

/**
 *
 * @author Oscar Plata <>
 */
public class DelegateUnidad {
    
    /**
     * Metodo de ejemplo para guardar Usuario
     * @param unidad
     * @return 
     */
    public int guardarUnidad(Unidad unidad){
        return ServiceLocator.getInstanceUnidadDAO().save(unidad);
    }
    
    /**
     * 
     * @param u 
     */
    public void actualizarUnidad(Unidad unidad){
        ServiceLocator.getInstanceUnidadDAO().update(unidad);
    }
    
    /**
     * 
     * @param valor
     * @param parametro
     * @return 
     */
    public List<Unidad> buscarPorParametro(String valor, String parametro){
        return ServiceLocator.getInstanceUnidadDAO().findByOneParameter(valor, parametro);
    }
    
    /**
     * 
     * @param i
     * @return 
     */
    public Unidad buscarPorId(int i){
        Unidad u = ServiceLocator.getInstanceUnidadDAO().find(i);
        return u;
    }
    
    /**
     * 
     * @return 
     */
    public List<Unidad> obtenerTodas(){
        return ServiceLocator.getInstanceUnidadDAO().findAll();
    }
    
    /**
     * 
     * @param profesor 
     */
    public void eliminarUnidad(Unidad unidad){
        ServiceLocator.getInstanceUnidadDAO().delete(unidad);
    }
    
}
