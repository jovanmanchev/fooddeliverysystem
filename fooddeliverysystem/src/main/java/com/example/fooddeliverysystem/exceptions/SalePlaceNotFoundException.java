package com.example.fooddeliverysystem.exceptions;


import com.example.fooddeliverysystem.repository.SalePlaceRepository;

public class SalePlaceNotFoundException extends Exception{

    public SalePlaceNotFoundException(String message){
        super(message);
    }
}
