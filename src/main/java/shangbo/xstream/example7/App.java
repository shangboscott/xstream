package shangbo.xstream.example7;

import java.util.ArrayList;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;

public class App {
	public static void main(String[] args) {
		// 实例化 XStream 对象
		XStream xstream = new XStream(new JettisonMappedXmlDriver()); // 注意此处
		xstream.alias("person", Person.class); // 自定义标签
		xstream.alias("phone", PhoneNumber.class); // 自定义标签
		xstream.aliasField("countrycode", PhoneNumber.class, "code"); // 自定义标签
		xstream.addImplicitCollection(Person.class, "phones"); // 去掉集合标签
		xstream.useAttributeFor(Person.class, "firstname"); // 生成属性，而非子标签
		xstream.useAttributeFor(Person.class, "lastname"); // 生成属性，而非子标签
		xstream.registerConverter(new PhoneNumberConverter()); // 注册转换器

		// 将对象转成 json
		String json = xstream.toXML(newPerson());
		System.out.println(json);

		// 将 json 转成对象
		Person shangbo = (Person) xstream.fromXML(json);
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
