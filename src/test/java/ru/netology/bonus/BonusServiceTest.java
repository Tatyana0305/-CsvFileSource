package ru.netology.bonus;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BonusServiceTest {

    @ParameterizedTest
    @CsvFileSource(resources = {"data/registered/data.csv", "data/unregistered/data.csv"},
            delimiter = '|', numLinesToSkip = 2)
    void shouldCalculate(String testName, long amount, boolean registered, long expected) {
        BonusService service = new BonusService();
        {
            long actual = service.calculate(amount, registered);
            assertEquals(expected, actual);
        }
    }

}

//    @CsvSource(value = {"'registered user, bonus under limit',100060,true,30",
//            "'registered user, bonus over limit',100000060,true,500"})
//    void shouldCalculate(String testName, long amount, boolean registered, long expected) {
//        BonusService service = new BonusService();
//
//        //вызываем целевой метод:
//        long actual = service.calculate(amount, registered);
//
//        //Производим проверку, сравниваем фактический и ожидаемый результат:
//        assertEquals(expected, actual);
//    }

