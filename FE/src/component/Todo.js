import React from "react";

import styled from "styled-components";
const TodoBlock = styled.div`
  width: 900px;
  height: 900px;
  margin: 100px auto 100px auto;
  background-color: white;
  border-radius: 10px;
  .todoCont {
    margin-left: 36px;
    position: relative;
    .dateBox {
      padding-top: 60px;
      h1 {
        margin: 0;
      }
      h3 {
        margin-top: 12px;
        color: #868e96;
      }
    }
    .todoTitle {
      margin-top: 48px;
      color: #20c997;
      font-weight: bold;
    }
    hr {
      margin-top: 18px;
      margin-bottom: 18px;
    }
    .todoList {
      .todo {
        display: flex;
        margin-top: 18px;
        font-size: 24px;

        .checkBox {
          width: 32px;
          height: 32px;
          margin-right: 10px;
          border: 1px solid #ced4da;
          border-radius: 16px;
        }
      }
    }
    .addTodoBox {
      position: absolute;
      bottom: -569px;
      left: 40%;
      width: 100px;
      height: 100px;
      border-radius: 50px;
      background-color: #20c997;
      text-align: center;
      .addTodo {
        font-size: 70px;
        color: white;
      }
    }
  }
`;

const Todo = () => {
  return (
    <TodoBlock>
      <div className="todoCont">
        <div className="dateBox">
          <h1>2022년 11월 2일</h1>
          <h3>수요일</h3>
        </div>
        <div className="todoTitle">
          <span>할 일 3개 남음</span>
        </div>
        <hr />
        <div className="todoList">
          <div className="todo">
            <div className="checkBox">
              <img src="check.png"></img>
            </div>
            <span>밥 먹기</span>
          </div>
          <div className="todo">
            <div className="checkBox"></div>
            <span>똥 싸기</span>
          </div>
          <div className="todo">
            <div className="checkBox"></div>
            <span>노래 듣기</span>
          </div>
        </div>
        <div className="addTodoBox">
          <span className="addTodo">+</span>
        </div>
      </div>
    </TodoBlock>
  );
};

export default Todo;
