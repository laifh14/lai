import java.io.File;
import java.util.concurrent.BlockingQueue;

public class BlockingQueueTest {
    public static void main(String[] args){
    }
}
class FileEnumerateTask implements Runnable{
    private File labelFile=new File("");
    private File startFile;
    private BlockingQueue<File> queue;

    public FileEnumerateTask(File file,BlockingQueue<File> queue){
        this.queue=queue;
        this.startFile=file;
    }

    private void enumerateFile(File file)throws InterruptedException{
        File[] files=file.listFiles();
        for(File filel:files){
            if (filel.isDirectory()){
                enumerateFile(filel);
            }else {
                queue.put(filel);
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

    }
}
