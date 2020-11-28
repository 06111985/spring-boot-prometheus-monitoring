package br.com.ultragaz.monitoring.application.service.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateCustomerResponse {

	private Integer id;
	private String name;
	private Date birthdate;

}
