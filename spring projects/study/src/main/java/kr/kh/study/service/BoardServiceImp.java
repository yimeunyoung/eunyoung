package kr.kh.study.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.kh.study.vo.BoardVO;
import kr.kh.study.dao.BoardDAO;

@Service
public class BoardServiceImp implements BoardService {

	@Autowired
	BoardDAO boardDao;
	
	@Override
	public List<BoardVO> getBoardList() {
		//매개변수 체크(없기 때문에 생략)
		//다오에게 게시글 리스트를 가져오라고 시키고
		List<BoardVO> list = boardDao.selectBoardList();
		//가져오면 반환
		return list;
	}

	@Override
	public BoardVO getBoard(Integer bo_num) {
		//매개변수 체크
		if(bo_num == null) {
			return null;
		}
		//다오에게 게시글 번호를 주면서 게시글을 가져오라고 시킴
		BoardVO board = boardDao.selectBoard(bo_num);
		return board;
	}

	@Override
	public void updateViews(Integer bo_num) {
		//매개변수 체크
		if(bo_num == null) {
			return; //void이기때문에 return null이 아닌 그냥 return만 쓰기
		}
		//다오에게 게시글 번호를 주면서 조회수를 1증가 시키라고 요청
		boardDao.updateBoardViews(bo_num);
	}
}
