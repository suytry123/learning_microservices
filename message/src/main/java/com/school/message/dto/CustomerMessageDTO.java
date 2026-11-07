package com.school.message.dto;

import lombok.Data;

@Data
public class CustomerMessageDTO {
	private Long customerId;
	private String name;
	private String email;
	private String mobileNumber;
}
