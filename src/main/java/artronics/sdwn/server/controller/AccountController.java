package artronics.sdwn.server.controller;

import artronics.sdwn.server.controller.exceptions.ConflictException;
import artronics.sdwn.server.model.Account;
import artronics.sdwn.server.resources.AccountResource;
import artronics.sdwn.server.resources.asm.AccountResourceAsm;
import artronics.sdwn.server.services.AccountService;
import artronics.sdwn.server.services.exceptions.ModelAlreadyExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/accounts")
public class AccountController
{
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService)
    {
        this.accountService = accountService;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<AccountResource> createAccount(@RequestBody AccountResource sentAcc){
        try {
            Account createdAccount = accountService.createAccount(sentAcc.toAccount(sentAcc));
            AccountResource res = new AccountResourceAsm().toResource(createdAccount);
            HttpHeaders headers = new HttpHeaders();
//        headers.setLocation(URI.create(res.getLink("self").getHref()));
            return new ResponseEntity<AccountResource>(res, headers, HttpStatus.CREATED);
        }catch (ModelAlreadyExistsException e) {
            throw new ConflictException();
        }
    }

}
