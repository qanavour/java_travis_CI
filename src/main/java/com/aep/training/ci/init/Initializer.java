package com.aep.training.ci.init;

import com.aep.training.ci.fakedb.FakeDB;
import com.aep.training.ci.model.Member;

public class Initializer {
	public static void init(){
		FakeDB.getReservationList().add(new Member(1001,"1241932125", "Emrah", "PEKESEN","XD45GT"));
		FakeDB.getReservationList().add(new Member(1002,"1351545451", "Aslý", "PEKESEN","FTG56H"));
		FakeDB.getReservationList().add(new Member(1003,"1266154515", "Kývanç", "PEKESEN","HGT43V"));
		FakeDB.getReservationList().add(new Member(1004,"1245655998", "Hüseyin", "KILIÇ","C124DT"));
		FakeDB.getReservationList().add(new Member(1005,"1323498784", "Haydar", "KALÇA","BNT8KL"));
		FakeDB.getReservationList().add(new Member(1006,"1659451848", "Onur", "ÞAHÝN","A124ER"));
		FakeDB.getReservationList().add(new Member(1007,"1057356465", "Hakan", "KEÇELÝOÐLU","P215RE"));
		
		FakeDB.getCheckInList().add(new Member(101,"1351545451", "Aslý", "PEKESEN","FTG56H"));
		FakeDB.getCheckInList().add(new Member(102,"1266154515", "Kývanç", "PEKESEN","HGT43V"));
		FakeDB.getCheckInList().add(new Member(103,"1323498784", "Haydar", "KALÇA","BNT8KL"));
		
	}

}
