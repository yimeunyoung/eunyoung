package kr.kh.spring.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import kr.kh.spring.vo.BoardTypeVO;
import kr.kh.spring.vo.MemberVO;

public interface MemberDAO {

	MemberVO selectMember(@Param("me_id")String me_id);

	boolean insertMember(@Param("m")MemberVO member);

	void updateMemberSession(@Param("user")MemberVO user);

	MemberVO selectMemberBySession(@Param("session_id")String session_id);

	List<BoardTypeVO> selectBoardTypeListByRole(@Param("me_role")String me_role);
	
}