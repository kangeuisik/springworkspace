package com.jafa.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransferDTO {
	private String fromMemberName;
	private String fromAccount;
	private String toMemberName;
	private String toAccount;
	private Integer amount;
}
