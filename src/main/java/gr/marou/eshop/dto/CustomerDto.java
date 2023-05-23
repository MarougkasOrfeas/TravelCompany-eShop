package main.java.gr.marou.eshop.dto;

import main.java.gr.marou.eshop.domain.enums.CustomerCategory;
import lombok.Data;

/**
 Data transfer object (DTO) for Customer information.
 */
@Data
public class CustomerDto {

    private long id;
    private String name;
    private CustomerCategory customerCategory;
}
