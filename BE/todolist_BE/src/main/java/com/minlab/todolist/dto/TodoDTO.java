package com.minlab.todolist.dto;

import com.minlab.todolist.model.TodoEntity;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TodoDTO {
    @NotNull
    @ApiModelProperty(example = "Integer (id - 프라이머리 키, 수정불가 값)")
    private Integer id;
    @NotNull
    @ApiModelProperty(example = "String (Todolist 내용)")
    private String title;
    @ApiModelProperty(example = "boolean (true/false - Todolist 내용)")
    private Boolean done = false;

    public TodoDTO(final TodoEntity entity)
    {
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.done = entity.getIsdone();
    }

    public static TodoEntity toEntity(final TodoDTO dto)
    {
        return TodoEntity.builder()
                .id(dto.getId())
                .title(dto.getTitle())
                .isdone(dto.getDone())
                .build();
    }

}
