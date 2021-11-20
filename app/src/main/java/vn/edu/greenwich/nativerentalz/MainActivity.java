package vn.edu.greenwich.nativerentalz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnGoForm = findViewById(R.id.btn_go);
        btnGoForm.setOnClickListener(btnGoForm_Click);
    }

    private View.OnClickListener btnGoForm_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent formActivity = new Intent(v.getContext(), FormActivity.class);
            startActivity(formActivity);
            finish();
        }
    };
}