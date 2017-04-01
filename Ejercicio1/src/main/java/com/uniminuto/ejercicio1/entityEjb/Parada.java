package com.uniminuto.ejercicio1.entityEjb;

/**
 * Created by yeimmy canon on 27/09/2016.
 */
import javax.persistence.*;


@Entity
@Table(name="Parada")
public class Parada {

    @Id
    @Column(name="id_parada")
    private Long idParada;

    @Column(name="nombre")
    private String nombre;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="servicio_id")
    private Servicio servicio;

    public Parada() {

    }

    public Long getIdParada() {
        return idParada;
    }

    public void setIdParada(Long idParada) {
        this.idParada = idParada;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }
}
