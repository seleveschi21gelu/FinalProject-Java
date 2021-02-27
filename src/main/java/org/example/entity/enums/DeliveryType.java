package org.example.entity.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum DeliveryType {
    @JsonProperty("bags")
    Bags,
    @JsonProperty("unit")
    Unit,
    @JsonProperty("boxes")
    Boxes,
    @JsonProperty("pallet")
    Pallet

}
