package kr.kh.spring.service;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.kh.spring.dao.MemberDAO;
import kr.kh.spring.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {
	
	@Autowired
	private MemberDAO memberDao;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Override
	public boolean signup(MemberVO member) {
		if(member == null) {
			return false;
		}
		
		//���̵� �ߺ� Ȯ��
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//�����Ϸ��� ���̵� �̹� ���Ե� ���
		if(dbMember != null) {
			return false;
		}
		//���, �̸��� null üũ + ��ȿ�� �˻�
		//���̵�� �������� �����ϰ�, 6~15��
		String idRegex = "^[a-zA-Z][a-zA-Z0-9]{5,14}$";
		//����� ����, ����, !@#$%�� �̷������ 6~15��
		String pwRegex = "^[a-zA-Z0-9!@#$%]{6,15}$";
		
		//���̵� ��ȿ���� ���� ������
		if(!Pattern.matches(idRegex, member.getMe_id())) {
			return false;
		}
		//����� ��ȿ���� ���� ������
		if(!Pattern.matches(pwRegex, member.getMe_pw())) {
			return false;
		}
		
		//��� ��ȣȭ
		String encPw = passwordEncoder.encode(member.getMe_pw());
		member.setMe_pw(encPw);
		//ȸ������
		return memberDao.insertMember(member);
	}

	@Override
	public MemberVO login(MemberVO member) {
		if(member == null) {
			return null;
		}
		MemberVO dbMember = memberDao.selectMember(member.getMe_id());
		//���Ե� ���̵� �ƴϸ� 
		if(dbMember == null) {
			return null;
		}
		//���Ȯ��
		//matches(��ȣȭ�ȵȹ��ڿ�, ��ȣȭ�ȹ��ڿ�)
		if(passwordEncoder.matches(member.getMe_pw(), dbMember.getMe_pw())) {
			return dbMember;
		}
		return null;
	}
}
