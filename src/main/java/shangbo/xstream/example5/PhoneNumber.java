package shangbo.xstream.example5;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;

public class PhoneNumber {
	@XStreamAlias("countrycode") // 自定义标签
	private String code;
	private String number;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

}
