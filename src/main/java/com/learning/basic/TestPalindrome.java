package com.learning.basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*******************************************************************************
 * Copyright (C)2010 Deutsche Bank AG APHO %created_by: pvinayk % %derived_by: %
 * %date_created: 11:09:22 AM Feb 5, 2010 % %date_modified: % %state: %
 * %full_filespec: % %release: %
 * 
 * Author: pvinayk
 * 
 * Created on: Feb 5, 2010
 * 
 * Purpose: TODO
 * 
 * Change History: Date Author Reason
 * --------------------------------------------------------------------------
 * 
 * 
 ******************************************************************************/

/**
 * @author pvinayk
 * 
 */
public class TestPalindrome
{

    /**
     * @param args
     */
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        numberPalindrome();
        System.out.println("Word : "+isPalindrome("MALAYALAM"));
    }

    public static void numberPalindrome()
    {
        try
        {
            BufferedReader object = new BufferedReader(new InputStreamReader(
                    System.in));
            System.out.println("Enter number");
            int num = Integer.parseInt(object.readLine());
            int n = num;
            int rev = 0;
            System.out.println("Number: ");
            System.out.println(" " + num);
            for (int i = 0; i <= num; i++)
            {
                int r = num % 10;
                num = num / 10;
                rev = rev * 10 + r;
                i = 0;
            }
            System.out.println("After reversing the number: " + " ");
            System.out.println(" " + rev);
            if (n == rev)
            {
                System.out.println("Number is palindrome!");
            }
            else
            {
                System.out.println("Number is not palindrome!");
            }
        }
        catch (Exception e)
        {
            System.out.println("Out of range!");
        }
    }

    public static boolean isPalindrome(String word)
    {
        int left = 0; // index of leftmost unchecked char
        int right = word.length() - 1; // index of the rightmost

        while (left < right)
        { // continue until they reach center
            if (word.charAt(left) != word.charAt(right))
            {
                return false; // if chars are different, finished
            }
            left++; // move left index toward the center
            right--; // move right index toward the center
        }

        return true; // if finished, all chars were same
    }

}
