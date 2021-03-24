package com.avance.service;

import com.avance.config.Utility;
import com.avance.dao.NaceDao;
import com.avance.dto.AddNaceDto;
import com.avance.error.SVCException;
import com.avance.model.Nace;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class NaceSvcImpl implements NaceSvc {
    private final Logger logger = LoggerFactory.getLogger(NaceSvcImpl.class);

    @Autowired
    private  NaceDao nacedao;


    @Override
    public Map<String, Object> addNace(AddNaceDto naceDto) {
        final String daoResponse;
        try {
            Nace nace = new Nace(naceDto.getOrder(), naceDto.getLevel(), naceDto.getCode(), naceDto.getParent(), naceDto.getDescription(), naceDto.getThisItemAlsoIncludes(), naceDto.getThisItemIncludes(), naceDto.getRulings(), naceDto.getThisItemExcludes(), naceDto.getReferenceToISICRev4());
            daoResponse = nacedao.addNace(nace);
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
            throw new SVCException("add nace object was unsuccessful", 500);
        }
        return new HashMap<String, Object>() {
            {
                put("statusCode", 200);
                put("message", daoResponse);
            }
        };
    }

    @Override
    public Map<String, Object> getNace(Long orderId) {
        final Nace daoResponse;
        try {
            daoResponse = nacedao.getNaceDetails(orderId);
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
            throw new SVCException("add nace object was unsuccessful", 500);
        }
        return new HashMap<String, Object>() {
            {
                put("statusCode", 200);
                put("message", "successful");
                put("data", daoResponse);
            }
        };
    }
}
