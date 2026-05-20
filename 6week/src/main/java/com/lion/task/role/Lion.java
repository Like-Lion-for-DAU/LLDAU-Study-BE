package com.lion.task.role;

import com.lion.task.policy.*;

public class Lion extends Role {
    private String number;

    public Lion(String name, String major, Integer year, String part, String number) {
        super(name, major, year, part);
        this.number = number;
    }

    @Override
    public HomeworkPolicy getHomeworkPolicy() {
        return new LionHomeworkPolicy();
    }
}
