package pdfa3eval;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class BenchmarkTesting {
	
	@Benchmark
    @BenchmarkMode(Mode.AverageTime)
	public void testMustang() {
		MustangPDFA3Session testMustangPDFA3Session = new MustangPDFA3Session();
		testMustangPDFA3Session.addAttachment("a1_file.pdf", "zugferd-invoice.xml");
		testMustangPDFA3Session.generate();
    }
	
	@Benchmark
    @BenchmarkMode(Mode.AverageTime)
	public void testFOP() {
	
	}


	public static void main(String[] args) throws Exception {
		Options opt = new OptionsBuilder()
                .include(BenchmarkTesting.class.getSimpleName())
                .warmupIterations(10)
                .measurementIterations(10000)
                .forks(5)
                .timeUnit(TimeUnit.MILLISECONDS)
                .build();

        new Runner(opt).run();

	}

}
