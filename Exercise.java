public class Exercise {
    public static void main(String[] args) {
        Time time1=new Time();
            System.out.println(time1.getHour()+":"+time1.getMinute()+":"+time1.getSecond());
        Time time2=new Time(555550000);
            System.out.println(time2.getHour()+":"+time2.getMinute()+":"+time2.getSecond());
        Time time3=new Time(5, 23, 55);
            System.out.println(time3.getHour()+":"+time3.getMinute()+":"+time3.getSecond());

    }
}
class Time{
    private int hour;
    private int minute;
    private int second;

    public int getHour() {return hour;}
    public int getMinute() {return minute;}
    public int getSecond() {return second;}
    
    public Time(){
        this(System.currentTimeMillis());
    }
    public Time(long elapsedTime){
        setTime(elapsedTime);

    }
    public Time(int hour,int minute,int second){
        this.hour=hour;
        this.minute=minute;
        this.second=second;
    }
    public void setTime(long elapsedTime){
        long totalSecond=elapsedTime/1000;
        second=(int)(totalSecond%60);
        long totalMinute=totalSecond/60;
        minute=(int)(totalMinute%60);
        long totalHour=totalMinute/60;
        hour=(int)(totalHour%24);
    }
    

}
