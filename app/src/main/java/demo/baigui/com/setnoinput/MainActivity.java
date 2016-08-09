package demo.baigui.com.setnoinput;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void mybuttonlistener(View target){
        //do something5

        if (target.getId() == R.id.go_login){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
        }else if (target.getId() == R.id.is_show_input){
            SharedPreferences sharedPreferences= getSharedPreferences("is_hide_input",
                    Activity.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            if (sharedPreferences.getBoolean("is_hide_input" , false)){
                ((Button)target).setText("当前无键盘");
                editor.putBoolean("is_hide_input" , false);
                editor.commit();
            }else {
                ((Button)target).setText("当前有键盘");
                editor.putBoolean("is_hide_input" , true);
                editor.commit();
            }
        }
    }
}
