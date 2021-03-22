package com.XmasApplication;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main{
    private static DrawText drawTextMachine = new DrawText();
    private static DrawImage drawImageMachine = new DrawImage();
    private static ChristmasCandle christmasCandle = new ChristmasCandle();
    private static Scanner scan = new Scanner(System.in);
    private static String cwd = System.getProperty("user.dir");
    private static String completeUrlFiles = cwd + "\\..\\..\\..\\Files\\";
    private static Random rnd = new Random();
    private static boolean isPlayingMusic = false;

    public static void main(String[] args) throws IOException, UnsupportedAudioFileException, InterruptedException {
        cls();
        System.out.println("Vánoční aplikace co si přeješ ?");
        int input = 0;
        String musicToStart = customPlaySound(false);
        if(!musicToStart.equals("bequiet")) {
            playClip(new File(completeUrlFiles + "Sounds\\" + musicToStart + ".wav"));
            isPlayingMusic = true;
        }
        while ((input = customInput()) != 0) {
            switch (input) {
                case 1:
                    drawTextMachine.setAnimate(true);
                    drawTextMachine.createTextImage("Šťastné a veselé Vánoce");
                    break;
                case 2:
                    cwd = System.getProperty("user.dir");
                    for (int i = 1; i < 21; i++) { cls();
                        drawImageMachine.createImage(completeUrlFiles + "Images\\image" + i + ".png");
                        TimeUnit.SECONDS.sleep(5);
                    } cls();
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Zadej výšku svíčky");
                    christmasCandle.setHeight(scan.nextInt());
                    System.out.println("Zadej šířku svíčky");
                    christmasCandle.setWidth(scan.nextInt());
                    System.out.println("Pruhovaná {1}/ Okraje {2}/ Jednobarevna {3}");
                    boolean str = false;
                    boolean hol = false;
                    switch (scan.nextInt()){
                        case 1:
                            str = true;
                            hol = false;
                            break;
                        case 2:
                            str = false;
                            hol = true;
                            break;
                        case 3:
                            break;
                        default:
                            str = false;
                            hol = false;
                            break;
                    }
                    christmasCandle.setStripes(str);
                    christmasCandle.setHollow(hol);
                    christmasCandle.drawCandleByParameters();
                    break;
                case 5:
                    System.out.println("Zadej cestu k obrazku: ");
                    scan.skip("[\\r\\n]+");
                    String path = scan.nextLine();
                    drawImageMachine.createImage(path);
                    break;
                case 6:
                    System.out.println("Zadej svuj vlastni text: ");
                    scan.skip("[\\r\\n]+");
                    String text = scan.nextLine();
                    drawTextMachine.setAnimate(false);
                    drawTextMachine.createTextImage(text);
                    break;
                case 7:
                    playClip(new File(completeUrlFiles + "Sounds\\" + customPlaySound(false)+ ".wav"));
                    isPlayingMusic = true;
                    break;
                default:
                    System.out.println("Asi jsi se uklik. Jsou vánoce to nevadí. Zkus to znovu.");
                    break;
            }
        }
    }

    private static int customInput() {
        System.out.print(".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:. \n" +
                            ".     *                                       . \n" +
                            ".    /.\\    1) Vypíše vánoční přání           . \n" +
                            ".   /..'\\   2) Vánoční prezentace             . \n" +
                            ".   /'.'\\   3) --------------------           . \n" +
                            ".  /.''.'\\  4) Vykreslí svíčku                . \n" +
                            ".  /.'.'.\\  5) Vykreslí vlastní obrázek       . \n" +
                            ". /'.''.'.\\ 6) Vykreslí vlastní text          . \n");
        if(!isPlayingMusic) {
        System.out.print(". ^^^[_]^^^ 7) Vyber vánoční hudbu            . \n" +
                            ".           0) Exit                           . \n");
        } else {
        System.out.print(". ^^^[_]^^^ 0) Exit                           . \n" +
                            ".                                             . \n");
        }
        System.out.print(".                                             . \n" +
                            ".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:. \n");
        int statement = scan.nextInt();cls();
        return statement;
    }

    private static String customPlaySound(boolean rand){
        int statement = 0;
        if(rand){
            statement = rnd.nextInt(4) + 1;
            while (statement == actualSong) {
                statement = rnd.nextInt(4) + 1;
            }
        } else {

//            System.out.print(".:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:. \n"+
//.                                             .
//.                                 .      .    .
//.                                 _\/  \/_    .
//.                                  _\/\/_     .
//.                              _\_\_\/\/_/_/_ .
//.                               / /_/\/\_\ \  .
//.                                  _/\/\_     .
//.                                  /\  /\     .
//.                                 '      '    .
//.                                             .
//.                                             .
//.                                             .
//.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:._.:*~*:.

            System.out.print("1) Last Christmas \n" +
                    "2) Jingle Bell Rock \n" +
                    "3) All I Want For Christmas Is You \n" +
                    "4) We Wish You A Merry Christmas \n" +
                    "5) Merry Christmas and Happy New Year \n" +
                    "6) Be quiet mode ");
            statement = scan.nextInt();
            cls();
        }
        String filename = "";
        switch (statement){
            case 1:
                filename = "lastchristmas";
                break;
            case 2:
                filename = "jinglebells";
                break;
            case 3:
                filename = "christmasisyou";
                break;
            case 5:
                filename = "happychristmas";
                break;
            case 6:
                filename = "bequiet";
                break;
            default:
                filename = "wewishyou";
                break;
        }
        actualSong = statement;
        return filename;
    }

    public static void cls() {
        try {
            new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
        } catch (final Exception ignore) {}
    }

    private static int actualSong = 0;
    private static void playClip(File clipFile) throws IOException, UnsupportedAudioFileException {
        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(clipFile);
        class AudioListener implements LineListener {
            @Override public synchronized void update(LineEvent event) {
                LineEvent.Type eventType = event.getType();
                if (eventType == LineEvent.Type.STOP || eventType == LineEvent.Type.CLOSE) {
                    try {
                        playClip(new File(completeUrlFiles + "Sounds\\"+customPlaySound(true)+".wav"));
                    } catch (IOException | UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    }
                    notifyAll();
                }
            }
        }
        AudioListener listener = new AudioListener();
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.addLineListener(listener);
            FloatControl volume = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            volume.setValue(((volume.getMaximum() - volume.getMinimum()) * 0.7f) + volume.getMinimum());
            clip.start();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        } finally {
            audioInputStream.close();
        }
    }
}