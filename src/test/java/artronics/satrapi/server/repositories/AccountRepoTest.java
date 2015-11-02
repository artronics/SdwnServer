package artronics.satrapi.server.repositories;

import artronics.satrapi.server.model.Account;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/business-config.xml")
public class AccountRepoTest
{
    @Autowired
    private AccountRepo repo;

    private Account account;

    @Before
    @Transactional
    @Rollback(false)
    public void setUp() throws Exception
    {
        account = new Account();
        account.setEmail("jalalhosseiny@gmail.com");
        account.setPassword("foo");

        repo.createAccount(account);
    }

    @Test
    @Transactional
    public void create_account(){
        Account createdAcc = repo.findAccount(account.getId());


        assertNotNull(createdAcc);
        assertEquals(createdAcc.getEmail(),"jalalhosseiny@gmail.com");
        assertEquals(createdAcc.getPassword(),"foo");
    }

    @Test
    @Transactional
    public void find_account_by_email()
    {
        Account fetchAcc = repo.findAccountByEmail("jalalhosseiny@gmail.com");

        assertNotNull(fetchAcc);
        assertEquals(fetchAcc.getPassword(), account.getPassword());
        assertEquals(fetchAcc.getEmail(), account.getEmail());
    }
}