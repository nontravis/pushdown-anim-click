package com.thekhaeng.pushdownanim;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * Created by The Khaeng on 09 Sep 2017
 */

public class PushDownAnim{
    public static final float DEFAULT_PUSH_SCALE = 0.97f;
    public static final long DEFAULT_PUSH_DURATION = 50;
    public static final long DEFAULT_RELEASE_DURATION = 125;
    public static final AccelerateDecelerateInterpolator DEFAULT_INTERPOLATOR
            = new AccelerateDecelerateInterpolator();

    private float scale = DEFAULT_PUSH_SCALE;
    private long durationPush = DEFAULT_PUSH_DURATION;
    private long durationRelease = DEFAULT_RELEASE_DURATION;
    private AccelerateDecelerateInterpolator interpolatorPush = DEFAULT_INTERPOLATOR;
    private AccelerateDecelerateInterpolator interpolatorRelease = DEFAULT_INTERPOLATOR;
    private View view;

    private PushDownAnim( View view ){
        this.view = view;
    }

    public static PushDownAnim setOnTouchPushDownAnim( View view,
                                                       View.OnTouchListener eventListener ){
        PushDownAnim pushAnim = new PushDownAnim( view );
        pushAnim.setOnTouchEvent( eventListener )
                .setOnClickListener( null );
        return pushAnim;
    }

    public static PushDownAnim setOnTouchPushDownAnim( View view ){
        PushDownAnim pushAnim = new PushDownAnim( view );
        pushAnim.setOnTouchEvent( null )
                .setOnClickListener( null );
        return pushAnim;
    }

    public PushDownAnim setScale( float scale ){
        this.scale = scale;
        return this;
    }

    public PushDownAnim setDurationPush( long duration ){
        this.durationPush = duration;
        return this;
    }

    public PushDownAnim setDurationRelease( long duration ){
        this.durationRelease = duration;
        return this;
    }

    public PushDownAnim setInterpolatorPush( AccelerateDecelerateInterpolator interpolatorPush ){
        this.interpolatorPush = interpolatorPush;
        return this;
    }

    public PushDownAnim setInterpolatorRelease( AccelerateDecelerateInterpolator interpolatorRelease ){
        this.interpolatorRelease = interpolatorRelease;
        return this;
    }


    public PushDownAnim setOnClickListener( View.OnClickListener clickListener ){
        if( view != null ){
            view.setOnClickListener( clickListener );
        }
        return this;
    }

    private PushDownAnim setOnTouchEvent( final View.OnTouchListener eventListener ){
        if( view != null ){
            view.setOnTouchListener( new View.OnTouchListener(){
                @Override
                public boolean onTouch( View view, MotionEvent motionEvent ){
                    int i = motionEvent.getAction();
                    if( i == MotionEvent.ACTION_DOWN ){
                        animScale( view,
                                scale,
                                durationPush,
                                interpolatorPush );
                    }else if( i == MotionEvent.ACTION_UP ){
                        view.performClick();
                        animScale( view,
                                1.0f,
                                durationRelease,
                                interpolatorRelease );
                    }else if( i == MotionEvent.ACTION_CANCEL ){
                        animScale( view,
                                1.0f,
                                durationRelease,
                                interpolatorRelease );
                    }
                    if( eventListener != null ){
                        return eventListener.onTouch( view, motionEvent );
                    }else{
                        return false;
                    }
                }
            } );
        }

        return this;
    }

    private void animScale( final View view,
                            float scale,
                            long duration,
                            TimeInterpolator interpolator ){
        ObjectAnimator scaleX = ObjectAnimator.ofFloat( view, "scaleX", scale );
        ObjectAnimator scaleY = ObjectAnimator.ofFloat( view, "scaleY", scale );
        scaleX.setInterpolator( interpolator );
        scaleX.setDuration( duration );
        scaleY.setInterpolator( interpolator );
        scaleY.setDuration( duration );

        AnimatorSet scaleAnimSet = new AnimatorSet();
        scaleAnimSet.play( scaleX ).with( scaleY );

        scaleX.addUpdateListener( new ValueAnimator.AnimatorUpdateListener(){
            @Override
            public void onAnimationUpdate( ValueAnimator valueAnimator ){
                View p = (View) view.getParent();
                p.invalidate();
            }
        } );
        scaleAnimSet.start();
    }

}
