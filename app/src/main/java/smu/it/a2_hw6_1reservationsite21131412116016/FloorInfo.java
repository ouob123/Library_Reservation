package smu.it.a2_hw6_1reservationsite21131412116016;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;

public class FloorInfo extends AppCompatActivity {
    // 객체 선언
    GridView gridView;
    ImageView imgAd;
    ImageButton btn_back, btn_home;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floor_info);

        // 객체 생성
        btn_back= findViewById(R.id.backButton);
        btn_home = findViewById(R.id.homeButton);
        gridView = findViewById(R.id.gridViewFloorInfo);
        imgAd = findViewById(R.id.imageViewAdvertisement);

        // Adapter 안에 데이터 담기
        FloorGridAdapter floorGridAdapter = new FloorGridAdapter(this);

        //리스트뷰에 Adapter 설정
        gridView.setAdapter(floorGridAdapter);

        // 뒤로 가기 버튼
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FloorInfo.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // 홈으로 돌아가기 버튼
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FloorInfo.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // 광고 이미지뷰 클릭 시 발생하는 이벤트
        imgAd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 인텐트 생성해서 웹으로 연결
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://lib.sookmyung.ac.kr/bbs/content/1_33152"));
                startActivity(intent);
            }
        });
    }
}

