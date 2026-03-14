package com.right.digits.platform.service.registry.microservice.entities;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RightDigitsBasicCommonEntity {

    private String uniqueUUID;

    private Date createdDate;

    private Date lastModifiedDate;

    private Long id;

}
