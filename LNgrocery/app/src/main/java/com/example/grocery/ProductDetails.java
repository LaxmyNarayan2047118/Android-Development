package com.example.grocery;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RemoteViews;
import android.widget.TextView;

@SuppressWarnings("ALL")
public class ProductDetails extends AppCompatActivity {
    ImageView imageViewProduct, imageViewBack;
    TextView txtName, txtDesc, txtPrice;
    Button b1;
    notifi nt;
    public static final String NOTIFICATION_CHANNEL_ID = "10001" ;
    private final static String default_notification_channel_id = "default" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);
        onNewIntent(getIntent());
        Intent i =getIntent();
        String name = i.getStringExtra("name");
        String desc = i.getStringExtra("desc");
        String price = i.getStringExtra("price");
        int image = i.getIntExtra("image",R.drawable.b1);
        txtName = findViewById(R.id.lblPName);
        txtDesc = findViewById(R.id.lblPDesc);
        txtPrice = findViewById(R.id.lblPPrice);
        imageViewProduct= findViewById(R.id.imgProduct);
        imageViewBack = findViewById(R.id.imgBack);
        txtName.setText(name);
        txtPrice.setText(price);
        txtDesc.setText(desc);
        imageViewProduct.setImageResource(image);


        imageViewBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent =new Intent(ProductDetails.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
    public void createNotification (View view) {
        nt=new notifi(this);
        nt.execute();
        RemoteViews contentView = new RemoteViews(getPackageName() , R.layout. notification ) ;
        NotificationManager mNotificationManager = (NotificationManager) getSystemService( NOTIFICATION_SERVICE ) ;
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(ProductDetails. this, default_notification_channel_id ) ;
        mBuilder.setContent(contentView) ;
        mBuilder.setSmallIcon(R.drawable. ic_launcher_foreground ) ;
        mBuilder.setAutoCancel( true ) ;
        mBuilder.setVisibility(NotificationCompat. VISIBILITY_SECRET ) ;
        long [] VIBRATE_PATTERN = { 0 , 500 } ;
        if (android.os.Build.VERSION. SDK_INT >= android.os.Build.VERSION_CODES. O ) {
            int importance = NotificationManager. IMPORTANCE_HIGH ;
            NotificationChannel notificationChannel = new NotificationChannel( NOTIFICATION_CHANNEL_ID , "NOTIFICATION_CHANNEL_NAME" , importance) ;
            mBuilder.setChannelId( NOTIFICATION_CHANNEL_ID ) ;
            assert mNotificationManager != null;
            mNotificationManager.createNotificationChannel(notificationChannel) ;
        }
        assert mNotificationManager != null;
        mNotificationManager.notify(( int ) System. currentTimeMillis () , mBuilder.build()) ;
    }


}