package artronics.sdwn.server.repositories;

import artronics.sdwn.server.model.Account;

public interface AccountRepo
{
    Account createAccount(Account data);
    Account findAccount(Long id);

    Account findAccountByEmail(String email);
}
