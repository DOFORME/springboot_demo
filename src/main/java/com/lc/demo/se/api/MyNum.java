package com.lc.demo.se.api;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyNum implements Comparable<MyNum> {

    private int num;

    @Override
    public int compareTo(MyNum o) {
        if (o.num == num) {
            return 0;
        } else if(o.num > num) {
            return 1;
        } else {
            return -1;
        }
    }
}
