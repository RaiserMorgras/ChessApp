package MainTest;

import boardgame.chess.*;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.assertTrue;

public class Main {

    public static void main(String[] args) {

        Result result = JUnitCore.runClasses(MainTest.TestCases.class);

        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }

        System.out.println(result.wasSuccessful());
    }
}