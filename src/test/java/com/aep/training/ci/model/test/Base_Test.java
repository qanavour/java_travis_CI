package com.aep.training.ci.model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.aep.training.ci.model.Member;
import com.aep.training.ci.model.MemberValidator;

public class Base_Test {

	private Member member;

	@Before
	public void setup() {
		member = new Member(1004, "1245655998", "Hüseyin", "KILIÇ", "C124DT");
	}

	@Test
	public void testMemberToString() {
		assertEquals(
				"Member(memberId=1245655998, firstName=Hüseyin, lastName=KILIÇ, pnr=C124DT)",
				member.toString());
	}

	@Test
	public void checkMemberId() {
		assertTrue(MemberValidator.checkMemberId(member));
		member.memberId("123456789");
		assertFalse(MemberValidator.checkMemberId(member));
		member.memberId("12345A6789");
		assertFalse(MemberValidator.checkMemberId(member));
		member.memberId("");
		assertFalse(MemberValidator.checkMemberId(member));
		member.memberId(null);
		assertFalse(MemberValidator.checkMemberId(member));
	}
}
