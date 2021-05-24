package pdfa3eval;

import org.xml.sax.SAXException;
import pdfa3eval.PDFA3Factory.Type;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException, SAXException {
//		PDFA3Session mustangPDFA3Session = PDFA3Factory.getPDFSession(Type.MUSTANG);
//		mustangPDFA3Session.addAttachment();
//		mustangPDFA3Session.generate();
		try {
			PDFA3Session fopPDFA3Session = PDFA3Factory.getPDFSession(Type.FOP);
			fopPDFA3Session.addAttachment();
			fopPDFA3Session.generate();
		} catch (NullPointerException e) {
			System.out.println(e.getMessage());
		}

	}

}
