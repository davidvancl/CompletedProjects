package com.Library.GUI;

import com.Library.App.AppGUI;
import com.Library.App.MyOrderLogic;
import com.Library.Utils.DataPanel;
import com.Library.Utils.JPanelTemplate;

import javax.swing.*;

public class MyOrders extends JPanelTemplate {
    private AppGUI frame;
    public DataPanel dataPanel;
    private JButton menu;

    public MyOrders(AppGUI frame, boolean isVisible) {
        super(frame.getWidth(), frame.getHeight(), isVisible);
        this.frame = frame;
    }

    @Override
    public void loadCustomComponents() {
        this.loadTitle();
        this.loadDataPanel();
        this.loadOrders();
        this.loadMenuButton();
    }

    private void loadOrders(){
        dataPanel.clearItemsO();
        MyOrderLogic.getOrderByUser(this,AppGUI.account.getNICKNAME());
    }

    private void loadTitle(){
        JLabel label = customJLabel("My Orders",20);
        label.setBounds(190, 10, 300, 50);
    }

    private void loadDataPanel(){
        dataPanel = new DataPanel(this,false,400);
        dataPanel.setBounds(dataPanel.getX(),40,dataPanel.getWidth(),dataPanel.getHeight());
        this.add(dataPanel);
    }

    /**
     * Načte se tlačítko do Menu.
     */
    private void loadMenuButton() {
        menu = new JButton("Menu", loadImageFromPackage("buttonMenu.png", 130, 40));
        menu.setBounds(40, 410, 130, 40);
        menu.addActionListener(e -> frame.swapScreen(frame.getMyOrders(), frame.getMenu()));
        this.dynamicUpgrade(menu);
        this.setComponentZOrder(menu, 0);
    }
}
