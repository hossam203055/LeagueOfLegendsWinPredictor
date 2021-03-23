package com.hsm.leagueoflegendswinpredictor;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;


import org.jetbrains.annotations.NotNull;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


public class MainActivity extends AppCompatActivity {
    String urlOfServer = "http://10.0.0.3:5000/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button predictButton = findViewById(R.id.predictButton);
        OkHttpClient okHttpClient = new OkHttpClient();
        final Request request = new Request.Builder().url(urlOfServer).build();
        okHttpClient.newCall(request).enqueue(new Callback() {

            @Override
            public void onResponse(@NotNull Call call, @NotNull Response response) throws IOException {
                TextView textView = findViewById(R.id.textView);
                textView.setText(response.body().string());
            }

            @Override
            public void onFailure(@NotNull Call call, @NotNull IOException e) {
                //Toast.makeText(MainActivity.this,"Failed to load data",Toast.LENGTH_LONG).show();
                TextView textView = findViewById(R.id.textView);
                textView.setText(e.getMessage());
            }
        });

        View.OnClickListener sendRowOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RadioButton blueFirstBloodRadioButton = findViewById(R.id.blueFirstBloodRadioButton);
                RadioButton blueFirstTowerRadioButton = findViewById(R.id.blueFirstTowerRadioButton);
                RadioButton blueFirstBaronRadioButton = findViewById(R.id.blueFirstBaronRadioButton);
                RadioButton blueFirstDragonRadioButton = findViewById(R.id.blueFirstDragonRadioButton);
                RadioButton blueFirstInhibitorRadioButton = findViewById(R.id.blueFirstInhibitorRadioButton);

                EditText blueDragonKillsEditText = findViewById(R.id.blueDragonKillsEditText);
                EditText blueBaronKillsEditText = findViewById(R.id.blueBaronKillsEditText);
                EditText blueTowerKillsEditText = findViewById(R.id.blueTowerKillsEditText);
                EditText blueInhibitorKillsEditText = findViewById(R.id.blueInhibitorKillsEditText);
                EditText blueWardPlacedEditText = findViewById(R.id.blueWardPlacedEditText);
                EditText blueWardKillsEditText = findViewById(R.id.blueWardKillsEditText);

                EditText blueKillsEditText = findViewById(R.id.blueKillsEditText);
                EditText blueDeathEditText = findViewById(R.id.blueDeathEditText);
                EditText blueAssistEditText =findViewById(R.id.blueAssistEditText);
                EditText blueChampionDamageDealtEditText = findViewById(R.id.blueChampionDamageDealtEditText);
                EditText blueTotalGoldEditText = findViewById(R.id.blueTotalGoldDealtEditText);
                EditText blueTotalMinionKillsEditText = findViewById(R.id.blueTotalMinionKillsEditText);

                EditText blueLevelS1EditTextEditText = findViewById(R.id.blueLevelS1EditText);
                EditText blueLevelS2EditTextEditText = findViewById(R.id.blueLevelS2EditText);
                EditText blueLevelS3EditTextEditText = findViewById(R.id.blueLevelS3EditText);
                EditText blueLevelS4EditTextEditText = findViewById(R.id.blueLevelS4EditText);
                EditText blueLevelS5EditTextEditText = findViewById(R.id.blueLevelS5EditText);

                int blueTotalLevel = Integer.parseInt(blueLevelS1EditTextEditText.getText().toString()) +
                        Integer.parseInt(blueLevelS2EditTextEditText.getText().toString()) +
                        Integer.parseInt(blueLevelS3EditTextEditText.getText().toString()) +
                        Integer.parseInt(blueLevelS4EditTextEditText.getText().toString()) +
                        Integer.parseInt(blueLevelS5EditTextEditText.getText().toString());

                EditText blueJungleMinionKillsEditText = findViewById(R.id.blueJungleMinionKillsEditText);
                EditText blueKillingSpreeEditText = findViewById(R.id.blueKillingSpreeEditText);
                EditText blueTotalHealEditText = findViewById(R.id.blueTotalHealEditText);
                EditText blueObjectDamageDealtEditText = findViewById(R.id.blueObjectDamageDealtEditText);

                EditText redDragonKillsEditText = findViewById(R.id.redDragonKillsEditText);
                EditText redBaronKillsEditText = findViewById(R.id.redBaronKillsEditText);
                EditText redTowerKillsEditText = findViewById(R.id.redTowerKillsEditText);
                EditText redInhibitorKillsEditText = findViewById(R.id.redInhibitorKillsEditText);
                EditText redWardPlacedEditText = findViewById(R.id.redWardPlacedEditText);
                EditText redWardKillsEditText = findViewById(R.id.redWardKillsEditText);

                EditText redKillsEditText = findViewById(R.id.redKillsEditText);
                EditText redDeathEditText = findViewById(R.id.redDeathEditText);
                EditText redAssistEditText =findViewById(R.id.redAssistEditText);
                EditText redChampionDamageDealtEditText = findViewById(R.id.redChampionDamageDealtEditText);
                EditText redTotalGoldEditText = findViewById(R.id.redTotalGoldDealtEditText);
                EditText redTotalMinionKillsEditText = findViewById(R.id.redTotalMinionKillsEditText);

                EditText redLevelS1EditTextEditText = findViewById(R.id.redLevelS1EditText);
                EditText redLevelS2EditTextEditText = findViewById(R.id.redLevelS2EditText);
                EditText redLevelS3EditTextEditText = findViewById(R.id.redLevelS3EditText);
                EditText redLevelS4EditTextEditText = findViewById(R.id.redLevelS4EditText);
                EditText redLevelS5EditTextEditText = findViewById(R.id.redLevelS5EditText);

                int redTotalLevel = Integer.parseInt(redLevelS1EditTextEditText.getText().toString()) +
                        Integer.parseInt(redLevelS2EditTextEditText.getText().toString()) +
                        Integer.parseInt(redLevelS3EditTextEditText.getText().toString()) +
                        Integer.parseInt(redLevelS4EditTextEditText.getText().toString()) +
                        Integer.parseInt(redLevelS5EditTextEditText.getText().toString());

                EditText redJungleMinionKillsEditText = findViewById(R.id.redJungleMinionKillsEditText);
                EditText redKillingSpreeEditText = findViewById(R.id.redKillingSpreeEditText);
                EditText redTotalHealEditText = findViewById(R.id.redTotalHealEditText);
                EditText redObjectDamageDealtEditText = findViewById(R.id.redObjectDamageDealtEditText);

                RequestBody requestBody = new FormBody.Builder()
                        .add("blueFirstBlood", blueFirstBloodRadioButton.isChecked() ? "1" : "0")
                        .add("blueFirstTower", blueFirstTowerRadioButton.isChecked() ? "1" : "0")
                        .add("blueFirstBaron", blueFirstBaronRadioButton.isChecked() ? "1" : "0")
                        .add("blueFirstDragon", blueFirstDragonRadioButton.isChecked() ? "1" : "0")
                        .add("blueFirstInhibitor", blueFirstInhibitorRadioButton.isChecked() ? "1" : "0")

                        .add("blueDragonKills", blueDragonKillsEditText.getText().toString())
                        .add("blueBaronKills", blueBaronKillsEditText.getText().toString())
                        .add("blueTowerKills", blueTowerKillsEditText.getText().toString())
                        .add("blueInhibitorKills", blueInhibitorKillsEditText.getText().toString())
                        .add("blueWardPlaced", blueWardPlacedEditText.getText().toString())
                        .add("blueWardKills", blueWardKillsEditText.getText().toString())

                        .add("blueKills",blueKillsEditText.getText().toString())
                        .add("blueDeath",blueDeathEditText.getText().toString())
                        .add("blueAssist",blueAssistEditText.getText().toString())
                        .add("blueChampionDamageDealt",blueChampionDamageDealtEditText.getText().toString())
                        .add("blueTotalGold",blueTotalGoldEditText.getText().toString())
                        .add("blueTotalMinionKills",blueTotalMinionKillsEditText.getText().toString())

                        .add("blueTotalLevel", blueTotalLevel + "")
                        .add("blueAvgLevel", (blueTotalLevel / 5) + "")
                        .add("blueJungleMinionKills", blueJungleMinionKillsEditText.getText().toString())
                        .add("blueKillingSpree", blueKillingSpreeEditText.getText().toString())
                        .add("blueTotalHeal", blueTotalHealEditText.getText().toString())
                        .add("blueObjectDamageDealt", blueObjectDamageDealtEditText.getText().toString())

                        .add("redDragonKills", redDragonKillsEditText.getText().toString())
                        .add("redBaronKills", redBaronKillsEditText.getText().toString())
                        .add("redTowerKills", redTowerKillsEditText.getText().toString())
                        .add("redInhibitorKills", redInhibitorKillsEditText.getText().toString())
                        .add("redWardPlaced", redWardPlacedEditText.getText().toString())
                        .add("redWardKills", redWardKillsEditText.getText().toString())

                        .add("redKills",redKillsEditText.getText().toString())
                        .add("redDeath",redDeathEditText.getText().toString())
                        .add("redAssist",redAssistEditText.getText().toString())
                        .add("redChampionDamageDealt",redChampionDamageDealtEditText.getText().toString())
                        .add("redTotalGold",redTotalGoldEditText.getText().toString())
                        .add("redTotalMinionKills",redTotalMinionKillsEditText.getText().toString())


                        .add("redTotalLevel", redTotalLevel + "")
                        .add("redAvgLevel", (redTotalLevel / 5) + "")
                        .add("redJungleMinionKills", redJungleMinionKillsEditText.getText().toString())
                        .add("redKillingSpree", redKillingSpreeEditText.getText().toString())
                        .add("redTotalHeal", redTotalHealEditText.getText().toString())
                        .add("redObjectDamageDealt", redObjectDamageDealtEditText.getText().toString())

                        .build();
                Request postRequest = new Request.Builder().url(urlOfServer + "newRow").post(requestBody).build();
                OkHttpClient postOkHttpClient = new OkHttpClient();
                postOkHttpClient.newCall(postRequest).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        TextView textView = findViewById(R.id.textView);
                        textView.setText("Error: " + e.getMessage());
                    }

                    @Override
                    public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView textView = findViewById(R.id.textView);
                                LinearLayout resultDialogLinearLayout = findViewById(R.id.resultDialogLinearLayout);
                                try {

                                    String teamWins = (response.body().string().contains("1")?"Blue Team Wins":"Red Team Wins");
                                    textView.setText("The result is " + teamWins);
                                    resultDialog(getApplicationContext(),teamWins).show();

                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        });
                    }
                });
            }
        };

        View.OnClickListener testOnClickListener = new View.OnClickListener() { //this object is for testing only
            @Override
            public void onClick(View v) {
                RequestBody requestBody = new FormBody.Builder().add("test","Hello from android").build();
                Request postRequest = new Request.Builder().url(urlOfServer+"two").post(requestBody).build();
                OkHttpClient postOkHttpClient = new OkHttpClient();
                postOkHttpClient.newCall(postRequest).enqueue(new Callback() {
                    @Override
                    public void onFailure(@NotNull Call call, @NotNull IOException e) {
                        TextView textView = findViewById(R.id.textView);
                        textView.setText("Error: " + e.getMessage());
                    }
                    @Override
                    public void onResponse(@NotNull Call call, @NotNull final Response response) throws IOException {
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                TextView textView = findViewById(R.id.textView);
                                resultDialog(getApplicationContext(),"Done").show();

                            }
                        });
                    }
                });
            }
        };
        predictButton.setOnClickListener(sendRowOnClickListener);
    }
    public AlertDialog resultDialog(Context context, String teamWins) {
        LayoutInflater inflater = LayoutInflater.from(context);
        final View viewInflater = inflater.inflate(R.layout.result_dialog, null);
        TextView teamWinsDialogTextView = viewInflater.findViewById(R.id.teamWinsDialogTextView);
        teamWinsDialogTextView.setText(teamWins);
        final AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this)
                .setView(viewInflater)
                .create();
        alertDialog.setCancelable(true);
        alertDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return alertDialog;
    }
}