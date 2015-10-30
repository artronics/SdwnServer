package artronics.sdwn.server.repositories.jpa;

import artronics.sdwn.server.model.Account;
import artronics.sdwn.server.repositories.AccountRepo;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

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
}
