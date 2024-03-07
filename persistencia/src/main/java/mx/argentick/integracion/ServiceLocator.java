/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.argentick.integracion;

import mx.argentick.DAO.ProfesorDAO;
import mx.argentick.DAO.UnidadDAO;


/**
 *
 * @author total
 */
public class ServiceLocator {
    
    private static ProfesorDAO profesorDAO;
    private static UnidadDAO unidadDAO;
    /**
     * se crea la instancia para alumno DAO si esta no existe
     */
    public static ProfesorDAO getInstanceProfesorDAO(){
        if(profesorDAO == null){
            profesorDAO = new ProfesorDAO();
            return profesorDAO;
        } else{
            return profesorDAO;
        }
    }
    /**
     * se crea la instancia de unidadDAO si esta no existe
     */
    public static UnidadDAO getInstanceUnidadDAO(){
        if(unidadDAO == null){
            unidadDAO = new UnidadDAO();
            return unidadDAO;
        } else{
            return unidadDAO;
        }
    }
    
}
