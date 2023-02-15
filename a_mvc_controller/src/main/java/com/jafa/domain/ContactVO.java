package com.jafa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ContactVO {
	private Long cno;
	private String name;
	private String phoneNumber;
}
