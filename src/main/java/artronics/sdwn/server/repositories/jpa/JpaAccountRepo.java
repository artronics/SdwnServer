package artronics.sdwn.server.repositories.jpa;

import artronics.sdwn.server.model.Account;
import artronics.sdwn.server.repositories.AccountRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Query;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class JpaAccountRepo implements AccountRepo
{
    @PersistenceContext
    private EntityManager em;

    @Override
    public Account findAccount(Long id)
    {
        return em.find(Account.class,id);
    }

    @Override
    public Account createAccount(Account data)
    {
        em.persist(data);

        return data;
    }

    @Override
    public Account findAccountByEmail(String email)
    {
        Query query = em.createQuery("SELECT a FROM Account a WHERE a.email=?1");
        query.setParameter(1, email);

        List<Account> results = query.getResultList();
        if (results.size() == 0)
            return null;

        return results.get(0);
    }
}
