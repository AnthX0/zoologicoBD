package org.itson.zoologicobd;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.itson.dominio.Continente;
import org.itson.dominio.Especie;
import org.itson.dominio.Persona;
import org.itson.persistencia.ContinentesDAO;
import org.itson.persistencia.EspeciesDAO;
import org.itson.persistencia.PersonasDAO;
import org.itson.persistencia.QuejaDAO;

/**
 * @author Victor
 */
public class ZoologicoBD {
    public static void main(String[] args) {
        System.out.println("Hello World!");
//        QuejaDAO dao = new QuejaDAO();
//        dao.guardarQueja("QUEJA", "correo", "telefono");
//
//        EspeciesDAO esp = new EspeciesDAO();
//        Especie especie = new Especie("tigre", "felino", "felino tigre");
//        Especie especie2 = new Especie("leon", "felino", "felino leon");
//        Especie especie3 = new Especie("gato", "felino", "felino gato");
//        esp.agregar(especie);
//        esp.agregar(especie2);
//        esp.agregar(especie3);
//        esp.eliminar(especie);
//        
//          ContinentesDAO cont = new ContinentesDAO();
//          Continente c = new Continente("america", "continente del lado oeste");
//          Continente c2 = new Continente("asia", "continente del lado este");
//          Continente c3 = new Continente("europa", "continente del lado este");
//          cont.agregar(c);
//          cont.agregar(c2);
//          cont.agregar(c3);
//          cont.eliminar(c2);
//          System.out.println(cont.consultarContinentes());
//          
        PersonasDAO per = new PersonasDAO();
//        ArrayList<String> direcciones = new ArrayList<>();
//        direcciones.add("direccion");
//        Persona pers = new Persona("hermann", direcciones, 61414141, new Date(2001, 5, 12));
//        Persona pers2 = new Persona("victor", direcciones, 343434, new Date(2023, 5, 12));
//        per.agregar(pers);
//        per.agregar(pers2);
//        per.eliminar(pers2);
          System.out.println(per.consultarPersonas());

        

    }
}