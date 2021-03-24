package com.avance.dao;

import com.avance.error.DAOException;
import com.avance.model.Nace;

import java.util.concurrent.CompletableFuture;

public interface NaceDao {
    String addNace(Nace nace) throws DAOException;

    Nace getNaceDetails(Long orderId) throws DAOException;
}
