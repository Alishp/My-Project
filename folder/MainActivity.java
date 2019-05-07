package com.example.alireza_72_shp.faradars;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

	TextView tv;
	Button b;
	EditText mEditText;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(com.example.alireza_72_shp.faradars.R.layout.activity_main);

		tv=findViewById(com.example.alireza_72_shp.faradars.R.id.tv);
		//tv.setText(new Date().toString());// تولید تاریخ و زمان
		tv.setTextColor(Color.rgb(10,20,30));
		tv.setVisibility(View.VISIBLE);

		b=findViewById(com.example.alireza_72_shp.faradars.R.id.btn);
		//b.setOnClickListener(this);              ****
		b.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				randomTextColor();
				String s = mEditText.getText().toString().trim();//****    برای جلوگیری از زدن space به جای نوشتن متن(trim)
				tv.setText(s);//tv.setText(mEditText.getText().toString().trim())

			}
		});
		mEditText.addTextChangedListener(new TextWatcher() {
			@Override
			public void beforeTextChanged(CharSequence s, int start, int count, int after) {
				tv.setText(s);
			}

			@Override
			public void onTextChanged(CharSequence s, int start, int before, int count) {

			}

			@Override
			public void afterTextChanged(Editable s) {

			}
		});

		b.setOnLongClickListener(new View.OnLongClickListener() {
			@Override
			public boolean onLongClick(View v) {
				//b.setText("Long Click");
				Intent i=new Intent(MainActivity.this,SecondActivity.class);
				startActivity(i);
				return true;
			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
		//tv.setText(new Date().toString());
	}

	public void randomTextColor(){
		Random r=new Random();
		tv.setTextColor(Color.rgb(r.nextInt(256),r.nextInt(256),200+ r.nextInt(56)));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		//getMenuInflater().inflate(R.menu.menu_main,menu);
		menu.add("myItem1");
		menu.add("myItem2");
		SubMenu subMenu=menu.addSubMenu("myItem3");
		subMenu.add("mySubmenu1");

		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (item.getItemId() == com.example.alireza_72_shp.faradars.R.id.I3){
			Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
		}

		return super.onOptionsItemSelected(item);
	}
	//    public void buttonOnClick(View v){               ****         روش دوم برای ساختن Event (OnClick)
//        if (v.getId()==R.id.btn){
//            Random r=new Random();
//            tv.setTextColor(Color.rgb(r.nextInt(256),r.nextInt(256),200+ r.nextInt(56));
//        }

}
