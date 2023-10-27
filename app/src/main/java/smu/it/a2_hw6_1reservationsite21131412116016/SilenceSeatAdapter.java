package smu.it.a2_hw6_1reservationsite21131412116016;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

// 뷰와 데이터를 연결해주는 다리역할을 하는 것이 Adapter
// 데이터의 원본을 받아 관리하고 어댑터뷰가 출력할 수 있는 형태로 data를 제공하는 중간 객체 역할
public class SilenceSeatAdapter extends BaseAdapter {
    Context context;
    // 좌석 이미지 배열
    Integer[] seatID = {R.drawable.seat1, R.drawable.seat2, R.drawable.seat3,
            R.drawable.seat4, R.drawable.seat5, R.drawable.seat6,R.drawable.seat7,
            R.drawable.seat8,R.drawable.seat9,R.drawable.seat10,R.drawable.seat11,
            R.drawable.seat12,R.drawable.seat13,R.drawable.seat14,R.drawable.seat15,
            R.drawable.seat16,R.drawable.seat17,R.drawable.seat18,R.drawable.seat19,
            R.drawable.seat20, R.drawable.seat21, R.drawable.seat22,R.drawable.seat23,
            R.drawable.seat24,R.drawable.seat25,R.drawable.seat26,R.drawable.seat27,
            R.drawable.seat28,R.drawable.seat29,R.drawable.seat30, R.drawable.seat31,
            R.drawable.seat32,R.drawable.seat33,R.drawable.seat34,R.drawable.seat35,
            R.drawable.seat36,R.drawable.seat37,R.drawable.seat38,R.drawable.seat39,
            R.drawable.seat40, R.drawable.seat41, R.drawable.seat42,R.drawable.seat43,
            R.drawable.seat44,R.drawable.seat45,R.drawable.seat46,R.drawable.seat47,
            R.drawable.seat48,R.drawable.seat49,R.drawable.seat50};

    // 좌석 번호 배열 - 예약 시에 넘겨줄 정보
    Integer[] seatNUM = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,
            26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50};

    public SilenceSeatAdapter(Context c) {context = c;}
    @Override
    public int getCount() {return seatNUM.length;}
    @Override
    public Object getItem(int position) {return null;}
    @Override
    public long getItemId(int position) {return 0;}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(110, 100)); // 이미지 뷰의 가로,세로 크기
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER); // 이미지 가운데 설정
        imageView.setPadding(0,0,0,0); // 여백 설정
        imageView.setImageResource(seatID[position]); // 보여줄 이미지 파일

        int selectedPosition = position;
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                dialogBuilder.setTitle("--- 정숙존 좌석 예약 ---"); // 다이얼로그 제목
                dialogBuilder.setMessage(seatNUM[selectedPosition]+"번 좌석을 예약하시겠습니까?"); // 내용
                dialogBuilder.setNegativeButton("취소",null);
                dialogBuilder.setPositiveButton("확인", // 확인 버튼을 눌렀을 때 이벤트 발생
                        new DialogInterface.OnClickListener() {
                            public void onClick (DialogInterface dialog, int which){

                                String seat_num, silence_zone;
                                seat_num = seatNUM[selectedPosition].toString(); // 선택한 좌석의 번호를 문자로 형변환
                                silence_zone = "정숙존";
                                // 인텐트로 데이터 전달
                                Intent intent = new Intent(context, ReservationResult.class);
                                Bundle extras = new Bundle();
                                extras.putString("zone name", silence_zone);
                                extras.putString("seat number", seat_num);
                                intent.putExtras(extras);

                                context.startActivity(intent); // 확인 버튼 누르면 예약결과 액티비티로 이동
                            }
                        });
                dialogBuilder.show();
            }
        });
        return imageView;
    }
}

