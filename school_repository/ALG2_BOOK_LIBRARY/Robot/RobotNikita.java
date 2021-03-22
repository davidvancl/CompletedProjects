package com.Library.Robot;

import com.Library.App.AppGUI;
import com.Library.GUI.*;
import com.Library.GUI.Menu;
import com.Library.Utils.ListedItem;

import java.awt.*;

public class RobotNikita {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Starting application.");
        AppGUI application = new AppGUI();
        //LOGIN PAGE
        System.out.println("Loading login.");
        Login login = application.getLogin();
        Thread.sleep(2000);

        //REGISTER PAGE
        System.out.println("Loading register.");
        Register register = application.getRegister();
        Thread.sleep(2000);
        System.out.println("Swap to register.");
        login.register.doClick();
        Thread.sleep(2000);
        System.out.println("Insert data to register.");
        register.insertData("nikitaUser","Nikita","Nevim","May 21, 1895","Nn123456*");
        Thread.sleep(2000);
        System.out.println("Registration.");
        register.register.doClick();
        Thread.sleep(2000);
        System.out.println("Swap to login.");

        //LOGIN
        register.login.doClick();
        Thread.sleep(2000);
        System.out.println("Insert data to login.");
        login.instantlyLog("nikitaUser","Nn123456*");
        Thread.sleep(2000);
        login.login.doClick();
        System.out.println("login");
        Thread.sleep(2000);

        //MENU
        Menu menu = application.getMenu();
        System.out.println("menu");
        menu.listDirectory.doClick();
        Thread.sleep(2000);

        //LIST LIBRARY
        ListLibrary listLibrary = application.getListLibrary();
        System.out.println("filtering");
        listLibrary.bookFilter.bookWriterText.setText("Pavel, ota");
        listLibrary.bookFilter.bookWriterCheck.setSelected(true);
        listLibrary.bookFilter.bookNameText.setText("Smrt");
        listLibrary.bookFilter.bookNameCheck.setSelected(true);
        Thread.sleep(2000);
        listLibrary.refresh.doClick();
        Thread.sleep(2000);
        System.out.println("add to cart");
        for (Component c : listLibrary.dataPanel.getComponents()) {
            if (c instanceof ListedItem) {
                ((ListedItem) c).clickEvent();
            }
        }
        Thread.sleep(2000);
        System.out.println("filtering");
        listLibrary.bookFilter.bookWriterText.setText("anděra");
        listLibrary.bookFilter.bookNameText.setText("zvířata v");
        listLibrary.refresh.doClick();
        Thread.sleep(2000);
        for (Component c : listLibrary.dataPanel.getComponents()) {
            if (c instanceof ListedItem) {
                ((ListedItem) c).clickEvent();
            }
        }
        System.out.println("add to cart");
        Thread.sleep(2000);
        listLibrary.menu.doClick();
        System.out.println("menu");
        Thread.sleep(2000);

        //MENU
        Cart cart = application.getCart();
        Thread.sleep(2000);
        menu.cart.doClick();
        System.out.println("cart");

        //CART
        Thread.sleep(5000);
        cart.order.doClick();
        System.out.println("Order");

        //ORDER
        Order order = application.getOrder();
        Thread.sleep(2000);
        System.out.println("Final form data insert.");
        order.insertData("777 777 777","Test Adresa 123","Nn123456*");
        Thread.sleep(2000);
        System.out.println("Order completed.");
        order.order.doClick();
        Thread.sleep(2000);
        order.menu.doClick();
        System.out.println("Menu");
        Thread.sleep(2000);
        System.out.println("Exit app.");
        menu.exit.doClick();
        Thread.sleep(2000);
    }
}
