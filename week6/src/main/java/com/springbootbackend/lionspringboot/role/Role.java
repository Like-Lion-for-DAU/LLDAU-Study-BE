package com.springbootbackend.lionspringboot.role;

public interface Role {
    String getName();
    String getMajor();
    int getGeneration();
    String getPart();
    String getStudentId();
    String getRoleType();
    boolean canSubmit();
}
