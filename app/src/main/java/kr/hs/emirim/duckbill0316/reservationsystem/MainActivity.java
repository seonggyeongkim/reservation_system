package kr.hs.emirim.duckbill0316.reservationsystem;

import android.graphics.Color;
import android.os.SystemClock;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.Chronometer;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.content.*;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Chronometer chrono;
    Button butStart, butDone;
    RadioButton radioDate, radioTime;
    CalendarView calView;
    TimePicker timePick;
    TextView textResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chrono=(Chronometer)findViewById(R.id.chrono);
        butStart=(Button)findViewById(R.id.but_start);
        butDone=(Button)findViewById(R.id.but_done);
        radioDate=(RadioButton)findViewById(R.id.radio_date);
        radioTime=(RadioButton)findViewById(R.id.radio_time);
        calView=(CalendarView)findViewById(R.id.calendar);
        timePick=(TimePicker)findViewById(R.id.time_pick);
        textResult=(TextView)findViewById(R.id.text_result);
        timePick.setVisibility(View.INVISIBLE);//안보이게 설정
        calView.setVisibility(View.INVISIBLE);

        //익명 클래스 (이름 없이 클래스를 구현 + 객체 생성) => event handler (EventLinstener (인터페이스): 감시자 / ex)Onclick)
        //감시자(EventListener) 상속 받아서, 클래스 생성!

        radioDate.setOnClickListener(new View.OnClickListener() { //인터페이스
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.VISIBLE); //보이게
                timePick.setVisibility(View.INVISIBLE); //안보이게
            }//추상 메소드
        }); //감시자 연결

        radioTime.setOnClickListener(new View.OnClickListener() { //인터페이스
            @Override
            public void onClick(View v) {
                calView.setVisibility(View.INVISIBLE); //안보이게
                timePick.setVisibility(View.VISIBLE); //보이게
            }//추상 메소드
        }); //감시자 연결

        butStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chrono.setBase(SystemClock.elapsedRealtime()); //시스템의 시간을 사용할 꺼다! (어떤 시간을 설정할 것인지)
                //현재 운영체제에서 사용되는 시간 설정
                chrono.start();//크로노 시작!
                chrono.setTextColor(Color.RED);//크로노미터의 글자색!
            }
        });

        butDone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                chrono.stop();//크로노 중지!
                chrono.setTextColor(Color.BLUE);//크로노미터의 글자색!
                Calendar cal=Calendar.getInstance(); //추상클래스 -> 반환 메소드 .getInstance()
                cal.setTimeInMillis(calView.getDate());
                int year=cal.get(Calendar.YEAR); //캘린더 뷰의 연도 반환 받음!
                int month=cal.get(Calendar.MONTH)+1; //캘린더 뷰의 달에 반환 (MONTH는 0부터!)
                int date=cal.get(Calendar.DATE);//일 반환!

               // int hour=timePick.getHour(); //타임 픽커에 시간 반환!
               // int min=timePick.getMinute(); // 타임 픽커에 분 반환!

                String dateAndTime=year+"년 "+month+"월 "+date+"일 "; /*+hour+"시 "+min+"분 */
                textResult.setText(dateAndTime); //최종 출력

            }
        });





    }
}
