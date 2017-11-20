package edu.texttoemoji;

import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import edu.texttoemoji.model.EmojiResponse;
import edu.texttoemoji.presenter.EmojiPresenter;
import edu.texttoemoji.retrofit.ApiUtils;
import edu.texttoemoji.retrofit.SOService;
import edu.texttoemoji.view.DashboardView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class EmojiConverter extends AppCompatEditText implements DashboardView {


    private SOService mService;
    private List<EmojiResponse> list;
    EmojiPresenter emojiPresenter;
    private Context context;
    String processedText;
    public EmojiConverter(Context context) {
        super(context);
        this.context = context;
        mService = ApiUtils.getSOService();
        list = new ArrayList<>();
        makeRequest();
        emojiPresenter = new EmojiPresenter(this);
    }

    public EmojiConverter(Context context,
                          AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        mService = ApiUtils.getSOService();
        list = new ArrayList<>();
        makeRequest();
        emojiPresenter = new EmojiPresenter(this);
    }

    public EmojiConverter(Context context,
                          AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
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

                } else {
                    int statusCode = response.code();
                    // handle request errors depending on status code
                }
            }

            @Override
            public void onFailure(Call<List<EmojiResponse>> call, Throwable t) {
                Log.d("EmojiConverter", "error loading from API");

            }
        });

    }



    @Override
    protected void onTextChanged(CharSequence s, int start,
                                 int lengthBefore, int lengthAfter) {
        String[] word = null;
        ArrayList<String> rawText = new ArrayList<>();
        word = s.toString().split(" ");
        Collections.addAll(rawText, word);

        if (list != null) {
            processedText = emojiPresenter.processString(list, rawText);
        }

    }


    @Override
    public void convertEmoji() {

        this.setText(processedText);

    }


}
