package pdfa3eval;

import io.konik.InvoiceTransformer;
import io.konik.PdfHandler;
import io.konik.zugferd.Invoice;
import io.konik.zugferd.unqualified.ZfDate;
import io.konik.zugferd.unqualified.ZfDateDay;
import io.konik.zugferd.unqualified.ZfDateMonth;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static io.konik.zugferd.profile.ConformanceLevel.BASIC;
import static org.apache.commons.io.FileUtils.openOutputStream;
import static org.apache.commons.lang3.time.DateUtils.addMonths;


public class KonikPDFA3Session implements PDFA3Session {

    Invoice invoice = new Invoice(BASIC);


    @Override
    public void addAttachment() throws IOException {
        ZfDate today = new ZfDateDay();
        ZfDate nextMonth = new ZfDateMonth(addMonths(today, 1));

        InvoiceTransformer transformer = new InvoiceTransformer();
        invoice = transformer.toModel(new File("/home/anandikarunaratne/Work/performanceEval/Library/Attachments/konik-invoice.xml"));
    }

    @Override
    public void generate() throws IOException {
        PdfHandler handler = new PdfHandler();
        InputStream inputPdf = getClass().getResourceAsStream("/konik-pdf.pdf");
        OutputStream resultingPdf = openOutputStream(new File("/home/anandikarunaratne/Work/performanceEval/Outputs/konikA3File.pdf"));
        handler.appendInvoice(invoice, inputPdf, resultingPdf);
    }
}
