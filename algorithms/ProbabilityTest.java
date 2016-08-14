package com.test;

import com.algs.RandomSample;
import com.algs.Shuffle;

public class ProbabilityTest {
	/**
	 *  列是每个位置出现的次数，行是各个字符的统计
	 * @param count
	 */
    private static void printResult(int [][] count){
        if (count == null || count.length == 0) return;
        
        // print index
        System.out.print("   ");
        for (int i = 0; i < count[0].length; i++) {
            System.out.printf("%-7d", i);
        }
        System.out.println();
        
        // print num appear in index i in total
        for (int i = 0; i < count.length; i++) {
            System.out.print(i + ": ");
            for (int j = 0; j < count[i].length; j++) {
                System.out.printf("%-7d", count[i][j]);
            }
            System.out.println();
        }
    }
    /**
     * 列是每个位置出现的次数，行是各个字符的统计
     * @param nums 传入需要统计的数据
     * @param count 统计结果
     */
    private static void addToResult(int[] nums, int[][] count){
        if (nums == null || nums.length == 0){
        	return;
        }

        for (int i = 0; i < nums.length; i++) {
            count[nums[i]][i]++;
        }
    }
    
    public static void probability(){
    	int[] cards = new int[10];
    	for(int i = 0; i < cards.length; i++){
    		cards[i] = i;
    	}
    	
        final int times = 100000;
        final int m = 5;
        int[][] countShuffle = new int[cards.length][cards.length];
        int[][] countRandomSample = new int[cards.length][m];
        
        for (int i = 0; i < times; i++) {
        	// shuffle
            Shuffle.shuffle(cards);
            addToResult(cards, countShuffle);
            
            // random sample
            int[] sample = RandomSample.randomSample(cards, m);
            addToResult(sample, countRandomSample);
        }
        System.out.println("Shuffle cards: ");
        printResult(countShuffle);
        System.out.println();
        System.out.println("Random sample: ");
        printResult(countRandomSample);
    }
}
