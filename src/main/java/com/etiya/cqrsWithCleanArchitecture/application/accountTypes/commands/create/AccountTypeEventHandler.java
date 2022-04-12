package com.etiya.cqrsWithCleanArchitecture.application.accountTypes.commands.create;

import com.etiya.cqrsWithCleanArchitecture.domain.AccountType;
import com.etiya.cqrsWithCleanArchitecture.persistence.AccountTypeRepository;
import org.axonframework.eventhandling.EventHandler;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AccountTypeEventHandler {
    private AccountTypeRepository accountTypeRepository;

    @Autowired
    public AccountTypeEventHandler(AccountTypeRepository accountTypeRepository) {
        this.accountTypeRepository = accountTypeRepository;
    }
    @EventHandler// olayları burada işliyor.
    public void on(AccountTypeCreatedEvent accountTypeCreatedEvent){
        AccountType accountType =new AccountType();
        BeanUtils.copyProperties(accountTypeCreatedEvent,accountType);
        this.accountTypeRepository.save(accountType);
        /*
        Yukarıdaki işlem model mapper ın yaptığını yapıyor.
         */

    }
}
