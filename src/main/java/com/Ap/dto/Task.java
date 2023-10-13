package com.Ap.dto;

import lombok.Data;
import lombok.Getter;

@Data
public class Task {
    private TaskIdDo taskIdDo;
    private String taskType;
    private String taskDesc;
    private String status;
    private String priority;
    private String compDeadline;
    private String criticalDeadline;
    private String updatedBy;
    private String updatedOn;
    private String createdBy;
    private String createdOn;
    private String redirectURL;

}
