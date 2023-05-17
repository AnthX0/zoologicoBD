
package org.itson.persistencia.DAO;

import org.itson.persistencia.*;
import com.mongodb.client.MongoDatabase;
import java.util.List;
import org.itson.dominio.Especie;
import org.itson.dominio.Habitat;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import java.util.ArrayList;
import org.bson.Document;
import org.itson.dominio.Persona;
import org.itson.dominio.Zona;
import org.itson.persistencia.Interfaces.IEspeciesDAO;

/**
 *
 * @author DELL User
 */
public class EspeciesDAO implements IEspeciesDAO {

    private ConexionMongoDB conexion;
    private MongoDatabase baseDatos;

    public EspeciesDAO() {
        // Obtener la conexión y la base de datos previamente establecidas
        ConexionMongoDB conexion = ConexionMongoDB.instance();
        baseDatos = conexion.getBaseDatos();
    }

    @Override
    public Especie agregar(Especie especie) {
        // Obtener la colección donde se guardarán las especies
        MongoCollection<Document> collection = baseDatos.getCollection("especie");

        // Crear un nuevo documento con los datos de la especie
        Document especieDocument = new Document();
        especieDocument.append("nombre", especie.getNombre())
                .append("nombreCientifico", especie.getNombreCientifico())
                .append("descripcion", especie.getDescripcion())
                .append("habitats", especie.getHabitats())
                .append("zonas", especie.getZonas())
                .append("cuidadores", especie.getCuidadores());

        // Insertar el documento en la colección
        collection.insertOne(especieDocument);

        return especie;
    }

    @Override
    public Especie eliminar(Especie especie) {
        // Obtener la colección donde se guardan las especies
        MongoCollection<Document> collection = baseDatos.getCollection("especie");

        // Crear un filtro para encontrar la especie por su ID
        Document filtro = new Document("nombre", especie.getNombre());
        // Eliminar la especie de la colección
        collection.deleteOne(filtro);

        // Devolver la especie eliminada
        return especie;
    }

    @Override
    public List<Especie> consultarEspecies() {
       // Obtener la colección donde se guardan las especies
        MongoCollection<Document> collection = baseDatos.getCollection("especie");

        // Crear una lista para almacenar las especies consultadas
        List<Especie> especies = new ArrayList<>();

        // Obtener un cursor para iterar sobre los documentos de la colección
        MongoCursor<Document> cursor = collection.find().iterator();

        // Recorrer los documentos y convertirlos a objetos Especie
        while (cursor.hasNext()) {
            Document documento = cursor.next();
            Especie especie = new Especie();
            especie.setId(documento.getObjectId("_id"));
            especie.setNombre(documento.getString("nombre"));
            especie.setNombreCientifico(documento.getString("nombreCientifico"));
            especie.setDescripcion(documento.getString("descripcion"));
            especie.setHabitats(documento.getList("habitats", Habitat.class));
            especie.setZonas(documento.getList("zonas", Zona.class));
            especie.setCuidadores(documento.getList("cuidadores", Persona.class));
            especies.add(especie);
        }

        // Cerrar el cursor
        cursor.close();

        // Devolver la lista de especies consultadas
        return especies;
    }

    @Override
    public List<Especie> consultarEspeciesPorHabitat(List<Habitat> habitats) {
      // Obtener la colección donde se guardan las especies
        MongoCollection<Document> collection = baseDatos.getCollection("especie");

        // Crear una lista para almacenar las especies consultadas
        List<Especie> especies = new ArrayList<>();

        // Crear un filtro para buscar especies que tengan los hábitats especificados
        List<String> habitatIds = new ArrayList<>();
        for (Habitat habitat : habitats) {
            String habitatId = habitat.getId().toString();
            habitatIds.add(habitatId);
        }
        Document filtro = new Document("habitats", new Document("$in", habitatIds));

        // Obtener un cursor para iterar sobre los documentos que cumplen con el filtro
        MongoCursor<Document> cursor = collection.find(filtro).iterator();

        // Recorrer los documentos y convertirlos a objetos Especie
        while (cursor.hasNext()) {
            Document documento = cursor.next();
            Especie especie = new Especie();
            especie.setId(documento.getObjectId("_id"));
            especie.setNombre(documento.getString("nombre"));
            especie.setNombreCientifico(documento.getString("nombreCientifico"));
            especie.setDescripcion(documento.getString("descripcion"));
            especie.setHabitats(documento.getList("habitats", Habitat.class));
            especie.setZonas(documento.getList("zonas", Zona.class));
            especie.setCuidadores(documento.getList("cuidadores", Persona.class));
            especies.add(especie);
        }

        // Cerrar el cursor
        cursor.close();

        // Devolver la lista de especies consultadas
        return especies;
    }

    

}
