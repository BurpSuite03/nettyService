package com.dtc.container;

import java.util.Hashtable;


public class Thread1 {
	public static void main(String args[]) {
		Hashtable<String, String> t = new Hashtable<>();
		Thread t1 = new Thread(new a1(t));
		Thread t2 = new Thread(new a2(t));
		Thread t3 = new Thread(new a3(t));

		t1.start();
		t2.start();
		t3.start();;
		t.put("name", "dtc");
	}
}

class a1 implements Runnable {
	 Hashtable<String, String> t;
	 public a1(Hashtable<String, String> t) {
		 this.t =t;
	   }
	@Override
	public void run() {
		try {
			//Thread.sleep(50);
			//Add2 add2 = new Add2();
			//add2.add(t, "");
			t.put("name", "dtc1");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class a2 implements Runnable {
	Hashtable<String, String> t;
	public a2(Hashtable<String, String> t) {
	       this.t =t;
	}
	@Override
	public void run() {
		try {
			//Thread.sleep(60);
			//Add2 add2 = new Add2();
			t.put("name", "dtc2");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class a3 implements Runnable{
	Hashtable<String, String> t;
    public a3(Hashtable<String, String> t) {
	       this.t = t;
    }
	@Override
	public void run() {
         try {
			//Thread.sleep(50);
        	//Add2 add2 = new Add2();
        	 System.out.println(t.get("name"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}

class Add2 {
	public void add(Hashtable<String, String> t,String name) {
		t.put("name", name);
	}
	
	public String get(Hashtable<String, String> t, String name) {
		return t.get(name);
	}
    
}