package com.ieslavereda.APIGestionIES.controllers;

import com.ieslavereda.APIGestionIES.dao.UbicacionesDao;
import com.ieslavereda.APIGestionIES.models.Ubicacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class UbicacionesController implements UbicacionesDao{

    @Autowired
    private UbicacionesDao ubicacionesDao;

    @Override
    @RequestMapping(value="api/ubicaciones")
    public List<Ubicacion> getUbicaciones() {
        return ubicacionesDao.getUbicaciones();
    }
}
