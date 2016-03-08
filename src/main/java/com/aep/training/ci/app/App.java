package com.aep.training.ci.app;

import com.aep.training.ci.fakedb.FakeDB;
import com.aep.training.ci.init.Initializer;
import com.aep.training.ci.model.Member;

public class App {

	public static void main(String[] args) {
	     Initializer.init();
	     checkMissingFlyers();
	     FakeDB.displayAllMissingFlyers();
	}
	
	public static void checkMissingFlyers(){
		for(Member m: FakeDB.getReservationList())
		{
			if(!FakeDB.getCheckInList().contains(m))
				FakeDB.getMissingFlyersList().add(m);
		}
	}

}
