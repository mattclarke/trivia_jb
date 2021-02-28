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
        File outputFile = new File("stdout_game.txt");
        System.setOut(new PrintStream(outputFile));

        GameRunner.main(null);

        String result = readStdOutputLog(outputFile);

        Approvals.verify(result);
    }

    @Test
    public void addingTwoPlayers() throws FileNotFoundException {
        File outputFile = new File("stdout_add_players.txt");
        System.setOut(new PrintStream(outputFile));

        Game game = new Game();
        game.add("Matt");
        game.add("Bron");

        String result = readStdOutputLog(outputFile);

        Approvals.verify(result);
    }

    @Test
    public void onWrongAnswer() throws FileNotFoundException {
        File outputFile = new File("stdout_on_wrong_answer.txt");
        System.setOut(new PrintStream(outputFile));

        Game game = new Game();
        game.add("Matt");
        game.wrongAnswer();

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
