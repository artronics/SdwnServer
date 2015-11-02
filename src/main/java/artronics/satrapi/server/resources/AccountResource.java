package artronics.satrapi.server.resources;

import artronics.satrapi.server.model.Account;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.ResourceSupport;

public class AccountResource extends ResourceSupport
{
    private String email;
    private String password;

    public Account toAccount(AccountResource resource){
        Account account = new Account();
        account.setEmail(email);
        account.setPassword(password);

        return account;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    @JsonIgnore
    public String getPassword()
    {
        return password;
    }

    @JsonProperty
    public void setPassword(String password)
    {
        this.password = password;
    }
}
