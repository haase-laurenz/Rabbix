package Blockchain.Account;


import org.springframework.data.repository.CrudRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;


@Repository
public interface AccountRepository extends CrudRepository<Account,Long>{
    
    @Override
    Streamable<Account> findAll();

    Account findByName(String name);

}   
