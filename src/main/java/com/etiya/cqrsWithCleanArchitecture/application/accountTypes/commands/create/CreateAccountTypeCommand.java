package com.etiya.cqrsWithCleanArchitecture.application.accountTypes.commands.create;

import lombok.Builder;
import lombok.Data;
import org.axonframework.modelling.command.TargetAggregateIdentifier;


@Data
@Builder//model mapper gibi
public class CreateAccountTypeCommand {//domainde hangi alanla ilgili ne yapacağız.

    @TargetAggregateIdentifier//bütün iventlerdeki belirleyici alan. benim tc nom budur.
    private String accountTypeId;

    private String accountName;

    private String description;

    private double price;

}
