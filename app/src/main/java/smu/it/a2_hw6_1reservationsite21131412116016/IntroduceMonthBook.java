package smu.it.a2_hw6_1reservationsite21131412116016;

import static smu.it.a2_hw6_1reservationsite21131412116016.BookGalleryAdapter.toastText;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IntroduceMonthBook extends AppCompatActivity {
    // 객체 선언
    ImageButton btn_back, btn_home;
    Gallery gallery;
    static ImageView imageViewBook; // static: 바꿀 수 없음

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.introduce_month_book);

        // 객체 생성
        btn_back= findViewById(R.id.backButton);
        btn_home = findViewById(R.id.homeButton);
        gallery = findViewById(R.id.galleryBook);
        imageViewBook = findViewById(R.id.showBook);

        // 갤러리에 들어갈 내용
        BookGalleryAdapter galleryAdapter = new BookGalleryAdapter(this);
        gallery.setAdapter(galleryAdapter);

        // 뒤로 가기 버튼
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroduceMonthBook.this, MainActivity.class);
                startActivity(intent);
            }
        });
        // 홈으로 돌아가기 버튼
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IntroduceMonthBook.this, MainActivity.class);
                startActivity(intent);
            }
        });

        // 책의 이미지뷰 클릭시 인터넷에 있는 책 정보로 연결(인텐트 사용)
        imageViewBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //
                Intent intent = null; // intent 선언
                if (toastText.getText() == "나의 문화유산답사기9:서울편1") {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://search.shopping.naver.com/book/catalog/32445567453?cat_id=50006022&frm=PBOKPRO&query=%EB%82%98%EC%9D%98+%EB%AC%B8%ED%99%94%EC%9C%A0%EC%82%B0%EB%8B%B5%EC%82%AC%EA%B8%B09&NaPm=ct%3Dlb23j7fc%7Cci%3Dbc08ddb6405ace7302c554f8564a0af2b5007998%7Ctr%3Dboknx%7Csn%3D95694%7Chk%3Dc87c3ea9a495d993a28ec724c46342e12507c163"));
                }
                else if (toastText.getText() == "타이탄의 도구들") {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://search.shopping.naver.com/book/catalog/32487660720?cat_id=50005622&frm=PBOKPRO&query=%ED%83%80%EC%9D%B4%ED%83%84%EC%9D%98+%EB%8F%84%EA%B5%AC%EB%93%A4&NaPm=ct%3Dlb23pc3s%7Cci%3D795cec597044b63af24fa439037f62123bf29f52%7Ctr%3Dboknx%7Csn%3D95694%7Chk%3D31511f5ab94672ad8f06b323bb8fbc20d42560dc"));
                }
                else if (toastText.getText() == "우리가 빛의 속도로 갈 수 없다면") {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://search.shopping.naver.com/book/catalog/32436342677?cat_id=50005764&frm=PBOKMOD&section=info&query=%EC%9A%B0%EB%A6%AC%EA%B0%80+%EB%B9%9B%EC%9D%98+%EC%86%8D%EB%8F%84%EB%A1%9C+%EA%B0%88+%EC%88%98+%EC%97%86%EB%8B%A4%EB%A9%B4&NaPm=ct%3Dlb23sbcw%7Cci%3D5c2c8c1694cb5c219ecdd2ea74be1807faf0b2a3%7Ctr%3Dboknx%7Csn%3D95694%7Chk%3Da8d6cd9ed77cc6376f97c165095107e5ec5e806a"));
                }
                else if (toastText.getText() == "살아온 기적 살아갈 기적") {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://search.shopping.naver.com/book/catalog/32455930029?cat_id=50011380&frm=PBOKPRO&query=%EC%82%B4%EC%95%84%EC%98%A8+%EA%B8%B0%EC%A0%81+%EC%82%B4%EC%95%84%EA%B0%88+%EA%B8%B0%EC%A0%81&NaPm=ct%3Dlb23sw6w%7Cci%3D73e49ce93a44145ac41ec089dc0d91a9116ccd24%7Ctr%3Dboknx%7Csn%3D95694%7Chk%3Dc9576c6bc97b6d36f83751940315055d664143c1"));
                }
                else if (toastText.getText() == "생명과학, 신에게 도전하다") {
                    intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://search.shopping.naver.com/book/catalog/32464068158?cat_id=50005674&frm=PBOKPRO&query=%EC%83%9D%EB%AA%85%EA%B3%BC%ED%95%99+%EC%8B%A0%EC%97%90%EA%B2%8C+%EB%8F%84%EC%A0%84&NaPm=ct%3Dlb23t7rk%7Cci%3Dccaf1e4333511b115b615be17cba757386bf53d6%7Ctr%3Dboknx%7Csn%3D95694%7Chk%3De576ede508b2a1708fb4a98fbbc959d3740a9b7d"));
                }
                // try-catch문으로 실행과 실행이 되지 않을 때의 예외 발생을 잡음
                try {
                    startActivity(intent);
                } catch (ActivityNotFoundException e) {
                    // Toast -> 안내 메세지를 띄워줌.
                    Toast.makeText(IntroduceMonthBook.this,
                            "지정한 동작을 실행할 App이 설치되어 있지 않습니다.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}