package com.thekhaeng.pushdownanimexample;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.thekhaeng.pushdownanim.PushDownAnim;


public class MainActivity extends AppCompatActivity{

    private Button button1;
    private Button button2;
    private View music;

    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        button1 = findViewById( R.id.button1 );
        button2 = findViewById( R.id.button2 );
        music = findViewById( R.id.music );

        PushDownAnim.setOnTouchPushDownAnim( music );
        PushDownAnim.setOnTouchPushDownAnim( button1 )
                .setOnClickListener( getClickListener() );
        PushDownAnim.setOnTouchPushDownAnim( button2 )
                .setOnClickListener( getClickListener() );
//        [equal]
//        PushDownAnim.setOnTouchPushDownAnim( button,null )
//                .setScale( PushDownAnim.DEFAULT_PUSH_SCALE )
//                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
//                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
//                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
//                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR );
    }

    @NonNull
    private View.OnClickListener getClickListener(){
        return new View.OnClickListener(){
            @Override
            public void onClick( View view ){
                Toast.makeText( MainActivity.this, "PUSH DOWN !!", Toast.LENGTH_SHORT ).show();
            }

        };
    }
}
