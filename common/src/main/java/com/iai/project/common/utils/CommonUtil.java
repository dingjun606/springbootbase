package com.iai.project.common.utils;

import com.iai.project.common.exceptions.GraceException;
import com.iai.project.common.result.ResponseStatusEnum;
import org.springframework.web.multipart.MultipartFile;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.List;

public class CommonUtil {

    // 时间戳转换为日期
    public static String changeTimeFormat(Date time){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String dateString = sdf.format(time);
        return dateString;
    }

    // byte[]类型转换为InputStream
    public static InputStream changInputStream(byte[] bytes){
        return new ByteArrayInputStream(bytes);
    }

    // 将字节数转换为MB，并保留两位小数
    public static String convertFileSizeToMb(long fileSizeInBytes) {
        double fileSizeInMb = (double) fileSizeInBytes / (1024 * 1024);
        return String.format("%.2f MB", fileSizeInMb);
    }

    public static String convertByteToString(byte[] bytes){
        return Base64.getEncoder().encodeToString(bytes);
    }

    // 分页处理
    public static <T> List<T> getPageData(List<T> data, int pageNum, int pageSize) {

        // 分页处理
        int startIndex = (pageNum - 1) * pageSize;
        int endIndex = Math.min(startIndex + pageSize, data.size());

        System.out.println(startIndex);
        System.out.println(endIndex);

        if (startIndex > endIndex){
            GraceException.display(ResponseStatusEnum.PAGE_SIZE_UNREASONABLE);
        }

        if (pageNum <= 0 || pageSize < 0){
            GraceException.display(ResponseStatusEnum.PAGE_SIZE_UNREASONABLE);
        }

        return data.subList(startIndex, endIndex);
    }

    // 获取分页总数
    public static <T> Integer getTotalPages(List<T> data, int pageSize){
        return  (int) Math.ceil((double) data.size() / pageSize);
    }

    // 获取数组大小
    public static <T> Integer getListSize(List<T> data){
        if (data != null){
            return data.size();
        }
        return 0;
    }

    // 总和计算
    public static float calculateSum(List<Float> list) {
        float sum = 0;
        for (float score : list) {
            sum += score;
        }
        return sum;
    }

    // 均值计算
    public static float calculateMean(List<Float> list) {
        float sum = calculateSum(list);
        float mean = sum / list.size();
        return mean;
    }

    // 方差计算
    public static float calculateVariance(List<Float> list) {
        float mean = calculateMean(list);
        float squareDiffSum = 0;

        for (float score : list) {
            float diff = score - mean;
            float squareDiff = diff * diff;
            squareDiffSum += squareDiff;
        }

        float variance = squareDiffSum / list.size();
        return variance;
    }

    public static String encodeToBase64(String originalString) {
        byte[] bytes = originalString.getBytes();
        byte[] encodedBytes = Base64.getEncoder().encode(bytes);
        return new String(encodedBytes);
    }

    public static String convertMultipartFileToBase64(MultipartFile multipartFile) {
        try {

            byte[] fileBytes = multipartFile.getBytes();
            System.out.println(fileBytes);
            byte[] base64Bytes = Base64.getEncoder().encode(fileBytes);
            return new String(base64Bytes, "UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }



}
