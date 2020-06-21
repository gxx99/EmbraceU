package cn.edu.upc.gxx.embraceu;

import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import cn.edu.upc.gxx.embraceu.Fragement.ConsultFragment;
import cn.edu.upc.gxx.embraceu.Fragement.MainFragment;
import cn.edu.upc.gxx.embraceu.Fragement.MeditationFragment;
import cn.edu.upc.gxx.embraceu.Fragement.MyinfoFragment;

public class MainActivity extends FragmentActivity implements View.OnClickListener {
    private TextView tv_main_title;//标题

    private TextView tv_back;//返回按钮

    private RelativeLayout title_bar;// android:id="@+id/title_bar"

    //来自activity_main.xml

    private RelativeLayout main_body;

    private TextView bottom_bar_text_main;

    private ImageView bottom_bar_image_main;

    private TextView bottom_bar_text_consult;

    private ImageView bottom_bar_image_consult;
    private TextView bottom_bar_text_meditation;

    private ImageView bottom_bar_image_meditation;

    private TextView bottom_bar_text_myinfo;

    private ImageView bottom_bar_image_myinfo;

    private LinearLayout main_bottom_bar;

    private RelativeLayout bottom_bar_main_btn;

    private RelativeLayout bottom_bar_consult_btn;

    private RelativeLayout bottom_bar_meditation_btn;
    private RelativeLayout bottom_bar_info_btn;

    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

//   看不懂所以先隐掉了     setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        initNavigation();

        initBody();

        initBottomBar();

        setInitStatus();

    }

    private void initNavigation() {
//不知道在哪所以先隐掉了
        tv_back = (TextView) findViewById(R.id.tv_back);

        tv_main_title = (TextView) findViewById(R.id.tv_main_title);

        title_bar = (RelativeLayout) findViewById(R.id.title_bar);

        title_bar.setBackgroundColor(Color.parseColor("#30B4FF"));

    }



    private void initBody() {

        main_body = (RelativeLayout) findViewById(R.id.main_body);

    }



    private void initBottomBar() {

        bottom_bar_text_main = (TextView) findViewById(R.id.bottom_bar_text_main);

        bottom_bar_image_main = (ImageView) findViewById(R.id.bottom_bar_image_main);

        bottom_bar_main_btn = (RelativeLayout) findViewById(R.id.bottom_bar_main_btn);

        bottom_bar_text_consult = (TextView) findViewById(R.id.bottom_bar_text_consult);

        bottom_bar_image_consult = (ImageView) findViewById(R.id.bottom_bar_image_consult);

        bottom_bar_consult_btn = (RelativeLayout) findViewById(R.id.bottom_bar_consult_btn);

        bottom_bar_text_meditation = (TextView) findViewById(R.id.bottom_bar_text_meditation);

        bottom_bar_image_meditation = (ImageView) findViewById(R.id.bottom_bar_image_meditation);

        bottom_bar_meditation_btn = (RelativeLayout) findViewById(R.id.bottom_bar_meditation_btn);

        bottom_bar_text_myinfo = (TextView) findViewById(R.id.bottom_bar_text_info);

        bottom_bar_image_myinfo = (ImageView) findViewById(R.id.bottom_bar_image_info);

        bottom_bar_info_btn = (RelativeLayout) findViewById(R.id.bottom_bar_info_btn);

        main_bottom_bar = (LinearLayout) findViewById(R.id.main_bottom_bar);

        setListener();

    }

    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.bottom_bar_main_btn:

                clearBottomImageState();

                /**  replacing instead of adding **/

                getSupportFragmentManager().beginTransaction().replace(R.id.main_body, new MainFragment()).commit();

                setSelectedStatus(0);

                break;

            case R.id.bottom_bar_consult_btn:

                clearBottomImageState();

                setSelectedStatus(1);

                getSupportFragmentManager().beginTransaction().replace(R.id.main_body, new ConsultFragment()).commit();

                break;

            case R.id.bottom_bar_meditation_btn:

                clearBottomImageState();

                setSelectedStatus(2);

                getSupportFragmentManager().beginTransaction().replace(R.id.main_body, new MeditationFragment()).commit();

                break;
            case R.id.bottom_bar_info_btn:

                clearBottomImageState();

                setSelectedStatus(3);

                getSupportFragmentManager().beginTransaction().replace(R.id.main_body, new MyinfoFragment()).commit();

                break;

        }

    }
    private void setListener() {

        for (int i = 0; i < main_bottom_bar.getChildCount(); i++) {

            main_bottom_bar.getChildAt(i).setOnClickListener((View.OnClickListener) this);

        }

    }

    private void setInitStatus() {

        clearBottomImageState();

        setSelectedStatus(0);

        getSupportFragmentManager().beginTransaction().add(R.id.main_body, new MainFragment()).commit();

    }

    private void setSelectedStatus(int index) {

        switch (index) {

            case 0:

                //mCourseBtn.setSelected(true);

                bottom_bar_image_main.setImageResource(R.drawable.i1);

                bottom_bar_text_main.setTextColor(Color.parseColor("#0097f7"));

                tv_main_title.setText("主页");

                break;

            case 1:

                //mExercisesBtn.setSelected(true);

                bottom_bar_image_consult.setImageResource(R.drawable.i2);

                bottom_bar_text_consult.setTextColor(Color.parseColor("#0097f7"));

                tv_main_title.setText("心理咨询");

                break;

            case 2:

                //mMyInfoBtn.setSelected(true);

                bottom_bar_image_meditation.setImageResource(R.drawable.i3);

                bottom_bar_text_meditation.setTextColor(Color.parseColor("#0097f7"));

                title_bar.setVisibility(View.VISIBLE);

                tv_main_title.setText("冥想星球");

                break;
            case 3:

                //mMyInfoBtn.setSelected(true);

                bottom_bar_image_myinfo.setImageResource(R.drawable.i4);

                bottom_bar_text_myinfo.setTextColor(Color.parseColor("#0097f7"));

                title_bar.setVisibility(View.VISIBLE);

                tv_main_title.setText("个人中心");

                break;

        }

    }



    private void clearBottomImageState() {

        bottom_bar_text_main.setTextColor(Color.parseColor("#666666"));

        bottom_bar_text_consult.setTextColor(Color.parseColor("#666666"));

        bottom_bar_text_meditation.setTextColor(Color.parseColor("#666666"));
        bottom_bar_text_myinfo.setTextColor(Color.parseColor("#666666"));



        bottom_bar_image_main.setImageResource(R.drawable.i1);

        bottom_bar_image_consult.setImageResource(R.drawable.i2);

        bottom_bar_image_meditation.setImageResource(R.drawable.i3);
        bottom_bar_image_myinfo.setImageResource(R.drawable.i4);
    }

}
