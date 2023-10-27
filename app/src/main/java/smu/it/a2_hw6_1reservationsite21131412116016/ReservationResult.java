package smu.it.a2_hw6_1reservationsite21131412116016;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ReservationResult extends AppCompatActivity {
    // 객체 선언
    TextView tv_result;
    Button ok;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reservation_result);

        // 객체 생성
        tv_result = findViewById(R.id.textViewShowResult);
        ok = findViewById(R.id.okButton);

        Bundle extras = getIntent().getExtras();
        tv_result.setText("1층 열람실: " + extras.getString("zone name")+
                "\n좌석번호: "+extras.getString("seat number")+"번");

        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // 다이얼로그 창 생성
                android.app.AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(ReservationResult.this);
                dialogBuilder.setMessage("* 반드시 10분내로 입실해주세요 *\n10분내로 입실하지 않으실 경우 예약은 자동 취소됩니다.");
                dialogBuilder.setPositiveButton("확인",
                        new DialogInterface.OnClickListener() { // 확인 버튼 누르면 이벤트 발생
                            public void onClick (DialogInterface dialog, int which){
                                // 인텐트 생성 후, 해당 액티비티로 이동
                                Intent intent = new Intent(ReservationResult.this, MainActivity.class);
                                startActivity(intent);
                            }
                        });
                dialogBuilder.show();
            }
        });
    }
}