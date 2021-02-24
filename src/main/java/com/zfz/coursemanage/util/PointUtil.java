package com.zfz.coursemanage.util;

public class PointUtil {
    public static Double getPoint(Integer score){
        double point = 0.0;
        if(score>=90) point=4.0;
        else if(score>=85) point=3.7;
        else if(score>=82) point=3.3;
        else if(score>=78) point=3.0;
        else if(score>=75) point=2.7;
        else if(score>=72) point=2.3;
        else if(score>=68) point=2.0;
        else if(score>=66) point=1.7;
        else if(score>=64) point=1.5;
        else if(score>=60) point=1.0;
        return point;
    }
}
