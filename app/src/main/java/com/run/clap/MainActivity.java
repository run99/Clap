package com.run.clap;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;

public class MainActivity extends Activity implements View.OnClickListener, AdapterView.OnItemSelectedListener {

    //繰り返し回数
    int repeat = 1;

    ImageButton button;
    Spinner spinner;

    Clap clapInstance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //部品を関連付け
        button = (ImageButton)findViewById(R.id.ImgBtn);
        spinner=(Spinner)findViewById(R.id.spinner);
        button.setOnClickListener(this);

        //動的に画像を設定したら画像がエミュレータで表示されるようになった
        button.setImageResource(R.drawable.button);

        //表示する文字列を配列に準備
        String[] strArray = new String[5];
        strArray[0]="パンッ！";
        strArray[1]="パンパンッ！";
        strArray[2]="パンパンパンッ！";
        strArray[3]="4回";
        strArray[4]="5回";

        //配列をspinnerに入れる
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,android.R.layout.simple_gallery_item,strArray
        );
        arrayAdapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item
        );

        spinner.setAdapter(arrayAdapter);


        //spinnerが使われたときの処理をこのクラスで指定
        spinner.setOnItemSelectedListener(this);


        //音声プレイヤーを作る
        clapInstance = new Clap(this.getApplicationContext());
    }

    @Override
    public void onClick(View v) {
        //clapInstance.play();
        //Clapで設計した繰り返し機能をここでインスタンス化
        clapInstance.repeatPlay(repeat);

    }

    //スピナーが選択された際の処理
    @Override
    public void onItemSelected(AdapterView<?>parent, View v, int pos, long id){
        //選択された項目の番号＋１を繰り返し回数に設定
        repeat = pos + 1;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}
