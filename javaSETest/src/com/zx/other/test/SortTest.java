package com.zx.other.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.zx.reflect.test.User;

public class SortTest {
	/**
	 * �鲢�����Ƚ��������Ͻ��ж��֣�ֱ�������ٶ���ʱ���ٽ��кϲ����ϲ������н�������
	 */
	public List<User> mergeSort(List<User> list,int left,int right){
		int mid=(left+right)/2;
		if(left<right){
			mergeSort(list,left,mid);//���õ������ϵؽ����϶���
			mergeSort(list,mid+1,right);
			merge(list,left,mid,right);//������㣬������Ԫ�ؿ�ʼ�����κϲ���ֱ�����ºϲ�Ϊlist
		}
		
		return list;
	};
	
	public void merge(List<User> list,int left,int mid,int right){
		List<User> temp=new ArrayList<User>();
		int i=left;
		int j=mid+1;
		while(i<=mid&&j<=right){
			if(list.get(i).compareTo(list.get(j))<0){
				temp.add(list.get(i));//temp�ȴ����ж�ΪС������
				i++;
			}else{
				temp.add(list.get(j));//temp�ȴ����ж�ΪС������
				j++;
			}
		}
		
		while(i<=mid){
			temp.add(list.get(i));//temp���뱻�ж�Ϊ�������
			i++;
		}
		
		while(j<=right){
			temp.add(list.get(j));//temp���뱻�ж�Ϊ�������
			j++;
		}
		
		for(int k=0;k<temp.size();k++){
			list.set(k+left, temp.get(k));//����temp����list�����һ������
		}
	}
	
	public void quickSort(List<User> list,int left, int right){
		if(left<right){
			int mid=getPattern(list, left, right);
			quickSort(list,left,mid-1);
			quickSort(list,mid+1,right);
		}
	}
	
	public int getPattern(List<User> list,int left,int right){
		int index=left;
		User userRight=list.get(right);
		for(int i=left;i<right;i++){
			if(list.get(i).compareTo(userRight)<0){
				if(index!=i){
					swap(list,index,i);
				}
				index++;
			}
		}
		if(index!=right){
			swap(list, index, right);
		}
		return index;
	}
	/**
	 * ��������������list��a��b��������Ӧ��Ԫ��
	 */
	public void swap(List<User> list,int a,int b){
		User temp=list.get(a);
		list.set(a, list.get(b));
		list.set(b, temp);
	}
	
	public List<User> generateList(){
		User u1=new User("ww");
    	User u2=new User("aa");
    	User u3=new User("bb");
    	User u4=new User("bb");
    	User u5=new User("cd");
    	User u6=new User("ee");
    	User u7=new User("ed");
    	User u8=new User("ec");
    	User u9=new User("ed");
    	User u10=new User("wkk");
        List<User> list = Arrays.asList(u1,u2,u3,u4,u5,u6,u7,u8,u9,u10);
        return list;
	}
	
	@Test
	public void mergeSortTest(){
		List<User> list=generateList();
		mergeSort(list, 0, list.size()-1);  
        list.forEach(u->System.out.println(u.getName()));
	}
	
	@Test
	public void quickSortTest(){
		List<User> list=generateList();
		quickSort(list, 0, list.size()-1);
		list.forEach(u->System.out.print(u.getName()+" "));
	}
	
}
