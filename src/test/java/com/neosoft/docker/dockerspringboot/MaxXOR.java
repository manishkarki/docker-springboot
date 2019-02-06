package com.neosoft.docker.dockerspringboot;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
 * Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
 * Could you do this in O(n) runtime?
 * Example:
 *
 * Input: [3, 10, 5, 25, 2, 8]
 * Output: 28
 * Explanation: The maximum result is 5 ^ 25 = 28.
 *
 * @author mkarki
 */
public class MaxXOR {

    public int findMaximumXOR(int[] nums) {
        int max = 0, mask = 0;
        for(int i = 31; i >= 0; i--){
            mask = mask | (1 << i);
            if(i <=4)
            System.out.println("mask when i:"+ i +" is:"+mask);
            Set<Integer> set = new HashSet<>();
            for(int num : nums){
                if(i < 5)
                    System.out.println("num is:"+num +" and mask is:"+ mask +" and with mask:"+ (num & mask));
                set.add(num & mask);
            }
            int tmp = max | (1 << i);
            if(i <= 4)
            System.out.println("tmp when i:"+ i +" is:"+tmp);
            for(int prefix : set){
                if(set.contains(tmp ^ prefix)) {
                    System.out.println(set);
                    System.out.println("in max, tmp is:"+tmp +" prefix is:"+prefix+" xor is:"+(tmp ^ prefix));
                    max = tmp;
                    break;
                }
            }
        }
        return max;
    }

    @Test
    public void randomTest() {
        System.out.println(Math.pow(2, 31));
        System.out.println(Math.pow(2, 30));
        System.out.println((1 << 31 | 1 <<30));
        System.out.println(findMaximumXOR(new int[]{3, 10, 5, 25, 2, 8}));
    }

}
