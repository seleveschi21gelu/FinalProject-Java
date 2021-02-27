package org.example.entity.enums;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;


public enum Status {
    @JsonProperty("advance")
    ADVANCE,
    @JsonProperty("paid")
    PAID,
    @JsonProperty("unpaid")
    UNPAID;


}
