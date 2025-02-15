package jp.example.camera;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;

public class MainActivity extends ActionBarActivity {
	
	private String ad0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		setTitle("写真撮影＆写メール送信");
		
		SharedPreferences prefs = getSharedPreferences("myprefs", Context.MODE_PRIVATE);
        ad0 = prefs.getString("mailadress0", "メールアドレスが設定されてません。初期設定を行ってください。");
        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText(ad0);
		
        // ボタンのオブジェクトを取得
        Button btn4 = (Button) findViewById(R.id.button4);
        Button btn2 = (Button)findViewById(R.id.button2);
        Button btn3 = (Button)findViewById(R.id.button0);

        // クリックイベントを受け取れるようにする
        btn2.setOnClickListener(new OnClickListener() {
            // このメソッドがクリック毎に呼び出される
            public void onClick(View v) {
                // ここにクリックされたときの処理を記述
            	//画面移動
            	Intent intent = new Intent(MainActivity.this,
            			SelectImageActivity.class );
                    startActivity(intent);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                    Camera2Activity.class );
                startActivity(intent);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,
                    Acount.class );
                startActivity(intent);
            }
        });

	}
	
	


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
