package com.minlab.todolist.controller;

import com.minlab.todolist.dto.TodoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TodoControllerTest {

    @Autowired
    TodoController todoController;

    @Test
    void createTodo() {
        TodoDTO dto = new TodoDTO();
        dto.setTitle("몌주랑 데이트");
        dto.setDone(true);

        System.out.println(todoController.createTodo(dto));


    }

    @Test
    void testCreateTodo() {
    }

    @Test
    void updateTodo() {
    }

    @Test
    void updateTodoTitle() {
    }

    @Test
    void updateTodoStatus() {
    }

    @Test
    void deleteTodoList() {
    }

    @Test
    void searchOne() {
    }

    @Test
    void searchAll() {
    }

    @Test
    void delteAll() {
    }
}