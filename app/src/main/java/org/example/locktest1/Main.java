package org.example.locktest1;

import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

public class Main {
    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(MultiThreadLockBenchmark.class.getSimpleName()) // 실행할 벤치마크 클래스
                .forks(1) // 실행 환경을 1번 초기화
                .warmupIterations(3) // 워밍업 실행 횟수
                .measurementIterations(5) // 실제 측정 실행 횟수
                .build();

        new Runner(opt).run();
    }
}
