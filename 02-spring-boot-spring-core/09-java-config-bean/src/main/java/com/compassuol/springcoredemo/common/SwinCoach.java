package com.compassuol.springcoredemo.common;

public class SwinCoach implements Coach {
    public SwinCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Swim 100 0 meters as a warm up";
    }
}
