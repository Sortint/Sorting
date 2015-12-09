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
public class MergeDescr {

        String pavad = "Merge sort";
        String apras = "Conceptually, a merge sort works as follows:\n"
                + "\n"
                + "1.Divide the unsorted list into n sublists, each containing 1 element (a list of 1 element is considered sorted).\n"
                + "2.Repeatedly merge sublists to produce new sorted sublists until there is only 1 sublist remaining. This will be the sorted list.";

        public String getPavad() {
            return pavad;
        }

        public String getApras() {
            return apras;
        }

    }
