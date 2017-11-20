package edu.texttoemoji;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import edu.texttoemoji.model.EmojiResponse;
import edu.texttoemoji.presenter.EmojiPresenter;
import edu.texttoemoji.retrofit.ApiUtils;
import edu.texttoemoji.retrofit.SOService;
import edu.texttoemoji.view.DashboardView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements DashboardView {


    @BindView(R.id.btnConvert)
    Button btnConvert;
    @BindView(R.id.edtRawText)
    EditText edtRawText;
    @BindView(R.id.txtProcessedText)
    TextView txtProcessedText;
    private SOService mService;
    private List<EmojiResponse> list;
    EmojiPresenter emojiPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mService = ApiUtils.getSOService();
        list = new ArrayList<>();
        makeRequest();
        emojiPresenter = new EmojiPresenter(this);


    }

    private void makeRequest() {

        mService.getEmojis().enqueue(new Callback<List<EmojiResponse>>() {
            @Override
            public void onResponse(Call<List<EmojiResponse>> call, Response<List<EmojiResponse>> response) {

                if (response.isSuccessful()) {
                    Log.d("Tag", response.toString());
                    list = response.body();
                    startProcessing();

                } else {
                    int statusCode = response.code();
                    // handle request errors depending on status code
                    Toast.makeText(MainActivity.this, "Error in hit", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<EmojiResponse>> call, Throwable t) {
                Log.d("MainActivity", "error loading from API");

            }
        });

    }

    private void startProcessing() {

        edtRawText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String[] word = null;
                ArrayList<String> rawText = new ArrayList<>();
                word = s.toString().split(" ");
                Collections.addAll(rawText, word);
                String processedText = emojiPresenter.processString(list,rawText);
                txtProcessedText.setText(processedText);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }

    @Override
    public void convertEmoji(String rawText) {

    }

    @Override
    public void finishActivity() {

    }

    @Override
    public void shareText() {

    }
}
