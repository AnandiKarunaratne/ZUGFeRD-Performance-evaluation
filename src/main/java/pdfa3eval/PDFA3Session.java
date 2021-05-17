package pdfa3eval;

import org.xml.sax.SAXException;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface PDFA3Session {
	
	public void addAttachment() throws IOException, SAXException;
	public void generate() throws IOException, SAXException;

}
