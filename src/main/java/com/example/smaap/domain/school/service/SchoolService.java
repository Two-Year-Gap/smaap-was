package com.example.smaap.domain.school.service;

import com.example.smaap.domain.school.entity.QSchool;
import com.example.smaap.domain.school.entity.School;
import com.example.smaap.domain.school.repository.SchoolRepository;
import com.example.smaap.domain.school.type.SchoolGenderType;
import com.example.smaap.domain.school.type.SchoolType;
import com.querydsl.core.BooleanBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolService {
    private final SchoolRepository schoolRepository;

    public List<School> list(String name, String address, SchoolType type, SchoolGenderType gender) {
        QSchool school = QSchool.school;
        BooleanBuilder builder = new BooleanBuilder();

        if (name != null && !name.isEmpty()) {
            builder.and(school.name.containsIgnoreCase(name));
        }

        if (type != null) {
            builder.and(school.type.eq(type));
        }

        if (gender != null) {
            builder.and(school.gender.eq(gender));
        }

        if (address != null && !address.isEmpty()) {
            builder.and(school.lotNumberAddress.containsIgnoreCase(address)
                    .or(school.readNameAddress.containsIgnoreCase(address)));
        }

        return (List<School>) schoolRepository.findAll(builder);
    }
}
