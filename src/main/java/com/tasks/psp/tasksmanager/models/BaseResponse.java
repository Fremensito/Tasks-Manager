package com.tasks.psp.tasksmanager.models;

import java.util.List;

public class BaseResponse {
    public String result;
    public JobTask trabajo;
    public List<JobTask> trabajos;
    public List<String> mensaje;

    public BaseResponse(){}
}
