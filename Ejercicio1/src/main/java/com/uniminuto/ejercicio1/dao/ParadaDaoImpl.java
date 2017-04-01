package com.uniminuto.ejercicio1.dao;

import com.uniminuto.ejercicio1.entityEjb.Parada;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.uniminuto.ejercicio1.entityEjb.Servicio;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import java.util.List;
import javax.persistence.Query;
import org.hibernate.HibernateException;
import org.hibernate.Transaction;

public class ParadaDaoImpl implements ParadaDao {

    @PersistenceContext(unitName = "movie-unit", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    @Override
    public Long insert(Parada parada) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        Long servicioID = null;
        try {
            tx = session.beginTransaction();
            servicioID = (Long) session.save(parada);
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return servicioID;
    }

    public boolean delete(Long id) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Parada p = (Parada) session.load(Parada.class, new Long(id));
            if (null != p) {
                session.delete(p);
            }

            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) {
                tx.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return true;
    }

    @Override
    public List<Parada> findParadaListByServicioId(Long ServicioId) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from Parada P where P.servicio.idServicio = :id ");
        query.setParameter("id", ServicioId);
        List<Parada> paradas = query.getResultList();
        return paradas;
    }



}
