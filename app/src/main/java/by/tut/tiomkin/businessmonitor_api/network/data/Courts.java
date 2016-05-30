package by.tut.tiomkin.businessmonitor_api.network.data;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.persistence.BackendlessDataQuery;

public class Courts
{
  private String ownerId;
  private Integer court_id;
  private String name;
  private java.util.Date updated;
  private String objectId;
  private java.util.Date created;
  public String getOwnerId()
  {
    return ownerId;
  }

  public Integer getCourt_id()
  {
    return court_id;
  }

  public void setCourt_id( Integer court_id )
  {
    this.court_id = court_id;
  }

  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

                                                    
  public Courts save()
  {
    return Backendless.Data.of( Courts.class ).save( this );
  }

  public Future<Courts> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Courts> future = new Future<Courts>();
      Backendless.Data.of( Courts.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Courts> callback )
  {
    Backendless.Data.of( Courts.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Courts.class ).remove( this );
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
      Backendless.Data.of( Courts.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Courts.class ).remove( this, callback );
  }

  public static Courts findById( String id )
  {
    return Backendless.Data.of( Courts.class ).findById( id );
  }

  public static Future<Courts> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Courts> future = new Future<Courts>();
      Backendless.Data.of( Courts.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Courts> callback )
  {
    Backendless.Data.of( Courts.class ).findById( id, callback );
  }

  public static Courts findFirst()
  {
    return Backendless.Data.of( Courts.class ).findFirst();
  }

  public static Future<Courts> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Courts> future = new Future<Courts>();
      Backendless.Data.of( Courts.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Courts> callback )
  {
    Backendless.Data.of( Courts.class ).findFirst( callback );
  }

  public static Courts findLast()
  {
    return Backendless.Data.of( Courts.class ).findLast();
  }

  public static Future<Courts> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Courts> future = new Future<Courts>();
      Backendless.Data.of( Courts.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Courts> callback )
  {
    Backendless.Data.of( Courts.class ).findLast( callback );
  }

  public static BackendlessCollection<Courts> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Courts.class ).find( query );
  }

  public static Future<BackendlessCollection<Courts>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Courts>> future = new Future<BackendlessCollection<Courts>>();
      Backendless.Data.of( Courts.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Courts>> callback )
  {
    Backendless.Data.of( Courts.class ).find( query, callback );
  }
}