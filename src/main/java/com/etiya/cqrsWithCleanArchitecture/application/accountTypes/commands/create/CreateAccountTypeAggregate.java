package com.etiya.cqrsWithCleanArchitecture.application.accountTypes.commands.create;

import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.modelling.command.AggregateIdentifier;
import org.axonframework.modelling.command.AggregateLifecycle;
import org.axonframework.spring.stereotype.Aggregate;
import org.springframework.beans.BeanUtils;


@Aggregate
public class CreateAccountTypeAggregate {
    @AggregateIdentifier
    private String accountTypeId;

    private String accountName;

    private String description;

    private double price;

    @CommandHandler//komutlar burada
    public CreateAccountTypeAggregate(CreateAccountTypeCommand command) {
        AccountTypeCreatedEvent accountTypeCreatedEvent = new AccountTypeCreatedEvent();

        BeanUtils.copyProperties(command, accountTypeCreatedEvent);//model mapper gibi

        AggregateLifecycle.apply((accountTypeCreatedEvent));//axon

    }

    @EventSourcingHandler//servis bus a gönderilercek verileri içerir// olay kaynak işleyicisi.
    //iş kuralları
    //kuyruğa atıyor. Axon da event sourcing yapıyoruz.
    public void on(AccountTypeCreatedEvent accountTypeCreatedEvent) {
        this.accountTypeId=accountTypeCreatedEvent.getAccountTypeId();
        this.accountName=accountTypeCreatedEvent.getAccountName();
        this.description=accountTypeCreatedEvent.getDescription();
        this.price=accountTypeCreatedEvent.getPrice();

    }

}
