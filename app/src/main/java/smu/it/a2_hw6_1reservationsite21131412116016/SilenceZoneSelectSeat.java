package smu.it.a2_hw6_1reservationsite21131412116016;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class SilenceZoneSelectSeat extends AppCompatActivity {
    ImageButton btn_back, btn_home; // 버튼 객체 선언
    GridView gridView; // 객체 선언

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.silence_zone_select_seat);

        // 객체 생성
        btn_back= findViewById(R.id.backButton);
        btn_home = findViewById(R.id.homeButton);
        // 그리드 어댑터 세팅: 어댑터를 그리드뷰에 전달
        gridView = findViewById(R.id.gridSilenceZoneSeat);
        SilenceSeatAdapter silenceSeatAdapter = new SilenceSeatAdapter(this);
        gridView.setAdapter(silenceSeatAdapter);

        // 뒤로 가기 버튼
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SilenceZoneSelectSeat.this, ReservationPage.class);
                startActivity(intent);
            }
        });
        // 홈으로 돌아가기 버튼
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SilenceZoneSelectSeat.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
