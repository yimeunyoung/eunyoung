import {BrowserRouter, Routes, Route} from 'react-router-dom'
import {useLocation} from 'react-router-dom'
import {Link} from 'react-router-dom'
import {useState} from 'react';
import {useNavigate} from 'react-router-dom'

function App() {
  let [movie, setMovie] = useState([{
    ID : '1',
    Title : 'Movie1',
    Genre: 'Drama',
    ReleaseDate: '2022-01-01'
  },{
    ID : '2',
    Title : 'Movie2',
    Genre: 'Action',
    ReleaseDate: '2022-02-01'
  }]);
  const deleteMovie = (ID)=>{
    let tmpMovie = movie.filter(item=>item.ID != ID);
    setMovie(tmpMovie);
  }
  const addMovie = (movie)=>{
    setMovie([movie, ...movie]);
  }
  return (
    <div>
      <BrowserRouter>
        <Header/>
        <Routes>
          <Route path="/" exact element={<Home movie={movie} deleteMovie={deleteMovie} add={addMovie} />} /> 
          <Route path='/insert' element={<Insert/>}/> 
        </Routes>
      </BrowserRouter>
    </div>
  );
}

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
function Home({movie, deleteMovie, add}) {
  const location = useLocation();
	let movies = location.state;
	if(movies != null){
		add(movies);
		location.state = null;
  }
  return (
		<main>
			<h1 className='movie' >Movies</h1>
			<table>
				<thead>
					<tr className='movie-list'>
						<th className='movie-item'>ID</th>
						<th className='movie-item'>Title</th>
						<th className='movie-item'>Genre</th>
						<th className='movie-item'>Release Date</th>
            <th className='movie-item'>Action</th>
					</tr>
				</thead>
				<tbody>
					{movie.length == 0 ?
						<tr><th colSpan={4}><h1>등록된 게시글이 없습니다.</h1></th></tr> :
						movie.map(item=>{
							return(
								<tr className='movie-list' key={item.ID}>
									<td className='create-item'>{item.ID}</td>
									<td className='create-item'>{item.Title}</td>
									<td className='create-item'>{item.Genre}</td>
                  <td className='create-item'>{item.ReleaseDate}</td>
									<td className='create-item'><button onClick={()=>{deleteMovie(item.ID)}}>삭제</button></td>
								</tr>
							)
						})
					}
				</tbody>
			</table>
    </main>
  );
}
function Insert(){
	const navigate = useNavigate();
	const [ID, setID] = useState('');
	const [title, setTitle] = useState('');
	const [genre, setGenre] = useState('');
	const [ReleaseDate, setReleaseDate] = useState('');

	const IDChange = e => setID(e.target.value);
	const titleChange = e => setTitle(e.target.value);
	const genreChange = e => setGenre(e.target.value);
	const ReleaseDateChange = e => setReleaseDate(e.target.value);

	const insertMovie = ()=>{
		navigate('/',{
			state : {
				ID : ID,
				title : title,
				genre : genre,
				ReleaseDate : ReleaseDate
			}
		})
	}
	return (
		<div>
		<h1 className='create'>Create Movie</h1>
			<div className='create-list'>
				<input type="number" placeholder='input movie id' onChange={IDChange} value={ID} required/> 
				<br/>
				<input type="text" placeholder='input movie title' onChange={titleChange} value={title} required/>
				<br/>
				<input type="text" placeholder='input movie genre' onChange={genreChange} value={genre} required/>
				<br/>
				<div>출시일 : <input type="date" placeholder='출시일' onChange={ReleaseDateChange} value={ReleaseDate} required/></div>
				<button className='create-btn' onClick={insertMovie}>Add Movie</button>
			</div>	
		</div>
	)
}
export default App;
