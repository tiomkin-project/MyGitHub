package by.tut.tiomkin.businessmonitor_api.network.data;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class Address
{
  private String Address;
  private java.util.Date updated;
  private java.util.Date created;
  private String objectId;
  private String ownerId;
  public String getAddress()
  {
    return Address;
  }

  public void setAddress( String Address )
  {
    this.Address = Address;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

                                                    
  public Address save()
  {
    return Backendless.Data.of( Address.class ).save( this );
  }

  public Future<Address> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Address> future = new Future<Address>();
      Backendless.Data.of( Address.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<Address> callback )
  {
    Backendless.Data.of( Address.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( Address.class ).remove( this );
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
      Backendless.Data.of( Address.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( Address.class ).remove( this, callback );
  }

  public static Address findById( String id )
  {
    return Backendless.Data.of( Address.class ).findById( id );
  }

  public static Future<Address> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Address> future = new Future<Address>();
      Backendless.Data.of( Address.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<Address> callback )
  {
    Backendless.Data.of( Address.class ).findById( id, callback );
  }

  public static Address findFirst()
  {
    return Backendless.Data.of( Address.class ).findFirst();
  }

  public static Future<Address> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Address> future = new Future<Address>();
      Backendless.Data.of( Address.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<Address> callback )
  {
    Backendless.Data.of( Address.class ).findFirst( callback );
  }

  public static Address findLast()
  {
    return Backendless.Data.of( Address.class ).findLast();
  }

  public static Future<Address> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<Address> future = new Future<Address>();
      Backendless.Data.of( Address.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<Address> callback )
  {
    Backendless.Data.of( Address.class ).findLast( callback );
  }

  public static BackendlessCollection<Address> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( Address.class ).find( query );
  }

  public static Future<BackendlessCollection<Address>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<Address>> future = new Future<BackendlessCollection<Address>>();
      Backendless.Data.of( Address.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<Address>> callback )
  {
    Backendless.Data.of( Address.class ).find( query, callback );
  }
}