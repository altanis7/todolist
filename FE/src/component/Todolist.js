import React from 'react';
import styled from 'styled-components';
import Todoitem from './Todoitem';
import { useTodoState } from '../TodoContext';

const Todolistbox = styled.div`
  flex: 1;
  padding: 20px 32px;
  padding-bottom: 48px;
  overflow-y: auto;
`;

function Todolist() {
  const todos = useTodoState();
  return <Todolistbox>
    {todos.map(todo => (
        <Todoitem
          key={todo.id}
          id={todo.id}
          text={todo.text}
          done={todo.done}
        />
      ))}
  </Todolistbox>;
}

export default Todolist;