package com.aep.training.ci.model.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.aep.training.ci.fakedb.FakeDB;
import com.aep.training.ci.model.Member;
import com.aep.training.ci.model.MemberValidator;


public class Base_Test {

	@Rule
	public final ExpectedException exception = ExpectedException.none();

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
		member.memberId("1245655998");
		assertTrue(MemberValidator.checkMemberId(member));
	}

	@Test // duplicate reservation check
	public void insertNewReservation() throws Exception  {
		exception.expect(Exception.class);
		FakeDB.insertReservation(member);
		FakeDB.insertReservation(member);
		
	}
	
	@Test // duplicate checkin check
	public void insertNewCheckIn() throws Exception  {
		exception.expect(Exception.class);
		FakeDB.insertCheckIn(member);
		FakeDB.insertCheckIn(member);
		
	}
	
	@Test // duplicate missing flyer check
	public void insertNewMissingFlyer() throws Exception  {
		exception.expect(Exception.class);
		FakeDB.insertMissingFlyer(member);
		FakeDB.insertMissingFlyer(member);
	}
}
