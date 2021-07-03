/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/
package UMLmodel;

import java.util.*;

// line 40 "model.ump"
// line 108 "model.ump"
// line 143 "model.ump"
public class ResearchMethods
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Method { Experimental, Modelling, Observational, Survey, Interviews, FieldStudies, CaseStudies, DocumentAnalysis, MetaAnalysis, Other }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //ResearchMethods Attributes
  private Method method;
  private String specify;

  //ResearchMethods Associations
  private List<Article> articles;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public ResearchMethods(Method aMethod, String aSpecify)
  {
    method = aMethod;
    specify = aSpecify;
    articles = new ArrayList<Article>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setMethod(Method aMethod)
  {
    boolean wasSet = false;
    method = aMethod;
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

  public Method getMethod()
  {
    return method;
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
    if (aArticle.indexOfResearchMethod(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aArticle.addResearchMethod(this);
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
    if (aArticle.indexOfResearchMethod(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aArticle.removeResearchMethod(this);
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
      aArticle.removeResearchMethod(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "specify" + ":" + getSpecify()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "method" + "=" + (getMethod() != null ? !getMethod().equals(this)  ? getMethod().toString().replaceAll("  ","    ") : "this" : "null");
  }
}