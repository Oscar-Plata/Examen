package mx.argentick.entidad;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import mx.argentick.entidad.Profesor;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2024-03-07T23:12:54")
@StaticMetamodel(Unidad.class)
public class Unidad_ { 

    public static volatile SingularAttribute<Unidad, Integer> horasLab;
    public static volatile SingularAttribute<Unidad, Integer> idUnidad;
    public static volatile SingularAttribute<Unidad, Integer> horasClase;
    public static volatile ListAttribute<Unidad, Profesor> profesorList;
    public static volatile SingularAttribute<Unidad, String> nombre;
    public static volatile SingularAttribute<Unidad, Integer> horasTaller;

}