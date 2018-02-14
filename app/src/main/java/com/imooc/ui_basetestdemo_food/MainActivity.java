package com.imooc.ui_basetestdemo_food;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.List;

/*
 * 步驟
 * 1、初始化控制項
 * 2、初始化數據
 * 3、為控制項添加監聽器
 */
public class MainActivity extends Activity {
    private EditText name;
    private RadioGroup sex;
    private CheckBox hot, fish, sour;
    private SeekBar seekBar;
    private Button find;
    private ImageView imageView;
    private ToggleButton toggleButton;
    private List<Food> lists_food;
    private List<Food> lists_get;
    private Person person;
    private RadioGroupListener radioGroupListener;
    private boolean isFish;
    private boolean isHot;
    private boolean isSour;
    private CheckBoxListener checkBoxListener;
    private int price = 30;
    private SeekBarListener seekBarListener;
    private ButtonListener buttonListener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_food);
        // 初始化控制項
        initView();
        // 初始化數據
        initData();
        // 為控制項添加監聽器
        setListener();
    }

    private void setListener() {
        radioGroupListener = new RadioGroupListener();
        sex.setOnCheckedChangeListener(radioGroupListener);
        checkBoxListener = new CheckBoxListener();
        fish.setOnCheckedChangeListener(checkBoxListener);
        hot.setOnCheckedChangeListener(checkBoxListener);
        sour.setOnCheckedChangeListener(checkBoxListener);
        seekBarListener = new SeekBarListener();
        seekBar.setOnSeekBarChangeListener(seekBarListener);
        buttonListener = new ButtonListener();
        find.setOnClickListener(buttonListener);
        toggleButton.setOnClickListener(buttonListener);
    }

    private void initData() {
        person = new Person();
        lists_get = new ArrayList<Food>();
        lists_food = new ArrayList<Food>();
        lists_food.add(new Food("麻辣香鍋", 55, R.drawable.malaxiangguo, true, false, false));

        lists_food.add(new Food("水煮魚", 48, R.drawable.shuizhuyu, true, true, false));
        lists_food.add(new Food("麻辣火鍋", 80, R.drawable.malahuoguo, true, true, false));

        lists_food.add(new Food("清蒸鱸魚", 68, R.drawable.qingzhengluyu, false, true, false));

        lists_food.add(new Food("桂林米粉", 15, R.drawable.guilin, false, false, false));
        lists_food.add(new Food("上湯娃娃菜", 28, R.drawable.wawacai, false, false, false));
        lists_food.add(new Food("紅燒肉", 60, R.drawable.hongshaorou, false, false, false));
        lists_food.add(new Food("木須肉", 40, R.drawable.muxurou, false, false, false));
        lists_food.add(new Food("酸菜牛肉麵", 35, R.drawable.suncainiuroumian, false, false, true));
        lists_food.add(new Food("西芹炒百合", 38, R.drawable.xiqin, false, false, false));

        lists_food.add(new Food("酸辣湯", 40, R.drawable.suanlatang, true, false,
                true));

    }

    private void initView() {
        name = (EditText) findViewById(R.id.et_name);
        sex = (RadioGroup) findViewById(R.id.rg_sex);
        hot = (CheckBox) findViewById(R.id.cb_hot);
        fish = (CheckBox) findViewById(R.id.cb_fish);
        sour = (CheckBox) findViewById(R.id.cb_sour);
        seekBar = (SeekBar) findViewById(R.id.sb_price);
        seekBar.setProgress(30);
        find = (Button) findViewById(R.id.btn_find);
        toggleButton = (ToggleButton) findViewById(R.id.tb_click);
        toggleButton.setChecked(true);
        imageView = (ImageView) findViewById(R.id.iv_pic);
    }

    class RadioGroupListener implements OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            // 當用戶選擇當前RadioGroup組的Button時被觸發
            switch (checkedId) {
                case R.id.rb_man:
                    person.setSex("男");
                    break;
                case R.id.rb_woman:
                    person.setSex("女");
                    break;
            }
            System.out.println("性別：" + person.getSex());
        }

    }

    class CheckBoxListener implements
            android.widget.CompoundButton.OnCheckedChangeListener {

        @Override
        public void onCheckedChanged(CompoundButton buttonView,
                                     boolean isChecked) {
            // 當控制項狀態改變時被觸發
            CheckBox cbBox = (CheckBox) buttonView;
            switch (cbBox.getId()) {
                case R.id.cb_fish:
                    if (isChecked) {
                        isFish = true;
                    } else {
                        isFish = false;
                    }

                    break;
                case R.id.cb_sour:
                    if (isChecked) {
                        isSour = true;
                    } else {
                        isSour = false;
                    }
                    break;
                case R.id.cb_hot:
                    if (isChecked) {
                        isHot = true;
                    } else {
                        isHot = false;
                    }
                    break;

            }
            System.out.println("當前喜好：" + "辣：" + isHot + " 海鮮：" + isFish + " 酸"
                    + isSour);

        }

    }

    class SeekBarListener implements OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress,
                                      boolean fromUser) {
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @SuppressLint("WrongConstant")
        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
            // TODO Auto-generated method stub
            price = seekBar.getProgress();
            Toast.makeText(MainActivity.this, "價格：" + price, Toast.LENGTH_LONG).show();
        }

    }

    class ButtonListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.btn_find:

                    break;
                case R.id.tb_click:

                    break;
            }

        }

        private void checkData() {
            // 找出菜品
            for (int i = 0; i < lists_food.size(); i++) {
                Food food = lists_food.get(i);
                if ((food.getPrice() <= price)
                        && (food.isFish() == isFish && food.isHot() == isHot && food
                        .isSour() == isSour)) {
                    lists_get.add(food);
                }
            }
            System.out.println("*********" + lists_get.size());

        }

    }

}

