package com.example.tax_module;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Toast;
import com.razorpay.Checkout;
import com.razorpay.PaymentData;
import com.razorpay.PaymentResultWithDataListener;
import com.razorpay.ExternalWalletListener;
import org.json.JSONException;
import org.json.JSONObject;


public class next_Pay extends AppCompatActivity implements PaymentResultWithDataListener, ExternalWalletListener{

    public static final String EXTRA_NAME = "name";
    public static final String EXTRA_AMOUNT= "amount";
//    public static final String EXTRA_PLOT= "plot2";
//    public static final String EXTRA_AREA= "area2";
    DataBaseHelper mydb;
    TextView show_name, show_amount;
    Button btn_pay;
    String new_name, new_amount, new_plot, new_area;
    int amount;

    private AlertDialog.Builder alertDialogBuilder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next_pay);

        show_name= findViewById(R.id.show_name);
        show_amount= findViewById(R.id.show_amount);
        btn_pay= findViewById(R.id.btn_pay);
        mydb= new DataBaseHelper(this);


        Intent i= getIntent();
        new_name= i.getStringExtra(Tax_Login.EXTRA_NAME);
        new_amount= i.getStringExtra(Tax_Login.EXTRA_AMOUNT);
        new_plot=i.getStringExtra(Tax_Login.EXTRA_PLOT);
        new_area=i.getStringExtra(Tax_Login.EXTRA_AREA);


        show_name.setText(new_name);
        show_amount.setText(new_amount);
        amount= (Integer.parseInt(new_amount))*100;



//        IMPORTING
        Checkout.preload(getApplicationContext());

        btn_pay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startPayment();
            }
        });
    }

    @Override
    public void onExternalWalletSelected(String s, PaymentData paymentData) {
        try{
            alertDialogBuilder.setMessage("Payment Successful :\nPayment ID: "+s+"\nPayment Data: "+paymentData.getData());
            alertDialogBuilder.show();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void onPaymentSuccess(String s, PaymentData paymentData) {


        //mydb.setStatus();
//
//        Intent i_receipt= new Intent(next_Pay.this, receipt.class);
//        i_receipt.putExtra(EXTRA_NAME,new_name );
//        i_receipt.putExtra(EXTRA_AMOUNT, new_amount);
//        startActivity(i_receipt);

    }

    @Override
    public void onPaymentError(int i, String s, PaymentData paymentData) {

    }


    public void startPayment() {
        Checkout checkout = new Checkout();
        checkout.setKeyID("rzp_test_3Nc0z4rymLbg1a");

        try {
            JSONObject options = new JSONObject();
            options.put("name", "कर भरणा");
            options.put("description", "Demoing Charges");
            options.put("send_sms_hash", true);
            options.put("allow_rotation", true);
            options.put("image", "drawable/logo2.jpg");
            options.put("currency", "INR");
            options.put("amount", amount);

            JSONObject preFill = new JSONObject();
            preFill.put("email", "test@razorpay.com");
            preFill.put("contact", "9503354853");

            options.put("prefill", preFill);

            checkout.open((Activity) this, options);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "Error in payment: " + e.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}