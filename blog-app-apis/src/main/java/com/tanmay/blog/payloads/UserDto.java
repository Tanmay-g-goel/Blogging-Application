package com.tanmay.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class UserDto {
	
	private int id;
	
	@NotEmpty
	@Size(min = 3, message = "Username must be of 3 characters")
	private String name;
	
	@Email(message = "Email Address is not valid!")
	private String email;
	
	@NotEmpty
	@Size(min = 3, max = 10, message = "Password must be min of 3 char and max of 10 char")
	private String password;
	
	@NotEmpty
	private String about;

}
