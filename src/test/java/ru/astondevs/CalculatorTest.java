package ru.astondevs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    // ============ ПОЗИТИВНЫЕ СЦЕНАРИИ ============

    @Test
    @DisplayName("Сложение двух положительных чисел")
    void shouldAddTwoPositiveNumbers() {
        assertEquals(5.0, calculator.add(2, 3));
    }

    @Test
    @DisplayName("Вычитание второго числа из первого")
    void shouldSubtractSecondFromFirst() {
        assertEquals(7.0, calculator.subtract(10, 3));
    }

    @Test
    @DisplayName("Умножение двух чисел")
    void shouldMultiplyTwoNumbers() {
        assertEquals(20.0, calculator.multiply(4, 5));
    }

    @Test
    @DisplayName("Деление первого числа на второе")
    void shouldDivideFirstBySecond() {
        assertEquals(2.5, calculator.divide(5, 2), 1e-9);
    }

    // ============ НЕГАТИВНЫЙ СЦЕНАРИЙ ============

    @Test
    @DisplayName("Деление на ноль выбрасывает ArithmeticException")
    void shouldThrowExceptionWhenDivideByZero() {
        ArithmeticException exception = assertThrows(
                ArithmeticException.class,
                () -> calculator.divide(10, 0)
        );
        assertEquals("Деление на ноль запрещено", exception.getMessage());
    }

    // ============ ДОПОЛНИТЕЛЬНЫЕ СЦЕНАРИИ ============

    @ParameterizedTest(name = "{0} + {1} = {2}")
    @DisplayName("Параметризованный тест сложения")
    @CsvSource({
            "1, 1, 2",
            "-1, -1, -2",
            "0, 0, 0",
            "2.5, 2.5, 5.0",
            "100, -50, 50"
    })
    void shouldAddDifferentNumbers(double a, double b, double expected) {
        assertEquals(expected, calculator.add(a, b), 1e-9);
    }

    @Test
    @DisplayName("Умножение на ноль даёт ноль")
    void shouldReturnZeroWhenMultiplyByZero() {
        assertEquals(0.0, calculator.multiply(123, 0));
    }

    @Test
    @DisplayName("Работа с отрицательными числами")
    void shouldHandleNegativeNumbers() {
        assertEquals(-8.0, calculator.multiply(-4, 2));
        assertEquals(-6.0, calculator.add(-3, -3));
    }

    @Test
    @DisplayName("Деление числа на само себя даёт единицу")
    void shouldReturnOneWhenDivideBySelf() {
        assertEquals(1.0, calculator.divide(42, 42), 1e-9);
    }

    @Test
    @DisplayName("Деление нуля на число даёт ноль")
    void shouldReturnZeroWhenDivideZeroByNumber() {
        assertEquals(0.0, calculator.divide(0, 5), 1e-9);
    }

    @Test
    @DisplayName("Деление на ноль.0 (double) тоже выбрасывает исключение")
    void shouldThrowExceptionWhenDivideByZeroDouble() {
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0.0));
    }
}