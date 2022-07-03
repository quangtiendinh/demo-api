package com.demo.api.core.dto.filter;

import com.fasterxml.jackson.annotation.JsonIgnore;

public interface SearchingDefinitions {
    @JsonIgnore
    String[] getSearchableFields();
}
