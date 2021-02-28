package com.adaptionsoft.games.trivia;

import com.adaptionsoft.games.trivia.runner.GameRunner;
import com.adaptionsoft.games.uglytrivia.Game;
import org.approvaltests.Approvals;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class ApprovalTest {
    @Test
    public void runningFullGame() throws FileNotFoundException {
        File outputFile = new File("stdout_capture.txt");
        System.setOut(new PrintStream(outputFile));

        GameRunner.main(null);

        String result = readStdOutputLog(outputFile);

        Approvals.verify(result);
    }

    @Test
    public void addingTwoPlayers() throws FileNotFoundException {
        File outputFile = new File("stdout_capture.txt");
        System.setOut(new PrintStream(outputFile));

        Game game = new Game();
        game.add("Matt");
        game.add("Bron");

        String result = readStdOutputLog(outputFile);

        Approvals.verify(result);
    }

    @Test
    public void onWrongAnswer() throws FileNotFoundException {
        File outputFile = new File("stdout_capture.txt");
        System.setOut(new PrintStream(outputFile));

        Game game = new Game();
        game.add("Matt");
        game.wrongAnswer();

        String result = readStdOutputLog(outputFile);

        Approvals.verify(result);
    }

    @Test
    public void wasCorrectlyAnswered() throws FileNotFoundException {
        File outputFile = new File("stdout_capture.txt");
        System.setOut(new PrintStream(outputFile));

        Game game = new Game();
        game.add("Matt");
        game.wasCorrectlyAnswered();

        String result = readStdOutputLog(outputFile);

        Approvals.verify(result);
    }

    @Test
    public void onlyPlayerRollsAOne() throws FileNotFoundException {
        File outputFile = new File("stdout_capture.txt");
        System.setOut(new PrintStream(outputFile));

        Game game = new Game();
        game.add("Matt");
        game.roll(1);

        String result = readStdOutputLog(outputFile);

        Approvals.verify(result);
    }

    @Test
    public void onlyPlayerRollsATwo() throws FileNotFoundException {
        File outputFile = new File("stdout_capture.txt");
        System.setOut(new PrintStream(outputFile));

        Game game = new Game();
        game.add("Matt");
        game.roll(2);

        String result = readStdOutputLog(outputFile);

        Approvals.verify(result);
    }

    @Test
    public void onlyPlayerRollsAThree() throws FileNotFoundException {
        File outputFile = new File("stdout_capture.txt");
        System.setOut(new PrintStream(outputFile));

        Game game = new Game();
        game.add("Matt");
        game.roll(3);

        String result = readStdOutputLog(outputFile);

        Approvals.verify(result);
    }

    @Test
    public void onlyPlayerRollsAFour() throws FileNotFoundException {
        File outputFile = new File("stdout_capture.txt");
        System.setOut(new PrintStream(outputFile));

        Game game = new Game();
        game.add("Matt");
        game.roll(4);

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
