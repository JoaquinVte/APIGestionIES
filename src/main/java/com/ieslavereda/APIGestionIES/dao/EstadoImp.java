package com.ieslavereda.APIGestionIES.dao;

import com.ieslavereda.APIGestionIES.models.Estado;
import com.ieslavereda.APIGestionIES.models.Ubicacion;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class EstadoImp implements EstadoDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Estado> getEstados() {

        String query = "FROM Estado";
        return entityManager.createQuery(query).getResultList();
    }
}
