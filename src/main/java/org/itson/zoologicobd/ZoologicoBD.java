package org.itson.zoologicobd;

import java.util.ArrayList;
import java.util.Date;
import org.itson.dominio.Cuidador;
import org.itson.dominio.Especie;
import org.itson.dominio.Guia;
import org.itson.dominio.Zona;
import org.itson.persistencia.DAO.CuidadoresDAO;
import org.itson.persistencia.DAO.GuiasDAO;
import org.itson.persistencia.DAO.ZonaDAO;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public class ZoologicoBD {
    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        QuejaDAO dao = new QuejaDAO();
//        dao.guardarQueja("QUEJA", "correo", "telefono");
//
//        EspeciesDAO esp = new EspeciesDAO();
        Especie especie = new Especie("tigre", "felino", "felino tigre");
        Especie especie2 = new Especie("leon", "felino", "felino leon");
        Especie especie3 = new Especie("gato", "felino", "felino gato");
         ArrayList<Especie> especies = new ArrayList<>();
         especies.add(especie);
         especies.add(especie2);
         especies.add(especie3);
//        esp.agregar(especie);
//        esp.agregar(especie2);
//        esp.agregar(especie3);
//        esp.eliminar(especie);
//
//        ContinentesDAO cont = new ContinentesDAO();
//        Continente c = new Continente("america", "continente del lado oeste");
//        Continente c2 = new Continente("asia", "continente del lado este");
//        Continente c3 = new Continente("europa", "continente del lado este");
//        cont.agregar(c);
//        cont.agregar(c2);
//        cont.agregar(c3);
//        cont.eliminar(c2);
//        System.out.println(cont.consultarContinentes());
//
//        PersonasDAO per = new PersonasDAO();
        ArrayList<String> direcciones = new ArrayList<>();
        direcciones.add("direccion");
//        Persona pers = new Persona("hermann", direcciones, 61414141, new Date(2001, 5, 12));
//        Persona pers2 = new Persona("victor", direcciones, 343434, new Date(2023, 5, 12));
//        per.agregar(pers);
//        per.agregar(pers2);
//        per.eliminar(pers2);
//        System.out.println(per.consultarPersonas());

//        HabitatDAO hab = new HabitatDAO();
//        Habitat habt = new Habitat("junlga", "lluvioso", "jungla, arboles, plantas");
//        Habitat habt2 = new Habitat("deseirto", "seco", "flora de desierto");
//        List<Continente> continentes = new ArrayList<>();
//        continentes.add(c);
//        List<Continente> continentes2 = new ArrayList<>();
//        continentes2.add(c2);
//        habt2.setContinentes(continentes);
//        hab.agregar(habt);
//        hab.agregar(habt2);
//        System.out.println(hab.consultarHabitats());
//          ZonaDAO zz = new ZonaDAO();
//          Zona zona = new Zona("zona 1", 35f);
//          zona.setEspecies(especies);
//          zz.agregar(zona);
//         System.out.println( zz.consultarZonas());
//        CuidadoresDAO cuid = new CuidadoresDAO();
//        Cuidador cud = new Cuidador(null, "hermann", direcciones, 3434, new Date(2001, 5, 12), especies, especies, new Date(2001, 5, 12));
//        System.out.println(cuid.consultarCuidadores());
        GuiasDAO gdao = new GuiasDAO();
        Guia guia = new Guia(null, "salomon", direcciones, 343434, new Date(2023, 5, 12), null);
        System.out.println(gdao.consultarGuias());

    }
}
