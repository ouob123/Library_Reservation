package smu.it.a2_hw6_1reservationsite21131412116016;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ReservationPage extends AppCompatActivity {
    ImageButton btn_back, btn_home, btn3, btn4; // 객체 선언
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_page);

        // 객체 생성
        btn_back= findViewById(R.id.backButton);
        btn_home = findViewById(R.id.homeButton);
        btn3 = findViewById(R.id.noiseZoneButton);
        btn4 = findViewById(R.id.silenceZoneButton);

        // 뒤로 가기 버튼
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReservationPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // 홈으로 돌아가기 버튼
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReservationPage.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // 소음존 예약하기 버튼
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReservationPage.this, NoiseZoneSelectSeat.class);
                startActivity(intent);
            }
        });
        // 정숙존 예약하기 버튼
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ReservationPage.this, SilenceZoneSelectSeat.class);
                startActivity(intent);
            }
        });
    }
}
