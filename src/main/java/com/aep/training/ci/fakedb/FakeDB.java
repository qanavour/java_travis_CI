package com.aep.training.ci.fakedb;

import java.util.ArrayList;
import java.util.List;

import lombok.AccessLevel;
import lombok.Getter;

import com.aep.training.ci.model.Member;

public abstract class FakeDB {

	private @Getter(AccessLevel.PUBLIC)
	static List<Member> reservationList = new ArrayList<Member>();
	private @Getter(AccessLevel.PUBLIC)
	static List<Member> checkInList = new ArrayList<Member>();
	private @Getter(AccessLevel.PUBLIC)
	static List<Member> missingFlyersList = new ArrayList<Member>();

	public static void insertReservation(Member m) {
		reservationList.add(m);
	}

	public static void insertCheckIn(Member m) {
		checkInList.add(m);
	}

	public static void insertMissingFlyer(Member m) {
		missingFlyersList.add(m);
	}

	private static void displayListWithSubject(List<Member> list, String subject) {
		System.out.println("All " + subject + "..");
		System.out.println("------------------------------------------------");
		for (Member m : list)
			System.out.println(m);
		System.out.println("------------------------------------------------");
	}

	public static void displayAllReservations() {
		displayListWithSubject(reservationList, "Reservations");
	}

	public static void displayAllCheckIns() {
		displayListWithSubject(checkInList, "CheckIns");
	}

	public static void displayAllMissingFlyers() {
		displayListWithSubject(missingFlyersList, "Missing Flyers");
	}

}
