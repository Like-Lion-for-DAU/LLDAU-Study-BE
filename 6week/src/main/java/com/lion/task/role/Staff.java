package com.lion.task.role;

import com.lion.task.policy.*;

public class Staff extends Role {
    private String position;

    public Staff(String name, String major, Integer year, String part, String position) {
        super(name, major, year, part);
        this.position = position;
    }

    @Override
    public HomeworkPolicy getHomeworkPolicy() {
        return new AdminHomeworkPolicy();
    }
}
