package io.bna.ccibook.detectloop;

import io.bna.ccibook.common.LinkedList;

/**
 * Created by brand on 10/5/2016.
 */
public class RunnerDetectionStrat implements LoopDetectionStrategy {
    @Override
    public LinkedList getLoopStart(LinkedList list) {
        LinkedList sRun = list, dRun = list;
        do {
            if(sRun.next == null || dRun.next == null || dRun.next.next == null) {
                return null;
            }
            sRun = sRun.next;
            dRun = dRun.next.next;
        } while(sRun != dRun);
        LinkedList sRun2 = list;
        while(sRun != sRun2) {
            sRun = sRun.next;
            sRun2 = sRun2.next;
        }
        return sRun;
    }
}
