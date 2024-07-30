package me.fer.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import me.fer.domain.model.User;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@JsonPropertyOrder({"id", "name", "account", "card", "features", "news"})
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null values during serialization
public class UserDto {

    private Long id;
    private String name;
    private AccountDto account;
    private CardDto card;
    private List<FeatureDto> features;
    private List<NewsDto> news;

    public UserDto(User model) {
        this.id = model.getId();
        this.name = model.getName();
        this.account = model.getAccount() != null ? new AccountDto(model.getAccount()) : null;
        this.card = model.getCard() != null ? new CardDto(model.getCard()) : null;
        this.features = model.getFeatures() != null ? model.getFeatures().stream().map(FeatureDto::new).collect(Collectors.toList()) : null;
        this.news = model.getNews() != null ? model.getNews().stream().map(NewsDto::new).collect(Collectors.toList()) : null;
    }

    public User toModel() {
        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setAccount(account != null ? account.toModel() : null);
        user.setCard(card != null ? card.toModel() : null);
        user.setFeatures(features != null ? features.stream().map(FeatureDto::toModel).collect(Collectors.toList()) : null);
        user.setNews(news != null ? news.stream().map(NewsDto::toModel).collect(Collectors.toList()) : null);
        return user;
    }
}
