package com.example.smaap.presentation.rest;

import com.example.smaap.application.sales.dto.SalesDto;
import com.example.smaap.application.sales.service.SalesService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sales")
@Tag(name = "Sales", description = "카드 데이터를 활용한 매출 관련 API")
@RequiredArgsConstructor
public class SalesController {
    private final SalesService salesService;

    @GetMapping
    public ResponseEntity<?> read(@RequestParam Integer year,
                                  @RequestParam(name = "neiborhood_id") Long neighborhoodId,
                                  @RequestParam(name = "business_id", required = false) Long businessId
    ) {
        SalesDto.Request dto = SalesDto.Request.builder()
                .year(year)
                .neighborhoodId(neighborhoodId)
                .businessId(businessId)
                .build();

        return ResponseEntity.ok(salesService.read(dto));

    }
}
