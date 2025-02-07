package com.example.swagger.dto;

import com.example.swagger.model.Category;
import jakarta.annotation.Nullable;

import java.util.List;
import java.util.Set;

public record BookResponseDto(
        String name ,
        AuthorDetailsDto authorDetails ,
        @Nullable List < CategoryDetailsDto > categories,
        @Nullable List < BookChildDetailsDto > bookChilds
) {
}
