package com.lielion.PBL.global.exception;

public class DuplicateMemberException extends RuntimeException {
    public DuplicateMemberException(String name) {
        super("이미 등록된 멤버 이름입니다. name=" + name);
    }
}
