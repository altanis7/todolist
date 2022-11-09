import React from 'react';
import styled,{css} from 'styled-components';
import { MdDone, MdClose } from 'react-icons/md';
import { useTodoDispatch } from '../TodoContext';


const Remove = styled.div`
  display: flex;
  align-items: center;
  justify-content: center;
  color: #dee2e6;
  font-size: 24px;
  cursor: pointer;
  &:hover {
    color: #ff6b6b;
  }
  display: none;
`;
const Todoitembox = styled.div`
  display: flex;
  align-items : center;
  padding-top: 10px;
  padding-bottom: 10px;
  /* background-color: beige;
  border-bottom: 1px solid #e9ecef; */
  &:hover {
    ${Remove} {
      display: initial;
    }
  }
`
const Circle = styled.div`
  width: 32px;
  height: 32px;
  border-radius: 16px;
  border: 1px solid #ced4da;
  font-size: 24px;
  display: flex;
  align-items: center;
  justify-content: center;
  margin-right: 20px;
  cursor: pointer;
  ${props =>
    props.done &&
    css`
      border: 1px solid #38d9a9;
      color: #38d9a9;
    `}
`
const Text = styled.div`
  flex: 1;
  font-size: 20px;
  color: #495057;
  
`

function Todoitem({id,done, text}) {
  const dispatch = useTodoDispatch();
  const remove = () => dispatch({type : 'REMOVE', id})
  const toggle = () => dispatch({type : 'TOGGLE', id})

  return(
    <Todoitembox>
      <Circle done= {done} onClick = {toggle}>{done &&<MdDone />}</Circle>
      <Text done= {done}>{text}</Text>
      <Remove onClick ={remove}><MdClose /></Remove>
    </Todoitembox>
  )
}

export default Todoitem;
