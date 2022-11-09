import React from 'react';
import styled from 'styled-components';
import { useTodoState } from '../TodoContext';

const TodoTitlebox = styled.div`
  padding-top : 20px;
  padding-bottom : 20px;
  padding-left : 20px;
  padding-right : 20px;
  border-bottom: 1px solid #e9ecef;

  h1 {
    margin : 0;
    font-size : 36px;
    color : #343a40;
  }

  .day {
    margin-top: 4px;
    color : gray;
    font-size : 20px;
  }

  .ListCount {
    color: #20c997;
    font-size: 18px;
    margin-top: 15px;
    font-weight: bold;
  }
`;

function TodoTitle() {
  const todos = useTodoState();
  const todocount = todos.filter (todo => !todo.done)
  const date = new Date();
  
  const year = date.getFullYear();
  const month = date.getMonth() + 1;
  const day = date.getDate();
  
  const week = ['일','월','화','수','목','금','토']
  const nowweek = week[date.getDay()]
  return (
    <TodoTitlebox>
      <h1>{year}년 {month}월 {day}일</h1>
      <div className="day">{nowweek}요일</div>
      <div className="ListCount">할 일 {todocount.length}개 남음</div>
    </TodoTitlebox>
  )
}

export default TodoTitle;