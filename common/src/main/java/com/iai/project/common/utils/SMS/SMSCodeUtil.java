package com.iai.project.common.utils.SMS;

import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

// 外部短信服务
@Component
@Slf4j
public class SMSCodeUtil {
    private final static String SMSURL = "https://cloud.gether.net/smartmarket/msgService/sendMessage";
    private final static String ACCESSKEY = "d70ab35f7d42d8e19d";
    private final static String ACCESSSECRET = "51d2e4c8e8c2daa226c4fba3dfb730";
    private final static String SIGNCODE = "zaabQhIM";
    private final static String TEMPLATECODE = "QwQ2KciH";
    private final static String PLANCODE = "FFIzfMsi";

    public static void sendSMS(String phone, String code) {
        String url = SMSURL;
        JSONObject jsonBody = new JSONObject();
        jsonBody.put("accessKey", ACCESSKEY);
        jsonBody.put("accessSecret", ACCESSSECRET);
        jsonBody.put("classificationSecret", PLANCODE);
        jsonBody.put("signCode", SIGNCODE);
        jsonBody.put("templateCode", TEMPLATECODE);
        jsonBody.put("phone", phone);
        // 变量参数用map存
        Map<String, String> params = new HashMap<>();
        // 验证码参数示例
        params.put("code", code);
        // 变量参数map存入json对象
        jsonBody.put("params", params);
        log.info("======发送短信=======");
        log.info(jsonBody.toJSONString());
        log.info("===== 返回结果=======");
        log.info(doPost(url, jsonBody).toJSONString());
    }


    /**
     * 发起post请求
     *
     * @param url  请求url
     * @param json json格式请求体
     * @return json格式响应体
     */
    public static JSONObject doPost(String url, JSONObject json) {
        JSONObject response;
        try {
            String result = HttpUtil.post(url, json.toString());// 返回json格式
            response = JSONObject.parseObject(result);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return response;
    }

}