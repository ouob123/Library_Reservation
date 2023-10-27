package smu.it.a2_hw6_1reservationsite21131412116016;

import android.app.AlertDialog;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

public class FloorGridAdapter extends BaseAdapter {
    // 객체 선언
    Context context;
    Integer[] floorID = {R.drawable.floor_info1, R.drawable.floor_info2,
            R.drawable.floor_info3, R.drawable.floor_info4};
    Integer[] infoID = {R.drawable.info1, R.drawable.info2,
            R.drawable.info3, R.drawable.info4};
    Integer[] floorInfo = {R.string.floor1, R.string.floor2,
            R.string.floor3, R.string.floor4};
    Integer[] icon = {R.drawable.icon, R.drawable.icon,
            R.drawable.icon, R.drawable.icon};

    public FloorGridAdapter(Context c) {context = c;}
    public int getCount() {return floorID.length;}

    public Object getItem(int position) {return null;}

    public long getItemId(int position) {return 0;}

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView = new ImageView(context);
        imageView.setLayoutParams(new GridView.LayoutParams(500,500));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5,5,5,5);
        imageView.setImageResource(floorID[position]);

        int selectedPosition = position;
        // 각 층을 선택하면 층별 안내가 나타나는 이벤트
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View dialogView = (View) View.inflate(
                        context, R.layout.floor_dialog, null);
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(context);
                ImageView imageViewPoster = (ImageView) dialogView.findViewById(R.id.imageViewForFloor);
                imageViewPoster.setImageResource(infoID[selectedPosition]);

                // 다이얼로그의 제목을 string 값으로 불러옴
                dialogBuilder.setTitle(floorInfo[selectedPosition]);
                // 다이얼로그의 아이콘을 이미지로 설정
                dialogBuilder.setIcon(icon[selectedPosition]);
                dialogBuilder.setView(dialogView);
                dialogBuilder.setNegativeButton("닫기", null);
                dialogBuilder.show();
            }
        });
        return imageView;
    }
}

