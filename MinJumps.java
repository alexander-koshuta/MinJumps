package com.ubs.wma.cdx.account.summary.utils;

import java.util.Arrays;
import java.util.Scanner;

public class MinJumps {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; ++i) {
            nums[i] = scanner.nextInt();
        }
        minJumps(nums);
    }

    private static void alternativeMinJumps(int[] arr) {

        int n = arr.length;

        int firstIndex = -1;
        for (int i = 0; i < n; ++i) {
            int remains = n - i - 1;
            if (arr[i] >= remains) {
                firstIndex = i;
                break;
            }
        }

        int counter = 0;

        for (int i = firstIndex - 1; i >= 0; --i) {


        }
    }

    private static void minJumps(int[] arr) {

        int n = arr.length;

        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        memo[0] = 0;

        for (int i = 0; i < n - 1; ++i) {
            /*int remains = n - i - 1;
            if (arr[i] >= remains) {
                continue;
            }*/
            int k = arr[i];
            /*if (k == 0) {
                memo[i] = -1;
                continue;
            }*/
            for (int j = 1; j <= k; ++j) {
                if (i + j >= n) {
                    break;
                }
                if (memo[i + j] == -1 || memo[i + j] > memo[i] + 1) {
                    memo[i + j] = memo[i] + 1;
                }
            }
        }

        int min = Integer.MAX_VALUE;
        int element = -1;

        for (int i = 0; i < n; ++i) {
            int remains = n - i - 1;
            if (arr[i] >= remains) {
                if (memo[i] != -1 && min > memo[i]) {
                    min = memo[i];
                    element = arr[i];
                }
            }
        }

        System.out.println(Arrays.toString(memo));

        System.out.println(min);
        System.out.println(element);
    }
}
