package com.lielion.PBL.member.service;

import com.lielion.PBL.global.exception.DuplicateMemberException;
import com.lielion.PBL.global.exception.MemberNotFoundException;
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
		if (memberRepository.findByName(request.getName()).isPresent()) {
			throw new DuplicateMemberException("이미 존재하는 이름입니다. name: " + request.getName());
		}
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
		if (memberRepository.findByName(request.getName()).isPresent()) {
			throw new DuplicateMemberException("이미 존재하는 이름입니다. name: " + request.getName());
		}
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
		Member member = memberRepository.findById(id)
			.orElseThrow(() -> new MemberNotFoundException("해당 멤버를 찾을 수 없습니다. id: " + id));
		return MemberResponse.from(member);
	}

	public List<MemberResponse> getByPart(String part) {
		return memberRepository.findByPart(part)
			.stream()
			.map(MemberResponse::from)
			.collect(Collectors.toList());
	}

	@Transactional
	public MemberResponse updateLion(Long id, LionUpdateRequest request) {
		Member member = memberRepository.findById(id)
			.orElseThrow(() -> new MemberNotFoundException("해당 멤버를 찾을 수 없습니다. id: " + id));
		String name = request.getName() != null ? request.getName() : member.getName();
		member.updateInfo(name, request.getMajor(), request.getGeneration(), request.getPart());
		member.updateStudentId(request.getStudentId());
		memberRepository.save(member);
		return MemberResponse.from(member);
	}

	@Transactional
	public MemberResponse updateStaff(Long id, StaffUpdateRequest request) {
		Member member = memberRepository.findById(id)
			.orElseThrow(() -> new MemberNotFoundException("해당 멤버를 찾을 수 없습니다. id: " + id));
		String name = request.getName() != null ? request.getName() : member.getName();
		member.updateInfo(name, request.getMajor(), request.getGeneration(), request.getPart());
		member.updatePosition(request.getPosition());
		memberRepository.save(member);
		return MemberResponse.from(member);
	}

	@Transactional
	public void deleteById(Long id) {
		Member member = memberRepository.findById(id)
			.orElseThrow(() -> new MemberNotFoundException("해당 멤버를 찾을 수 없습니다. id: " + id));
		memberRepository.deleteById(id);
	}
}
