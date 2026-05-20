package com.example.demo.policy;

public class LionAssignmentPolicy implements AssignmentPolicy {
    @Override
    public boolean canSubmit() {
        return true; // 아기사자는 제출 가능
    }
}