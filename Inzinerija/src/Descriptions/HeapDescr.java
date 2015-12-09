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
public   class HeapDescr {

        String pavad = "Heap sort";
        String apras = "The heapsort algorithm consists of these steps:\n"
                + "\n"
                + "1.Build the heap using all elements of the array.\n"
                + "2.Poll the highest element of the heap.\n"
                + "3.Swap it with the last element of the heap (in array).\n"
                + "4.Reduce the heap size by 1 (elements at the end of the heap are already sorted).\n"
                + "5.Repair the heap (move element swapped in 3 to its correct place in the structure).\n"
                + "6.If there are any elements remaining in the heap GOTO: 2.\n"
                + "7.Array is sorted according to the priority of the elements in reverse order.";

        public String getPavad() {
            return pavad;
        }

        public String getApras() {
            return apras;
        }

    }
