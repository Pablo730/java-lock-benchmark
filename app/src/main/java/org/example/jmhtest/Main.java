package org.example.jmhtest;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(BenchmarkTest.class.getSimpleName()) // 실행할 벤치마크 클래스 지정
                .forks(1) // 프로세스를 몇 번 실행할지 (1이면 한 번 실행)
                .warmupIterations(3) // 워밍업 실행 횟수
                .measurementIterations(5) // 실제 측정 실행 횟수
                .build();

        new Runner(opt).run();
    }
}