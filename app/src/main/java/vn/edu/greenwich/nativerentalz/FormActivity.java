package vn.edu.greenwich.nativerentalz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        Spinner spinPropType = findViewById(R.id.txt_PropType);
        String[] itemsPropType = new String[]{"Select Property Type","Flat", "House", "Bungalow"};
        ArrayAdapter<String> adapterPropType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsPropType);
        spinPropType.setAdapter(adapterPropType);

        Spinner spinBedrooms = findViewById(R.id.txt_Bedroom);
        String[] itemsBedrooms = new String[]{"Select Bedrooms", "Studio", "One", "Two", "etc."};
        ArrayAdapter<String> adapterBedrooms = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsBedrooms);
        spinBedrooms.setAdapter(adapterBedrooms);

        Spinner spinFurType = findViewById(R.id.txt_FurType);
        String[] itemsFurType = new String[]{"Select Furniture Type", "Furnished", "Unfurnished", "Part Furnished"};
        ArrayAdapter<String> adapterFurType = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, itemsFurType);
        spinFurType.setAdapter(adapterFurType);

        TextView txtDate = findViewById(R.id.txt_Date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss");
        String currentDateTime = sdf.format(new Date());
        txtDate.setText(currentDateTime);

        Button btnSubmit = findViewById(R.id.btn_confirm);
        btnSubmit.setOnClickListener(btnSubmit_Click);
    }

    private View.OnClickListener btnSubmit_Click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Boolean isValid = true;

            //Lấy textview ra jvs
            TextView txtPropName = findViewById(R.id.txt_PropName);
            TextView txtPropAdd = findViewById(R.id.txt_PropAddress);
            Spinner spinPropType = (Spinner) findViewById(R.id.txt_PropType);
            Spinner spinBedroom = (Spinner) findViewById(R.id.txt_Bedroom);
            TextView txtDate = findViewById(R.id.txt_Date);
            TextView txtRentPrice = findViewById(R.id.txt_RentPrice);
            Spinner spinFurType = (Spinner) findViewById(R.id.txt_FurType);
            TextView txtReporter = findViewById(R.id.txt_Reporter);
            TextView txtNote = findViewById(R.id.txt_PropNote);
            TextView tvError = findViewById(R.id.tv_error);

            String error = "";

            //Get content of textview
            String PropName = txtPropName.getText().toString();
            String PropAdd = txtPropAdd.getText().toString();
            String PropType = spinPropType.getSelectedItem().toString();
            String Bedroom = spinBedroom.getSelectedItem().toString();
            String Date = txtDate.getText().toString();
            String RentPrice = txtRentPrice.getText().toString();
            String FurType = spinFurType.getSelectedItem().toString();
            String Reporter = txtReporter.getText().toString();
            String Note = txtNote.getText().toString();

            tvError.setText("");

            //Validate form
            if (TextUtils.isEmpty(PropName)) {
                error += "* Name cannot be blank. \n";
                isValid = false;
            }

            if (TextUtils.isEmpty(PropAdd)) {
                error += "* Address cannot be blank. \n";
                isValid = false;
            }

            if (PropType == "Select Property Type") {
                error += "* Property Type cannot be blank. \n";
                isValid = false;
            }

            if (Bedroom == "Select Bedrooms") {
                error += "* Bedrooms cannot be blank. \n";
                isValid = false;
            }

            if (TextUtils.isEmpty(Date)) {
                error += "* Date cannot be blank. \n";
                isValid = false;
            }

            if (TextUtils.isEmpty(RentPrice)) {
                error += "* Monthly Rent Price cannot be blank. \n";
                isValid = false;
            }

            if (TextUtils.isEmpty(Reporter)) {
                error += "* Reporter cannot be blank. \n";
                isValid = false;
            }

            if (isValid){
                Bundle propInfo = new Bundle();
                propInfo.putString("PropName", PropName);
                propInfo.putString("PropAdd", PropAdd);
                propInfo.putString("PropType", PropType);
                propInfo.putString("Bedroom", Bedroom);
                propInfo.putString("Date", Date);
                propInfo.putString("RentPrice", RentPrice);
                propInfo.putString("FurType", FurType);
                propInfo.putString("Reporter", Reporter);
                propInfo.putString("Note", Note);

                Intent confirmActivity = new Intent(v.getContext(), ConfirmActivity.class);
                confirmActivity.putExtras(propInfo);
                startActivity(confirmActivity);
            }
            else{
                tvError.setText((error));
            }
        }
    };
}