package com.Ap.dto;

import lombok.Data;

@Data
public class TaskAttributesList {
    private TaskAttributeIdDo taskAttributeIdDo;
    private String attrValue;
    private String createdBy;
    private String createdOn;
    private String updatedBy;
    private String updatedOn;
}
