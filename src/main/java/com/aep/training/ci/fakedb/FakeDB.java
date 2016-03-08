package com.aep.training.ci.fakedb;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;

import lombok.AccessLevel;
import lombok.Getter;

import com.aep.training.ci.model.Member;

public abstract class FakeDB {

	private @Getter(AccessLevel.PUBLIC) static List<Member> reservationList = new ArrayList<Member>();
	private @Getter(AccessLevel.PUBLIC) static List<Member> checkInList = new ArrayList<Member>();
	private @Getter(AccessLevel.PUBLIC) static List<Member> missingFlyersList = new ArrayList<Member>();

	public static void insertReservation(Member m) throws Exception {
		List<Member> members = reservationList.stream()
				.filter(k -> k.equals(m)).collect(Collectors.toList());
		if (members.size() == 0)
			reservationList.add(m);
		else
			throw new Exception("Rezervasyon Zaten Mevcut!");
	}

	public static void insertCheckIn(Member m) throws Exception {
		List<Member> members = checkInList.stream().filter(k -> k.equals(m))
				.collect(Collectors.toList());
		if (members.size() == 0)
			checkInList.add(m);
		else
			throw new Exception("Check In Zaten Mevcut!");
	}

	public static void insertMissingFlyer(Member m) throws Exception {
		List<Member> members = missingFlyersList.stream()
				.filter(k -> k.equals(m)).collect(Collectors.toList());
		if (members.size() == 0)
			missingFlyersList.add(m);
		else
			throw new Exception("Missing Flyer Zaten Eklenmiþ!");
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
