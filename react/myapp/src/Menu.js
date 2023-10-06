import './css/Menu.css'

function Menu(){
  return(
    <nav>
      <ul className='menu-list'>
        <li className='menu-item'>
          <a className='menu-link' href='#'>메뉴1</a>
        </li>
        <li className='menu-item'>
          <a className='menu-link' href='#'>메뉴2</a>
        </li>
        <li className='menu-item'>
          <a className='menu-link' href='#'>메뉴</a>
        </li>
      </ul>
			<footer></footer>
    </nav>
  );
}
export default Menu;
