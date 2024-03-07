package mx.argentick.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.argentick.entidad.Unidad;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-06T13:30:22")
@StaticMetamodel(Profesor.class)
public class Profesor_ { 

    public static volatile SingularAttribute<Profesor, String> apellidos;
    public static volatile SingularAttribute<Profesor, Integer> idProfesor;
    public static volatile ListAttribute<Profesor, Unidad> unidadList;
    public static volatile SingularAttribute<Profesor, String> nombre;
    public static volatile SingularAttribute<Profesor, String> rfc;

}