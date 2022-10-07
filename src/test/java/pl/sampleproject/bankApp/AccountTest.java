package pl.sampleproject.bankApp;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class AccountTest {
    Account account;
    @Mock TransactionRepository transactionRepository;
    @Captor ArgumentCaptor<Transaction> transactionArgumentCaptor;

    @BeforeEach
    public void init() {
        MockitoAnnotations.openMocks(this);
        account = new Account(transactionRepository);
    }

    @Test
    public void shouldCreateDepositTransactionWithTodaysDateAnd100AmountAndBalance() {
        //when
        account.deposit(100);
        verify(transactionRepository).add(transactionArgumentCaptor.capture());
        Transaction value = transactionArgumentCaptor.getValue();
        //then
        assertThat(value.getDate()).isEqualTo(LocalDate.now());
        assertThat(value.getAmount()).isEqualTo(100);
        assertThat(value.getBalance()).isEqualTo(100);
    }
    @Test
    public void shouldCreateDepositTransactionWithTodaysDateAnd100AmountAnd600Balance() {
        //given
        account.setBalance(500);
        //when
        account.deposit(100);
        verify(transactionRepository).add(transactionArgumentCaptor.capture());
        Transaction value = transactionArgumentCaptor.getValue();
        //then
        assertThat(value.getDate()).isEqualTo(LocalDate.now());
        assertThat(value.getAmount()).isEqualTo(100);
        assertThat(value.getBalance()).isEqualTo(600);
    }
    @Test
    public void shouldCreateWithdrawTransactionWithTodaysDateAnd100AmountAnd0Balance() {
        //given
        account.setBalance(100);
        //when
        account.withdraw(100);
        verify(transactionRepository).add(transactionArgumentCaptor.capture());
        Transaction value = transactionArgumentCaptor.getValue();
        //then
        assertThat(value.getDate()).isEqualTo(LocalDate.now());
        assertThat(value.getAmount()).isEqualTo(100);
        assertThat(value.getBalance()).isEqualTo(0);
    }

    @Test
    public void shouldThrowExceptionWhenTryingToWithdrawMoreThanYouHave() {
        //given
        account.setBalance(500);
        //when, then
        assertThrows(NotEnoughFundsOnAccountException.class, () -> account.withdraw(600));
    }
}