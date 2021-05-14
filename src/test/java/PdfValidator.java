import org.mustangproject.validator.ZUGFeRDValidator;

public class PdfValidator {
	
	public static void mustangPdfVal(String filePath) {
		ZUGFeRDValidator zfv=new ZUGFeRDValidator();
		System.out.println(zfv.validate(filePath));
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stubZUGFeRDValidator zfv=new ZUGFeRDValidator();
		
		mustangPdfVal("generatedA3.pdf");
	}

}
