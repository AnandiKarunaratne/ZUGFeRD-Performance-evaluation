package pdfa3eval;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import org.xml.sax.SAXException;
import pdfa3eval.PDFA3Factory.Type;

public class BenchmarkTesting {
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public void testMustang() throws IOException, SAXException {
		PDFA3Session testMustangPDFA3Session = PDFA3Factory.getPDFSession(Type.MUSTANG);
		testMustangPDFA3Session.addAttachment();
		testMustangPDFA3Session.generate();
    }
	
	@Benchmark
    @BenchmarkMode(Mode.AverageTime)
	public void testFOP() throws IOException, SAXException {
		PDFA3Session fopPDFA3Session = PDFA3Factory.getPDFSession(Type.FOP);
		fopPDFA3Session.addAttachment();
		fopPDFA3Session.generate();
	}


	public static void main(String[] args) throws Exception {
		Options opt = new OptionsBuilder()
                .include(BenchmarkTesting.class.getSimpleName())
                .warmupIterations(1)
                .measurementIterations(1)
                .forks(1)
                .timeUnit(TimeUnit.MILLISECONDS)
                .build();

        new Runner(opt).run();

	}

}
