package com.example.grocery;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.renderscript.Sampler;
import android.util.Log;
import android.widget.Toast;

@SuppressWarnings("ALL")
public class notifi extends AsyncTask  <Void,Integer,String> {
    Context ctx;
    ProgressDialog pd;

    public notifi(Context ct) {
        ctx = ct;
    }

    @Override
    protected void onPreExecute() {
        pd = new ProgressDialog(ctx);
        pd.setTitle("Finding Your Delievry agent.");
        pd.setMessage("Searching Please Wait...");
        pd.setMax(4);
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                dialog.cancel();
                cancel(true);
            }
        });
        pd.show();
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {
            for (int i = 1; i <= 5; i++) {
                Thread.sleep(4000);
                Log.i("Thread", "Executed");
                publishProgress(i);

            }
            return "Successfully found";
        } catch (Exception e){
            Log.i("Exception",e.getMessage());
            return "failure";
        }
    }
    @Override
    protected void onProgressUpdate(Integer... values) {
        int Agents = values[0];
        pd.setProgress(Agents);
    }

    @Override
    protected void onPostExecute(String s) {
        Toast.makeText(ctx, "Agent was found your item will be delivered", Toast.LENGTH_SHORT).show();
        pd.dismiss();
    }
}