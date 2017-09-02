package mx.cetys.jorgepayan.actividad1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView text_view_messageReceived;
    Button button_goBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);

        text_view_messageReceived = (TextView) findViewById(R.id.text_view_showFromTextName);
        button_goBack = (Button) findViewById(R.id.button_GoToMain);

        Intent intent = getIntent();
        String messageReceived = intent.getStringExtra(MainActivity.EXTRA_KEY);
        text_view_messageReceived.setText(messageReceived);

        button_goBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
