package artronics.sdwn.server.services.impl;

import artronics.sdwn.server.model.Account;
import artronics.sdwn.server.repositories.AccountRepo;
import artronics.sdwn.server.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService
{
    @Autowired
    private AccountRepo accountRepo;

    @Override
    public Account findAccountByEmail(String email)
    {
        return null;
    }

    @Override
    public Account createAccount(Account account)
    {
        return null;
    }
}
