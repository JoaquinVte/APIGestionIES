package com.ieslavereda.APIGestionIES.controllers;

import com.ieslavereda.APIGestionIES.dao.EstadoDao;
import com.ieslavereda.APIGestionIES.models.Estado;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EstadoController implements EstadoDao{

    @Autowired
    private EstadoDao estadoDao;

    @Override
    @RequestMapping(value="api/estados")
    public List<Estado> getEstados() {
        return estadoDao.getEstados();
    }
}
