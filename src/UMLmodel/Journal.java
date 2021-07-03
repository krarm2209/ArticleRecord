/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/
package UMLmodel;

import java.util.*;

// line 27 "model.ump"
// line 97 "model.ump"
// line 133 "model.ump"
public class Journal
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Journal Attributes
  private String name;

  //Journal Associations
  private List<JournalDiscipline> journalDisciplines;
  private List<Article> articles;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Journal(String aName)
  {
    name = aName;
    journalDisciplines = new ArrayList<JournalDiscipline>();
    articles = new ArrayList<Article>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setName(String aName)
  {
    boolean wasSet = false;
    name = aName;
    wasSet = true;
    return wasSet;
  }

  public String getName()
  {
    return name;
  }
  /* Code from template association_GetMany */
  public JournalDiscipline getJournalDiscipline(int index)
  {
    JournalDiscipline aJournalDiscipline = journalDisciplines.get(index);
    return aJournalDiscipline;
  }

  public List<JournalDiscipline> getJournalDisciplines()
  {
    List<JournalDiscipline> newJournalDisciplines = Collections.unmodifiableList(journalDisciplines);
    return newJournalDisciplines;
  }

  public int numberOfJournalDisciplines()
  {
    int number = journalDisciplines.size();
    return number;
  }

  public boolean hasJournalDisciplines()
  {
    boolean has = journalDisciplines.size() > 0;
    return has;
  }

  public int indexOfJournalDiscipline(JournalDiscipline aJournalDiscipline)
  {
    int index = journalDisciplines.indexOf(aJournalDiscipline);
    return index;
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
  public static int minimumNumberOfJournalDisciplines()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public JournalDiscipline addJournalDiscipline(JournalDiscipline.Discipline aDiscipline, String aSpecify)
  {
    return new JournalDiscipline(aDiscipline, aSpecify, this);
  }

  public boolean addJournalDiscipline(JournalDiscipline aJournalDiscipline)
  {
    boolean wasAdded = false;
    if (journalDisciplines.contains(aJournalDiscipline)) { return false; }
    Journal existingJournal = aJournalDiscipline.getJournal();
    boolean isNewJournal = existingJournal != null && !this.equals(existingJournal);
    if (isNewJournal)
    {
      aJournalDiscipline.setJournal(this);
    }
    else
    {
      journalDisciplines.add(aJournalDiscipline);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeJournalDiscipline(JournalDiscipline aJournalDiscipline)
  {
    boolean wasRemoved = false;
    //Unable to remove aJournalDiscipline, as it must always have a journal
    if (!this.equals(aJournalDiscipline.getJournal()))
    {
      journalDisciplines.remove(aJournalDiscipline);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addJournalDisciplineAt(JournalDiscipline aJournalDiscipline, int index)
  {  
    boolean wasAdded = false;
    if(addJournalDiscipline(aJournalDiscipline))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfJournalDisciplines()) { index = numberOfJournalDisciplines() - 1; }
      journalDisciplines.remove(aJournalDiscipline);
      journalDisciplines.add(index, aJournalDiscipline);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveJournalDisciplineAt(JournalDiscipline aJournalDiscipline, int index)
  {
    boolean wasAdded = false;
    if(journalDisciplines.contains(aJournalDiscipline))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfJournalDisciplines()) { index = numberOfJournalDisciplines() - 1; }
      journalDisciplines.remove(aJournalDiscipline);
      journalDisciplines.add(index, aJournalDiscipline);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addJournalDisciplineAt(aJournalDiscipline, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfArticles()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Article addArticle(String aAuthor, int aPubYear, String aTitle, DataType aDataType)
  {
    return new Article(aAuthor, aPubYear, aTitle, this, aDataType);
  }

  public boolean addArticle(Article aArticle)
  {
    boolean wasAdded = false;
    if (articles.contains(aArticle)) { return false; }
    Journal existingJournal = aArticle.getJournal();
    boolean isNewJournal = existingJournal != null && !this.equals(existingJournal);
    if (isNewJournal)
    {
      aArticle.setJournal(this);
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
    //Unable to remove aArticle, as it must always have a journal
    if (!this.equals(aArticle.getJournal()))
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
    for(int i=journalDisciplines.size(); i > 0; i--)
    {
      JournalDiscipline aJournalDiscipline = journalDisciplines.get(i - 1);
      aJournalDiscipline.delete();
    }
    for(int i=articles.size(); i > 0; i--)
    {
      Article aArticle = articles.get(i - 1);
      aArticle.delete();
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "name" + ":" + getName()+ "]";
  }
}