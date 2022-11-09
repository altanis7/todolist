import React from 'react';
import styled from 'styled-components';
import TodoTitle from './TodoTitle';
import Todolist from './Todolist';
//ssdf
const Templatebox = styled.div`
  width : 500px;
  height : 760px;

  background : white;
  border-radius: 10px;
  margin: 0 auto;
  margin-top: 80px;

`

function Template ({ children }) {
  return <Templatebox>{ children }</Templatebox>
}

export default Template;