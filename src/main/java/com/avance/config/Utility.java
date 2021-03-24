package com.avance.config;

import com.avance.error.UtilityException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class Utility {
    private final Logger logger = LoggerFactory.getLogger(Utility.class);

    public String mapToJsonString(Map<String, Object> map) {
        ObjectMapper mapper = new ObjectMapper();
        String strValue = null;
        try {
            strValue = mapper.writeValueAsString(map);
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
            throw new UtilityException("Map to json string was unsuccessful", 500);
        }
        return strValue;
    }
}
