package com.yidu.victory.excle.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Aaaaaa {
	public static int getRandom(int min,int max){
		Random random=new Random();
		return random.nextInt(max-min+1)+min;
	}
	public static int[] getRandoms(int min,int max,int count){
		int[] randoms = new int[count];
        List<Integer> listRandom = new ArrayList<Integer>();
 
        if( count > ( max - min + 1 )){
            return null;
        }
        // �����еĿ��ܳ��ֵ����ַŽ���ѡlist
        for(int i = min; i <= max; i++){
            listRandom.add(i);
        }
        // �Ӻ�ѡlist��ȡ���������飬�Ѿ���ѡ�еľʹ����list���Ƴ�
        for(int i = 0; i < count; i++){
            int index = getRandom(0, listRandom.size()-1);
            randoms[i] = listRandom.get(index);
            listRandom.remove(index);
        }
 
        return randoms;
	}
	
	public static void main(String[] args) {
		int[] randoms=getRandoms(5,100,45);
		for(int i=0;i<randoms.length;i++){
			System.out.print(randoms[i]+"   ");
		}

	}

}
