package com.avance.dao;

import com.avance.config.Utility;
import com.avance.error.DAOException;
import com.avance.model.Nace;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class NaceDaoImpl implements NaceDao {
    private final Logger logger = LoggerFactory.getLogger(NaceDaoImpl.class);

    @Autowired
    SessionFactory sessionFactory;


    @Override
    public String addNace(Nace nace) throws DAOException {
        String queryResult;
        Session session = sessionFactory.openSession();
        try {
            session.beginTransaction();
            session.save(nace);
            session.getTransaction().commit();
            queryResult = "nace object has been created successfully";
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
            throw new DAOException("create nace object was unsuccessful", 500);
        }
        if (session.isOpen()) {
            session.close();
        }
        return queryResult;
    }

    @Override
    public Nace getNaceDetails(Long orderId) throws DAOException {
        Nace queryResult;
        try {
            Session session = sessionFactory.openSession();
            TypedQuery<Nace> query = session.createNamedQuery("getNaceByOrderId", Nace.class);
            query.setParameter("orderId", orderId);
            queryResult = query.getSingleResult();
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
            throw new DAOException("Retrieve nace object was unsuccessful",500);
        }
        return queryResult;
    }
}
