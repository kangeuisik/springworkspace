package com.jafa.exception;

public class NotFoundMemberException extends RuntimeException {

	public NotFoundMemberException() {
		super("회원을 찾을수 없습니다. 이름을 확인해 주세요");
	}
}
