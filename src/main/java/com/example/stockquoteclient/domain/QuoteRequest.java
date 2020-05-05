package com.example.stockquoteclient.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Pattern;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuoteRequest {

    @Pattern(regexp = "^GOOG$|^ORCL$")
    private String quote;
}
