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

public class Algo {

        BubbleDescr bubble = new BubbleDescr();
        HeapDescr heap = new HeapDescr();
        SelectionDescr selection = new SelectionDescr();
        MergeDescr merge = new MergeDescr();
        QuickDescr quick = new QuickDescr();
        CombDescr combo = new CombDescr();
        InsertionDescr insertion = new InsertionDescr();
        ShellDescr shell = new ShellDescr();
        CoctailDescr coctail = new CoctailDescr();

        public SelectionDescr getSelection() {
            return selection;
        }

        public MergeDescr getMerge() {
            return merge;
        }

        public QuickDescr getQuick() {
            return quick;
        }

        public CombDescr getCombo() {
            return combo;
        }

        public InsertionDescr getInsertion() {
            return insertion;
        }

        public ShellDescr getShell() {
            return shell;
        }

        public CoctailDescr getCoctail() {
            return coctail;
        }

        public BubbleDescr getBubble() {
            return bubble;
        }

        public HeapDescr getHeap() {
            return heap;
        }
    }
