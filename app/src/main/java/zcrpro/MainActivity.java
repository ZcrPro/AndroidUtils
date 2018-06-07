package zcrpro;

import android.com.androidutils.R;
import android.com.lib.view.ClickProxy;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_click)
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        btnClick.setOnClickListener(new ClickProxy(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击了", Toast.LENGTH_SHORT).show();
            }
        }, new ClickProxy.IAgain() {
            @Override
            public void onAgain() {
                Toast.makeText(MainActivity.this, "重复点击了", Toast.LENGTH_SHORT).show();
            }
        }, 1000));
    }
}