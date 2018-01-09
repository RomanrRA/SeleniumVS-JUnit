package testCase.secondVariant;

import org.junit.Test;

public class Start {

    private StepsAndMethods step = new StepsAndMethods();

    @Test
    public void firstTestChromeYandex() {
        step.firstTestChromeYandex();
    }

    @Test
    public void firstTestChromeGoogle() {
        step.firstTestChromeGoogle();
    }

    @Test
    public void firstTestChromeRambler() {
        step.firstTestChromeRambler();
    }

    @Test
    public void firstTestFireFoxGoogle() {
        step.firstTestFireFoxGoogle();
    }

    @Test
    public void firstTestFireFoxRambler() {
        step.firstTestFireFoxRambler();
    }

    @Test
    public void firstTestFireFoxYandex() {
        step.firstTestFireFoxYandex();
    }

}
