package com.lion.task.policy;

public class LionHomeworkPolicy implements HomeworkPolicy {

    @Override
    public Boolean isSubmittable() {
        return true;
    }
}
