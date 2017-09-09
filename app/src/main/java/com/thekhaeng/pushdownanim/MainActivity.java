package com.thekhaeng.pushdownanim;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private Button button;
    private View music;

    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        button = findViewById( R.id.button );
        music = findViewById( R.id.music );
//        music.setOnClickListener( new View.OnClickListener(){
//            @Override
//            public void onClick( View view ){
//
//            }
//        } );

        PushDownAnim.setOnTouchPushDownAnim( music );
        PushDownAnim.setOnTouchPushDownAnim( button )
                .setOnClickListener( new View.OnClickListener(){
                    @Override
                    public void onClick( View view ){
                        Toast.makeText( MainActivity.this, "PUSH DOWN !!", Toast.LENGTH_SHORT ).show();
                    }

                } );
//        [equal]
//        PushDownAnim.setOnTouchPushDownAnim( button,null )
//                .setScale( PushDownAnim.DEFAULT_PUSH_SCALE )
//                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
//                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
//                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
//                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR );
    }
}
