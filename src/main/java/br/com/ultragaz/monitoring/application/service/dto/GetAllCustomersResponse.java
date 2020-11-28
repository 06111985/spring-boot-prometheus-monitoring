package br.com.ultragaz.monitoring.application.service.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonValue;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAllCustomersResponse {

	@JsonValue
	private List<GetAllCustomersResponseElement> customers = new ArrayList<>();

	public void addElement(GetAllCustomersResponseElement element) {
		this.customers.add(element);
	}

}
