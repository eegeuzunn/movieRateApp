package com.rateMovie.dto.converter;

import com.rateMovie.dto.CommentDto;
import com.rateMovie.model.Comment;
import org.springframework.stereotype.Component;

@Component
public class CommentConverter {

    public CommentDto toDto(Comment from){
        return new CommentDto(
                from.getComment(),
                from.getComment_datetime(),
                from.getRate_point(),
                from.getId()
        );
    }
}
