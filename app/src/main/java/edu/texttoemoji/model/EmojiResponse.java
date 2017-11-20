package edu.texttoemoji.model;

/**
 * Created by Ankit on 20/11/17.
 */

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EmojiResponse implements Serializable
{

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("keywords")
    @Expose
    private List<String> keywords = null;
    @SerializedName("char")
    @Expose
    private String _char;
    @SerializedName("category")
    @Expose
    private String category;
    private final static long serialVersionUID = 5337359183655585228L;

    /**
     * No args constructor for use in serialization
     *
     */
    public EmojiResponse() {
    }

    /**
     *
     * @param category
     * @param keywords
     * @param name
     * @param _char
     */
    public EmojiResponse(String name, List<String> keywords, String _char, String category) {
        super();
        this.name = name;
        this.keywords = keywords;
        this._char = _char;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getKeywords() {
        return keywords;
    }

    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }

    public String getChar() {
        return _char;
    }

    public void setChar(String _char) {
        this._char = _char;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}