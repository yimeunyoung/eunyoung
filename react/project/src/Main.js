import {useState} from "react";

function Main(){
	let [page, setPage] = useState(1); //[0,f]
	//console.log('렌더링',page);
	const leftBtnClick = ()=>{
		setPage(page == 1 ? 13 : page-1);
		//console.log('클릭',page);
	}
	const rightBtnClick= ()=>{
		setPage(page == 13 ? 1 : page+1);
	}
  return (
    <main>
      <div>
        <button onClick={leftBtnClick}>-</button>
        <span>{page} / 13</span>
        <button onClick={rightBtnClick}>+</button>
      </div>
    </main>
  )
}

export default Main;