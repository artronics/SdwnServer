package artronics.satrapi.server.services;

import artronics.satrapi.server.model.Account;

public interface AccountService
{
    Account createAccount(Account account);
    Account findAccountByEmail(String email);
}
