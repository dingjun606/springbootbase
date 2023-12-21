package com.iai.project.common.result;

public enum ResponseStatusEnum {

    SUCCESS(200, true, "操作成功！"),
    FAILED(500, false, "操作失败！"),
    UN_LOGIN(501,false,"请登录后再继续操作！"),
    TICKET_INVALID(502,false,"会话失效，请重新登录！"),
    NO_AUTH(503,false,"您的权限不足，无法继续操作！"),
    USER_NOT_EXIST(504, false, "该用户不存在! "),
    PHONE_ERROR(505, false, "手机号码不正确！"),
    RANDOM_ERROR(506, false, "随机生成错误! "),
    USER_EXIST(507, false, "该用户已存在! "),
    SMS_CODE_ERROR(509,false ,"验证码错误！" ),
    IP_CODE_LIMITATION(510,false ,"验证码发送次数太多，请稍后再试！" ),
    PAGE_SIZE_UNREASONABLE(511,false ,"数据库数据有限，分页条件不合理！" ),
    PASSWORD_ERROR(512,false ,"密码错误" ),
    FILE_NAME_ERROR(513,false ,"文件格式不正确" ),
    PASSWORD_INCORRECT(505, false, "密码错误！");

    // 响应业务状态
    private Integer status;
    // 调用是否成功
    private Boolean success;
    // 响应消息，可以为成功或者失败的消息
    private String msg;

    ResponseStatusEnum(Integer status, Boolean success, String msg) {
        this.status = status;
        this.success = success;
        this.msg = msg;
    }

    public Integer status() {
        return status;
    }
    public Boolean success() {
        return success;
    }
    public String msg() {
        return msg;
    }
}

