package by.tut.tiomkin.businessmonitor_api.network.data.crud.common;

import android.app.Application;

public class DataApplication extends Application
{
  private String chosenTable;

  public String getChosenTable()
  {
    return chosenTable;
  }

  public void setChosenTable( String chosenTable )
  {
    this.chosenTable = chosenTable;
  }
}