package com.hy.result;

public interface ContentResult {
    public static final String SUCCESS_CODE = "1";
    public static final String SUCCESS_MSG = "操作成功";
    public static final String FAIL_CODE = "0";
    public static final String FAIL_MSG = "操作失败";
    public static final String SUCCESS_LOGIN_CODE="2";
    public static final String SUCCESS_LOGIN_MSG="登录成功";
    public static final String FAIL_LOGIN_CODE="3";
    public static final String FAIL_LOGIN_MSG="登录失败";
    public static final String TOKEN_NOT_NULL_CODE="4";
    public static final String TOKEN_NOT_NULL_MSG="token不能为空";
}
