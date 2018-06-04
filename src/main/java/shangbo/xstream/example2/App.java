package shangbo.xstream.example2;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;

public class App {
	public static void main(String[] args) {
		// 实例化 XStream 对象
		XStream xstream = new XStream();
		xstream.alias("person", Person.class); // 自定义标签
		xstream.alias("phone", PhoneNumber.class); // 自定义标签
		xstream.aliasField("countrycode", PhoneNumber.class, "code"); // 自定义标签

		// 将对象转成 xml
		String xml = xstream.toXML(newPerson());
		System.out.println(xml);

		// 将 xml 转成对象
		Person shangbo = (Person) xstream.fromXML(xml);
		System.out.println(shangbo);
	}

	private static Person newPerson() {
		List<PhoneNumber> phones = new ArrayList<>();

		PhoneNumber phone = new PhoneNumber();
		phone.setCode("86");
		phone.setNumber("0411-12345678");
		phones.add(phone);

		PhoneNumber cell = new PhoneNumber();
		cell.setCode("86");
		cell.setNumber("18912345678");
		phones.add(cell);

		Address address = new Address();
		address.setState("LiaoNing");
		address.setCity("DaLian");
		address.setStreat("GaoXingQu");

		Person shangbo = new Person();
		shangbo.setFirstname("Bo");
		shangbo.setLastname("Shang");
		shangbo.setAddress(address);
		shangbo.setPhones(phones);

		return shangbo;
	}
}
