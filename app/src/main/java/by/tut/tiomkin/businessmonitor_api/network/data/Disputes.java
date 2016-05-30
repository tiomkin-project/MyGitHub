package by.tut.tiomkin.businessmonitor_api.network.data;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Disputes
{
  private String case_num;
  private String objectId;
  private String room;
  private String plaintiff_name;
  private java.util.Date date_hearing;
  private Integer court_id;
  private String def_name;
  private String disp_matter;
  private String ownerId;
  private java.util.Date created;
  private String judge;
  private java.util.Date updated;
  public String getCase_num()
  {
    return case_num;
  }

  public void setCase_num( String case_num )
  {
    this.case_num = case_num;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getRoom()
  {
    return room;
  }

  public void setRoom( String room )
  {
    this.room = room;
  }

  public String getPlaintiff_name()
  {
    return plaintiff_name;
  }

  public void setPlaintiff_name( String plaintiff_name )
  {
    this.plaintiff_name = plaintiff_name;
  }

  public java.util.Date getDate_hearing()
  {
    return date_hearing;
  }

  public void setDate_hearing( java.util.Date date_hearing )
  {
    this.date_hearing = date_hearing;
  }

  public Integer getCourt_id()
  {
    return court_id;
  }

  public void setCourt_id( Integer court_id )
  {
    this.court_id = court_id;
  }

  public String getDef_name()
  {
    return def_name;
  }

  public void setDef_name( String def_name )
  {
    this.def_name = def_name;
  }

  public String getDisp_matter()
  {
    return disp_matter;
  }

  public void setDisp_matter( String disp_matter )
  {
    this.disp_matter = disp_matter;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getJudge()
  {
    return judge;
  }

  public void setJudge( String judge )
  {
    this.judge = judge;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

                                                    
  public Disputes save()
  {
    return Backendless.Data.of( Disputes.class ).save( this );
  }

  public Future<Disputes> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Disputes> future = new Future<Disputes>();
      Backendless.Data.of( Disputes.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Disputes> callback )
  {
    Backendless.Data.of( Disputes.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Disputes.class ).remove( this );
  }

  public Future<Long> removeAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Long> future = new Future<Long>();
      Backendless.Data.of( Disputes.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Disputes.class ).remove( this, callback );
  }

  public static Disputes findById( String id )
  {
    return Backendless.Data.of( Disputes.class ).findById( id );
  }

  public static Future<Disputes> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Disputes> future = new Future<Disputes>();
      Backendless.Data.of( Disputes.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Disputes> callback )
  {
    Backendless.Data.of( Disputes.class ).findById( id, callback );
  }

  public static Disputes findFirst()
  {
    return Backendless.Data.of( Disputes.class ).findFirst();
  }

  public static Future<Disputes> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Disputes> future = new Future<Disputes>();
      Backendless.Data.of( Disputes.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Disputes> callback )
  {
    Backendless.Data.of( Disputes.class ).findFirst( callback );
  }

  public static Disputes findLast()
  {
    return Backendless.Data.of( Disputes.class ).findLast();
  }

  public static Future<Disputes> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Disputes> future = new Future<Disputes>();
      Backendless.Data.of( Disputes.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Disputes> callback )
  {
    Backendless.Data.of( Disputes.class ).findLast( callback );
  }

  public static BackendlessCollection<Disputes> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Disputes.class ).find( query );
  }

  public static Future<BackendlessCollection<Disputes>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Disputes>> future = new Future<BackendlessCollection<Disputes>>();
      Backendless.Data.of( Disputes.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Disputes>> callback )
  {
    Backendless.Data.of( Disputes.class ).find( query, callback );
  }
}