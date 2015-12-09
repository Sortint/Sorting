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
public class CombDescr {

        String pavad = "Combo sort";
        String apras = "The main idea is to eliminate the small values near the end of the list, as these slow down the sorting process.\n"
                + "\n"
                + "How it works:\n"
                + "\n"
                + "In comb sort, the main usage is of gaps. For example, in bubble sort the gap between two elements was 1 whilst here the gap starts out as a large value and shrinks until it reaches the value 1, when it practically becomes bubble sort. The shrink factor determines how much the gap is lessened. The value is crucial, so an ideal value would be 1.3";

        public String getPavad() {
            return pavad;
        }

        public String getApras() {
            return apras;
        }

    }
