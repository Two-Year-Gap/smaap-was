package com.example.smaap.presentation.res;

import com.example.smaap.domain.school.service.SchoolService;
import com.example.smaap.domain.school.type.SchoolGenderType;
import com.example.smaap.domain.school.type.SchoolType;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/school")
@Tag(name = "School", description = "학교 정보 API")
@RequiredArgsConstructor
public class SchoolController {
    private final SchoolService schoolService;

    @GetMapping
    @Operation(summary = "학교 목록 조회", description = "학교 목록을 조회합니다.")
    @ApiResponse(responseCode = "200", description = "학교 목록 조회 성공")
    public ResponseEntity<?> list(@RequestParam(required = false) String name,
                                  @RequestParam(required = false) String address,
                                  @RequestParam(required = false) SchoolType type,
                                  @RequestParam(required = false) SchoolGenderType gender) {
        return ResponseEntity.ok(schoolService.list(name, address, type, gender));
    }
}
