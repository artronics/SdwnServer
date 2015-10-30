package artronics.sdwn.server.resources.asm;

import artronics.sdwn.server.controller.AccountController;
import artronics.sdwn.server.model.Account;
import artronics.sdwn.server.resources.AccountResource;
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
