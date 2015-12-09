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

    
 public class ShellDescr {

        String pavad = "Shell sort";
        String apras = "Shell sort uses so called diminishing increment. It means that in every step only elements at some distance are compared (for example the first with the fifth, second with the sixth...). This approach ensures that elements with high and low value are moved to the appropriate side of the array very quickly. In every iteration the gap between the compared elements is reduced. In the iteration step, the gap is set to one – the algorithm degrades to an ordinary insertion sort, which terminates very quickly, because now the array contains only few misplaced elements.";

        public String getPavad() {
            return pavad;
        }

        public String getApras() {
            return apras;
        }

    }