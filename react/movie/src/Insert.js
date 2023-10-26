import {useState} from 'react';
import {useNavigate} from 'react-router-dom'

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
				<input type="date" placeholder='출시일' onChange={ReleaseDateChange} value={ReleaseDate} required/>
				<br/>
				<button onClick={insertMovie}>Add Movie</button>
			</div>	
		</div>
	)
}

export default Insert;