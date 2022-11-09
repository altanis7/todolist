package com.minlab.todolist.controller;

import com.minlab.todolist.dto.TodoDTO;
import com.minlab.todolist.service.TodoService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("todo")
public class TodoController {

    @Autowired
    private TodoService service;

    @PostMapping("create")
    @ApiOperation(value = "TodoList 생성", notes = "title(내용)과 done(완료상태) 값을 받아 todolist를 생성한다.")
    public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto)
    {
        boolean create = service.create(dto);

//        // (5) 자바 스트림을 이용해 리턴된 엔티티 리스트를 TodoDTO 리스트로 변환한다.
//        List<TodoDTO> dtos = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
//
////            List<TodoDTO> dtosFor = new ArrayList<>();
////            for(TodoEntity te : entities){
////                TodoDTO tdt = new TodoDTO(te);
////                dtosFor.add(tdt);
////            }

        // (6) 변환된 TodoDTO 리스트를 이용해 ResponseDTO를 초기화한다.

        // (7) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(create);
    }

    @PutMapping("update")
    @ApiOperation(value="Todolist 전체 수정", notes = "전체 Todolist 전체를 수정합니다.")
    public ResponseEntity<?> updateTodo(@RequestBody @Valid TodoDTO dto)
    {
        boolean update = service.update(dto);

        // (6) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(update);
    }

    @PutMapping("update/title")
    @ApiOperation(value="Todolist 내용(title) 수정", notes = "전체 Todolist 내용(title)을 수정합니다.")
    public ResponseEntity<?> updateTodoTitle(@RequestBody TodoDTO dto)
    {
        boolean update = service.titleUpdate(dto);

        // (6) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(update);
    }

    @PutMapping("update/status")
    @ApiOperation(value="Todolist 완료상태(done) 수정", notes = "전체 Todolist 완료상태(done)를 수정합니다.")
    public ResponseEntity<?> updateTodoStatus(@RequestBody TodoDTO dto)
    {
        boolean update = service.statusUpdate(dto);

        // (6) ResponseDTO를 리턴한다.
        return ResponseEntity.ok().body(update);
    }

    @GetMapping("serach/one")
    @ApiOperation(value="TodoList 한 가지 조회", notes = "한 가지 Todolist를 조회합니다.")
    @ApiImplicitParam(name = "id", value = "Todolist id")
    public ResponseEntity<?> searchOne(@Valid @RequestParam Integer id)
    {
        TodoDTO dto = service.searchByID(id);

        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("search/all")
    @ApiOperation(value="Todolist 전체 조회", notes = "전체 Todolist를 조회합니다.")
    public ResponseEntity<?> searchAll()
    {
        return ResponseEntity.ok().body(service.searchAll());
    }

    @DeleteMapping("delete/one")
    @ApiOperation(value="TodoList 한 가지 삭제", notes = "한 가지 Todolist를 삭제합니다.")
    @ApiImplicitParam(name = "id", value = "Todolist id")
    public ResponseEntity<?> deleteOne(@Valid @RequestParam Integer id)
    {
        boolean delete = service.deleteById(id);

        return ResponseEntity.ok().body(delete);
    }

    @DeleteMapping("delete/all")
    @ApiOperation(value="Todolist 전체 삭제", notes = "전체 Todolist를 삭제합니다.")
    public ResponseEntity<?> delteAll()
    {
        return ResponseEntity.ok().body(service.deleteAll());
    }


//    @GetMapping("test")
//    public ResponseEntity<?> testTodo()
//    {
//        String str = service.testService(); // 테스트 서비스 사용
//        List<String> list = new ArrayList<>();
//        list.add(str);
//
//        ResponseDTO<String> response = ResponseDTO.<String>builder().data(list).build();
//
//        return ResponseEntity.ok().body(response);
//    }
}
