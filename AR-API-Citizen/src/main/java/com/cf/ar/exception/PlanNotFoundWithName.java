package com.cf.ar.exception;

public class PlanNotFoundWithName extends RuntimeException {
   
	public PlanNotFoundWithName(String msg) {
        super(msg);
    }
}
