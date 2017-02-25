package com.wijdemans.error;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;

/**
 * Body of errors message.
 * <p>
 * Body contains a list of errors that have occured.
 */
@JsonRootName(value = "errors")
public class Errors {

    private ObjectMapper mapper = new ObjectMapper();

    @JsonProperty
    private List<Error> errors = new ArrayList<>();

    public Errors(List<Error> errors) {
        this.errors = errors;
    }

    public Errors(Error errors) {
        this.errors.add(errors);
    }

    public Errors(Exception e) {
        this.errors.add(new Error(e));
    }

    public String asJson() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error mapping errors to json.");
        }
    }
}
