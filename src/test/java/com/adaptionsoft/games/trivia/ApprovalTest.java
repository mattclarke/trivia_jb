package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ApprovalTest {
    @Test
    public void testRunningGame() throws FileNotFoundException {
        File outputFile = new File("stdout_log.txt");
        System.setOut(new PrintStream(outputFile));

        GameRunner.main(null);

        String result = readStdOutputLog(outputFile);

        Approvals.verify(result);
    }

    private String readStdOutputLog(File outputFile) throws FileNotFoundException {
        StringBuilder resultStringBuilder = new StringBuilder();
        Scanner myReader = new Scanner(outputFile);
        while (myReader.hasNextLine()) {
            resultStringBuilder.append(myReader.nextLine()).append("\n");
        }
        myReader.close();
        return resultStringBuilder.toString();
    }
}
