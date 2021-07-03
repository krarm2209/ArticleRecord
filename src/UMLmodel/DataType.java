/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/
package UMLmodel;

import java.util.*;

// line 47 "model.ump"
// line 113 "model.ump"
// line 148 "model.ump"
public class DataType
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Type { Qualitative, Quantitative, Mixed }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //DataType Attributes
  private Type type;

  //DataType Associations
  private List<Article> articles;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public DataType(Type aType)
  {
    type = aType;
    articles = new ArrayList<Article>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setType(Type aType)
  {
    boolean wasSet = false;
    type = aType;
    wasSet = true;
    return wasSet;
  }

  public Type getType()
  {
    return type;
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
  /* Code from template association_AddManyToOne */
  public Article addArticle(String aAuthor, int aPubYear, String aTitle, Journal aJournal)
  {
    return new Article(aAuthor, aPubYear, aTitle, aJournal, this);
  }

  public boolean addArticle(Article aArticle)
  {
    boolean wasAdded = false;
    if (articles.contains(aArticle)) { return false; }
    DataType existingDataType = aArticle.getDataType();
    boolean isNewDataType = existingDataType != null && !this.equals(existingDataType);
    if (isNewDataType)
    {
      aArticle.setDataType(this);
    }
    else
    {
      articles.add(aArticle);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeArticle(Article aArticle)
  {
    boolean wasRemoved = false;
    //Unable to remove aArticle, as it must always have a dataType
    if (!this.equals(aArticle.getDataType()))
    {
      articles.remove(aArticle);
      wasRemoved = true;
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
    for(int i=articles.size(); i > 0; i--)
    {
      Article aArticle = articles.get(i - 1);
      aArticle.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "type" + "=" + (getType() != null ? !getType().equals(this)  ? getType().toString().replaceAll("  ","    ") : "this" : "null");
  }
}