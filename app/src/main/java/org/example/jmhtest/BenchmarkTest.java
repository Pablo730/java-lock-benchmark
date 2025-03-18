package org.example.jmhtest;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@BenchmarkMode(Mode.AverageTime) // 평균 실행 시간 측정
@State(Scope.Thread) // 각 스레드마다 독립적인 상태 유지
@OutputTimeUnit(TimeUnit.NANOSECONDS) // 실행 시간 단위를 나노초로 설정
public class BenchmarkTest {

    private int count = 0;
    private final Lock reentrantLock = new ReentrantLock();

    @Benchmark
    public synchronized void synchronizedIncrement() {
        count++;
    }

    @Benchmark
    public void reentrantLockIncrement() {
        reentrantLock.lock();
        try {
            count++;
        } finally {
            reentrantLock.unlock();
        }
    }
}
