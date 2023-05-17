
package org.itson.persistencia;

import java.util.List;
import org.itson.dominio.Continente;
import org.itson.dominio.Habitat;
import org.itson.dominio.Zona;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface IZonaDAO {

    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo zona
     *
     * @param zona Objeto a agregar
     * @return El objeto zona agregado
     */
    public Zona agregar(Zona zona);

    /**
     * Método que elimina un objeto de tipo zona
     *
     * @param habitat Objeto a eliminar
     * @return El objeto Habitat eliminado
     */
    public Zona eliminar(Zona zona);

    /**
     * Método que crea una lista con todos los objetos zona creados
     *
     * @return La lista de objetos zona
     */
    public List<Zona> consultarZonas();

}
