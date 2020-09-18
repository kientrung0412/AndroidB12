package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.dao.AppDatabase;
import com.example.myapplication.models.Student;

public class StudentActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String EXTRA_STUDENT = "extra.STUDENT";
    private EditText edtName;
    private EditText edtScore;
    private EditText edtSubject;
    private Button btnOk;

    private Student student;

    public static Intent getInstance(Context context, Student student) {
        Intent intent = new Intent(context, StudentActivity.class);
        intent.putExtra(EXTRA_STUDENT, student);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);
        student = (Student) getIntent().getSerializableExtra(EXTRA_STUDENT);
        initViews();
        showData();
    }

    private void showData() {
        edtName.setText(student.getName());
        edtScore.setText(student.getScore() + "");
        edtSubject.setText(student.getSubject());
    }

    private void initViews() {
        edtName = findViewById(R.id.edt_name);
        edtScore = findViewById(R.id.edt_score);
        edtSubject = findViewById(R.id.edt_subject);
        btnOk = findViewById(R.id.btn_ok);

        btnOk.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_ok:

                String name = edtName.getText().toString();
                String score = edtScore.getText().toString();
                String subject = edtSubject.getText().toString();

                if (name.isEmpty() || score.isEmpty() || subject.isEmpty()) {
                    Toast.makeText(this, "Không được bỏ trống", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (Float.parseFloat(score) > 10f && Float.parseFloat(score) < 0f) {
                    Toast.makeText(this, "Điểm nhập không trính xác r", Toast.LENGTH_SHORT).show();
                    return;
                }

                student.setName(name);
                student.setScore(Float.parseFloat(score));
                student.setSubject(subject);

                if (student.getId() == 0) {
                    AppDatabase.getInstance(this).getAppDao().insert(student);
                } else {
                    AppDatabase.getInstance(this).getAppDao().update(student);
                }
                setResult(RESULT_OK);
                break;
        }
    }
}