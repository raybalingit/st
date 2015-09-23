package com.stengg.stee.stelectronics.models;

/**
 * Created by Raymond Balingit on 24/9/2015.
 */
public class WoClass {
    private String content;

    private String maxvalue;

    public String getContent ()
    {
        return content;
    }

    public void setContent (String content)
    {
        this.content = content;
    }

    public String getMaxvalue ()
    {
        return maxvalue;
    }

    public void setMaxvalue (String maxvalue)
    {
        this.maxvalue = maxvalue;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [content = "+content+", maxvalue = "+maxvalue+"]";
    }
}
