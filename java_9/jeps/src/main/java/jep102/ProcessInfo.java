package jep102;

public class ProcessInfo {
    public static void main(String[] args) throws Exception {
        // a process handle can also be obtained from a started process
        ProcessBuilder pb1 = new ProcessBuilder("sleep", "20");
        Process process1 = pb1.start();
        ProcessHandle handle1 = process1.toHandle();
        System.out.println("PID sleep 20: " + handle1.pid());

        ProcessBuilder pb2 = new ProcessBuilder("stress-ng", "--cpu", "1", "--timeout", "10");
        Process process2 = pb2.start();
        ProcessHandle handle2 = process2.toHandle();
        System.out.println("PID stress-ng: " + handle2.pid());

        // print information of the child processes
        ProcessHandle.current().children().forEach(ProcessInfo::printInfo);
    }

    private static void printInfo(ProcessHandle p) {
        System.out.printf("started: %s   PID: %5d   command line: %s%n",
                p.info().startInstant().get(),
                p.pid(),
                // contains "p.info().command()" and "p.info().arguments()"
                p.info().commandLine()
        );
    }
}
