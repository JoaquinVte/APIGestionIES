package com.ieslavereda.APIGestionIES.controllers;

import com.ieslavereda.APIGestionIES.dao.ArticuloDao;
import com.ieslavereda.APIGestionIES.models.Articulo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ArticuloController implements ArticuloDao {

    @Autowired
    private ArticuloDao articuloDao;

    @RequestMapping(value = "api/articulos/{id}")
    public Articulo getArticulo(@PathVariable int id) {
        return articuloDao.getArticulo(id);
    }

    @RequestMapping(value = "api/articulos/", method = RequestMethod.POST)
    public boolean updateArticuloWithFoto(Articulo articulo) {
        if (articulo.getFoto() != null) return articuloDao.updateArticuloWithFoto(articulo);
        else return articuloDao.updateArticuloWithoutFoto(articulo);
    }

    @RequestMapping(value = "api/articulos/updatewithoutfoto", method = RequestMethod.POST)
    public boolean updateArticuloWithoutFoto(@RequestBody Articulo articulo) {
        return articuloDao.updateArticuloWithoutFoto(articulo);
    }

    @Override
    @RequestMapping(value = "api/articulos/foto/{id}")
    public Byte[] getFotoArticulo(@PathVariable int id) {
        return articuloDao.getFotoArticulo(id);
    }

    @RequestMapping(value = "api/articulos", method = RequestMethod.GET)
    public List<Articulo> getArticulos(@RequestParam(value = "username") String username) {
        return articuloDao.getArticulos(username);
    }

    @RequestMapping(value = "api/articulos/editable/{id}")
    public boolean userCanEditItem(@PathVariable int id, @RequestParam(value = "username") String username) {
        return articuloDao.userCanEditItem(id, username);
    }

    @RequestMapping(value = "api/articulos", method = RequestMethod.POST)
    public void registrar(@RequestBody Articulo articulo) {
        articuloDao.registrar(articulo);
    }

    @RequestMapping(value = "api/articulos/{id}", method = RequestMethod.DELETE)
    public void eliminar(@PathVariable int id) {
        articuloDao.eliminar(id);
    }
}
