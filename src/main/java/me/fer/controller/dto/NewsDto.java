package me.fer.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import me.fer.domain.model.News;

@Data
@Builder
@JsonPropertyOrder({"id", "icon", "description"})
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null values during serialization
public class NewsDto {

    private Long id;
    private String icon;
    private String description;

    public NewsDto(News model) {
        this.id = model.getId();
        this.icon = model.getIcon();
        this.description = model.getDescription();
    }

    public News toModel() {
        News news = new News();
        news.setId(id);
        news.setIcon(icon);
        news.setDescription(description);
        return news;
    }
}
