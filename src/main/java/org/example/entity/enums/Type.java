package org.example.entity.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum  Type {
    @JsonProperty("red")
    red,
    @JsonProperty("gray")
    gray,
    @JsonProperty("white")
    white
}
