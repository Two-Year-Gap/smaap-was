package com.example.smaap.presentation.rest;

import com.example.smaap.domain.region.service.RegionService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/regions")
@Tag(name = "Region", description = "지역 관련 API")
@RequiredArgsConstructor
public class RegionController {
    private final RegionService regionService;

    @GetMapping
    public ResponseEntity<?> list() {
        return ResponseEntity.ok(regionService.list());
    }
}
