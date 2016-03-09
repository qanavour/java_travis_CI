package com.aep.training.ci.model;

public abstract class MemberValidator {
	public static boolean checkMemberId(Member m) {
		if ( m.memberId() == null || "".equals(m.memberId()) || !m.memberId().startsWith("1")
				|| m.memberId().length() != 10)
			return false;
		try {
			Integer.parseInt(m.memberId());
		} catch (NumberFormatException ex) {
			return false;
		}
		return true;
	}
}
