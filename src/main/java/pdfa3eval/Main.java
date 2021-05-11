package pdfa3eval;

import pdfa3eval.PDFA3Factory.Type;

public class Main {

	public static void main(String[] args) {
		PDFA3Session testMustangPDFA3Session = PDFA3Factory.getPDFSession(Type.MUSTANG);
		testMustangPDFA3Session.addAttachment("a1_file.pdf", "zugferd-invoice.xml");
		testMustangPDFA3Session.generate();
	}

}
