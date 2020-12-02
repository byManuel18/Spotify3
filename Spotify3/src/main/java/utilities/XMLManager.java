package utilities;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import model.Options;



public class XMLManager {
	private static String FILE="Options.xml";

	public static boolean SetOption(Options o){
		boolean valid=false;
		JAXBContext context;
		FileWriter fw;
		BufferedWriter bw;
		Marshaller ms;
		try {
			fw=new FileWriter(FILE);
			bw=new BufferedWriter(fw);
			try {
				context=JAXBContext.newInstance(Options.class);
				ms=context.createMarshaller();
				ms.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
				ms.marshal(o, bw);
				bw.close();
				fw.close();
				valid=true;
			} catch (JAXBException e) {
				e.printStackTrace();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return valid;
	}

	public static Options GetChannel(){
		Options c=null;
		JAXBContext context;
		Unmarshaller us;
		try {
			context=JAXBContext.newInstance(Options.class);
			us=context.createUnmarshaller();
			c=(Options) us.unmarshal(new File(FILE));
		} catch (JAXBException e) {
			c=new Options();
			SetOption(c);

		}
		return c;
	}
}
