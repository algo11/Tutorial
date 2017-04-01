package com.uniminuto.ejercicio1.dao;

import com.uniminuto.ejercicio1.entityEjb.Parada;
import java.util.List;

public interface ParadaDao {

    Long insert(Parada parada);

    boolean delete(Long id);
    
    List<Parada> findParadaListByServicioId(Long ServicioId); 

}
