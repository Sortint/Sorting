/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Descriptions;

/**
 *
 * @author marius940716
 */
public class QuickDescr {

        String pavad = "Quick sort";
        String apras = "Now, the principle of the quicksort algorithm is this:\n"
                + "\n"
                + "1.Pick a “pivot” element.\n"
                + "2.“Partition” the array into 3 parts:\n"
                + "3.First part: all elements in this part is less than the pivot.\n"
                + "4.Second part: the pivot itself (only one element!)\n"
                + "5.Third part: all elements in this part is greater than or equal to the pivot.\n"
                + "6.Then, apply the quicksort algorithm to the first and the third part. (recursively)";

        public String getPavad() {
            return pavad;
        }

        public String getApras() {
            return apras;
        }

    }
