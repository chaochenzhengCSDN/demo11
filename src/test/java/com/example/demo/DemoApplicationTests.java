package com.example.demo;


import com.alibaba.fastjson.JSONObject;
import com.example.entity.Person;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.Cache;


import javax.lang.model.SourceVersion;
import javax.swing.*;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class DemoApplicationTests {

    @Test
    public void test(){
        JaxWsDynamicClientFactory factory=JaxWsDynamicClientFactory.newInstance();
        Client client=factory.createClient("http://localhost:8080/services/TestService?wsdl");
        try {
            Object[] objects=new Object[0];
            objects=client.invoke("sendMessageForName","zcc");
            System.out.println("objects[0] = " + objects[0]);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1(){
        Person p1=new Person(1l,"jack");
        Person p2 = new Person(3l, "jack chou");
        Person p3 = new Person(2l, "tom");
        Person p4 = new Person(4l, "hanson");
        Person p5 = new Person(5l, "胶布虫");

        List<Person> persons= Arrays.asList(p1, p2, p3, p4, p5);
        System.out.println("persons = " + persons);
        List<Person> personList=new ArrayList<>();
        personList.add(p1);
        personList.add(p3);
        persons.stream().forEach(
            p->{
                if(!personList.contains(p)){
                    personList.add(p);
                    System.out.println("persons中不在personList中的元素："+p);
                }
            }
        );
    }
    @Test
    public void test2(){
        String workCode="HD096846";
        long stamp=System.currentTimeMillis();
        String key="oaSalary";
        String token=encodePassword(key+workCode+stamp);
        System.out.println("加密后token:"+token);
    }

    public static String encodePassword(String psw){
        if(psw.isEmpty()||psw.trim().equals("")){
            return null;
        }else{
            return DigestUtils.sha1Hex(psw);
        }
    }

    @Test
    public void test3(){

        JSONObject json=new JSONObject();
        JSONObject json1=new JSONObject();
        JSONObject json2=new JSONObject();
        json2.put("data",json);
        json2.put("page",2);
        JSONObject json3=new JSONObject();
        json3.put("data",json1);
        json3.put("page",3);
        List<Person> personList=new LinkedList<>();
        Person p1=new Person(1l,"jack");
        Person p2 = new Person(3l, "jack chou");
        Person p3 = new Person(2l, "tom");
        Person p4 = new Person(4l, "hanson");
        Person p5 = new Person(5l, "胶布虫");
        personList=Arrays.asList(p1,p2,p3,p4,p5);
        System.out.println("personList = " + personList);
        long startTime1=System.currentTimeMillis();
        personList.stream().forEach(
                person -> {
                    System.out.println("person = " + person);
                }
        );
        long endTime1 = System.currentTimeMillis();
        long usedTime1=endTime1-startTime1;
        System.out.println("endTime1-startTime1 = " + usedTime1);

        json.put("personList",personList);
        json.put("usedTime1",usedTime1);
        System.out.println("json2 = " + json2);


        long startTime=System.currentTimeMillis();
        for(Person person:personList){
            System.out.println("person = " + person);
        }
        long endTime = System.currentTimeMillis();
        long usedTime=endTime-startTime;
        System.out.println("endTime-startTime = " + usedTime);
        json1.put("personList",personList);
        json1.put("usedTime",usedTime);
        System.out.println("json3 = " + json3);
    }

    @Test
    public void test4(){
        HttpClient client= HttpClients.createDefault();
        String url ="http://192.168.1.101:8080/getJson";
        HttpPost httpPost=new HttpPost(url);
        JSONObject date=new JSONObject();
        JSONObject jsonObject=null;
        try {
            StringEntity stringEntity=new StringEntity(date.toString());
            stringEntity.setContentEncoding("UTF-8");
            stringEntity.setContentType("application/json");
            httpPost.setEntity(stringEntity);
            httpPost.addHeader("content-type","text/xml");
            HttpResponse res=client.execute(httpPost);
            String response1= EntityUtils.toString(res.getEntity());
            System.out.println("response1 = " + response1);
            if(res.getStatusLine().getStatusCode()== HttpStatus.SC_OK){
                String result=EntityUtils.toString(res.getEntity());// 返回json格式：
                jsonObject=JSONObject.parseObject(result);
            }
        }  catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("jsonObject = " + jsonObject);
    }


}
