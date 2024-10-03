package com.example.omikujiapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private String[] results = {"大吉", "中吉", "小吉", "末吉", "凶", "大凶"};
    private int[] colors = {
            0xFFFFD700, // 大吉 (金色)
            0xFF00FF00, // 中吉 (緑)
            0xFFADFF2F, // 小吉 (黄緑)
            0xFFFFFF00, // 末吉 (黄色)
            0xFFFF4500, // 凶 (オレンジ)
            0xFFFF0000  // 大凶 (赤)
    };

    private TextView resultTextView;
    private Button drawButton;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.result);
        drawButton = findViewById(R.id.button);
        backButton = findViewById(R.id.back_button);

        drawButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // ランダムに結果を選ぶ
                Random random = new Random();
                int index = random.nextInt(results.length);
                resultTextView.setText(results[index]);

                // 背景色を変更
                int backgroundColor = colors[index];
                findViewById(R.id.background).setBackgroundColor(backgroundColor);

                // 結果の色を変更
                int textColor;
                if (backgroundColor == 0xFFFFFFFF) { // 背景が白の場合は黒
                    textColor = 0xFF000000; // 黒
                } else {
                    textColor = 0xFFFFFFFF; // 背景が明るい色の場合は白
                }
                resultTextView.setTextColor(textColor);

                // ボタンの表示/非表示を切り替え
                drawButton.setVisibility(View.GONE);
                backButton.setVisibility(View.VISIBLE);
                resultTextView.setVisibility(View.VISIBLE); // 結果を表示
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 戻るボタンが押されたときの処理
                resultTextView.setText("おみくじ結果");
                resultTextView.setTextColor(0xFF000000); // テキストの色を黒に戻す
                findViewById(R.id.background).setBackgroundColor(0xFFFFFFFF); // 背景色を白に戻す

                drawButton.setVisibility(View.VISIBLE);
                backButton.setVisibility(View.GONE);
                resultTextView.setVisibility(View.VISIBLE); // 結果を表示
            }
        });
    }
}
