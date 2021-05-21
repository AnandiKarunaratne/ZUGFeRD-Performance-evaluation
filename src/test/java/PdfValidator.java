import org.junit.jupiter.api.Test;
import org.mustangproject.validator.ZUGFeRDValidator;
import org.xml.sax.SAXException;
import pdfa3eval.PDFA3Factory;
import pdfa3eval.PDFA3Session;

import java.io.IOException;

public class PdfValidator {

	@Test
	public void zugferdMustangVal() throws IOException, SAXException {
		String OUTPUT_FILE = "mustangA3File.pdf";

		PDFA3Session mustangPDFA3Session = PDFA3Factory.getPDFSession(PDFA3Factory.Type.MUSTANG);
		mustangPDFA3Session.addAttachment();
		mustangPDFA3Session.generate();

		ZUGFeRDValidator zfv = new ZUGFeRDValidator();
		System.out.println(zfv.validate(OUTPUT_FILE));
	}

	@Test
	public void zugferdFopVal() throws IOException, SAXException {
		String OUTPUT_FILE = "fopA3File.pdf";

		PDFA3Session fopPDFA3Session = PDFA3Factory.getPDFSession(PDFA3Factory.Type.FOP);
		fopPDFA3Session.addAttachment();
		fopPDFA3Session.generate();

		ZUGFeRDValidator zfv = new ZUGFeRDValidator();
		System.out.println(zfv.validate(OUTPUT_FILE));
	}

}
