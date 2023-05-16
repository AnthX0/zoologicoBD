package org.itson.negocio;

public interface IitinerarioNegocio {

    public void buscarItinerarioUltimoMes();

    public void buscarItinerarioFechaDia();

    public void buscarItinerarioHora();

    public void llenarListaItinerarios(String nombre);

    public void llenarListaItinerariosFechaDia(String fecha, String dia);

    public void llenarListaItinerariosHora(String hora);
}
