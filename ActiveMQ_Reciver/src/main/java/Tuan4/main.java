package Tuan4;

import java.io.StringWriter;
import java.util.Date;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;



public class main {

	public static void main(String[] args) {
		benhnhan obj = new benhnhan("101", "Thân Thị Đẹt", "Tring","dsa");
		try {
			JAXBContext ctx = JAXBContext.newInstance(benhnhan.class);
			Marshaller ms = ctx.createMarshaller();
			StringWriter sw = new StringWriter();
			ms.marshal(obj, sw);
			System.out.println(ms.toString());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
