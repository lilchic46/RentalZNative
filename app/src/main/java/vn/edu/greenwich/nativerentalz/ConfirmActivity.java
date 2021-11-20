package vn.edu.greenwich.nativerentalz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        TextView tvPropName = findViewById(R.id.tv_PropName);
        TextView tvPropAdd = findViewById(R.id.tv_PropAdd);
        TextView tvPropType = findViewById(R.id.tv_PropType);
        TextView tvBedroom = findViewById(R.id.tv_Bedroom);
        TextView tvDate = findViewById(R.id.tv_Date);
        TextView tvRentPrice = findViewById(R.id.tv_RentPrice);
        TextView tvFurType = findViewById(R.id.tv_FurType);
        TextView tvReporter = findViewById(R.id.tv_Reporter);
        TextView tvNote = findViewById(R.id.tv_Note);

        String PropName = "";
        String PropAdd = "";
        String PropType = "";
        String Bedroom = "";
        String Date = "";
        String RentPrice = "";
        String FurType = "";
        String Reporter = "";
        String Note = "";

        //Get bundle
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();

        if (bundle != null){
            PropName = bundle.getString("PropName");
            PropAdd = bundle.getString("PropAdd");
            PropType = bundle.getString("PropType");
            Bedroom = bundle.getString("Bedroom");
            Date = bundle.getString("Date");
            RentPrice = bundle.getString("RentPrice");
            FurType = bundle.getString("FurType");
            Reporter = bundle.getString("Reporter");
            Note = bundle.getString("Note");
        }

        tvPropName.setText(PropName);
        tvPropAdd.setText(PropAdd);
        tvPropType.setText(PropType);
        tvBedroom.setText(Bedroom);
        tvDate.setText(Date);
        tvRentPrice.setText(RentPrice);
        tvFurType.setText(FurType);
        tvReporter.setText(Reporter);
        tvNote.setText(Note);

        Button btnConfirm = findViewById(R.id.btn_confirm);

        btnConfirm.setOnClickListener(btnConfirm_Click);
    }

    private View.OnClickListener btnConfirm_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(v.getContext(), "Submit successfully", Toast.LENGTH_LONG).show();

            Log.i("Form Submit", "This is a Success Form Submit.");

        }
    };

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}