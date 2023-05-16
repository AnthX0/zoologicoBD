package org.itson.zoologicobd;

import org.itson.dominio.Especie;
import org.itson.persistencia.EspeciesDAO;
import org.itson.persistencia.QuejaDAO;

/**
 * @author Victor
 */
public class ZoologicoBD {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        QuejaDAO dao = new QuejaDAO();
        dao.guardarQueja("QUEJA", "correo", "telefono");

        EspeciesDAO esp = new EspeciesDAO();
        Especie especie = new Especie("tigre", "felino", "felino tigre");
        Especie especie2 = new Especie("leon", "felino", "felino leon");
        Especie especie3 = new Especie("gato", "felino", "felino gato");
        esp.agregar(especie);
        esp.agregar(especie2);
        esp.agregar(especie3);
        esp.eliminar(especie);
        
        

    }
}