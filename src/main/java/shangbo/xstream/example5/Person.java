package shangbo.xstream.example5;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;

@XStreamAlias("person") // 自定义标签
public class Person {
	@XStreamAsAttribute // 生成属性，而非子标签
	private String firstname;
	@XStreamAsAttribute // 生成属性，而非子标签
	private String lastname;
	private Address address;
	
	@XStreamImplicit(itemFieldName="phone") // 去掉集合标签
	private List<PhoneNumber> phones;

	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<PhoneNumber> getPhones() {
		return phones;
	}

	public void setPhones(List<PhoneNumber> phones) {
		this.phones = phones;
	}

}
