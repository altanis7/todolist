package com.minlab.todolist.service;

import com.minlab.todolist.dto.TodoDTO;
import com.minlab.todolist.model.TodoEntity;
import com.minlab.todolist.repository.TodoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public boolean create(final TodoDTO dto)
    {
        try {
            TodoEntity entity = new TodoEntity();

            entity.setId(dto.getId());
            entity.setTitle(dto.getTitle());
            entity.setIsdone(dto.getDone());

            repository.save(entity);

            log.info("Entity ID : {} is saved.", entity.getId());

            return true;
        } catch (Exception e)
        {
            log.info("Create Error : {} ", e);
            return false;
        }
    }

    public boolean update(final TodoDTO dto)
    {
        try {
            // (2) 넘겨받은 엔티티 id를 이용해 TodoEntity를 가져온다. 존재하지 않는 엔티티는 업데이트할 수 없기 때문이다.
            Optional<TodoEntity> original = repository.findById(dto.getId());

            if (original.isPresent()) {
                final TodoEntity newtodo = original.get();
                newtodo.setTitle(dto.getTitle());
                newtodo.setIsdone(dto.getDone());

                // (4) 데이터베이스에 새 값을 저장한다.
                repository.save(newtodo);
            }

            // Retrieve Todoo 에서 만든 메서드를 이용해 사용자의 모든 Todoo 리스트를 리턴한다.
            return true;
        } catch (Exception e)
        {
            log.info("Update Error {}", e);
            return false;
        }
    }

    public boolean titleUpdate(final TodoDTO dto)
    {
        try {
            // (2) 넘겨받은 엔티티 id를 이용해 TodoEntity를 가져온다. 존재하지 않는 엔티티는 업데이트할 수 없기 때문이다.
            Optional<TodoEntity> original = repository.findById(dto.getId());

            if (original.isPresent()) {
                final TodoEntity newtodo = original.get();
                newtodo.setTitle(dto.getTitle());

                // (4) 데이터베이스에 새 값을 저장한다.
                repository.save(newtodo);
            }

            // Retrieve Todoo 에서 만든 메서드를 이용해 사용자의 모든 Todoo 리스트를 리턴한다.
            return true;
        } catch (Exception e)
        {
            log.info("title_Update Error {}", e);
            return false;
        }
    }

    public boolean statusUpdate(final TodoDTO dto)
    {
        try {
            // (2) 넘겨받은 엔티티 id를 이용해 TodoEntity를 가져온다. 존재하지 않는 엔티티는 업데이트할 수 없기 때문이다.
            Optional<TodoEntity> original = repository.findById(dto.getId());

            if (original.isPresent()) {
                final TodoEntity newtodo = original.get();
                newtodo.setIsdone(dto.getDone());

                // (4) 데이터베이스에 새 값을 저장한다.
                repository.save(newtodo);
            }

            // Retrieve Todoo 에서 만든 메서드를 이용해 사용자의 모든 Todoo 리스트를 리턴한다.
            return true;
        } catch (Exception e)
        {
            log.info("done_Update Error {}", e);
            return false;
        }
    }


    public boolean deleteById(final Integer id)
    {
        try
        {
            Optional<TodoEntity> original = repository.findById(id);

            if (original.isPresent()) {
                final TodoEntity newtodo = original.get();

                repository.delete(newtodo);
            }

            return true;
        }
        catch(Exception e)
        {
            // (3) exception 발생 시 exception 을 로깅한다.
            log.error("error deleting entity ", e);

            return false;
        }
    }

    public boolean deleteAll()
    {
        try {
            repository.deleteAll();
            return true;
        } catch (Exception e)
        {
            log.info("deleteall error {}", e);
            return false;
        }
    }

    public List<TodoDTO> searchAll()
    {
        List<TodoEntity> entities = repository.findAll();

        List<TodoDTO> dtosFor = new ArrayList<>();
        for(TodoEntity te : entities){
            TodoDTO dto = new TodoDTO(te);
            dtosFor.add(dto);
        }

        return dtosFor;
    }

    public TodoDTO searchByID(final Integer id)
    {
        Optional<TodoEntity> entity = repository.findById(id);

        TodoDTO dto = new TodoDTO();
        if(entity.isPresent() ) {

            dto.setId(entity.get().getId());
            dto.setTitle(entity.get().getTitle());
            dto.setDone(entity.get().getIsdone());
        }

        TodoDTO.builder()
                .id(entity.get().getId())
                .title(entity.get().getTitle())
                .done(entity.get().getIsdone())
                .build();

        return dto;
    }

}
