package artronics.satrapi.server.repositories;

import artronics.satrapi.server.model.Account;

public interface AccountRepo
{
    Account createAccount(Account data);
    Account findAccount(Long id);

    Account findAccountByEmail(String email);
}
