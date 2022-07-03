package com.demo.api.product.dto.filter;

import com.demo.api.core.dto.filter.BaseFilter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductFilter extends BaseFilter {
    private Long id;

    private Double minPrice;
    private Double maxPrice;

    @Override
    public String[] getSearchableFields() {
        return new String[] {
                "title",
                "description"
        };
    }

    @Override
    public String[] getSortableFields() {
        return new String[] {
                "name",
                "price"
        };
    }

    @Schema(name = "sorts", example = "sorts=+name&-price&createdAt")
    @Override
    public String[] getSorts() {
        return super.getSorts();
    }
}

