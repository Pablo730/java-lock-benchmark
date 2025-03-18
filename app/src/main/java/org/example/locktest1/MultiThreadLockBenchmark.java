package org.example.locktest1;

import org.openjdk.jmh.annotations.*;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@BenchmarkMode(Mode.All) // All 벤치마크 모드를 실행
@OutputTimeUnit(TimeUnit.NANOSECONDS) // 실행 시간 단위를 나노초로 설정
@State(Scope.Benchmark) // 모든 스레드가 동일한 자원 공유
public class MultiThreadLockBenchmark {

    private int count = 0;
    private final Lock reentrantLock = new ReentrantLock();

    @Benchmark
    @Threads(20)
    public synchronized void synchronizedIncrement() {
        count++;
    }

    @Benchmark
    @Threads(20)
    public void reentrantLockIncrement() {
        reentrantLock.lock();
        try {
            count++;
        } finally {
            reentrantLock.unlock();
        }
    }
}
