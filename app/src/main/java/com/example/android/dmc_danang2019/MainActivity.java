package com.example.android.dmc_danang2019;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.dmc_danang2019.DAO.ThongBaoDAO;
import com.example.android.dmc_danang2019.Model.ThongBao;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int NOTIFICATION_ID = 234;
    private GoogleSignInClient mGoogleSignInClient;
    TextView txtEmail,txtName;
    ImageView imgHinh;
    Button LogOut,Notifiaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //yêu câu người dung cung cấp địa chỉ
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        //kết nối google client
        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        txtEmail=(TextView) findViewById(R.id.txtEmail);
        txtName=(TextView)findViewById(R.id.txtName);
        imgHinh=(ImageView) findViewById(R.id.circle_avatar_user);
        LogOut=(Button)findViewById (R.id.btnLogOut);
        Notifiaction=(Button) findViewById(R.id.btnNotification);

        Bundle bundle = getIntent().getExtras();
        txtName.setText(bundle.getString("Name"));
        txtEmail.setText(bundle.getString("Email"));
        String img = bundle.getString("photo");
        Picasso.with(getApplicationContext()).load(img).into(imgHinh);

        findViewById(R.id.btnLogOut).setOnClickListener(this);
        Button startBtnSendEmail = (Button) findViewById(R.id.btnsendEmail);
        startBtnSendEmail.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                sendEmail();
            }
        });


        Button startBtnView = (Button) findViewById(R.id.btnView);
        startBtnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Emailid=txtEmail.getText().toString();
                Intent intent = new Intent(MainActivity.this,ChiTietHoaDon.class);
                Bundle bundle1 = new Bundle();
                bundle1.putString("Emailid",Emailid);


                intent.putExtras(bundle1);
                startActivity(intent);

            }
        });
    }

    @SuppressLint("LongLogTag")
    protected void sendEmail() {
        Log.i("Send email", "");
        String[] TO = {""};
        String[] CC = {""};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            //  Toast.makeText(MainActivity.this, "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private void signOut() {
        mGoogleSignInClient.signOut()
                .addOnCompleteListener(this, new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        updateUI();
                        // ...
                    }
                });
    }
    public void updateUI() {
        Toast.makeText(MainActivity .this, "You are logout", Toast.LENGTH_LONG);
        Intent mainActivity = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(mainActivity);
        finish();
    }
    public void createNotification(View view) {
        ThongBaoDAO thongBaoDAO=new ThongBaoDAO();
        Bundle bundle = getIntent().getExtras();
        String emailid_TB=bundle.getString("Email");
        ThongBao arrThongBao=thongBaoDAO.getListThongBao(emailid_TB);



        NotificationManager notificati1onManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);

        String CHANNEL_ID = "";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {


            CHANNEL_ID = "my_channel_01";
            CharSequence name = "my_channel";
            String Description = "This is my channel";
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, name, importance);
            mChannel.setDescription(Description);
            mChannel.enableLights(true);
            mChannel.setLightColor(Color.RED);
            mChannel.enableVibration(true);
            mChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            mChannel.setShowBadge(false);
            notificati1onManager.createNotificationChannel(mChannel);
        }

        // đơi 
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getApplicationContext(), CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Tiền Phòng Trọ !!!")
                .setContentText("Tháng :" + arrThongBao.getThang() + "/" + arrThongBao.getNam() + " Tiền: " + arrThongBao.getTongCong());

        Intent intent = new Intent(MainActivity.this, NhanThongBao.class);
        Bundle bundle1 = new Bundle();
        bundle1.putString("Nam", String.valueOf(arrThongBao.getNam()));
        bundle1.putString("Thang", String.valueOf(arrThongBao.getThang()));
        bundle1.putString("TienDien", String.valueOf(arrThongBao.getTienDien()));
        bundle1.putString("TienNuoc", String.valueOf(arrThongBao.getTienNuoc()));
        bundle1.putString("TongCong", String.valueOf(arrThongBao.getTongCong()));
        intent.putExtras(bundle1);
        // startActivity(intent);

        TaskStackBuilder stackBuilder = TaskStackBuilder.create(getApplicationContext());
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
        PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(0, PendingIntent.FLAG_UPDATE_CURRENT);

        builder.setContentIntent(resultPendingIntent);

        notificati1onManager.notify(NOTIFICATION_ID, builder.build());


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnLogOut:
                signOut();
                break;
        }
    }



}
