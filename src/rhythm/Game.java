package rhythm;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Game extends Thread{
    private Image judgementLineImage = new ImageIcon(Main.class.getResource("/rhythm/images/judgementLine.png")).getImage();
    private Image gameInfoImage = new ImageIcon(Main.class.getResource("/rhythm/images/gameInfo.png")).getImage();
    private Image noteRouteLineImage = new ImageIcon(Main.class.getResource("/rhythm/images/noteRouteLine.png")).getImage();
    private Image noteRouteQImage = new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
    private Image noteRouteWImage = new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
    private Image noteRouteEImage = new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
    private Image noteRouteRImage = new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
    private Image noteRouteUImage = new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
    private Image noteRouteIImage = new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
    private Image noteRouteOImage = new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
    private Image noteRoutePImage = new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
    private Image flareImage;
    private Image judgeImage;
    private Image keyPadQImage = new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();
    private Image keyPadWImage = new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();
    private Image keyPadEImage = new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();
    private Image keyPadRImage = new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();
    private Image keyPadUImage = new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();
    private Image keyPadIImage = new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();
    private Image keyPadOImage = new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();
    private Image keyPadPImage = new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();

    private String titleName;
    private String difficulty;
    private String musicTitle;
    private Music gameMusic;

    ArrayList<Note> noteList= new ArrayList<Note>();

    private int theInt=0;

    public Game(String titleName, String difficulty,String musicTitle){
        this.titleName=titleName;
        this.difficulty=difficulty;
        this.musicTitle=musicTitle;
        gameMusic=new Music(this.musicTitle,false);

    }

    public void screenDraw(Graphics2D g){
        g.drawImage(noteRouteQImage,220,30,null);
        g.drawImage(noteRouteWImage,324,30,null);
        g.drawImage(noteRouteEImage,428,30,null);
        g.drawImage(noteRouteRImage,532,30,null);
        g.drawImage(noteRouteUImage,636,30,null);
        g.drawImage(noteRouteIImage,740,30,null);
        g.drawImage(noteRouteOImage,844,30,null);
        g.drawImage(noteRoutePImage,948,30,null);
        g.drawImage(noteRouteLineImage,216,30,null);
        g.drawImage(noteRouteLineImage,424,30,null);
        g.drawImage(noteRouteLineImage,528,30,null);
        g.drawImage(noteRouteLineImage,632,30,null);
        g.drawImage(noteRouteLineImage,736,30,null);
        g.drawImage(noteRouteLineImage,840,30,null);
        g.drawImage(noteRouteLineImage,944,30,null);
        g.drawImage(noteRouteLineImage,1048,30,null);
        g.drawImage(gameInfoImage,0,660,null);
        g.drawImage(judgementLineImage, 0,580,null);
        for(int i = 0;i<noteList.size();i++){
            Note note= noteList.get(i);
            if(note.getY()>620)
                judgeImage=new ImageIcon(Main.class.getResource("/rhythm/images/judgeMiss.png")).getImage();
            if(!note.isProceeded()){
                noteList.remove(i);
            }else
            note.screenDraw(g);
        }
        g.setColor(Color.white);
        g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING,RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g.setFont(new Font("Arial", Font.BOLD,30));
        g.drawString(titleName,20,702);
        g.drawString(difficulty,1190,702);
        g.setColor(Color.DARK_GRAY);
        g.drawString("Q",260,609);
        g.drawString("W",364,609);
        g.drawString("E",468,609);
        g.drawString("R",572,609);
        g.drawString("U",676,609);
        g.drawString("I",780,609);
        g.drawString("O",884,609);
        g.drawString("P",988,609);
        g.setColor(Color.LIGHT_GRAY);
        g.setFont(new Font("Elephant", Font.BOLD,30));
//        g.drawString("000000",565,702);

        g.drawString(String.format("%06d",theInt), 565, 702);
        g.drawImage(flareImage,490,425,null);
        g.drawImage(judgeImage,460,420,null);
        g.drawImage(keyPadQImage,220,580,null);
        g.drawImage(keyPadWImage,324,580,null);
        g.drawImage(keyPadEImage,428,580,null);
        g.drawImage(keyPadRImage,532,580,null);
        g.drawImage(keyPadUImage,636,580,null);
        g.drawImage(keyPadIImage,740,580,null);
        g.drawImage(keyPadOImage,844,580,null);
        g.drawImage(keyPadPImage,948,580,null);
    }

    public void pressQ(){
        judge("Q");
        noteRouteQImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoutePressed.png")).getImage();
        keyPadQImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadPressed.png")).getImage();
        new Music("drumSmall1.mp3", false).start();
    }
    public void releaseQ(){
        noteRouteQImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
        keyPadQImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();

    }
    public void pressW(){
        judge("W");
        noteRouteWImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoutePressed.png")).getImage();
        keyPadWImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadPressed.png")).getImage();
        new Music("drumSmall2.mp3", false).start();

    }
    public void releaseW(){
        noteRouteWImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
        keyPadWImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();

    }
    public void pressE(){
        judge("E");
        noteRouteEImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoutePressed.png")).getImage();
        keyPadEImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadPressed.png")).getImage();
        new Music("drumSmall3.mp3", false).start();

    }
    public void releaseE(){
        noteRouteEImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
        keyPadEImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();

    }
    public void pressR(){
        judge("R");
        noteRouteRImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoutePressed.png")).getImage();
        keyPadRImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadPressed.png")).getImage();

        new Music("drumSmall4.mp3", false).start();

    }
    public void releaseR(){
        noteRouteRImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
        keyPadRImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();

    }
    public void pressU(){
        judge("U");
        noteRouteUImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoutePressed.png")).getImage();
        keyPadUImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadPressed.png")).getImage();

        new Music("drumBig1.mp3", false).start();

    }
    public void releaseU(){
        noteRouteUImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
        keyPadUImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();

    }
    public void pressI(){
        judge("I");
        noteRouteIImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoutePressed.png")).getImage();
        keyPadIImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadPressed.png")).getImage();

        new Music("drumBig2.mp3", false).start();

    }
    public void releaseI(){
        noteRouteIImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
        keyPadIImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();

    }
    public void pressO(){
        judge("O");
        noteRouteOImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoutePressed.png")).getImage();
        keyPadOImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadPressed.png")).getImage();

        new Music("drumBig3.mp3", false).start();

    }
    public void releaseO(){
        noteRouteOImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
        keyPadOImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();

    }
    public void pressP(){
        judge("P");
        noteRoutePImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoutePressed.png")).getImage();
        keyPadPImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadPressed.png")).getImage();
        new Music("drumBig4.mp3", false).start();

    }
    public void releaseP(){
        noteRoutePImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteRoute.png")).getImage();
        keyPadPImage=new ImageIcon(Main.class.getResource("/rhythm/images/keyPadBasic.png")).getImage();
    }

    @Override
    public void run(){
        dropNotes(this.titleName);
    }
    public void close(){
        gameMusic.close();
        this.interrupt();
    }

    public void dropNotes(String titleName){

        Beat[] beats= null;
        if(titleName.equals("Eric Skiff - A Night Of Dizzy Spells")&&difficulty.equals("Easy")){
            int startTime=50-Main.REACH_TIME*1000;
            int gap= 150;
            beats=new Beat[]{
                    new Beat(startTime+gap*2,"U"),
                    new Beat(startTime+gap*4,"P"),
                    new Beat(startTime+gap*6,"U"),
                    new Beat(startTime+gap*8,"P"),
                    new Beat(startTime+gap*10,"U"),
                    new Beat(startTime+gap*12,"P"),
                    new Beat(startTime+gap*14,"U"),
                    new Beat(startTime+gap*16,"Q"),
                    new Beat(startTime+gap*18,"W"),
                    new Beat(startTime+gap*20,"R"),
                    new Beat(startTime+gap*22,"W"),
                    new Beat(startTime+gap*24,"U"),
                    new Beat(startTime+gap*26,"I"),
                    new Beat(startTime+gap*28,"I"),
                    new Beat(startTime+gap*30,"I"),
                    new Beat(startTime+gap*32,"P"),
                    new Beat(startTime+gap*34,"P"),
                    new Beat(startTime+gap*36,"U"),
                    new Beat(startTime+gap*38,"P"),
                    new Beat(startTime+gap*40,"U"),
                    new Beat(startTime+gap*42,"W"),
                    new Beat(startTime+gap*44,"W"),
                    new Beat(startTime+gap*46,"E"),
                    new Beat(startTime+gap*48,"R"),
                    new Beat(startTime+gap*50,"U"),
                    new Beat(startTime+gap*52,"W"),
                    new Beat(startTime+gap*54,"U"),
                    new Beat(startTime+gap*56,"R"),
                    new Beat(startTime+gap*58,"U"),
                    new Beat(startTime+gap*60,"R"),
                    new Beat(startTime+gap*62,"I"),
                    new Beat(startTime+gap*64,"I"),
                    new Beat(startTime+gap*66,"O"),
                    new Beat(startTime+gap*68,"Q"),
                    new Beat(startTime+gap*70,"W"),
                    new Beat(startTime+gap*72,"P"),
                    new Beat(startTime+gap*74,"P"),
                    new Beat(startTime+gap*76,"U"),
                    new Beat(startTime+gap*78,"P"),
                    new Beat(startTime+gap*80,"U"),
                    new Beat(startTime+gap*82,"P"),
                    new Beat(startTime+gap*84,"U"),
                    new Beat(startTime+gap*86,"R"),
                    new Beat(startTime+gap*88,"W"),
                    new Beat(startTime+gap*90,"W"),
                    new Beat(startTime+gap*92,"E"),
                    new Beat(startTime+gap*94,"I"),
                    new Beat(startTime+gap*96,"O"),
                    new Beat(startTime+gap*98,"I"),
                    new Beat(startTime+gap*100,"Q"),
                    new Beat(startTime+gap*102,"R"),
                    new Beat(startTime+gap*104,"O"),
                    new Beat(startTime+gap*106,"P"),
                    new Beat(startTime+gap*108,"W"),
                    new Beat(startTime+gap*110,"W"),
                    new Beat(startTime+gap*112,"W"),
            };
        }else if(titleName.equals("Eric Skiff - A Night Of Dizzy Spells")&&difficulty.equals("Hard")){
            int startTime=1000-Main.REACH_TIME*1000;
            int gap= 150;
            beats=new Beat[]{
                    new Beat(startTime,"U"),
                    new Beat(startTime+gap*2,"U"),
                    new Beat(startTime+gap*4,"P"),
                    new Beat(startTime+gap*6,"U"),
                    new Beat(startTime+gap*8,"P"),
                    new Beat(startTime+gap*10,"U"),
                    new Beat(startTime+gap*12,"P"),
                    new Beat(startTime+gap*14,"U"),
                    new Beat(startTime+gap*16,"Q"),
                    new Beat(startTime+gap*18,"W"),
                    new Beat(startTime+gap*20,"R"),
                    new Beat(startTime+gap*22,"W"),
                    new Beat(startTime+gap*24,"U"),
                    new Beat(startTime+gap*26,"I"),
                    new Beat(startTime+gap*28,"I"),
                    new Beat(startTime+gap*30,"I"),
                    new Beat(startTime+gap*32,"P"),
                    new Beat(startTime+gap*34,"P"),
                    new Beat(startTime+gap*36,"U"),
                    new Beat(startTime+gap*38,"P"),
                    new Beat(startTime+gap*40,"U"),
                    new Beat(startTime+gap*42,"P")
            };
        }else if(titleName.equals("Quincas Moreira - Robot City")&&difficulty.equals("Easy")){
            int startTime=500-Main.REACH_TIME*1000;
            beats=new Beat[]{
                    new Beat(startTime,"U")
            };
        }else if(titleName.equals("Quincas Moreira - Robot City")&&difficulty.equals("Hard")){
            int startTime=500-Main.REACH_TIME*1000;
            beats=new Beat[]{
                    new Beat(startTime,"U")
            };
        }else if(titleName.equals("William Rosati - Floating Also")&&difficulty.equals("Easy")){
            int startTime=500-Main.REACH_TIME*1000;
            beats=new Beat[]{
                    new Beat(startTime,"U")
            };
        }else if(titleName.equals("William Rosati - Floating Also")&&difficulty.equals("Hard")){
            int startTime=500-Main.REACH_TIME*1000;
            beats=new Beat[]{
                    new Beat(startTime,"U")
            };
        }
        int i = 0;
        try{
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        gameMusic.start();
        while(i<beats.length&& !isInterrupted()){
            boolean dropped=false;
            if(beats[i].getTime()<=gameMusic.getTime()){
                Note note= new Note(beats[i].getNoteName());
                note.start();
                noteList.add(note);
                i++;
                dropped=true;
            }
            if(!dropped){
                try{
                    Thread.sleep(5);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public void judge(String input){
        for(int i =0;i<noteList.size();i++){
            Note note= noteList.get(i);
            if(input.equals(note.getNoteType())){
                judgeEvent(note.judge());
                break;
            }
        }
    }
    public void judgeEvent(String judge){
        if(!judge.equals("None")){
            flareImage=new ImageIcon(Main.class.getResource("/rhythm/images/flare.png")).getImage();
        }
        if(judge.equals("Miss")){
            judgeImage=new ImageIcon(Main.class.getResource("/rhythm/images/judgeMiss.png")).getImage();
        }else if(judge.equals("Late")){
            judgeImage=new ImageIcon(Main.class.getResource("/rhythm/images/judgeLate.png")).getImage();
        }else if(judge.equals("Good")){
            judgeImage=new ImageIcon(Main.class.getResource("/rhythm/images/judgeGood.png")).getImage();
            theInt+=1250;
        }else if(judge.equals("Great")){
            judgeImage=new ImageIcon(Main.class.getResource("/rhythm/images/judgeGreat.png")).getImage();
            theInt+=2110;
        }else if(judge.equals("Perfect")){
            judgeImage=new ImageIcon(Main.class.getResource("/rhythm/images/judgePerfect.png")).getImage();
            theInt+=3200;
        }else if(judge.equals("Early")){
            judgeImage=new ImageIcon(Main.class.getResource("/rhythm/images/judgeEarly.png")).getImage();
        }
    }
}
