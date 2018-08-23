package com.zyz.monitor.jvm;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CpuTest {

	private Object lock1 = new Object();

	private Object lock2 = new Object();

	/**
	 * 死循环
	 * */
	@Test
	public void loop(){
		String data = "{\"data\":[{\"partnerid\":]";
		getPartneridsFromJson(data);
		System.out.println(data);
	}

	/**
	 * 死锁
	 * */
	@Test
	public void deadlock() throws InterruptedException {
		new Thread(()->{
			synchronized(lock1) {
				try {Thread.sleep(1000);}catch(Exception e) {}
				synchronized(lock2) {
					System.out.println("Thread1 over");
				}
			}
		}) .start();
		new Thread(()->{
			synchronized(lock2) {
				try {Thread.sleep(1000);}catch(Exception e) {}
				synchronized(lock1) {
					System.out.println("Thread2 over");
				}
			}
		}) .start();

		while(true){
			Thread.sleep(2000);
			System.out.println(System.currentTimeMillis());
		}
	}

	public  List<Long> getPartneridsFromJson(String data){
	    //{\"data\":[{\"partnerid\":982,\"count\":\"10000\",\"cityid\":\"11\"},{\"partnerid\":983,\"count\":\"10000\",\"cityid\":\"11\"},{\"partnerid\":984,\"count\":\"10000\",\"cityid\":\"11\"}]}  
	    //上面是正常的数据  
	    List<Long> list = new ArrayList<Long>(2);  
	    if(data == null || data.length() <= 0){  
	        return list;  
	    }      
	    int datapos = data.indexOf("data");  
	    if(datapos < 0){  
	        return list;  
	    }  
	    int leftBracket = data.indexOf("[",datapos);  
	    int rightBracket= data.indexOf("]",datapos);  
	    if(leftBracket < 0 || rightBracket < 0){  
	        return list;  
	    }  
	    String partners = data.substring(leftBracket+1,rightBracket);  
	    if(partners == null || partners.length() <= 0){  
	        return list;  
	    }  
	    while(partners!=null && partners.length() > 0){  
	        int idpos = partners.indexOf("partnerid");  
	        if(idpos < 0){  
	            break;  
	        }  
	        int colonpos = partners.indexOf(":",idpos);  
	        int commapos = partners.indexOf(",",idpos);  
	        if(colonpos < 0 || commapos < 0){  
	            //partners = partners.substring(idpos+"partnerid".length());//1  
	            continue;
	        }  
	        String pid = partners.substring(colonpos+1,commapos);  
	        if(pid == null || pid.length() <= 0){  
	            //partners = partners.substring(idpos+"partnerid".length());//2  
	            continue;
	        }  
	        try{  
	            list.add(Long.parseLong(pid));  
	        }catch(Exception e){  
	            //do nothing  
	        }  
	        partners = partners.substring(commapos);  
	    }  
	    return list;  
	}  
	
}
