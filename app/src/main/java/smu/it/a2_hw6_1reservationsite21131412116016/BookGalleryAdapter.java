package smu.it.a2_hw6_1reservationsite21131412116016;

import static smu.it.a2_hw6_1reservationsite21131412116016.IntroduceMonthBook.imageViewBook;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class BookGalleryAdapter extends BaseAdapter {
    Context context;
    ImageView imageView;
    static TextView toastText; // IntroduceMonthBook에서 사용하기 위해 static으로 선언

    Integer[] bookID = {R.drawable.book1, R.drawable.book2, R.drawable.book3,
            R.drawable.book4, R.drawable.book5};
    String[] bookTitle = {"나의 문화유산답사기9:서울편1", "타이탄의 도구들", "우리가 빛의 속도로 갈 수 없다면",
            "살아온 기적 살아갈 기적", "생명과학, 신에게 도전하다"};

    public BookGalleryAdapter(Context c) {
        context = c;
    } // context로 MainActivity의 this를 잡아줌
    @Override
    public int getCount() {
        return bookID.length;
    }
    @Override
    public Object getItem(int i) {
        return null;
    }
    @Override
    public long getItemId(int i) {
        return 0;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        imageView = new ImageView(context);
        imageView.setLayoutParams(new Gallery.LayoutParams(300, 400));
        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        imageView.setPadding(5, 5, 5, 5);
        imageView.setImageResource(bookID[position]); // 갤러리뷰에 이미지 넣기

        final int selectedPosition = position;

        imageView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                imageViewBook.setScaleType(ImageView.ScaleType.FIT_CENTER);
                imageViewBook.setImageResource(bookID[selectedPosition]); // 이미지뷰에 선택한 도서 크게 띄우기
                // 토스트로 선택된 책 이름 띄우기
                Toast toast = new Toast(context.getApplicationContext());
                View toastView = (View) View.inflate(context.getApplicationContext(), R.layout.toast_book_title,null);
                toastText = (TextView) toastView.findViewById(R.id.textViewToast);
                toastText.setText(bookTitle[selectedPosition]);
                toast.setView(toastView);
                toast.show();
                return false;
            }
        });
        return imageView;
    }
}

