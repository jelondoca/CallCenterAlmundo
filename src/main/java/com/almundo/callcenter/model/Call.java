package com.almundo.callcenter.model;

import com.almundo.callcenter.util.Util;

/**
 * 
 * @author jelondoca
 *
 */
public class Call {
    private int duration;

    public Call() {
        duration = Util.getRandomTimeCall();
    }

    public int getDuration() {
        return duration;
    }

}
