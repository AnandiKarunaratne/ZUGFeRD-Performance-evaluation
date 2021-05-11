package pdfa3eval;

import java.util.concurrent.TimeUnit;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import pdfa3eval.PDFA3Factory.Type;

public class BenchmarkTesting {
	
	@Benchmark
	@BenchmarkMode(Mode.AverageTime)
	public void testMustang() {
		PDFA3Factory.getPDFSession(Type.MUSTANG);
    }
	
//	@Benchmark
//    @BenchmarkMode(Mode.AverageTime)
//	public void testFOP() {
//	
//	}


	public static void main(String[] args) throws Exception {
		Options opt = new OptionsBuilder()
                .include(BenchmarkTesting.class.getSimpleName())
                .warmupIterations(10)
                .measurementIterations(1)
                .forks(5)
                .timeUnit(TimeUnit.MILLISECONDS)
                .build();

        new Runner(opt).run();

	}

}
