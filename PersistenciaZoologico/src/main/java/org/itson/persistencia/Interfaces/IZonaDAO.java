
package org.itson.persistencia.Interfaces;

import java.util.List;
import org.itson.dominio.Zona;

/**
 * @author Victor, Henry, Hermann y Adán
 * @version IDE 17
 */
public interface IZonaDAO {
    // MÉTODOS
    /**
     * Método que agrega un objeto de tipo Zona
     * @param zona Objeto a agregar
     * @return El objeto Zona agregado
     */
    public Zona agregar(Zona zona);
    /**
     * Método que elimina un objeto de tipo Zona
     * @param zona Objeto a eliminar
     * @return El objeto Zona eliminado
     */
    public Zona eliminar(Zona zona);
    /**
     * Método que crea una lista con todos los objetos zona creados
     * @return La lista de objetos Zona
     */
    public List<Zona> consultarZonas();
}