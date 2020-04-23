package com.kodilla.hibernate.manytomany.facade;

import org.springframework.stereotype.Component;

@Component
public class Changer {
    public String changeWord(String word) {
        return "%" + word + "%";
    }
}
