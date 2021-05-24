package pdfa3eval;

import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.xmlgraphics.util.MimeConstants;
import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.util.Objects;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FopPDFA3Session implements PDFA3Session {

	private static final Logger LOGGER = Logger.getLogger(FopPDFA3Session.class.getName());
	private static String FOP_FO_FILE;
	private static String CONFIG_PROPERTIES;
	private static String FOP_XCONF;
	private static final String OUTPUT_FILE = "fopA3File.pdf";


	public void addAttachment() {
		/*
		FO file is considered instead of xml and xslt style sheet.
		xml + xslt --> fo
		xslt transformation is not implemented.
		 */
		FOP_FO_FILE = "helloworld.fo";
		CONFIG_PROPERTIES = "config.properties";
		FOP_XCONF = "fop.xconf";
	}

	public void generate() throws IOException, SAXException {

		ClassLoader classLoader = FopPDFA3Session.class.getClassLoader();
		File configFile = new File(Objects.requireNonNull(classLoader.getResource(FOP_XCONF)).getFile());
			
		Properties prop = new Properties();
		InputStream is = new FileInputStream(Objects.requireNonNull(classLoader.getResource(CONFIG_PROPERTIES)).getFile());
		prop.load(is);
			
		FopFactory fopFactory = FopFactory.newInstance(configFile);
		String outputFile = prop.getProperty("OUTPUT_PATH") + File.separator + OUTPUT_FILE;
		OutputStream out = new BufferedOutputStream(new FileOutputStream(outputFile));
			
		FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
		foUserAgent.setAccessibility(true);
		foUserAgent.getRendererOptions().put("pdf-a-mode", "PDF/A-3u");
		foUserAgent.getRendererOptions().put("version", "1.4");
		foUserAgent.setAuthor("Author 1");
			
		try {
			Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

			TransformerFactory factory = TransformerFactory.newInstance();
			Transformer transformer = factory.newTransformer();
			Source src = new StreamSource(Objects.requireNonNull(classLoader.getResource(FOP_FO_FILE)).getFile());
			Result res = new SAXResult(fop.getDefaultHandler());
			transformer.transform(src, res);

		} catch (TransformerException e) {
			LOGGER.log(Level.SEVERE, "Could not convert to PDF/A", e);
		} finally {
			out.close();
		}
		
	}

}
