package ohtu;

import com.google.gson.JsonElement;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Submission {
    private String student_number;
    private String week;
    private String hours;
    public int yhteensa;
    private boolean a1;
    private boolean a2;
    private boolean a3;
    private boolean a4;
    private boolean a5;
    private boolean a6;
    private boolean a7;
    private boolean a8;
    private boolean a9;
    private boolean a10;
    private boolean a11;
    private boolean a12;
    private boolean a13;
    private boolean a14;
    private boolean a15;
    private boolean a16;
    private boolean a17;
    private boolean a18;
    private boolean a19;
    private boolean a20;
    private boolean a21;
    

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }
    
    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }
    
    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }
    
    public void setA1(boolean a1){
        this.a1 = a1;
    }
    
    public void setA2(boolean a2){
        this.a2 = a2;
    }
    
    public void setA3(boolean a3){
        this.a3 = a3;
    }
    
    public void setA4(boolean a4){
        this.a4 = a4;
    }
    
    public void setA5(boolean a5){
        this.a5 = a5;
    }
    
    public void setA6(boolean a6){
        this.a6 = a6;
    }
    
    public void setA7(boolean a7){
        this.a7 = a7;
    }
    
    public void setA8(boolean a8){
        this.a8 = a8;
    }
    
    public void setA9(boolean a9){
        this.a9 = a9;
    }
    
    public void setA10(boolean a10){
        this.a10 = a10;
    }
    
    public void setA11(boolean a11){
        this.a11 = a11;
    }
    
    public void setA12(boolean a12){
        this.a12 = a12;
    }
    public void setA13(boolean a13){
        this.a13 = a13;
    }
    
    public void setA14(boolean a14){
        this.a14 = a14;
    }
    public void setA15(boolean a15){
        this.a15 = a15;
    }
    
    public void setA16(boolean a16){
        this.a16 = a16;
    }
    
    public void setA17(boolean a17){
        this.a17 = a17;
    }
    
    public void setA18(boolean a18){
        this.a18 = a18;
    }
    
    public void setA19(boolean a19){
        this.a19 = a19;
    }
    public void setA20(boolean a20){
        this.a20 = a20;
    }
    
    public void setA21(boolean a21){
        this.a21 = a21;
    }
    
    
    @Override
    public String toString() {
        ArrayList<Integer> t = new ArrayList<Integer>();
        if(this.a1 == true){
            t.add(1);
        }
        if(this.a2 == true){
            t.add(2);
        }
        if(this.a3 == true){
            t.add(3);
        }
        if(this.a4 == true){
            t.add(4);
        }
        if(this.a5 == true){
            t.add(5);
        }
        if(this.a6 == true){
            t.add(6);
        }
        if(this.a7 == true){
            t.add(7);
        }
        if(this.a8 == true){
            t.add(8);
        }
        if(this.a9 == true){
            t.add(9);
        }
        if(this.a10 == true){
            t.add(10);
        }
        if(this.a11 == true){
            t.add(11);
        }
        if(this.a12 == true){
            t.add(12);
        }
        if(this.a13 == true){
            t.add(13);
        }
        if(this.a14 == true){
            t.add(14);
        }
        if(this.a15 == true){
            t.add(15);
        }
        if(this.a16 == true){
            t.add(16);
        }
        if(this.a17 == true){
            t.add(17);
        }
        if(this.a18 == true){
            t.add(18);
        }
        if(this.a19 == true){
            t.add(19);
        }
        if(this.a20 == true){
            t.add(20);
        }
        
        if(this.a21 == true){
            t.add(21);
        }
        
        String tulostus = "";
        tulostus += " tehtyjä tehtäviä yhteensä: " + t.size();
        tulostus += " aikaa kului " + this.getHours() + " tuntia, ";
        tulostus += " tehdyt tehtävät " + t.toString();
        this.yhteensa = t.size();
        return tulostus;
    }
    
}