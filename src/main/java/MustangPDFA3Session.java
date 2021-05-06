import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.mustangproject.ZUGFeRD.IZUGFeRDExporter;
import org.mustangproject.ZUGFeRD.ZUGFeRDExporterFromA1;

public class MustangPDFA3Session implements PDFA3Session {
	
	IZUGFeRDExporter ze;
	
	public void addAttachment(String pdfA1FilePath, String xmlFilePath) {
		try {
			// get pdf a-1 file
			ze = new ZUGFeRDExporterFromA1().setProducer("My Application")
				.setCreator(System.getProperty("user.name"))
			    .load(pdfA1FilePath);
			
			// get pdf xml file
			String ZUGFeRDXML = new String(Files.readAllBytes
					(Paths.get(xmlFilePath)), StandardCharsets.UTF_8);
			ze.setXML(ZUGFeRDXML.getBytes());
			
		} catch (IOException e){
			e.printStackTrace();
		}
	}
	
	public void generate() {
		try {
			ze.export("./generatedA3.pdf");
		} catch (IOException e){
			e.printStackTrace();
		}
	}

}
