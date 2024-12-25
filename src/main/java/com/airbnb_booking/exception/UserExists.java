package com.airbnb_booking.exception;

public class UserExists extends RuntimeException
{
    public UserExists(String msg) {
        super(msg);
    }
}

