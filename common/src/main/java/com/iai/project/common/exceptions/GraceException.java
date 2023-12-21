package com.iai.project.common.exceptions;
import com.iai.project.common.result.ResponseStatusEnum;

public class GraceException {
    public static void display(ResponseStatusEnum responseStatusEnum)  {
        throw new Exception(responseStatusEnum);
    }
}
