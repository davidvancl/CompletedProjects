package com.projectAirlines.SharedUtils;

import com.projectAirlines.Main;
import com.projectAirlines.Tools.ConfigFile;
import com.projectAirlines.Tools.GraphicUtils;
import com.projectAirlines.Tools.ProjectPath;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class SettingsLabel extends JPanel{
    private String layout = ProjectPath.getGraphicPath("menuBorder.png");
    private int settingsWidth = 400;
    private int settingsHeight = 400;


    public SettingsLabel(int widthScreen, int heightScreen, JFrame frame) throws IOException {
        //setting up Label
        this.setBounds((widthScreen / 2) - (this.settingsWidth / 2),(heightScreen / 2) - (this.settingsHeight / 2) - 25,settingsWidth,settingsHeight);
        setVisible(false);
        setLayout(null);

        //load components
        setVolumeBar();

        //add to main frame
        frame.add(this);
    }

    /**
     * Method setting visibility of Label
     *
     * @param statement boolean,(true/false)
     */
    public void setGameSettingsVisible(boolean statement){
        setVisible(statement);
    }

    protected void paintComponent(Graphics g) {
        try {
            g.drawImage(GraphicUtils.resize(ImageIO.read(new File(this.layout)), this.settingsHeight, this.settingsWidth), 0, 0, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void setVolumeBar() throws IOException {
        JSlider slider = new JSlider();
        slider.setBounds(25,25,350,30);
        slider.setBackground(Color.WHITE);
        slider.setMinimum((int)Main.getMusicThread().getMinimumVolume());
        slider.setMaximum((int)Main.getMusicThread().getMaximumVolume());
        slider.addChangeListener(e -> {
            JSlider source = (JSlider)e.getSource();
            if(!source.getValueIsAdjusting())
            {
                Main.getMusicThread().setVolume(source.getValue());
                try {
                    ConfigFile.saveConfig("musicVolume",source.getValue() + "");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        slider.setValue((int)Float.parseFloat(Objects.requireNonNull(ConfigFile.loadData("musicVolume"))));
        this.add(slider);
    }
}