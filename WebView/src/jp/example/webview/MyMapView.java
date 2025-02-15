package jp.example.webview;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MyMapView extends ActionBarActivity {
	
	// GoogleMapオブジェクトの宣言
    private GoogleMap googleMap;
    
    @SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_my_map_view);
		
		// MapFragmentオブジェクトを取得
        MapFragment mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.map);
        try {
            // GoogleMapオブジェクトの取得
            googleMap = mapFragment.getMap();

            // Activityが初回で生成されたとき
            if (savedInstanceState == null) {

                // MapFragmentのオブジェクトをセット
                mapFragment.setRetainInstance(true);

                // 地図の初期設定を行うメソッドの呼び出し
                mapInit();
            }
        }
        // GoogleMapが使用不可のときのためにtry catchで囲っています。
        catch (Exception e) {
        }
	}
    
 // 地図の初期設定メソッド
    private void mapInit() {

        // 地図タイプ設定
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        // 現在位置ボタンの表示を行なう
        googleMap.setMyLocationEnabled(true);

        // 中野駅の位置、ズーム設定
        CameraPosition camerapos = new CameraPosition.Builder()
                .target(new LatLng(35.705833, 139.665556)).zoom(15.5f).build();

        // 地図の中心の変更する
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(camerapos));
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.my_map_view, menu);
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
