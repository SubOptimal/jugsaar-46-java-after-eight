package jep213;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TryWithResourcePreJava9 {

    static void localResources() throws IOException {
        try (BufferedReader reader = Files.newBufferedReader(Paths.get("lorem"));
             BufferedWriter writer = Files.newBufferedWriter(Paths.get("ipsum"))
        ) {
            copyLine(reader, writer);
        }
    }

    static void externalResources(BufferedReader reader, BufferedWriter writer) throws IOException {
        try (BufferedReader r = reader; BufferedWriter w = writer) {
            copyLine(r, w);
        }
    }

    public static void main(String[] args) throws IOException {
        localResources();

        BufferedReader reader = Files.newBufferedReader(Paths.get("lorem"));
        BufferedWriter writer = Files.newBufferedWriter(Paths.get("ipsum"));
        externalResources(reader, writer);
    }

    private static void copyLine(BufferedReader reader, BufferedWriter writer) throws IOException {
        for (String line = reader.readLine(); line != null; line = reader.readLine()) {
            writer.write(line);
            writer.newLine();
        }
    }
}
