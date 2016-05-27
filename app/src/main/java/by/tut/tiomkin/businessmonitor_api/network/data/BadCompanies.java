package by.tut.tiomkin.businessmonitor_api.network.data;

import com.backendless.Backendless;
import com.backendless.BackendlessCollection;
import com.backendless.BackendlessUser;
import com.backendless.async.callback.AsyncCallback;
import com.backendless.geo.GeoPoint;
import com.backendless.persistence.BackendlessDataQuery;

public class BadCompanies
{
  private String unp;
  private java.util.Date created;
  private String name;
  private String ownerId;
  private String article;
  private String objectId;
  private String date_included;
  private java.util.Date updated;
  public String getUnp()
  {
    return unp;
  }

  public void setUnp( String unp )
  {
    this.unp = unp;
  }

  public java.util.Date getCreated()
  {
    return created;
  }

  public String getName()
  {
    return name;
  }

  public void setName( String name )
  {
    this.name = name;
  }

  public String getOwnerId()
  {
    return ownerId;
  }

  public String getArticle()
  {
    return article;
  }

  public void setArticle( String article )
  {
    this.article = article;
  }

  public String getObjectId()
  {
    return objectId;
  }

  public String getDate_included()
  {
    return date_included;
  }

  public void setDate_included( String date_included )
  {
    this.date_included = date_included;
  }

  public java.util.Date getUpdated()
  {
    return updated;
  }

                                                    
  public BadCompanies save()
  {
    return Backendless.Data.of( BadCompanies.class ).save( this );
  }

  public Future<BadCompanies> saveAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BadCompanies> future = new Future<BadCompanies>();
      Backendless.Data.of( BadCompanies.class ).save( this, future );

      return future;
    }
  }

  public void saveAsync( AsyncCallback<BadCompanies> callback )
  {
    Backendless.Data.of( BadCompanies.class ).save( this, callback );
  }

  public Long remove()
  {
    return Backendless.Data.of( BadCompanies.class ).remove( this );
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
      Backendless.Data.of( BadCompanies.class ).remove( this, future );

      return future;
    }
  }

  public void removeAsync( AsyncCallback<Long> callback )
  {
    Backendless.Data.of( BadCompanies.class ).remove( this, callback );
  }

  public static BadCompanies findById( String id )
  {
    return Backendless.Data.of( BadCompanies.class ).findById( id );
  }

  public static Future<BadCompanies> findByIdAsync( String id )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BadCompanies> future = new Future<BadCompanies>();
      Backendless.Data.of( BadCompanies.class ).findById( id, future );

      return future;
    }
  }

  public static void findByIdAsync( String id, AsyncCallback<BadCompanies> callback )
  {
    Backendless.Data.of( BadCompanies.class ).findById( id, callback );
  }

  public static BadCompanies findFirst()
  {
    return Backendless.Data.of( BadCompanies.class ).findFirst();
  }

  public static Future<BadCompanies> findFirstAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BadCompanies> future = new Future<BadCompanies>();
      Backendless.Data.of( BadCompanies.class ).findFirst( future );

      return future;
    }
  }

  public static void findFirstAsync( AsyncCallback<BadCompanies> callback )
  {
    Backendless.Data.of( BadCompanies.class ).findFirst( callback );
  }

  public static BadCompanies findLast()
  {
    return Backendless.Data.of( BadCompanies.class ).findLast();
  }

  public static Future<BadCompanies> findLastAsync()
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BadCompanies> future = new Future<BadCompanies>();
      Backendless.Data.of( BadCompanies.class ).findLast( future );

      return future;
    }
  }

  public static void findLastAsync( AsyncCallback<BadCompanies> callback )
  {
    Backendless.Data.of( BadCompanies.class ).findLast( callback );
  }

  public static BackendlessCollection<BadCompanies> find( BackendlessDataQuery query )
  {
    return Backendless.Data.of( BadCompanies.class ).find( query );
  }

  public static Future<BackendlessCollection<BadCompanies>> findAsync( BackendlessDataQuery query )
  {
    if( Backendless.isAndroid() )
    {
      throw new UnsupportedOperationException( "Using this method is restricted in Android" );
    }
    else
    {
      Future<BackendlessCollection<BadCompanies>> future = new Future<BackendlessCollection<BadCompanies>>();
      Backendless.Data.of( BadCompanies.class ).find( query, future );

      return future;
    }
  }

  public static void findAsync( BackendlessDataQuery query, AsyncCallback<BackendlessCollection<BadCompanies>> callback )
  {
    Backendless.Data.of( BadCompanies.class ).find( query, callback );
  }
}