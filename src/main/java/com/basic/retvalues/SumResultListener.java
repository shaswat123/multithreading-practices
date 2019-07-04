package com.basic.retvalues;

public class SumResultListener implements ResultListener<Integer> {

    private String taskId;

    public SumResultListener(String taskId) {
        this.taskId = taskId;
    }


    public void notifyResult(Integer result) {

        System.out.println("The result for task with task id " + taskId + " " + result);


    }
}
