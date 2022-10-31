package com.example.account.exception;

import com.example.account.type.ErrorCode;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//checked Exception은 트랜젝션에서 롤백해주는 대상이 되지 않는다. 따라서 runtimeException을 상속받아 사용
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AccountException extends RuntimeException {
	private ErrorCode errorCode;
	private String errorMessage;

	public AccountException(ErrorCode errorCode) {
		this.errorCode = errorCode;
		this.errorMessage = errorCode.getDescription();
	}
}
