package voinaIMir;

import java.util.concurrent.atomic.AtomicInteger;

public class ComaCounter implements Runnable{
	
	private String text;
	private static AtomicInteger commas = new AtomicInteger(0);
	private int id;

	
	
	public ComaCounter(String text,int id) {
		this.text=text;
		this.id=id;
		
	}
	
	public static int getCommas() {
		return commas.get();
	}

	@Override
	public void run() {
		for (int i = 0; i < text.length(); i++) {
			if(text.charAt(i)==',') {
				commas.getAndIncrement();
				//System.out.println(commas);
			}
			
		}

	}
}
