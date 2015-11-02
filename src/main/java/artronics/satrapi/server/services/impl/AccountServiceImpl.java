package artronics.satrapi.server.services.impl;

import artronics.satrapi.server.model.Account;
import artronics.satrapi.server.repositories.AccountRepo;
import artronics.satrapi.server.services.AccountService;
import artronics.satrapi.server.services.exceptions.ModelAlreadyExistsException;
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
        return accountRepo.findAccountByEmail(email);
    }

    @Override
    public Account createAccount(Account account)
    {
        Account fetched = findAccountByEmail(account.getEmail());
        if (fetched != null) {
            throw new ModelAlreadyExistsException();
        }

        return accountRepo.createAccount(account);
    }
}
