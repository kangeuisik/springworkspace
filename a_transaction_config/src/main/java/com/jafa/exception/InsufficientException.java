package com.jafa.exception;

public class InsufficientException extends RuntimeException {
	public InsufficientException() {
		super("잔액이 부족합니다");
	}
}
