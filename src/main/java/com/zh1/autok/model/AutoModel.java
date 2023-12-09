package com.zh1.autok.model;

import com.zh1.autok.service.AutoService;

public class AutoModel
{
    public AutoModel(String rendszam, String gyarto, String tipus, int loero)
    {
        this.rendszam = rendszam;
        this.gyarto = gyarto;
        this.tipus = tipus;
        this.loero = loero;
    }

    public AutoModel() {}

    private String rendszam;

    private String gyarto;

    private String tipus;

    private int loero;

    public String GetRendszam()
    {
        return rendszam;
    }

    public String GetGyarto()
    {
        return gyarto;
    }

    public String GetTipus()
    {
        return tipus;
    }

    public int GetLoero()
    {
        return loero;
    }
}
