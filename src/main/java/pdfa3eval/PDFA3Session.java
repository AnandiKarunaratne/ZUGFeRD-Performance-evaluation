package pdfa3eval;

import org.xml.sax.SAXException;

import java.io.IOException;

public interface PDFA3Session {
	
	public void addAttachment(String pdfA1FileName, String xmlFileName) throws IOException, SAXException;
	public void generate();

}
