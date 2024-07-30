package me.fer.controller.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Data;
import me.fer.domain.model.Feature;

@Data
@Builder
@JsonPropertyOrder({"id", "icon", "description"})
@JsonInclude(JsonInclude.Include.NON_NULL) // Exclude null values during serialization
public class FeatureDto {

    private Long id;
    private String icon;
    private String description;

    public FeatureDto(Feature model) {
        this.id = model.getId();
        this.icon = model.getIcon();
        this.description = model.getDescription();
    }

    public Feature toModel() {
        Feature feature = new Feature();
        feature.setId(id);
        feature.setIcon(icon);
        feature.setDescription(description);
        return feature;
    }
}
