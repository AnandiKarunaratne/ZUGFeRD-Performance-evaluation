package pdfa3eval;

import org.mustangproject.ZUGFeRD.IZUGFeRDExporter;
import org.mustangproject.ZUGFeRD.ZUGFeRDExporterFromA1;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class MustangPDFA3Session implements PDFA3Session {
	
	IZUGFeRDExporter ze;
	private String PDF_A1_FILE, XML_FILE;
	private final String OUTPUT_FILE = "Outputs/mustangA3File.pdf";

	public void addAttachment() throws IOException, SAXException {

		PDF_A1_FILE = "Library/Attachments/mustangA1File.pdf";
		XML_FILE = "Library/Attachments/factur-x.xml";

		try {
			// get pdf a-1 file
			ze = new ZUGFeRDExporterFromA1().setProducer("My Application")
				.setCreator(System.getProperty("user.name"))
			    .load(PDF_A1_FILE);
			
			// get pdf xml file
			String ZUGFeRDXML = new String(Files.readAllBytes
					(Paths.get(XML_FILE)), StandardCharsets.UTF_8);
			ze.setXML(ZUGFeRDXML.getBytes());
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void generate() {
		try {
			ze.export(OUTPUT_FILE);
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
