package com.example.omikujiapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // おみくじ結果の配列
    private String[] results = {"大吉", "中吉", "小吉", "末吉", "凶", "大凶"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // レイアウトからテキストビューを取得
        Button button = findViewById(R.id.button);
        TextView result = findViewById(R.id.result);

        // ボタンがクリックされたときの処理
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ランダムでおみくじ結果を選択
                Random random = new Random();
                int index = random.nextInt(results.length);

                // 結果をテキストビューに表示
                result.setText(results[index]);
            }
        });
    }
}