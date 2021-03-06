package com.example.graphql.resolver;

import com.example.graphql.domain.bank.BankAccount;
import com.example.graphql.domain.bank.Client;
import com.example.graphql.domain.bank.Currency;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Slf4j
@Component
public class BankAccountResolver implements GraphQLQueryResolver {

    public BankAccount bankAccount(UUID id){
        log.info("Retrieving bank account id: {}", id);

        var clientA = Client.builder()
                .id(UUID.randomUUID())
                .firstName("Tom")
                .lastName("Hardes")
                .build();
        var clientB = Client.builder()
                .id(UUID.randomUUID())
                .firstName("Steven")
                .lastName("Harvey")
                .build();

        clientA.setClient(clientB);
        clientB.setClient(clientA);

        return BankAccount.builder().id(id).currency(Currency.USD).client(clientA).build();
    }
}
