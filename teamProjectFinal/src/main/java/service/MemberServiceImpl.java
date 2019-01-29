package service;

import org.springframework.stereotype.Service;

import dao.MemberDao;
import domain.AuthInfo;
import domain.Member;
import domain.RegisterRequest;
import exception.AlreadyExistingMemberException;
import exception.IdPasswordMatchingException;
import exception.MemberNotFoundException;

@Service
public class MemberServiceImpl implements MemberService {
	private MemberDao memberDao;

	public MemberDao getMemberDao() {
		return memberDao;
	}

	public void setMemberDao(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Override	//회원가입 메서드
	public void regist(RegisterRequest req) {
		Member member = memberDao.selectById(req.getId());	//id가 있는지 DB에서 검색

		if(member != null) {	//id가 존재하면
			throw new AlreadyExistingMemberException("아이디가 이미 존재합니다.");
		}

		try {	//id가 존재하지 않으면 DB에 데이터를 넣어줌
			Member newMember = new Member(
					req.getId(),
					req.getPassword(),
					req.getName(),
					req.getPhone(),
					req.getAddress(),
					req.getEmail()
					);
			memberDao.insert(newMember);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override	//비밀번호 변경하는 메서드
	public void changePassword(String id, String oldPassword, String newPassword) {
		Member member = memberDao.selectById(id);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		if(member.getPassword().equals(oldPassword)) {
			member.changePassword(oldPassword, newPassword);
			memberDao.update(member);
		} else {
			throw new IdPasswordMatchingException();
		}
	}

	@Override	//아이디 저장하기
	public AuthInfo authenticate(String id, String password) {
		Member member = memberDao.selectById(id);
		if(member == null) {
			throw new IdPasswordMatchingException();
		}
		if(!member.matchPassword(password)) {
			throw new IdPasswordMatchingException();
		}
		return new AuthInfo(member.getId(), member.getPassword());
	}

	@Override	//회원 정보 보는 메서드
	public Member detail(String id) {
		Member member = memberDao.selectById(id);
		if(member == null) { //Id가 없으면 null
			throw new AlreadyExistingMemberException("id가 존재하지 않습니다.");
		}
		return member;
	}

	@Override	//회원 탈퇴하는 메서드
	public void delete(String id, String confirmPassword) {
		Member member = memberDao.selectById(id);
		if(member == null) {
			throw new MemberNotFoundException();
		}
		if(member.getPassword().equals(confirmPassword)) {
			memberDao.delete(member);
		} else {
			throw new IdPasswordMatchingException();
		}
	}
}
