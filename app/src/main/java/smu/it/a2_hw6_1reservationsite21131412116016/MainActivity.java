package smu.it.a2_hw6_1reservationsite21131412116016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageButton btn1, btn2, btn3; // 객체 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 객체 생성
        btn1 = findViewById(R.id.reservationButton);
        btn2 = findViewById(R.id.floorInfoButton);
        btn3 = findViewById(R.id.introduceBookButton);

        // 각 버튼마다 해당 페이지로 이동하는 이벤트 리스너 함수 작성
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, ReservationPage.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FloorInfo.class);
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, IntroduceMonthBook.class);
                startActivity(intent);
            }
        });
    }
}