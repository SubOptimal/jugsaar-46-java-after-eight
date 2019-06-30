package jep102;

import static java.lang.management.ManagementFactory.getRuntimeMXBean;

public class    Pid {
    public static void main(String[] args) throws Exception {
        // before Java 9 the PID could be stripped from the JVM name
        String name = getRuntimeMXBean().getName();
        System.out.println("PID@host: " + name);

        // with Java 9 a process handle can be used
        ProcessHandle current = ProcessHandle.current();
        System.out.println("PID of JVM: " + current.pid());
        System.out.println("current = " + current.info().totalCpuDuration());

        // a process handle can also be obtained from a started process
        ProcessBuilder pb = new ProcessBuilder("sleep", "10");
        Process process = pb.start();
        ProcessHandle handle = process.toHandle();
        System.out.println("PID of sleep: " + handle.pid());
        pb.wait();
    }
}
