package artronics.satrapi.server.resources.asm;

import artronics.satrapi.server.controller.AccountController;
import artronics.satrapi.server.resources.AccountResource;
import artronics.satrapi.server.model.Account;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class AccountResourceAsm extends ResourceAssemblerSupport<Account,AccountResource>
{
    public AccountResourceAsm()
    {
        super(AccountController.class, AccountResource.class);
    }

    @Override
    public AccountResource toResource(Account account)
    {
        AccountResource resource = new AccountResource();
        resource.setPassword(account.getPassword());
        resource.setEmail(account.getEmail());

        return resource;
    }
}
