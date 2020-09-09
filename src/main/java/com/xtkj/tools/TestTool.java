package com.xtkj.tools;

//import com.alibaba.fastjson.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.math.BigInteger;
import java.security.MessageDigest;

public enum  TestTool {


    INSTALL;

    public  String getMD5String(String str) {
        try {
            // 生成一个MD5加密计算摘要
            MessageDigest md = MessageDigest.getInstance("MD5");
            // 计算md5函数
            md.update(str.getBytes());
            // digest()最后确定返回md5 hash值，返回值为8位字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
            // BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
            //一个byte是八位二进制，也就是2位十六进制字符（2的8次方等于16的2次方）
            return new BigInteger(1, md.digest()).toString(16);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

//    public <T> String  toJsonString(T t){
//        JsonResult<T> jsonResult =new JsonResult<>();
//        jsonResult.setMsg("Ok");
//        jsonResult.setStateCode(200);
//        jsonResult.setObj(t);
//        String s = JSONObject.toJSONString(jsonResult);
//        return s;
//    }
//
//    public <T> String  toJsonString(int code){
//        JsonResult<T> jsonResult =new JsonResult<>();
//        jsonResult.setMsg("Ok");
//        jsonResult.setStateCode(code);
//        String s = JSONObject.toJSONString(jsonResult);
//        return s;
//    }
    public <T> String  toJsonString(T t){

        JsonResult<T> jsonResult =new JsonResult<>();
        jsonResult.setMsg("Ok");
        jsonResult.setStateCode(200);
        jsonResult.setObj(t);

        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        String s1 = gson.toJson(jsonResult);
        return s1;
    }

    public ClassPathXmlApplicationContext getClassPathXmlApplicationContext(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        return context;
    }

}
