package com.ieslavereda.APIGestionIES.dao;

import com.ieslavereda.APIGestionIES.models.Articulo;
import com.ieslavereda.APIGestionIES.models.Estado;
import com.ieslavereda.APIGestionIES.models.Ubicacion;

import java.util.List;
import java.util.Map;

public interface ArticuloDao {
    List<Articulo> getArticulos(String username);
    Articulo getArticulo(int id);
    boolean updateArticuloWithFoto(Articulo articulo);
    boolean updateArticuloWithoutFoto(Articulo articulo);
    Byte[] getFotoArticulo(int idArticulo);
    void eliminar(int id);
    boolean userCanEditItem(int id, String username);
    void registrar(Articulo articulo);
}
