import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        System.out.println("input the base directory");
        File file=new File(in.next());
        System.out.println("please input the keywords");
        String keywords=in.next();

        int blockingQueueSize=20;
        int threadSize=30;
        BlockingQueue<File> blockingQueue=new ArrayBlockingQueue<>(blockingQueueSize);

        FileEnumerateTask fileEnumerateTask=new FileEnumerateTask(file,blockingQueue);
        Thread threadE=new Thread(fileEnumerateTask);
        threadE.start();

        for(int i=0;i<threadSize;i++){
            SearchFileTask searchFileTask=new SearchFileTask(blockingQueue,keywords);
            Thread threadS=new Thread(searchFileTask);
            threadS.start();
        }
    }
}
class FileEnumerateTask implements Runnable{
    private static File labelFile=new File("");
    private File startFile;
    private BlockingQueue<File> queue;

    public FileEnumerateTask(File file,BlockingQueue<File> queue){
        this.queue=queue;
        this.startFile=file;
    }

    public static File getLabelFile() {
        return labelFile;
    }

    private void enumerateFile(File file)throws InterruptedException{
        File[] files=file.listFiles();
        if(files==null) {
            for (File file1 : files) {
                if (file1.isDirectory()) {
                    enumerateFile(file1);
                } else {
                    queue.put(file1);
                }
            }
        }
    }

    @Override
    public void run() {
        try {
            enumerateFile(startFile);
            queue.put(labelFile);
        }catch (InterruptedException ie){
            //TODO process InterruptedException
        }
    }
}
class SearchFileTask implements Runnable{
    private BlockingQueue<File> queue;
    private String keyword;

    public SearchFileTask(BlockingQueue<File> queue,String keyword){
        this.queue=queue;
        this.keyword=keyword;
    }

    @Override
    public void run() {
        try{
            while (queue.take()==null){
                File file=queue.take();
                if(file==FileEnumerateTask.getLabelFile()){
                    return;
                }else {
                    searchFile(file);
                }
            }
        }catch (InterruptedException ie){

        }


    }
    public void searchFile(File file){
        try {
            Scanner in=new Scanner(file);
            int numberLine=0;
            if (in.hasNext()){
                String str=in.next();
                if(str.contains(keyword)){
                    System.out.println(keyword+" is in "+file.getName()+": "+numberLine+" line");
                }
            }

        }catch (IOException io){

        }

    }
}
