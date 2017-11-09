package com.hystrix.demo;

import java.util.Random;

import rx.Observer;
import rx.Single;
import rx.schedulers.Schedulers;

public class RXJavaDemo {

	
	public static void main(String[] args) {
		Random random = new Random();
		
		Single.just("hello")
		.subscribeOn(Schedulers.immediate())
		.subscribe(new Observer<String>() {

			@Override
			public void onCompleted() {
				System.out.println("hello world");
			}

			@Override
			public void onError(Throwable throwable) {
				System.out.println("error");
			}

			@Override
			public void onNext(String arg0) {
//				System.out.println(arg0);
				
				// 如果随机时间 大于 100 ，那么触发容错
                int value = random.nextInt(200);

                if (value > 100) {
                    throw new RuntimeException("Timeout!");
                }

                System.out.println("helloWorld() costs " + value + " ms.");
			}
			
		});
	}

}
