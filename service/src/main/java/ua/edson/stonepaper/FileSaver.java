package ua.edson.stonepaper;

import java.io.File;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSaver extends Saver {

    @Override
    public void saveScore(Integer number1, Integer number2 ) {

        try (PrintWriter out = new PrintWriter("score.txt")) {
            out.println(number1);
            out.println(number2);
        } catch (Exception ex) {

        }
    }

    @Override
    public Integer getScore(Integer number1, Integer number2) {
        try {
            String content = Files.readString(Paths.get("score.txt"), StandardCharsets.UTF_8);
            return Integer.valueOf(content.trim());
        } catch (Exception ex) {
            return null;
        }
    }
}
