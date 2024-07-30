package me.fer.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import me.fer.domain.model.Card;

import java.math.BigDecimal;

@Data
@Builder
@JsonPropertyOrder({"id", "number", "limit"})
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null values during serialization
public class CardDto {

    private Long id;
    private String number;
    private BigDecimal limit;

    public CardDto(Card model) {
        this.id = model.getId();
        this.number = model.getNumber();
        this.limit = model.getLimit();
    }

    public Card toModel() {
        Card card = new Card();
        card.setId(id);
        card.setNumber(number);
        card.setLimit(limit);
        return card;
    }
}
