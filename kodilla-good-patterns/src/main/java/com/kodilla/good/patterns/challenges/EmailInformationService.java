package com.kodilla.good.patterns.challenges;

public class EmailInformationService implements InformationService {
    @Override
    public void sendConfirmationToUser(User user) {
        System.out.println("We've sent an e-mail to: " + user.getName() + " " + user.getSurname() +
                " about confirmation of the order");
    }
}
