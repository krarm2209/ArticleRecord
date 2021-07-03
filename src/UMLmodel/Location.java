/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/
package UMLmodel;

import java.util.*;

// line 16 "model.ump"
// line 92 "model.ump"
// line 128 "model.ump"
public class Location
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Region { Africa, Asia, Oceania, Europe, NorthAmerica, SouthAmerica, Other }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Location Attributes
  private Region region;
  private String country;
  private String state;
  private String city;
  private String specify;

  //Location Associations
  private List<Article> articles;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Location(Region aRegion, String aCountry, String aState, String aCity, String aSpecify)
  {
    region = aRegion;
    country = aCountry;
    state = aState;
    city = aCity;
    specify = aSpecify;
    articles = new ArrayList<Article>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setRegion(Region aRegion)
  {
    boolean wasSet = false;
    region = aRegion;
    wasSet = true;
    return wasSet;
  }

  public boolean setCountry(String aCountry)
  {
    boolean wasSet = false;
    country = aCountry;
    wasSet = true;
    return wasSet;
  }

  public boolean setState(String aState)
  {
    boolean wasSet = false;
    state = aState;
    wasSet = true;
    return wasSet;
  }

  public boolean setCity(String aCity)
  {
    boolean wasSet = false;
    city = aCity;
    wasSet = true;
    return wasSet;
  }

  public boolean setSpecify(String aSpecify)
  {
    boolean wasSet = false;
    specify = aSpecify;
    wasSet = true;
    return wasSet;
  }

  public Region getRegion()
  {
    return region;
  }

  public String getCountry()
  {
    return country;
  }

  public String getState()
  {
    return state;
  }

  public String getCity()
  {
    return city;
  }

  public String getSpecify()
  {
    return specify;
  }
  /* Code from template association_GetMany */
  public Article getArticle(int index)
  {
    Article aArticle = articles.get(index);
    return aArticle;
  }

  public List<Article> getArticles()
  {
    List<Article> newArticles = Collections.unmodifiableList(articles);
    return newArticles;
  }

  public int numberOfArticles()
  {
    int number = articles.size();
    return number;
  }

  public boolean hasArticles()
  {
    boolean has = articles.size() > 0;
    return has;
  }

  public int indexOfArticle(Article aArticle)
  {
    int index = articles.indexOf(aArticle);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfArticles()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addArticle(Article aArticle)
  {
    boolean wasAdded = false;
    if (articles.contains(aArticle)) { return false; }
    articles.add(aArticle);
    if (aArticle.indexOfLocation(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aArticle.addLocation(this);
      if (!wasAdded)
      {
        articles.remove(aArticle);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeArticle(Article aArticle)
  {
    boolean wasRemoved = false;
    if (!articles.contains(aArticle))
    {
      return wasRemoved;
    }

    int oldIndex = articles.indexOf(aArticle);
    articles.remove(oldIndex);
    if (aArticle.indexOfLocation(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aArticle.removeLocation(this);
      if (!wasRemoved)
      {
        articles.add(oldIndex,aArticle);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addArticleAt(Article aArticle, int index)
  {  
    boolean wasAdded = false;
    if(addArticle(aArticle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArticles()) { index = numberOfArticles() - 1; }
      articles.remove(aArticle);
      articles.add(index, aArticle);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveArticleAt(Article aArticle, int index)
  {
    boolean wasAdded = false;
    if(articles.contains(aArticle))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfArticles()) { index = numberOfArticles() - 1; }
      articles.remove(aArticle);
      articles.add(index, aArticle);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addArticleAt(aArticle, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Article> copyOfArticles = new ArrayList<Article>(articles);
    articles.clear();
    for(Article aArticle : copyOfArticles)
    {
      aArticle.removeLocation(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "country" + ":" + getCountry()+ "," +
            "state" + ":" + getState()+ "," +
            "city" + ":" + getCity()+ "," +
            "specify" + ":" + getSpecify()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "region" + "=" + (getRegion() != null ? !getRegion().equals(this)  ? getRegion().toString().replaceAll("  ","    ") : "this" : "null");
  }
}