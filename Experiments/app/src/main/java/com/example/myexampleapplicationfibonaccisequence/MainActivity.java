package com.example.myexampleapplicationfibonaccisequence;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addBtn = (Button) findViewById(R.id.FibonacciButton );

        addBtn.setOnClickListener(new View.OnClickListener(){



            public void onClick(View view){
                EditText numEditText = (EditText) findViewById((R.id.editText));
                TextView fibAns = (TextView) findViewById(R.id.textView2);

                int num = Integer.parseInt(numEditText.getText().toString());

                int result = fibNum(num);

                fibAns.setText(result + "");
            }
        });




    }

    private int fibNum(int n) {

        if (n <= 1 ){
            return n;
        }

        return fibNum(n-1) + fibNum(n-2);
    }
}
