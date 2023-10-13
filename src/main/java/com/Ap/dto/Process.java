package com.Ap.dto;

import lombok.Data;

@Data
public class Process {
    private String processId;
    private String systemId;
    private String processName;
    private String processDesc;
    private String subject;
    private String requestId;
    private String completedAt;
    private String completedBy;
    private String updatedBy;
    private String updatedOn;
    private String createdBy;
    private String createdOn;
}
