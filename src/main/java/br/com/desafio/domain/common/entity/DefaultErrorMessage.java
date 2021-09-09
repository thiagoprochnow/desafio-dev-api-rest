package br.com.desafio.domain.common.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Thiago Henrique Prochnow
 *	
 * Default Error Message to be returned on the response for Http Exception. 
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DefaultErrorMessage {
	private int httpStatusCode;
	private Date recordTimestamp;
	private String exceptionMessage;
	private String requestDescription;
	
	@Override
	public String toString() {
		return "{httpStatusCode=" + httpStatusCode + ", timestamp=" + recordTimestamp + ", message=" + exceptionMessage
				+ ", description=" + requestDescription + "}";
	}	
}
