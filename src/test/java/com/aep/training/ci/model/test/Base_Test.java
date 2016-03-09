package com.aep.training.ci.model.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.aep.training.ci.app.App;
import com.aep.training.ci.fakedb.FakeDB;
import com.aep.training.ci.init.Initializer;
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
	
	@Test
	public void initializeFakeDBData(){
		Initializer iForCodeCoverage = new Initializer();
		assertNotNull(iForCodeCoverage);
		
		Initializer.init();
		List<Member> reservationInitList = new ArrayList<Member>();
		
		reservationInitList.add(new Member(1001,"1241932125", "Emrah", "PEKESEN","XD45GT"));
		reservationInitList.add(new Member(1002,"1351545451", "Aslý", "PEKESEN","FTG56H"));
		reservationInitList.add(new Member(1003,"1266154515", "Kývanç", "PEKESEN","HGT43V"));
		reservationInitList.add(new Member(1004,"1245655998", "Hüseyin", "KILIÇ","C124DT"));
		reservationInitList.add(new Member(1005,"1323498784", "Haydar", "KALÇA","BNT8KL"));
		reservationInitList.add(new Member(1006,"1659451848", "Onur", "ÞAHÝN","A124ER"));
		reservationInitList.add(new Member(1007,"1057356465", "Hakan", "KEÇELÝOÐLU","P215RE"));
		
		assertEquals(reservationInitList, FakeDB.getReservationList());
	}
	
	@Test
	public void checkIfAppisRunningProperly(){
		assertTrue(FakeDB.getMissingFlyersList().size()==0);
		
		App app = new App();
		assertNotNull(app);
		app.main(null);
		
		assertTrue(FakeDB.getMissingFlyersList().size()>0);
	}
	
}
