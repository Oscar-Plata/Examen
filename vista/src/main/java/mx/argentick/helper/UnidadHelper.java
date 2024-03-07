/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.helper;

import java.io.Serializable;
import java.util.List;
import mx.argentick.entidad.Unidad;
import mx.argentick.integracion.ServiceFacadeLocator;

/**
 *
 * @author Oscar Plata
 */
public class UnidadHelper implements Serializable {
    public int guardarUnidad(Unidad p){
        return ServiceFacadeLocator.getInstanceFacadeUnidad().guardarUnidad(p);       
    }
    
     public void actualizarUnidad(Unidad p){
         ServiceFacadeLocator.getInstanceFacadeUnidad().actualizarUnidad(p);
     }
     
     public List<Unidad> buscarPorParametro(String v, String p){
         return ServiceFacadeLocator.getInstanceFacadeUnidad().buscarPorParametro(v, p);
     }
     
    public Unidad buscarPorId(int i){
        return ServiceFacadeLocator.getInstanceFacadeUnidad().buscarPorId(i);
    }
    
    /**
     * 
     * @return 
     */
    public List<Unidad> obtenerTodas(){
        return ServiceFacadeLocator.getInstanceFacadeUnidad().obtenerTodas();
    }
    
    /**
     * 
     * @param unidad 
     */
    public void eliminarUnidad(Unidad unidad){
        ServiceFacadeLocator.getInstanceFacadeUnidad().eliminarUnidad(unidad);
    }
}
