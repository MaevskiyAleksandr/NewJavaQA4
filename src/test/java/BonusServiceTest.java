import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);
    }


    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);


        Assertions.assertEquals(expected, actual);
    }


    @Test
    void calculationOfThePercentageForAnUnregisteredUserUnderLimit() {
        BonusService service = new BonusService();

        long amount = 1000;
        boolean registered = false;
        long expected = 10;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);


    }

    @Test

    void calculationOfTheInterestRateForAnUnregisteredUserOverTheLimit() {
        BonusService service = new BonusService();

        long amount = 1_000_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void maxBonusForAnUnregisteredUser() {
        BonusService service = new BonusService();

        long amount = 50_000;
        boolean registered = false;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }

    @Test
    void maxBonusForRegisteredUser() {
        BonusService service = new BonusService();

        long amount = 16_667;
        boolean registered = true;
        long expected = 500;

        long actual = service.calculate(amount, registered);

        Assertions.assertEquals(expected, actual);

    }


}
