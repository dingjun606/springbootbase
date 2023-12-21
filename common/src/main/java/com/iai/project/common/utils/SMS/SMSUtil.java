package com.iai.project.common.utils.SMS;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;

import java.util.Random;

// 阿里云短信服务
public class SMSUtil {
    static final String ACCESS_KET = "";
    static final String ACCESS_KEY_SECRET = "";
    static final String TEMPLATECODE = "";

    public static String getSMSCode(String phoneNum) throws ClientException {
        String code = generateCode();
        String templateParam = "{\"code\":\"" + code + "\"}";

        // 创建DefaultAcsClient实例并初始化
        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KET, ACCESS_KEY_SECRET);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", "Dysmsapi", "dysmsapi.aliyuncs.com");
        IAcsClient client = new DefaultAcsClient(profile);

        // 创建发送短信的请求对象
        SendSmsRequest request = new SendSmsRequest();
        request.setPhoneNumbers(phoneNum);
        request.setSignName("新维智科");
        request.setTemplateCode(TEMPLATECODE);
        request.setTemplateParam(templateParam);

        // 发送短信并处理响应
        SendSmsResponse response = client.getAcsResponse(request);

        return code;
    }


    //生成随机验证码
    private static String generateCode() {
        Random random = new Random();
        int code = random.nextInt(999999);
        String format = String.format("%06d", code);
        return format;

    }

    public static void main(String[] args) throws ClientException {
        String phoneNum = "17756736317";
        String smsCode = getSMSCode(phoneNum);
        System.out.println("生成的验证码为"+smsCode);
    }
}
