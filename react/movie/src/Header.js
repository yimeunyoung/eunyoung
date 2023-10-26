import {Link} from 'react-router-dom'

function Header(){
	return(
		<header className='menu'>
			<ul className='menu-list'>
				<li className='menu-item'>
					<Link to="/" className='menu-link'>List</Link>
				</li>
				<li className='menu-item'>
					<Link to="/insert" className='menu-link'>Add New Movie</Link>
				</li>
			</ul>
		</header>
	)
}

export default Header;