package br.com.desafio.domain.common.entity;

import java.util.Date;
import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author Thiago Henrique Prochnow
 *	
 * Default Success Message for endpoint requests when not returning a Entity as response. 
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class DefaultSuccessMessage {
	private int httpStatusCode;
	private Date recordTimestamp;
	private String message;
	private String requestDescription;
	private Map<String, String> optionals;
	
	public DefaultSuccessMessage(int httpStatusCode, Date recordTimestamp, String message, String requestDescription) {
		super();
		this.httpStatusCode = httpStatusCode;
		this.recordTimestamp = recordTimestamp;
		this.message = message;
		this.requestDescription = requestDescription;
	}
	
	@Override
	public String toString() {
		return "{httpStatusCode=" + httpStatusCode + ", timestamp=" + recordTimestamp + ", message=" + message
				+ ", description=" + requestDescription + "}";
	}	
}
