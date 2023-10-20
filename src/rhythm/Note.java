package rhythm;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLOutput;

public class Note extends Thread{
    private Image noteBasicImage= new ImageIcon(Main.class.getResource("/rhythm/images/noteBasic.png")).getImage();
    private int x, y=580-(1000/ Main.SLEEP_TIME* Main.NOTE_SPEED)* Main.REACH_TIME;
    private String noteType;
    private boolean proceeded=true;

    public String getNoteType(){
        return noteType;
    }
    public boolean isProceeded(){
        return proceeded;
    }

    public void close(){
        proceeded=false;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public Note(String noteType){
        if(noteType.equals("Q")){
            x=220;
        }else if(noteType.equals("W")){
            x=324;
        }else if(noteType.equals("E")){
            x=428;
        }else if(noteType.equals("R")){
            x=532;
        }else if(noteType.equals("U")){
            x=636;
        }else if(noteType.equals("I")){
            x=740;
        }else if(noteType.equals("O")){
            x=844;
        }else if(noteType.equals("P")){
            x=948;
        }
        this.noteType=noteType;
    }

    public void screenDraw(Graphics2D g){
        if(noteType.equals("long")){
            g.drawImage(noteBasicImage,x,y,null);
            g.drawImage(noteBasicImage,x+104,y,null);
        }else{
            g.drawImage(noteBasicImage,x,y, null);
        }
    }

    public void drop(){
        y+= Main.NOTE_SPEED;
        if(y>620){
            System.out.println("Miss");
            close();
        }
    }
    
    @Override
    public void run(){
    try{
        while(true){
            drop();
            if(proceeded){
                Thread.sleep(Main.SLEEP_TIME);
            }else{
                interrupt();
                break;
            }
        }
    }catch(Exception e){
        System.err.println(e.getMessage());
    }
    }
    public String judge(){
        if(y>=613){
            System.out.println("Late");
            close();
            return "Late";
        }else if(y>=600){
            System.out.println("Good");
            close();
            return "Good";
        }else if(y>=587){
            System.out.println("Great");
            close();
            return "Great";
        }else if(y>=574){
            System.out.println("Perfect");
            close();
            return "Perfect";
        }else if(y>=560){
            System.out.println("Great");
            close();
            return "Great";
        }else if(y>=547){
            System.out.println("Good");
            close();
            return "Good";
        }else if(y>=530){
            System.out.println("Early");
            close();
            return "Early";
        }
        return "None";
    }
}
