package kr.kh.study.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.study.dao.MemberDAO;
import kr.kh.study.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	@Override
	public boolean signup(MemberVO member) {
		if(member == null || 
			member.getMe_id() == null || 
			member.getMe_pw() == null || 
			member.getMe_email() == null) {
		return false;
		}
		//유효성 검사
		if(!checkRegexMember(member)) {
			return false;
		}
		//아이디 중복체크
		//아이디로 회원정보를 가져옴
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		if(dbMember != null) {
			return false;
		}
		//회원가입 진행(암호화)
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		return memberDao.insertMember(member);
	}
	
	private boolean checkRegexMember(MemberVO member) {
		//필요하면 유효성 검사 코드 구현하면 됨
		return true;
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null || member.getMe_id() == null || member.getMe_pw() == null) {
			return null;
		}
		MemberVO user = memberDao.selectMember(member.getMe_id());
		//가입된 아이디가 아니면
		if(user == null) {
			return null;
		}
		//비번확인
		//matches(암호화안된문자열, 암호화된문자열)
		if(passwordEncoder.matches(member.getMe_pw(), user.getMe_pw())) {
			return user;
		}
		return null;
	}	
}
