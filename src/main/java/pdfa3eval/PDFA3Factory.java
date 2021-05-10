package pdfa3eval;

public class PDFA3Factory {
	
	enum Type {
		  MUSTANG,
		  FOP
	}

	public static void getPDFSession(Type type) {
		if (type == Type.MUSTANG) { // for Mustang
			MustangPDFA3Session testMustangPDFA3Session = new MustangPDFA3Session();
			testMustangPDFA3Session.addAttachment("a1_file.pdf", "zugferd-invoice.xml");
			testMustangPDFA3Session.generate();
		}
		else { // for FOP
			
		}
	}
	
	public static void main(String[] args) {
		getPDFSession(Type.MUSTANG);
	}

}
