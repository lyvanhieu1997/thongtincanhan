package bcvt.edu.thongtincanhan;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText edtTen;
    private EditText edtCmnd;
    private EditText edtTtbs;
    private RadioButton rbtDh;
    private RadioButton rbtCd;
    private RadioButton rbtTc;
    private CheckBox cbbao;
    private CheckBox cbSach;
    private CheckBox cbCoding;
    private Button btnGui;
    String msg ="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setControl();
        setEvent();
    }
    public void setControl(){
        edtTen= findViewById(R.id.edt_ten);
        edtCmnd= findViewById(R.id.edt_cmnd);
        edtTtbs= findViewById(R.id.edt_ttbs);
        rbtDh= findViewById(R.id.rbt_dh);
        rbtCd= findViewById(R.id.rbt_cd);
        rbtTc= findViewById(R.id.rbt_tc);
        cbbao= findViewById(R.id.cb_bao);
        cbSach= findViewById(R.id.cb_sach);
        cbCoding= findViewById(R.id.cb_code);
        btnGui= findViewById(R.id.btn_gui);
    }
    public void setEvent(){
        btnGui.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                msg = String.valueOf(edtTen.getText()) + "\n";
                msg += String.valueOf(edtCmnd.getText()) + "\n";
                if(rbtDh.isChecked()){
                    msg += rbtDh.getText();
                }else if (rbtCd.isChecked()){
                    msg += rbtCd.getText();
                }else {
                    msg +=rbtCd.getText();
                }
                msg += "\n-------------\n";
                if (cbbao.isChecked()){
                    msg += cbbao.getText() + "\n";
                }
                if (cbSach.isChecked()){
                    msg +=cbSach.getText() +"\n";
                }
                if (cbCoding.isChecked()){
                    msg +=cbCoding.getText() +"\n";
                }
                msg +="Thong Tin Bo Sung:\n";
                msg +=edtTtbs.getText();
                //Toast.makeText(TTinActi.this, msg, Toast.LENGTH_LONG).show();
                showAlert();

            }
        });


    }
    public void showAlert(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Thông Tin Cá Nhân");
        builder.setNegativeButton("Đóng", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        builder.setMessage(msg);
        builder.setCancelable(false);
        builder.show();

    }


}
