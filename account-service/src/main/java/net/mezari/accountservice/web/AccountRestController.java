package net.mezari.accountservice.web;

//import net.mezari.accountservice.clients.CustomerRestClient;
import net.mezari.accountservice.entities.BankAccount;
import net.mezari.accountservice.model.Customer;
import net.mezari.accountservice.repository.BankAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountRestController {
    private BankAccountRepository accountRepository;
 //   private CustomerRestClient customerRestClient;

    public AccountRestController(BankAccountRepository accountRepository/*,
                                 CustomerRestClient customerRestClient*/) {
        this.accountRepository = accountRepository;
        //this.customerRestClient = customerRestClient;
    }
    @GetMapping("/accounts")
    public List<BankAccount> accountList(){
       /* List<BankAccount> accountList = accountRepository.findAll();
        accountList.forEach(acc->{
            acc.setCustomer(customerRestClient.findCustomerById(acc.getCustomerId()));
        });
        return accountList;*/
        return accountRepository.findAll();
    }
    @GetMapping("/accounts/{id}")
    public BankAccount bankAccountById(@PathVariable String id){
        BankAccount bankAccount= accountRepository.findById(id).get();
        /*Customer customer=customerRestClient.findCustomerById(bankAccount.getCustomerId());
        bankAccount.setCustomer(customer);
        return bankAccount;*/
        return accountRepository.findById(id).get();
    }
}
