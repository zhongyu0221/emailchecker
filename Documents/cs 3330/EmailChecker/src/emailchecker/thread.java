/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package emailchecker;

import java.io.File;
import static java.lang.Thread.sleep;

/**
 *
 * @author zhongyu
 */
public class thread extends Thread {
     CheckEmailObj EmailObj = new CheckEmailObj();


    public thread(String threadName) {
        super(threadName);
        //System.out.println("没跑??");
    }

  

    public void run() {
        Boolean result;
        
        System.out.println( " Thread 1 开始\n");

       for (int i = 0; i < 10; i++) {

           //  result = EmailObj.checkEmail(getName());
             
          System.out.println(i );
     

            try {
                sleep((int) Math.random() * 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(getName() + " run方法结束");
    }
}
