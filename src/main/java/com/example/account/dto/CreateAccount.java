package com.example.account.dto;

import java.time.LocalDateTime;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CreateAccount {

	@Getter
	@Setter
	@AllArgsConstructor
	@NoArgsConstructor
	public static class Request {
		//컨트롤러에서 어떻게 Valid 하는지 정해준다
		@NotNull
		@Min(1)
		private Long userId;

		@NotNull
		@Min(0)
		private Long initialBalance;
	}

	@Getter
	@Setter
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder
	public static class Response {
		private Long userId;
		private String accountNumber;
		private LocalDateTime registeredAt;

		public static Response from(AccountDto accountDto) {
			return Response.builder()
				.userId(accountDto.getUserId())
				.accountNumber(accountDto.getAccountNumber())
				.registeredAt(accountDto.getRegisteredAt())
				.build();

		}
	}
}
