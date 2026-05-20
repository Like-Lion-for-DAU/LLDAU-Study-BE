package com.example.pbl.policy;

public class StaffSubmitPolicy implements SubmitPolicy {

    @Override
    public boolean canSubmit() {
        return false;
    }
}