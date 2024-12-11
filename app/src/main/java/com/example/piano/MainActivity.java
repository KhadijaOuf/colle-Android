package com.example.piano;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] keyIds = {
                R.id.key_c, R.id.key_d, R.id.key_e,
                R.id.key_f, R.id.key_g, R.id.key_a, R.id.key_b
        };

        int[] soundIds = {
                R.raw.key_c, R.raw.key_d, R.raw.key_e,
                R.raw.key_f, R.raw.key_g, R.raw.key_a, R.raw.key_b
        };

        for (int i = 0; i < keyIds.length; i++) {
            Button button = findViewById(keyIds[i]);
            final int soundId = soundIds[i];

            button.setOnClickListener(v -> playSound(soundId));
        }

    }

    private void playSound(int soundId) {
        if (mediaPlayer != null) {
            mediaPlayer.release();  // Libérer l'ancienne ressource
        }
        mediaPlayer = MediaPlayer.create(this, soundId);
        if (mediaPlayer != null) {
            mediaPlayer.start();
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}

