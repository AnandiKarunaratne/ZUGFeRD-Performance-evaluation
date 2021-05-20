import org.junit.jupiter.api.Test;
import org.mustangproject.validator.ZUGFeRDValidator;

public class PdfValidator {

	@Test
	void zugferdPdfVal() {
		ZUGFeRDValidator zfv = new ZUGFeRDValidator();
		System.out.println(zfv.validate("fopA3File.pdf"));
	}

}
