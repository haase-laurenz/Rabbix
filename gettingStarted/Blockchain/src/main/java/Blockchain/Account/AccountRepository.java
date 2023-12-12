package Blockchain.Account;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Streamable;


public interface AccountRepository extends CrudRepository<Account,Long>{
    
    @Override
    Streamable<Account> findAll();

    Account findByName(String name,Sort sort);

}   
