package me.fer.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import me.fer.domain.model.Account;

import java.math.BigDecimal;

@Data
@Builder
@JsonPropertyOrder({"id", "number", "agency", "balance", "limit"})
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null values during serialization
public class AccountDto {

    private Long id;
    private String number;
    private String agency;
    private BigDecimal balance;
    private BigDecimal limit;

    public AccountDto(Account model) {
        this.id = model.getId();
        this.number = model.getNumber();
        this.agency = model.getAgency();
        this.balance = model.getBalance();
        this.limit = model.getLimit();
    }

    public Account toModel() {
        Account account = new Account();
        account.setId(id);
        account.setNumber(number);
        account.setAgency(agency);
        account.setBalance(balance);
        account.setLimit(limit);
        return account;
    }
}
