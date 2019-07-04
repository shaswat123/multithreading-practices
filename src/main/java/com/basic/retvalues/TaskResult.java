package com.basic.retvalues;


public class TaskResult<S, T> {

    private S taskId;
    private T result;

    public TaskResult(S taskId, T result) {
        this.taskId = taskId;
        this.result = result;
    }

    public S getTaskId() {
        return taskId;
    }

    public T getResult() {
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskResult<?, ?> that = (TaskResult<?, ?>) o;
        return getTaskId().equals(that.getTaskId()) &&
                getResult().equals(that.getResult());
    }

    @Override
    public int hashCode() {
        return getTaskId().hashCode();
    }

    @Override
    public String toString() {
        return "TaskResult{" +
                "taskId=" + taskId +
                ", result=" + result +
                '}';
    }
}
