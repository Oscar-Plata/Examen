/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import mx.argentick.DAO.ProfesorDAO;
import mx.argentick.DAO.UnidadDAO;
import mx.argentick.entidad.Profesor;
import mx.argentick.entidad.Unidad;

/**
 *
 * @author Lenovo PC
 */
public class test {

    public static void main(String[] args) {
        ProfesorDAO profDAO = new ProfesorDAO();
        UnidadDAO uniDAO = new UnidadDAO();
        
        System.out.println(profDAO.findAll());
        System.out.println(uniDAO.findAll());
//        List<Unidad> u = uniDAO.findByOneParameter("historia", "nombre");
////        System.out.println(u);
//        Unidad uu = u.get(0);
////        List<Profesor> p = profDAO.findByOneParameter("Oscar", "nombre");
////        Profesor pp=p.get(0);
////          Profesor  pp = new Profesor();
////          pp.setNombre("chucho");
////          pp.setApellidos("sisus");
////        pp.setRfc("michucho");
////          pp.setIdProfesor(0);
////          pp.setUnidadList(new ArrayList<>(0));
////        System.out.println("PRoF NEW: "+pp);
////        profDAO.save(pp);
//
//        List<Profesor> p = profDAO.findByOneParameter("chucho", "nombre");
//        Profesor pp = p.get(0);
//        pp.setApellidos("SISUS");
//
//        List<Unidad> aux = pp.getUnidadList();
////        System.out.println("Unidad asiganadas: "+aux);
//        aux.add(uu);
////        System.out.println("Unidad Act: "+ aux);
//        pp.setUnidadList(aux);
//        System.out.println("Prof uns: " + pp.getUnidadList());
//
//        List<Profesor> uax = uu.getProfesorList();
//        uax.add(pp);
//        uu.setProfesorList(uax);
//        System.out.println("Uns uax: " + uu.getProfesorList());
//        //uniDAO.update(uu);
//        profDAO.update(pp);
//        System.out.println("Actualizado");

    }
}
