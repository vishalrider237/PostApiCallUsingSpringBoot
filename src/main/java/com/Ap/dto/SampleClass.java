package com.Ap.dto;

import lombok.Data;

import java.util.List;
@Data
public class SampleClass {
    private Task task;
    private Process process;;
    private List<TaskOwnersList> taskOwnersList;
    private List<TaskAttributesList>taskAttributesList;


}
