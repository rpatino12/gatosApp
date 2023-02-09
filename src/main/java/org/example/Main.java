package org.example;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        String[] buttons = {"Show cats", "Show favorites", "Exit"};
        String option;

        do {
            // Main menu
            option = (String) JOptionPane.showInputDialog(null, "Cats in Java", "Main Menu", JOptionPane.INFORMATION_MESSAGE, null, buttons, buttons[0]);

            // Here we execute the action based on the option selected by the user
            switch (option){
                case "Show cats":
                    CatService.showCats();
                    break;
                case "Show favorites":
                    Cat cat = new Cat();
                    CatService.showFavorites(cat.getApikey());
                    break;
                default:
                    break;
            }
        } while (!option.equals("Exit"));
    }
}
