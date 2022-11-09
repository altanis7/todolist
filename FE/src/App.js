import React from 'react';
import { createGlobalStyle } from 'styled-components';
import Template from './component/Template';
import TodoTitle from './component/TodoTitle';
import Todolist from './component/Todolist';
import PlusTodo from './component/PlusTodo';
import { TodoProvider } from './TodoContext';

//sdf
const GlobalStyle = createGlobalStyle`
  body {
    background: beige;
  }
`;
function App() {
  return (
    <TodoProvider>
      <GlobalStyle />
        <Template>
          <TodoTitle />
          <Todolist />
          <PlusTodo></PlusTodo>
        </Template>
    </TodoProvider>
  );
}

export default App;
