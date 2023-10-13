package com.Ap.dto;

import lombok.Data;

@Data
public class TaskOwnersList {
    private TaskOwnerIdDo taskOwnerIdDo;
    private String createdBy;
    private String createdOn;
    private String updatedBy;
    private String updatedOn;
    private String ownerType;
    private int isPrimary;
}
