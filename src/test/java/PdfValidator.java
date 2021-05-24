import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mustangproject.validator.ZUGFeRDValidator;
import org.xml.sax.SAXException;
import pdfa3eval.PDFA3Factory;
import pdfa3eval.PDFA3Session;

import java.io.IOException;

public class PdfValidator {

	@Test
	public void zugferdMustangVal() throws IOException, SAXException {
		String OUTPUT_FILE = "Outputs/mustangA3File.pdf";

		PDFA3Session mustangPDFA3Session = PDFA3Factory.getPDFSession(PDFA3Factory.Type.MUSTANG);
		mustangPDFA3Session.addAttachment();
		mustangPDFA3Session.generate();

		ZUGFeRDValidator zfv = new ZUGFeRDValidator();
		String valMessage = zfv.validate(OUTPUT_FILE);
		System.out.println(valMessage);
		// unit test fails if valMessage contains substring <summary status="invalid">
		Assertions.assertFalse(valMessage.contains("<summary status=\"invalid\"/>"));
	}

	@Test
	public void zugferdFopVal() throws IOException, SAXException {
		String OUTPUT_FILE = "Outputs/fopA3File.pdf";

		PDFA3Session fopPDFA3Session = PDFA3Factory.getPDFSession(PDFA3Factory.Type.FOP);
		fopPDFA3Session.addAttachment();
		fopPDFA3Session.generate();

		ZUGFeRDValidator zfv = new ZUGFeRDValidator();
		String valMessage = zfv.validate(OUTPUT_FILE);
		System.out.println(valMessage);
		// unit test fails if valMessage contains substring <summary status="invalid">
		Assertions.assertFalse(valMessage.contains("<summary status=\"invalid\"/>"));
	}

	@Test
	public void zugferdKonikVal() throws IOException, SAXException {
		String OUTPUT_FILE = "Outputs/konikA3File.pdf";

		PDFA3Session konikPDFA3Session = PDFA3Factory.getPDFSession(PDFA3Factory.Type.KONIK);
		konikPDFA3Session.addAttachment();
		konikPDFA3Session.generate();

		ZUGFeRDValidator zfv = new ZUGFeRDValidator();
		String valMessage = zfv.validate(OUTPUT_FILE);
		System.out.println(valMessage);
		// unit test fails if valMessage contains substring <summary status="invalid">
		Assertions.assertFalse(valMessage.contains("<summary status=\"invalid\"/>"));
	}

}
