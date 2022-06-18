package com.zhong.app.util;

import lombok.*;

/**
 * @author JoeZhou
 */
@Data
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
public class Result {

    /**
     * 响应码
     */
    private Integer code;

    /**
     * 响应描述
     */
    private String message;

    /**
     * 响应数据
     */
    private Object data;

    /**
     * 操作成功，响应码为 `1`，描述为 `success`，无响应数据。
     *
     * @return JsonResult对象
     */
    @SneakyThrows
    public static Result ok() {
        return ok(1, "success", null);
    }

    /**
     * 操作成功，响应码为 `1`，描述为 `success`，响应数据自定义。
     *
     * @param data 响应数据
     * @return JsonResult对象
     */
    @SneakyThrows
    public static Result ok(Object data) {
        return ok(1, "success", data);
    }

    /**
     * 操作成功，响应码和描述自定义，无响应数据。
     *
     * @param code    响应状态码，正数表示成功，零或负数表示失败
     * @param message 响应成功描述
     * @return JsonResult对象
     */
    @SneakyThrows
    public static Result ok(Integer code, String message) {
        return ok(code, message, null);
    }

    /**
     * 操作成功，响应码，描述和响应数据均自定义。
     *
     * @param code    响应状态码，正数表示成功，零或负数表示失败
     * @param message 响应成功描述
     * @param data    响应数据
     * @return JsonResult对象
     */
    @SneakyThrows
    public static Result ok(Integer code, String message, Object data) {
        return new Result(code, message, data);
    }

    /**
     * 操作失败，响应码为 `0`，描述为 `fail`，无响应数据。
     *
     * @return JsonResult对象
     */
    @SneakyThrows
    public static Result fail() {
        return fail(0, "fail");
    }

    /**
     * 操作失败，响应码和描述自定义，无响应数据。
     *
     * @param code    响应状态码，正数表示成功，零或负数表示失败
     * @param message 响应失败描述
     * @return JsonResult对象
     */
    @SneakyThrows
    public static Result fail(Integer code, String message) {
        return new Result(code, message, null);
    }
}