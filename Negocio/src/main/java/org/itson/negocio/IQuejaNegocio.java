package org.itson.negocio;

public interface IQuejaNegocio {

    public void guardarQueja(String queja, String correoElectronico, String telefono);

    public void validacionQueja(String queja, String correoElectronico, String telefono);

}
