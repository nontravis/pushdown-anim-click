package com.thekhaeng.pushdownanimexample;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.Toast;

import com.thekhaeng.pushdownanim.PushDownAnim;
import com.transitionseverywhere.Fade;
import com.transitionseverywhere.TransitionManager;
import com.transitionseverywhere.TransitionSet;
import com.transitionseverywhere.extra.Scale;


public class MainActivity extends AppCompatActivity{

    private Button button1;
    private Button button2;
    private View music;
    private ViewGroup container;

    @Override
    protected void onCreate( Bundle savedInstanceState ){
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        container = findViewById(R.id.container);
        button1 = findViewById( R.id.button1 );
        button2 = findViewById( R.id.button2 );


        music = findViewById( R.id.music );

        // music.setEnabled( false ); // if you want to disable click
//        PushDownAnim.setPushDownAnimTo( music )
//                .setScale( PushDownAnim.MODE_STATIC_DP, 2 )
//                .setOnClickListener( getClickListener() )
//                .setOnLongClickListener( getLongClickListener() );
//
//        PushDownAnim.setPushDownAnimTo( button1 )
//                .setOnClickListener( getClickListener() )
//                .setOnLongClickListener( getLongClickListener() );
//
//        PushDownAnim.setPushDownAnimTo( button2 )
//                .setOnClickListener( getClickListener() )
//                .setOnLongClickListener( getLongClickListener() );

//        [equal]
//        PushDownAnim.setPushDownAnimTo( button )
//                .setScale( PushDownAnim.MODE_SCALE , PushDownAnim.DEFAULT_PUSH_SCALE )
//                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
//                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
//                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
//                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR
//                .setOnClickListener( getClickListener() )
//                .setOnLongClickListener( getLongClickListener() );
//        [equal]
        PushDownAnim.setPushDownAnimTo( music, button1, button2 )
                .setScale( PushDownAnim.MODE_STATIC_DP , 2 )
                .setDurationPush( PushDownAnim.DEFAULT_PUSH_DURATION )
                .setDurationRelease( PushDownAnim.DEFAULT_RELEASE_DURATION )
                .setInterpolatorPush( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setInterpolatorRelease( PushDownAnim.DEFAULT_INTERPOLATOR )
                .setOnClickListener( getClickListener() )
                .setOnLongClickListener( getLongClickListener() );


        // delay show view to check PushDownAnim.MODE_STATIC_DP not calculate size of view is zero.
        button2.setVisibility(View.GONE);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                    TransitionSet set = new TransitionSet()
                            .addTransition(new Scale())
                            .addTransition(new Fade())
                            .setDuration(200)
                            .setInterpolator(new OvershootInterpolator(1.0f));
                    TransitionManager.beginDelayedTransition(container, set);
                    TransitionManager.beginDelayedTransition(container);
                    button2.setVisibility(View.VISIBLE);
                }
            }
        }, 1000);


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
