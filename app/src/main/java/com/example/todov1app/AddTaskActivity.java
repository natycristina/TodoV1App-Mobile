package com.example.todov1app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.RadioGroup;

import com.example.todov1app.databinding.ActivityAddTaskBinding;

public class AddTaskActivity extends AppCompatActivity {

    ActivityAddTaskBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addNewButton.setOnClickListener(view -> {
            String name = binding.taskNameEditText.getText().toString();
            String desc = binding.taskDescEditText.getText().toString();
            RadioGroup priorityGroup = findViewById(R.id.priorityRadioGroup);
            int selectedId = priorityGroup.getCheckedRadioButtonId();

            String priority = "Low"; // valor padrão
            if (selectedId == R.id.highPriorityRadio) {
                priority = "High";
            } else if (selectedId == R.id.mediumPriorityRadio) {
                priority = "Medium";
            }
// Agora você pode criar a task com isso
            Task task = new Task(name, desc, priority);

            Intent i = new Intent();
            i.putExtra("taskAdded", task);
            setResult(RESULT_OK, i);
            AddTaskActivity.this.finish();
        });
    }
}