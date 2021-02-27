package org.example.entity.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum  Type {
    @JsonProperty("red")
    Red,
    @JsonProperty("gray")
    Gray,
    @JsonProperty("white")
    White
}
