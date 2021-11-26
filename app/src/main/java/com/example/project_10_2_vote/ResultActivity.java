package com.example.project_10_2_vote;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class ResultActivity extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        setTitle("투표 결과");

        Intent intent = getIntent();
        int[] voteResult = intent.getIntArrayExtra("VoteCount");
        String[] imageName = intent.getStringArrayExtra("ImageName");

        TextView tv[] = new TextView[imageName.length];
        RatingBar rbar[] = new RatingBar[imageName.length];
        Image im[] = new Image[imageName.length];

        Integer tvID[] = { R.id.tv1, R.id.tv2, R.id.tv3, R.id.tv4, R.id.tv5,
                R.id.tv6, R.id.tv7, R.id.tv8, R.id.tv9, };
        Integer rbarID[] = { R.id.rb1, R.id.rb2, R.id.rb3, R.id.rb4, R.id.rb5,
                R.id.rb6, R.id.rb7, R.id.rb8, R.id.rb9, };
        Integer imageFileID[] = { R.drawable.iv1, R.drawable.iv2, R.drawable.iv3,
                R.drawable.iv4, R.drawable.iv5, R.drawable.iv6, R.drawable.iv7,
                R.drawable.iv8, R.drawable.iv9, };

        for (int i=0; i<voteResult.length; i++) {
            tv[i] = (TextView) findViewById(tvID[i]);
            rbar[i] = (RatingBar) findViewById(rbarID[i]);
        }

        for (int i=0; i<voteResult.length; i++) {
            tv[i].setText(imageName[i]);
            rbar[i].setRating((float) voteResult[i]);
        }

        Button bt2 = (Button) findViewById(R.id.bt2);
        bt2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                finish();
            }
        });

    }
}
