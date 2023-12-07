package com.ExceptionsdemoHW.Service;


import org.springframework.stereotype.Service;


@Service
public class InformationServiceImp implements InformationService {

    @Override
    public String startPage() {
        return "<b> Добро пожаловать на главную старницу! </b>";
    }

}

