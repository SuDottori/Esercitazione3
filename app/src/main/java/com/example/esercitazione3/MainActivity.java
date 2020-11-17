package com.example.esercitazione3;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;

import java.util.Arrays;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        int min = 4;
        int max = 16;
        int gen = ((max - min) + 1);
        Random rand = new Random();
        int nxt = rand.nextInt(gen) + min;
        while (nxt % 2 != 0) {
            rand = new Random();
            nxt = rand.nextInt(gen) + min;
        }
        System.out.println
                ("The Randomly generated integer is : " + nxt);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        PieChartView pieChart = this.findViewById(R.id.piechart);

        Float[] percent = new Float[nxt];
        float total = 50.0f;
        int minf = 1;
        //int genf = ((total - minf) + 1);

        for (int i = 0; i < (nxt / 2); i++) {
            Random randf = new Random();
            float nxtf;

            if(i == nxt/2 -1){
                percent[i]= total;
                percent[((nxt) - i)-1] =  total;
            }
            else{
               nxtf = minf + randf.nextFloat() * (total - minf);
                percent[i]=nxtf;
                percent[((nxt) - i)-1] = nxtf;
                        total -= nxtf;
            }
        }
        Integer[] colors = new Integer[nxt];
        for (int i = 0; i < (nxt / 2); i++) {
            int R = (int)(Math.random()*256);
            int G = (int)(Math.random()*256);
            int B= (int)(Math.random()*256);
            Color color = new Color();
            colors[i]= color.rgb(R,G,B);;
            colors[((nxt)-i)-1]= color.rgb(R,G,B);;


            pieChart.setPercent(Arrays.asList(percent));
            pieChart.setSegmentColor(Arrays.asList(colors));

            pieChart.setRadius(300);
            pieChart.setStrokeColor(Color.BLACK);
            pieChart.setStrokeWidth(4);
        }


    }
}