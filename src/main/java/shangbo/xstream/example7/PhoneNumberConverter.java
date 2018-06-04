package shangbo.xstream.example7;

import com.thoughtworks.xstream.converters.Converter;
import com.thoughtworks.xstream.converters.MarshallingContext;
import com.thoughtworks.xstream.converters.UnmarshallingContext;
import com.thoughtworks.xstream.io.HierarchicalStreamReader;
import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

public class PhoneNumberConverter implements Converter {

	@SuppressWarnings("rawtypes")
	@Override
	public boolean canConvert(Class type) {
		return type.equals(PhoneNumber.class);
	}

	@Override
	public void marshal(Object source, HierarchicalStreamWriter writer, MarshallingContext context) {
		PhoneNumber phone = (PhoneNumber) source;
		writer.setValue(phone.getCode() + " " + phone.getNumber());
	}

	@Override
	public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext context) {
		PhoneNumber phone = new PhoneNumber();
		String[] p = reader.getValue().split(" ");
		phone.setCode(p[0]);
		phone.setNumber(p[1]);

		return phone;
	}

}
