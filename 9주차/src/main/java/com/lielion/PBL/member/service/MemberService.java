package com.lielion.PBL.member.service;

import com.lielion.PBL.member.domain.Member;
import com.lielion.PBL.member.domain.RoleType;
import com.lielion.PBL.member.dto.LionCreateRequest;
import com.lielion.PBL.member.dto.LionUpdateRequest;
import com.lielion.PBL.member.dto.MemberResponse;
import com.lielion.PBL.member.dto.StaffCreateRequest;
import com.lielion.PBL.member.dto.StaffUpdateRequest;
import com.lielion.PBL.member.repository.MemberRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
public class MemberService {
	private final MemberRepository memberRepository;

	public MemberService(MemberRepository memberRepository) {
		this.memberRepository = memberRepository;
	}

	@Transactional
	public MemberResponse createLion(LionCreateRequest request) {
		Member member = new Member(
			request.getName(),
			request.getMajor(),
			request.getGeneration(),
			request.getPart(),
			RoleType.LION,
			request.getStudentId(),
			null
		);
		Member saved = memberRepository.save(member);
		return MemberResponse.from(saved);
	}

	@Transactional
	public MemberResponse createStaff(StaffCreateRequest request) {
		Member member = new Member(
			request.getName(),
			request.getMajor(),
			request.getGeneration(),
			request.getPart(),
			RoleType.STAFF,
			null,
			request.getPosition()
		);
		Member saved = memberRepository.save(member);
		return MemberResponse.from(saved);
	}

	public List<MemberResponse> getAll() {
		return memberRepository.findAll()
			.stream()
			.map(MemberResponse::from)
			.collect(Collectors.toList());
	}

	public MemberResponse getById(Long id) {
		return memberRepository.findById(id)
			.map(MemberResponse::from)
			.orElse(null);
	}

	@Transactional
	public MemberResponse updateLion(Long id, LionUpdateRequest request) {
		Member member = memberRepository.findById(id).orElse(null);
		if (member == null) {
			return null;
		}
		String name = request.getName() != null ? request.getName() : member.getName();
		member.updateInfo(name, request.getMajor(), request.getGeneration(), request.getPart());
		member.updateStudentId(request.getStudentId());
		memberRepository.save(member);
		return MemberResponse.from(member);
	}

	@Transactional
	public MemberResponse updateStaff(Long id, StaffUpdateRequest request) {
		Member member = memberRepository.findById(id).orElse(null);
		if (member == null) {
			return null;
		}
		String name = request.getName() != null ? request.getName() : member.getName();
		member.updateInfo(name, request.getMajor(), request.getGeneration(), request.getPart());
		member.updatePosition(request.getPosition());
		memberRepository.save(member);
		return MemberResponse.from(member);
	}

	@Transactional
	public void deleteById(Long id) {
		memberRepository.deleteById(id);
	}
}
