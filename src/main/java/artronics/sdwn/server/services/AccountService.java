package artronics.sdwn.server.services;

import artronics.sdwn.server.model.Account;

public interface AccountService
{
    Account createAccount(Account account);
    Account findAccountByEmail(String email);
}
