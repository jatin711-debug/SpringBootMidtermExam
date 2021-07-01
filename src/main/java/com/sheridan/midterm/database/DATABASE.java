package com.sheridan.midterm.database;
import java.util.List;

import com.sheridan.midterm.beans.Spending;

interface DATABASE {
    public void addDataToDatabase(Spending object);
    public void searchFromDatabase();
    public List<Spending> getAllDatabase();
}
