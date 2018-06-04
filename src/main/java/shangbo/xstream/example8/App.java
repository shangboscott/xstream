package shangbo.xstream.example8;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.oxm.Marshaller;
import org.springframework.oxm.Unmarshaller;
import org.springframework.oxm.XmlMappingException;

public class App {
	public static void main(String[] args) throws XmlMappingException, IOException {
		// 实例化 Spring IoC 容器
        @SuppressWarnings("resource")
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 将对象转为 xml
        try(OutputStream outputStream = new FileOutputStream("D:\\0_Shangbo\\Dev\\Workspace\\test.xml")) {
            StreamResult streamResult = new StreamResult(outputStream);
            Marshaller marshaller = context.getBean(Marshaller.class);
            marshaller.marshal(newPerson(), streamResult);
        }
        
        // 将 xml 转成对象
        try(InputStream inputStream = new FileInputStream("D:\\0_Shangbo\\Dev\\Workspace\\test.xml")) {
        	StreamSource source = new StreamSource(inputStream);
            Unmarshaller unmarshaller = context.getBean(Unmarshaller.class);
            Person shangbo = (Person) unmarshaller.unmarshal(source);
            System.out.println(shangbo);
        }
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
