package com.aep.training.ci.model;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(exclude = { "uniqueId" })
@ToString(exclude = { "uniqueId" })
@AllArgsConstructor(access = AccessLevel.PUBLIC)
@NoArgsConstructor(access = AccessLevel.PUBLIC)
@Accessors(fluent=true)
public class Member {
	@Setter(AccessLevel.PRIVATE)
	private int uniqueId;
	private String memberId;
	private String firstName;
	private String lastName;
	private String pnr;
}
