package kr.hs.emirim.duckbill0316.reservationsystem;

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



    }
}
