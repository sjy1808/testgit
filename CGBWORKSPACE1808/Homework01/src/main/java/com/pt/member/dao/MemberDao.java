package com.pt.member.dao;

import java.util.List;

import com.pt.member.entity.Member;

public interface MemberDao {

	List<Member> findPageObjects();
}
