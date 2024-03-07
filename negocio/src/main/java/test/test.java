/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;
import java.util.List;
import mx.argentick.entidad.Profesor;
import mx.argentick.entidad.Unidad;
import mx.argentick.integracion.ServiceFacadeLocator;

/**
 *
 * @author Lenovo PC
 */
public class test {
    public static void main(String[] args) {
        List<Unidad> unis= ServiceFacadeLocator.getInstanceFacadeUnidad().obtenerTodas();
        Profesor profs =ServiceFacadeLocator.getInstanceFacadeProfesor().buscarPorId(1);
        System.out.println(profs);
    }
}
