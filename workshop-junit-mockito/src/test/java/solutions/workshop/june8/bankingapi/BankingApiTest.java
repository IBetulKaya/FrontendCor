package solutions.workshop.june8.bankingapi;

import com.workshop.june8.bankingapi.client.BankingClient;
import com.workshop.june8.bankingapi.exception.BankingApiException;
import com.workshop.june8.bankingapi.model.Account;
import com.workshop.june8.bankingapi.service.BankingApi;
import com.workshop.june8.bankingapi.service.LoanApi;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BankingApiTest {

    @Mock
    BankingApi bankingApi;

    @Mock
    LoanApi loanApi;

    @InjectMocks
    BankingClient bankingClient;

    @Test
    public void TransferSufficientFundsTest() throws BankingApiException {

        when(bankingApi.getBalance("12345")).thenReturn(100000D);

        boolean succes = bankingClient.transfer(23000D, "12345", "23456");
        assertEquals(true, succes);

    }

    @Test
    public void TransferInSufficientFundsTest() throws BankingApiException {

        when(bankingApi.getBalance("12345")).thenReturn(1000D);

        Exception exception = Assertions.assertThrows(BankingApiException.class, () -> {
            bankingClient.transfer(23000D, "12345", "23456");
        });

        assertEquals("Amount exceeds balance", exception.getMessage());
    }

    @Test
    public void applyForLoanOkTest() throws BankingApiException {

        Account account = new Account();
        account.setIban("7624542");
        account.setBsn("12345890");
        account.setName("Julia");

        when(loanApi.hasCurrentDebts(account.getBsn())).thenReturn(false);
        when(bankingApi.getBalance(account.getIban())).thenReturn(12000D);

        double amount = bankingClient.applyForLone(account);

        assertEquals(24000D, amount);
    }

    @Test
    public void applyForLoanNotOkTest() throws BankingApiException {

        Account account = new Account();
        account.setIban("7624542");
        account.setBsn("12345890");
        account.setName("Julia");

        when(loanApi.hasCurrentDebts(account.getBsn())).thenReturn(false);
        when(bankingApi.getBalance(account.getIban())).thenReturn(-1200D);

        Exception exception = Assertions.assertThrows(BankingApiException.class, () -> {
            bankingClient.applyForLone(account);
        });

        assertEquals("Loan declined: balance negative", exception.getMessage());
    }

    @Test
    public void applyForLoanNotOk2Test() throws BankingApiException {

        Account account = new Account();
        account.setIban("7624542");
        account.setBsn("12345890");
        account.setName("Julia");

        when(loanApi.hasCurrentDebts(account.getBsn())).thenReturn(true);
        when(bankingApi.getBalance(account.getIban())).thenReturn(12000D);

        Exception exception = Assertions.assertThrows(BankingApiException.class, () -> {
            bankingClient.applyForLone(account);
        });

        assertEquals("Loan declined: open debts", exception.getMessage());
    }

    @Test
    public void applyForLoanNotOk3Test() throws BankingApiException {

        Account account = new Account();
        account.setIban("7624542");
        account.setBsn("12345890");
        account.setName("Julia");

        when(loanApi.hasCurrentDebts(account.getBsn())).thenReturn(true).thenThrow();
        when(bankingApi.getBalance(account.getIban())).thenReturn(12000D);

        Exception exception = Assertions.assertThrows(BankingApiException.class, () -> {
            bankingClient.applyForLone(account);
        });

        assertEquals("Loan declined: open debts", exception.getMessage());
    }

    public void exampleTest() throws BankingApiException{
        final String PIN = "1234";
        Account account = new Account();
        account.setIban("NL98ING0000726635");
        account.setBsn("12345890");
        account.setName("Julia");

        BankingApi bankingApi = mock(BankingApi.class);
        when(bankingApi.login(PIN)).thenReturn( account);
        when(bankingApi.getBalance("NL98ING0000726635")).thenReturn(20000D);
        when(bankingApi.applyForLone(account)).thenReturn(true);
        when(bankingApi.transfer(3000D, "NL98ING0000726635", "NL96RAB0000347990")).thenReturn(true);
    }

    @Test
    public void givenLenientdStub_whenInvokingGetThenThrowUnnecessaryStubbingException() {
        List<String> mockList = Mockito.mock(ArrayList.class);
        mockList.add("two");
        lenient().when(mockList.add("one")).thenReturn(true);
        assertEquals( true, mockList.add("one"));
        when(mockList.get(anyInt())).thenReturn("hello");
        assertEquals( "hello", mockList.get(1));
    }
}

