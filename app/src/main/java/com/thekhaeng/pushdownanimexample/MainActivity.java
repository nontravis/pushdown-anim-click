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

        // music.setEnabled( false ); // if you want to disable click
        PushDownAnim.setPushDownAnimTo( music )
                .setOnClickListener( getClickListener() )
                .setOnLongClickListener( getLongClickListener() );

        PushDownAnim.setPushDownAnimTo( button1 )
                .setOnClickListener( getClickListener() )
                .setOnLongClickListener( getLongClickListener() );

        PushDownAnim.setPushDownAnimTo( button2 )
                .setOnClickListener( getClickListener() )
                .setOnLongClickListener( getLongClickListener() );

//        [equal]
//        PushDownAnim.setPushDownAnimTo( button )
//                .setScale( PushDownAnim.DEFAULT_PUSH_SCALE )
//                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
//                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
//                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
//                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR
//                .setOnClickListener( getClickListener() )
//                .setOnLongClickListener( getLongClickListener() );
//        [equal]
//        PushDownAnim.setPushDownAnimTo( music,button1,button2 )
//                .setScale( PushDownAnim.DEFAULT_PUSH_SCALE )
//                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
//                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
//                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
//                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR )
//                .setOnClickListener( getClickListener() )
//                .setOnLongClickListener( getLongClickListener() );
    }

    @NonNull
    private View.OnClickListener getClickListener(){
        return new View.OnClickListener(){
            @Override
            public void onClick( View view ){
                if( view == music ){
                    Toast.makeText( MainActivity.this, "PUSH DOWN 1 !!", Toast.LENGTH_SHORT ).show();
                }else if( view == button1 ){
                    Toast.makeText( MainActivity.this, "PUSH DOWN 2 !!", Toast.LENGTH_SHORT ).show();
                }else if( view == button2 ){
                    Toast.makeText( MainActivity.this, "PUSH DOWN 3 !!", Toast.LENGTH_SHORT ).show();
                }
            }

        };
    }

    @NonNull
    private View.OnLongClickListener getLongClickListener(){
        return new View.OnLongClickListener(){
            @Override
            public boolean onLongClick( View view ){
                if( view == music ){
                    Toast.makeText( MainActivity.this, "LONG PUSH DOWN 1 !!", Toast.LENGTH_SHORT ).show();
                }else if( view == button1 ){
                    Toast.makeText( MainActivity.this, "LONG PUSH DOWN 2 !!", Toast.LENGTH_SHORT ).show();
                }else if( view == button2 ){
                    Toast.makeText( MainActivity.this, "LONG PUSH DOWN 3 !!", Toast.LENGTH_SHORT ).show();
                }
                return true; // true: not effect to single click
            }
        };
    }


}
