package pdfa3eval;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;
import org.xml.sax.SAXException;

public class FopPDFA3Session implements PDFA3Session {

	private static final Logger LOGGER = Logger.getLogger(FopPDFA3Session.class.getName());
	
	public void addAttachment(String pdfA1FileName, String xmlFileName) throws IOException, SAXException {
		// generating pdf-a1 file
		createA1File(pdfA1FileName);
		
	}
	public void generate() {
		// embedding xml file and generating pdf a-3 - not yet implemented
		
	}
	
	public String createA1File(String OUTPUT_A1_FILE) throws SAXException, IOException {
		/*
		FO file is considered instead of xml and xslt style sheet.
		xml + xslt --> fo
		xslt transformation is not implemented.
		 */
		String FOP_FO_FILE = "helloworld.fo";
		String CONFIG_PROPERTIES = "config.properties";
		String FOP_XCONF = "fop.xconf";

		ClassLoader classLoader = FopPDFA3Session.class.getClassLoader();
		File configFile = new File(classLoader.getResource(FOP_XCONF).getFile());
			
		Properties prop = new Properties();
		InputStream is = new FileInputStream(classLoader.getResource(CONFIG_PROPERTIES).getFile());
		prop.load(is);
			
		FopFactory fopFactory = FopFactory.newInstance(configFile);
		String outputFile = prop.getProperty("OUTPUT_PATH") + File.separator + OUTPUT_A1_FILE;
		OutputStream out = new BufferedOutputStream(new FileOutputStream(new File(outputFile)));
			
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
		foUserAgent.setAccessibility(true);
		foUserAgent.getRendererOptions().put("pdf-a-mode", "PDF/A-3u");
			
		try {
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);
			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			Source src = new StreamSource(classLoader.getResource(FOP_FO_FILE).getFile());
			Result res = new SAXResult(fop.getDefaultHandler());
			transformer.transform(src, res);
		} catch (TransformerException e) {
			LOGGER.log(Level.SEVERE, "Could not convert to PDF/A", e);
		} finally {
			out.close();
		}
		
		return OUTPUT_A1_FILE;
		
	}

}
