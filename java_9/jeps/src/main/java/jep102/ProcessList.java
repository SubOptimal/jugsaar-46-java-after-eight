package jep102;

import static java.util.Comparator.comparing;

import java.time.Duration;
import java.time.Instant;
import java.util.Comparator;

public class ProcessList {
    public static void main(String[] args) {
        Comparator<ProcessHandle> cpuDuration =
                comparing(ph -> ph.info().totalCpuDuration().orElse(Duration.ZERO));

        ProcessHandle.allProcesses()
                .sorted(cpuDuration.reversed())
                .limit(4)
                .forEach(ProcessList::printProcessInfo);
    }

    private static void printProcessInfo(ProcessHandle ph) {
        printLine("PID", ph.pid());
        ProcessHandle.Info info = ph.info();
        printLine("command", info.command().orElse("[not available]"));
        printLine("start time", info.startInstant().orElse(Instant.now()));
        printLine("duration (ms)", info.totalCpuDuration().orElse(Duration.ZERO).toMillis());
        System.out.println();
    }
    private static void printLine(String name, Object value) {
        String format = "%-13s: %s%n";
        System.out.printf(format, name, value);
    }
}
