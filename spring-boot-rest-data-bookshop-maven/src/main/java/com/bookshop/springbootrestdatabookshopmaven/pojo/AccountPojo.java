package com.bookshop.springbootrestdatabookshopmaven.pojo;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class AccountPojo {
	private int accountId;
	@NotNull
	private String email;
	@NotNull
	private String password;
	@NotNull
	private String firstname;
	@NotNull
	private String lastname;

}
