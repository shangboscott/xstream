package shangbo.xstream.example8;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.xstream.XStreamMarshaller;

@Configuration
public class AppConfig {

	@Bean
	public PhoneNumberConverter phoneNumberConverter() {
		return new PhoneNumberConverter();
	}
	
	@Bean
	public XStreamMarshaller xStreamMarshaller(PhoneNumberConverter phoneNumberConverter) {
		XStreamMarshaller xstream = new XStreamMarshaller();
		xstream.setConverters(phoneNumberConverter);
		
		Map<String, Class<?>> aliases = new HashMap<>();
		aliases.put("person", Person.class);
		aliases.put("phone", PhoneNumber.class);
		xstream.setAliases(aliases);
		
		Map<String, String> fieldAliases = new HashMap<>();
		fieldAliases.put("shangbo.xstream.example8.PhoneNumber.code", "countrycode");
		xstream.setFieldAliases(fieldAliases);
		
		Map<Class<?>, String> implicitCollections = new HashMap<>();
		implicitCollections.put(Person.class, "phones");
		xstream.setImplicitCollections(implicitCollections);
		
		Map<Class<?>, List<String>> useAttributeFor = new HashMap<>();
		List<String> attribute = new ArrayList<>();
		attribute.add("firstname");
		attribute.add("lastname");
		useAttributeFor.put(Person.class, attribute);
		xstream.setUseAttributeFor(useAttributeFor);
		
		return xstream;
	}
}
