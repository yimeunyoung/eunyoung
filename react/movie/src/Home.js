import {useLocation} from 'react-router-dom'

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

export default Home;