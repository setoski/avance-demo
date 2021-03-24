package com.avance.controller;

import com.avance.config.Utility;
import com.avance.dto.AddNaceDto;
import com.avance.dto.GetNaceDto;
import com.avance.error.CTRLException;
import com.avance.service.NaceSvc;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class NaceCtrl {
    private final Logger logger = LoggerFactory.getLogger(NaceCtrl.class);
    private final NaceSvc nacesvc;
    private final Utility utility;

    public NaceCtrl(NaceSvc naceSvc, Utility utility) {
        this.nacesvc = naceSvc;
        this.utility = utility;
    }

    @Async
    @PostMapping(value = "/add-nace", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Object>> addNace(@Valid @RequestBody(required = true) AddNaceDto addNaceDto) {
        Map<String, Object> svcResponse;
        try {
            svcResponse = nacesvc.addNace(addNaceDto);
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
            Map<String, Object> exMsg = new HashMap<String, Object>() {
                {
                    put("message", "add nace object was unsuccessful");
                    put("status", 500);
                }
            };
            throw new CTRLException("add nace object was unsuccessful", 500);
        }
        return ResponseEntity.status(200).body(svcResponse);
    }

    @Async
    @GetMapping(value = "/get-nace", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Map<String, Object>> getNace(@RequestBody(required = true) GetNaceDto getNaceDto) {
        try {
            Map<String, Object> map = nacesvc.getNace(getNaceDto.getOrderId());
            return ResponseEntity.status(200).body(map);
        } catch (Exception ex) {
            logger.error(ex.getLocalizedMessage());
            Map<String, Object> exMsg = new HashMap<String, Object>() {
                {
                    put("message", "get nace object was unsuccessful");
                    put("status", 500);
                }
            };
            throw new CTRLException("get nace object was unsuccessful", 500);
        }
    }
}
