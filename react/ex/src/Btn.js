import {useState} from 'react'

function Btn({text, event}){
  /*클릭 이벤트 추가
  const click= ()=>{
    alert('클릭');
  }*/
  return (
  <button onClick={event}>{text}</button>
  )
}

export default Btn;
