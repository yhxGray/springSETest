package com.zx.java8.test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.junit.Test;

import com.zx.reflect.test.User;

public class LambdaTest {
	@Test
	public void listTest1(){
		List<String> list=Arrays.asList("fee","bde","abc","ess","eaa");
		Collections.sort(list, (a,b)->a.compareTo(b));
		//list.stream().filter(s->s.contains("e")).forEach(s->{s=s.replace("e", "h");System.out.print(s);});
		list.forEach(s->{System.out.print(s+" ");});
		System.out.println();
		User u1=new User("wkk", "aaa");
		User u2=new User("wkk","bbb");
		User u3=new User("wk","ccc");
		List<User> ul=Arrays.asList(u1,u2,u3);
		ul.stream().filter(u->u.getName().equals("wkk")).forEach(u->u.setAge(22));
		ul.forEach(u->{System.out.println(u.getAge());});
	}
	
	/**
	 * 取出list中的素数，并删除掉重复的元素后保存到新list中
	 */
	@Test
	public void listTest2(){
		List<String> ls=Arrays.asList("1","2","3","4","5","6","7","8","9","2","5","11","10","2");
		List<Integer> li=ls.stream()	//先创建一个流
				.map(a->new Integer(a))	//通过map方法，把流中的String元素转换成integer
				.filter(a->{			//通过filter，判断素数并返回给流
					if(a==1) return false;
					if(a==2) return true;
					for(int i=2;i<=Math.sqrt(a);i++){
						if(a%i==0) return false;
					}
					return true;
				})
				.distinct()				//查重，删除重复数据后返回给流
				.collect(Collectors.toList());//将流变为List
		li.forEach(i->{System.out.print(i+" ");});
	}
	/**
	 * 
	 */
	@Test
	public void listTest3(){
		List<String> ls=Arrays.asList("1","2","1","4","8","6","5","8","9","2","5","11","10","2");
		Map<Integer,Integer> map=ls.stream().map(a->new Integer(a)).collect(Collectors.groupingBy(a->a,Collectors.summingInt(a->1)));
		System.out.println(map);
	}
	
	@Test
	public void testn(){
		Double d=null;
		if(d instanceof Double){
			System.out.println("ok");
		}else{
			System.out.println("nu");
		}
	}
}
