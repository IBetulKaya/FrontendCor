package com.workshop.june8.calculation;

import com.workshop.june8.bankingapi.exception.BankingApiException;
import com.workshop.june8.bankingapi.service.BankingApi;
import com.workshop.june8.calculation.exception.CalculationException;
import com.workshop.june8.calculation.exception.EndpointException;
import com.workshop.june8.calculation.webservice.BankingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.function.Executable;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class CalculationTest {

    String now = "20200608";

    @Mock
    BankingService bankingService;

    @InjectMocks
    InterestCalculator interestCalculator;

    @Test
    public void testInterestRateTomorrow() throws EndpointException, CalculationException {

        LocalDate tomorrow = LocalDate.now().plusDays(1);

        when(bankingService.getInterestRate( tomorrow)).thenReturn(2.0);

        double result = interestCalculator.calculateInterest(3000.0, 2, tomorrow);

        assertEquals( 81000.0, result);

    }

    @Test
    public void testInterestRateToday() throws EndpointException, CalculationException {

        when(bankingService.getInterestRate( LocalDate.now())).thenReturn(2.0);

        double result = interestCalculator.calculateInterest(3000.0, 2);

        assertEquals( 81000.0, result);

    }

    @Test
    public void testInterestRateServiceNotAvailable() throws EndpointException, CalculationException {

        when(bankingService.getInterestRate( LocalDate.now())).thenThrow( new EndpointException("Endpoint is not available"));

        Exception exception = Assertions.assertThrows(CalculationException.class, () -> {
            double result = interestCalculator.calculateInterest(3000.0, 2);
        });

        assertEquals("Calculation failed due to: Endpoint is not available", exception.getMessage());
    }
}
