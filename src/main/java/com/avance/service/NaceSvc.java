package com.avance.service;

import com.avance.dto.AddNaceDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface NaceSvc {
    Map<String,Object> addNace(AddNaceDto naceDto);
    Map<String,Object> getNace(Long orderId);
}
