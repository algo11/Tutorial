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

public class ServicioDaoImpl implements ServicioDao {

    @PersistenceContext(unitName = "movie-unit", type = PersistenceContextType.EXTENDED)
    private EntityManager em;

    public Long insert(Servicio servicio) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Transaction tx = null;
        Long servicioID = null;
        try {
            tx = session.beginTransaction();
            servicioID = (Long) session.save(servicio);
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
            Servicio p = (Servicio) session.load(Servicio.class, new Long(id));
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
    public Servicio findById(Long ServicioId) {
        SessionFactory sf = HibernateUtil.getSessionFactory();
        Session session = sf.openSession();
        Query query = session.createQuery("from Servicio S where S.idServicio = :id ");
        query.setParameter("id", ServicioId);
        Servicio servicio = (Servicio) query.getSingleResult();
        return servicio;
    }


}
