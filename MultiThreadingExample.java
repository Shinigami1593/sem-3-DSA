class DownloadImage {

    void downloadImage(int num, String imgName){
        for(int i = 1;i<=num;i++){
            System.out.println("Downloading image " + imgName + i + ".jpg");
        }
    }
}

class myThread extends Thread{
    DownloadImage obj;
    myThread(DownloadImage obj){
        this.obj = obj;
    }
    @Override
    public void run(){
        obj.downloadImage(5, "dog");
    }
}
class yourThread extends Thread{
    DownloadImage obj;
    yourThread(DownloadImage obj){
        this.obj = obj;
    }
    @Override
    public void run(){
        obj.downloadImage(5, "dog");
    }
}
public class MultiThreadingExample{
    public static void main(String[] args) {
        DownloadImage obj = new DownloadImage();
        myThread t1 = new myThread(obj);
        yourThread t2 = new yourThread(obj);
        t1.start();
        t2.start();
        try{
            t1.join();
        }
        catch(Exception ee){
            ee.printStackTrace();
        } 
    }  
}

