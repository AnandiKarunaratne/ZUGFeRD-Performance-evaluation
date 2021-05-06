public class Main {

	public static void main(String[] args) {
		MustangPDFA3Session testMustangPDFA3Session = new MustangPDFA3Session();
		testMustangPDFA3Session.addAttachment("a1_file.pdf", "zugferd-invoice.xml");
		testMustangPDFA3Session.generate();
	}

}
