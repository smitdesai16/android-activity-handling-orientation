package me.creatorguy.androidactivityhandlingorientation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private final String BTN_MAIN_TEXT = "btnMainText";
    private final String TV_MAIN_TEXT = "tvMainText";

    private static Button btnMain;
    private static TextView tvMain;
    private static CheckBox cbMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnMain = findViewById(R.id.btnMain);
        tvMain = findViewById(R.id.tvMain);
        cbMain = findViewById(R.id.cbMain);

        btnMain.setOnClickListener(this);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        if(savedInstanceState != null) {
            btnMain.setText(savedInstanceState.getString(BTN_MAIN_TEXT));
            tvMain.setText(savedInstanceState.getString(TV_MAIN_TEXT));
        }
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putString(BTN_MAIN_TEXT, btnMain.getText().toString());
        outState.putString(TV_MAIN_TEXT, tvMain.getText().toString());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnMain:
                btnMain.setText("Updated");
                tvMain.setText("Updated");
                cbMain.setChecked(true);
                break;

            default:
                break;
        }
    }
}