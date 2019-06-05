package com.run.clap;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

public class Clap {

    //音楽プレイヤー
    private SoundPool soundPool;

    //読み込んだ音声のID
    private int soundId;

    //Clapインスタンスをつくり、初期化する
    public Clap (Context context){

        //新しいSoundPoolインスタンスを生成
        soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        //音声ファイルを読み込む
        soundId = soundPool.load(context, R.raw.clap,1);
    }

    //音声再生メソッド
    public void play(){
        soundPool.play(soundId,1.0f,1.0f,0,0,1.0f);
    }

    //手拍子再生メソッド
    public void repeatPlay(int repeat){
        //繰り返した回数をカウント
        int count = 0;

        while (count < repeat){
            //playメソッドで音声を再生
            play();
            //繰り返しカウントを1増やす
            count ++;

            try{
                //500ミリ秒待つ
                Thread.sleep(500);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
