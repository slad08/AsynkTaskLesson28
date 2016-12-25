package android.bignerdranch.com.asynktasklesson28;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class MainActivity extends AppCompatActivity {
    private myAsyncTask task;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       task= new myAsyncTask();
    }
    public void onShowMessage(View view) throws ExecutionException, InterruptedException {

        task.execute();

        String text = null;
        try {
            text = task.get(2, TimeUnit.SECONDS);
            Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
        } catch (TimeoutException e) {
            Toast.makeText(this,"Мы не смогли получить ответ",Toast.LENGTH_SHORT).show();
        }


    }
    class myAsyncTask extends AsyncTask<Void,Void,String>{

        @Override
        protected String doInBackground(Void... params) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return "HELLO";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
        }
    }
}
