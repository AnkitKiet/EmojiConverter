package edu.texttoemoji.presenter;

import java.util.ArrayList;
import java.util.List;

import edu.texttoemoji.model.EmojiResponse;
import edu.texttoemoji.view.DashboardView;

/**
 * Created by Ankit on 20/11/17.
 */

public class EmojiPresenter {

    private DashboardView dashboardView;
    private ArrayList<EmojiResponse> list;

    public EmojiPresenter(DashboardView dashboardView) {
        this.dashboardView = dashboardView;
    }

    public String processString(List<EmojiResponse> listEmojis, List<String> rawText) {
        if (listEmojis.size() > 0 && rawText.size() > 0) {
            String processedText = "";
            for (int i = 0; i < rawText.size(); i++) {

                for (EmojiResponse model : listEmojis) {
                    String raw = rawText.get(i);
                    List<String> keywords = model.getKeywords();
                    if (keywords.contains(raw)) {
                        rawText.set(i, model.getChar());
                    }

                }

            }

            for (String process : rawText) {
                processedText += (process + " ");
            }
            return processedText;
        }else{
            return "";

        }
    }


}
