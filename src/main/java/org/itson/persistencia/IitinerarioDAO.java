
package org.itson.persistencia;

public interface IitinerarioDAO {

    public void consultarItinerariosUltimoMes();

    public void consultarItinerarioFechaDia(String nombre);

    public void consultarItinerarioHora(String nombre);
}
