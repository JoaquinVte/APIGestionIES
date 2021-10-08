package com.ieslavereda.APIGestionIES.dao;

import com.ieslavereda.APIGestionIES.models.Articulo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

@Repository
@Transactional
public class ArticuloDaoImp implements ArticuloDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Articulo> getArticulos(String username) {

//        String query = "FROM Articulo";
        String query = "SELECT A.idArticulo AS idArticulo, A.descripcion AS descripcion, A.ubicacion , A.estado FROM Articulo A INNER JOIN Departamento D ON A.departamento=D.idDepartamento INNER JOIN User U ON D.jdp=U.idUser where U.username=:username OR 'admin'=(SELECT idRol FROM User WHERE username=:username) ORDER BY A.idArticulo";
        List<Object[]> list = entityManager.createNativeQuery(query)
                .setParameter("username", username)
                .getResultList();

        List<Articulo> result = list.stream()
                .map(arr -> {
                    Articulo a = new Articulo.ArticuloBuilder()
                            .withIdArticulo((int) arr[0])
                            .withDescripcion((arr[1].toString()))
                            .withUbicacion((int) arr[2])
                            .withEstado((int)arr[3])
                            .build();

                    return a;
                })
                .collect(Collectors.toList());

        return result;
//        return entityManager.createQuery(query).getResultList();
    }

    @Override
    public Articulo getArticulo(int id) {
        return entityManager.find(Articulo.class, id);
    }

    @Override
    public boolean userCanEditItem(int id, String username) {
        List resultList = entityManager.createNativeQuery("SELECT COUNT(*) FROM Articulo A INNER JOIN Departamento D ON A.departamento=D.idDepartamento INNER JOIN User U ON D.jdp=U.idUser INNER JOIN Rol R ON R.idRol = U.idRol WHERE A.idArticulo= :id AND (U.username= :username OR 'admin'=(SELECT idRol FROM User WHERE username= :username))")
                .setParameter("id", id)
                .setParameter("username", username).getResultList();

        BigInteger cantidad = (BigInteger) resultList.get(0);

        return Objects.equals(cantidad, BigInteger.valueOf(1));
    }

    @Override
    public void registrar(Articulo articulo) {
        entityManager.merge(articulo);
    }

    @Override
    public boolean updateArticuloWithFoto(Articulo articulo) {

        int cantidad = entityManager.createNativeQuery("UPDATE Articulo SET ubicacion=:idUbicacion, estado=:idEstado, foto=:foto WHERE idArticulo=:idArticulo ")
                .setParameter("idUbicacion", articulo.getUbicacion())
                .setParameter("idEstado", articulo.getEstado())
                .setParameter("foto", articulo.getFoto())
                .setParameter("idArticulo", articulo.getIdArticulo())
                .executeUpdate();
        return cantidad == 1;
    }

    @Override
    public boolean updateArticuloWithoutFoto(Articulo articulo) {
        System.out.println("Sin foto");
        int cantidad = entityManager.createNativeQuery("UPDATE Articulo SET ubicacion=:idUbicacion, estado=:idEstado WHERE idArticulo=:idArticulo ")
                .setParameter("idUbicacion", articulo.getUbicacion())
                .setParameter("idEstado", articulo.getEstado())
                .setParameter("idArticulo", articulo.getIdArticulo())
                .executeUpdate();
        return cantidad == 1;
    }

    @Override
    public Byte[] getFotoArticulo(int idArticulo) {
        byte[] resultado = entityManager.find(Articulo.class, idArticulo).getFoto();
        if (resultado == null)
            return null;
        else {
            Byte[] foto = new Byte[resultado.length];
            int i = 0;
            for (byte b : resultado)
                foto[i++] = b;

            return foto;
        }
    }

    @Override
    public void eliminar(int id) {
        Articulo articulo = entityManager.find(Articulo.class, id);
        entityManager.remove(articulo);
    }
}
