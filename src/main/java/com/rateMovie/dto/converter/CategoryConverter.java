package com.rateMovie.dto.converter;

import com.rateMovie.dto.CategoryDto;
import com.rateMovie.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryConverter {

    public CategoryDto toDto(Category category){
        return new CategoryDto(category.getCategory_name());
    }

}
