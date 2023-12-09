package com.zh1.autok.service;

import com.zh1.autok.model.AutoModel;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class AutoService
{
    public AutoService() {}

    private static List<AutoModel> autoList = new ArrayList<>();
    static
    {
        AutoModel bmwe60 = new AutoModel("ASD-123", "BMW", "E60", 120);
        AutoModel audis6 = new AutoModel("LKJ-421", "AUDI", "S6", 200);

        autoList.add(bmwe60);
        autoList.add(audis6);
    }

    public List<AutoModel> GetAutoList()
    {
        return autoList;
    }

    public AutoModel AutokLekerese(String rendszam)
    {
        for (AutoModel autoModel : autoList)
        {
            if (autoModel.GetRendszam().equals(rendszam))
            {
                return autoModel;
            }
        }
        return null;
    }

    public void AutoHozzaadasa(String rendszam, String gyarto, String tipus, int loero)
    {
        for (AutoModel autoModel : autoList)
        {
            if (rendszam.equals(autoModel.GetRendszam()))
            {
                throw new RuntimeException("HIBA: Már létezik ilyen rendszámú autó!");
            }
        }
        AutoModel autoDetails = new AutoModel(rendszam, gyarto, tipus, loero);
        autoList.add(autoDetails);
    }
    
    public void AutoFrissitese(String rendszam, String gyarto, String tipus, int loero)
    {
        for (int i = 0; i < autoList.size(); i++)
        {
            if (rendszam.equals(autoList.get(i).GetRendszam()))
            {
                AutoModel autoDetailed = new AutoModel(rendszam, gyarto, tipus, loero);
                autoList.set(i, autoDetailed);
            }
        }
    }

    public void AutoTorlese(String rendszam)
    {
        autoList.removeIf(a -> a.GetRendszam().equals(rendszam));
    }
}
