package com.uniminuto.ejercicio1.dao;

import com.uniminuto.ejercicio1.entityEjb.Servicio;

public interface ServicioDao {

    Long insert(Servicio servicio);

    boolean delete(Long id);
    
   Servicio findById(Long ServicioId); 

}
