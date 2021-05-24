package pdfa3eval;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class BenchmarkTesting {
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public void testMustang() throws IOException, SAXException {
		PDFA3Session mustangPDFA3Session = PDFA3Factory.getPDFSession(PDFA3Factory.Type.MUSTANG);
		mustangPDFA3Session.addAttachment();
		mustangPDFA3Session.generate();
    }
	
//	@Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//	public void testFOP() throws IOException, SAXException {
//		PDFA3Session fopPDFA3Session = PDFA3Factory.getPDFSession(PDFA3Factory.Type.FOP);
//		fopPDFA3Session.addAttachment();
//		fopPDFA3Session.generate();
//	}

	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public void testKonik() throws IOException, SAXException {
		PDFA3Session konikPDFA3Session = PDFA3Factory.getPDFSession(PDFA3Factory.Type.KONIK);
		konikPDFA3Session.addAttachment();
		konikPDFA3Session.generate();
	}

	public static void main(String[] args) throws Exception {
		Options opt = new OptionsBuilder()
                .include(BenchmarkTesting.class.getSimpleName())
                .warmupIterations(5)
                .measurementIterations(1)
                .forks(1)
                .timeUnit(TimeUnit.MILLISECONDS)
                .build();

        new Runner(opt).run();

	}

}
