package com.zx.other.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.zx.reflect.test.User;

public class MergeArraysTest {
	
	/**
	 * 此方法仅适用于已经由小到大拍完序的两个数组进行合并
	 * @param a have been sorted by A->Z
	 * @param b have been sorted by A->Z
	 * @return new array merged and sorted by A->Z
	 */
	public User[] mergeArrays(User[] a,User[] b){
		int len1=a.length;
		int len2=b.length;
		int i1=0,i2=0,iall=0;
		User[] ab=new User[len1+len2];
		while(true){
			if(a[i1].compareTo(b[i2])>0){
				ab[iall++]=b[i2++];
				if(i2==len2){
					while(i1<len1){
						ab[iall++]=a[i1++];
					}
					break;
				}
			}else{
				ab[iall++]=a[i1++];
				if(i1==len1){
					while(i2<len2){
						ab[iall++]=b[i2++];
					}
					break;
				}
			}
		}
		return ab;
	}
	
	public <T extends User> List<T> mergeLists(List<T> list1,List<T> list2){
		int len1=list1.size();
		int len2=list2.size();
		int i1=0,i2=0;
		List<T> listMerge=new ArrayList<>();
		while(true){
			if(list1.get(i1).compareTo(list2.get(i2))>0){
				listMerge.add(list2.get(i2++));
				if(i2==len2){
					while(i1<len1){
						listMerge.add(list1.get(i1++));
					}
					break;
				}
			}else{
				listMerge.add(list1.get(i1++));
				if(i1==len1){
					while(i2<len2){
						listMerge.add(list2.get(i2++));
					}
					break;
				}
			}
		}
		return listMerge;
	}
	
	@Test
	public void ListMergeTest(){
		List<User> li1=new ArrayList<>();
		List<User> li2=new ArrayList<>();
		li1.add(new User("aa"));
		li1.add(new User("bd"));
		li1.add(new User("ce"));
		li1.add(new User("da"));
		li1.add(new User("gw"));
		li1.add(new User("he"));
		li1.add(new User("ka"));
		li1.add(new User("ll"));
		li2.add(new User("ab"));
		li2.add(new User("ac"));
		li2.add(new User("ah"));
		li2.add(new User("bc"));
		li2.add(new User("bh"));
		li2.add(new User("cf"));
		li2.add(new User("dw"));
		li2.add(new User("ed"));
		li2.add(new User("ir"));
		li2.add(new User("kk"));
		
		List<User> list3=mergeLists(li1,li2);
		list3.forEach(l->System.out.print(l.getName()+" "));
	}
	
	@Test
	public void arrayMergeTest(){
		User[] us1={	new User("aa"),
					    new User("bd"),
				        new User("ce"),
				        new User("da"),
				        new User("gw"),
				        new User("he"),
				        new User("ka"),
				        new User("ll")
		};
		
		User[] us2={	new User("ab"),
                        new User("ac"),
				        new User("ah"),
				        new User("bc"),
				        new User("bh"),
				        new User("cf"),
				        new User("dw"),
				        new User("ed"),
				        new User("ir"),
				        new User("kk")
		};
		
		User[] usall=mergeArrays(us1, us2);
		for (User user : usall) {
			System.out.print(user.getName()+" ");
		}
	}
}
