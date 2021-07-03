/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/
package UMLmodel;

import java.util.*;

// line 2 "model.ump"
// line 79 "model.ump"
// line 123 "model.ump"
public class Article
{

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Article Attributes
  private String author;
  private int pubYear;
  private String title;

  //Article Associations
  private List<Location> locations;
  private Journal journal;
  private List<ResearchMethods> researchMethods;
  private List<Topic> topics;
  private List<Mine> mines;
  private DataType dataType;
  private List<PMLU> pMLUs;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Article(String aAuthor, int aPubYear, String aTitle, Journal aJournal, DataType aDataType)
  {
    author = aAuthor;
    pubYear = aPubYear;
    title = aTitle;
    locations = new ArrayList<Location>();
    boolean didAddJournal = setJournal(aJournal);
    if (!didAddJournal)
    {
      throw new RuntimeException("Unable to create article due to journal. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    researchMethods = new ArrayList<ResearchMethods>();
    topics = new ArrayList<Topic>();
    mines = new ArrayList<Mine>();
    boolean didAddDataType = setDataType(aDataType);
    if (!didAddDataType)
    {
      throw new RuntimeException("Unable to create article due to dataType. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
    pMLUs = new ArrayList<PMLU>();
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setAuthor(String aAuthor)
  {
    boolean wasSet = false;
    author = aAuthor;
    wasSet = true;
    return wasSet;
  }

  public boolean setPubYear(int aPubYear)
  {
    boolean wasSet = false;
    pubYear = aPubYear;
    wasSet = true;
    return wasSet;
  }

  public boolean setTitle(String aTitle)
  {
    boolean wasSet = false;
    title = aTitle;
    wasSet = true;
    return wasSet;
  }

  public String getAuthor()
  {
    return author;
  }

  public int getPubYear()
  {
    return pubYear;
  }

  public String getTitle()
  {
    return title;
  }
  /* Code from template association_GetMany */
  public Location getLocation(int index)
  {
    Location aLocation = locations.get(index);
    return aLocation;
  }

  public List<Location> getLocations()
  {
    List<Location> newLocations = Collections.unmodifiableList(locations);
    return newLocations;
  }

  public int numberOfLocations()
  {
    int number = locations.size();
    return number;
  }

  public boolean hasLocations()
  {
    boolean has = locations.size() > 0;
    return has;
  }

  public int indexOfLocation(Location aLocation)
  {
    int index = locations.indexOf(aLocation);
    return index;
  }
  /* Code from template association_GetOne */
  public Journal getJournal()
  {
    return journal;
  }
  /* Code from template association_GetMany */
  public ResearchMethods getResearchMethod(int index)
  {
    ResearchMethods aResearchMethod = researchMethods.get(index);
    return aResearchMethod;
  }

  public List<ResearchMethods> getResearchMethods()
  {
    List<ResearchMethods> newResearchMethods = Collections.unmodifiableList(researchMethods);
    return newResearchMethods;
  }

  public int numberOfResearchMethods()
  {
    int number = researchMethods.size();
    return number;
  }

  public boolean hasResearchMethods()
  {
    boolean has = researchMethods.size() > 0;
    return has;
  }

  public int indexOfResearchMethod(ResearchMethods aResearchMethod)
  {
    int index = researchMethods.indexOf(aResearchMethod);
    return index;
  }
  /* Code from template association_GetMany */
  public Topic getTopic(int index)
  {
    Topic aTopic = topics.get(index);
    return aTopic;
  }

  public List<Topic> getTopics()
  {
    List<Topic> newTopics = Collections.unmodifiableList(topics);
    return newTopics;
  }

  public int numberOfTopics()
  {
    int number = topics.size();
    return number;
  }

  public boolean hasTopics()
  {
    boolean has = topics.size() > 0;
    return has;
  }

  public int indexOfTopic(Topic aTopic)
  {
    int index = topics.indexOf(aTopic);
    return index;
  }
  /* Code from template association_GetMany */
  public Mine getMine(int index)
  {
    Mine aMine = mines.get(index);
    return aMine;
  }

  public List<Mine> getMines()
  {
    List<Mine> newMines = Collections.unmodifiableList(mines);
    return newMines;
  }

  public int numberOfMines()
  {
    int number = mines.size();
    return number;
  }

  public boolean hasMines()
  {
    boolean has = mines.size() > 0;
    return has;
  }

  public int indexOfMine(Mine aMine)
  {
    int index = mines.indexOf(aMine);
    return index;
  }
  /* Code from template association_GetOne */
  public DataType getDataType()
  {
    return dataType;
  }
  /* Code from template association_GetMany */
  public PMLU getPMLU(int index)
  {
    PMLU aPMLU = pMLUs.get(index);
    return aPMLU;
  }

  public List<PMLU> getPMLUs()
  {
    List<PMLU> newPMLUs = Collections.unmodifiableList(pMLUs);
    return newPMLUs;
  }

  public int numberOfPMLUs()
  {
    int number = pMLUs.size();
    return number;
  }

  public boolean hasPMLUs()
  {
    boolean has = pMLUs.size() > 0;
    return has;
  }

  public int indexOfPMLU(PMLU aPMLU)
  {
    int index = pMLUs.indexOf(aPMLU);
    return index;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfLocations()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addLocation(Location aLocation)
  {
    boolean wasAdded = false;
    if (locations.contains(aLocation)) { return false; }
    locations.add(aLocation);
    if (aLocation.indexOfArticle(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aLocation.addArticle(this);
      if (!wasAdded)
      {
        locations.remove(aLocation);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeLocation(Location aLocation)
  {
    boolean wasRemoved = false;
    if (!locations.contains(aLocation))
    {
      return wasRemoved;
    }

    int oldIndex = locations.indexOf(aLocation);
    locations.remove(oldIndex);
    if (aLocation.indexOfArticle(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aLocation.removeArticle(this);
      if (!wasRemoved)
      {
        locations.add(oldIndex,aLocation);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addLocationAt(Location aLocation, int index)
  {  
    boolean wasAdded = false;
    if(addLocation(aLocation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLocations()) { index = numberOfLocations() - 1; }
      locations.remove(aLocation);
      locations.add(index, aLocation);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveLocationAt(Location aLocation, int index)
  {
    boolean wasAdded = false;
    if(locations.contains(aLocation))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfLocations()) { index = numberOfLocations() - 1; }
      locations.remove(aLocation);
      locations.add(index, aLocation);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addLocationAt(aLocation, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setJournal(Journal aJournal)
  {
    boolean wasSet = false;
    if (aJournal == null)
    {
      return wasSet;
    }

    Journal existingJournal = journal;
    journal = aJournal;
    if (existingJournal != null && !existingJournal.equals(aJournal))
    {
      existingJournal.removeArticle(this);
    }
    journal.addArticle(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfResearchMethods()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addResearchMethod(ResearchMethods aResearchMethod)
  {
    boolean wasAdded = false;
    if (researchMethods.contains(aResearchMethod)) { return false; }
    researchMethods.add(aResearchMethod);
    if (aResearchMethod.indexOfArticle(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aResearchMethod.addArticle(this);
      if (!wasAdded)
      {
        researchMethods.remove(aResearchMethod);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeResearchMethod(ResearchMethods aResearchMethod)
  {
    boolean wasRemoved = false;
    if (!researchMethods.contains(aResearchMethod))
    {
      return wasRemoved;
    }

    int oldIndex = researchMethods.indexOf(aResearchMethod);
    researchMethods.remove(oldIndex);
    if (aResearchMethod.indexOfArticle(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aResearchMethod.removeArticle(this);
      if (!wasRemoved)
      {
        researchMethods.add(oldIndex,aResearchMethod);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addResearchMethodAt(ResearchMethods aResearchMethod, int index)
  {  
    boolean wasAdded = false;
    if(addResearchMethod(aResearchMethod))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfResearchMethods()) { index = numberOfResearchMethods() - 1; }
      researchMethods.remove(aResearchMethod);
      researchMethods.add(index, aResearchMethod);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveResearchMethodAt(ResearchMethods aResearchMethod, int index)
  {
    boolean wasAdded = false;
    if(researchMethods.contains(aResearchMethod))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfResearchMethods()) { index = numberOfResearchMethods() - 1; }
      researchMethods.remove(aResearchMethod);
      researchMethods.add(index, aResearchMethod);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addResearchMethodAt(aResearchMethod, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfTopics()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addTopic(Topic aTopic)
  {
    boolean wasAdded = false;
    if (topics.contains(aTopic)) { return false; }
    topics.add(aTopic);
    if (aTopic.indexOfArticle(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aTopic.addArticle(this);
      if (!wasAdded)
      {
        topics.remove(aTopic);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removeTopic(Topic aTopic)
  {
    boolean wasRemoved = false;
    if (!topics.contains(aTopic))
    {
      return wasRemoved;
    }

    int oldIndex = topics.indexOf(aTopic);
    topics.remove(oldIndex);
    if (aTopic.indexOfArticle(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aTopic.removeArticle(this);
      if (!wasRemoved)
      {
        topics.add(oldIndex,aTopic);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addTopicAt(Topic aTopic, int index)
  {  
    boolean wasAdded = false;
    if(addTopic(aTopic))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTopics()) { index = numberOfTopics() - 1; }
      topics.remove(aTopic);
      topics.add(index, aTopic);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveTopicAt(Topic aTopic, int index)
  {
    boolean wasAdded = false;
    if(topics.contains(aTopic))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfTopics()) { index = numberOfTopics() - 1; }
      topics.remove(aTopic);
      topics.add(index, aTopic);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addTopicAt(aTopic, index);
    }
    return wasAdded;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfMines()
  {
    return 0;
  }
  /* Code from template association_AddManyToOne */
  public Mine addMine(String aCommodity, Mine.MinMethod aMiningMethod)
  {
    return new Mine(aCommodity, aMiningMethod, this);
  }

  public boolean addMine(Mine aMine)
  {
    boolean wasAdded = false;
    if (mines.contains(aMine)) { return false; }
    Article existingArticle = aMine.getArticle();
    boolean isNewArticle = existingArticle != null && !this.equals(existingArticle);
    if (isNewArticle)
    {
      aMine.setArticle(this);
    }
    else
    {
      mines.add(aMine);
    }
    wasAdded = true;
    return wasAdded;
  }

  public boolean removeMine(Mine aMine)
  {
    boolean wasRemoved = false;
    //Unable to remove aMine, as it must always have a article
    if (!this.equals(aMine.getArticle()))
    {
      mines.remove(aMine);
      wasRemoved = true;
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addMineAt(Mine aMine, int index)
  {  
    boolean wasAdded = false;
    if(addMine(aMine))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMines()) { index = numberOfMines() - 1; }
      mines.remove(aMine);
      mines.add(index, aMine);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMoveMineAt(Mine aMine, int index)
  {
    boolean wasAdded = false;
    if(mines.contains(aMine))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfMines()) { index = numberOfMines() - 1; }
      mines.remove(aMine);
      mines.add(index, aMine);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addMineAt(aMine, index);
    }
    return wasAdded;
  }
  /* Code from template association_SetOneToMany */
  public boolean setDataType(DataType aDataType)
  {
    boolean wasSet = false;
    if (aDataType == null)
    {
      return wasSet;
    }

    DataType existingDataType = dataType;
    dataType = aDataType;
    if (existingDataType != null && !existingDataType.equals(aDataType))
    {
      existingDataType.removeArticle(this);
    }
    dataType.addArticle(this);
    wasSet = true;
    return wasSet;
  }
  /* Code from template association_MinimumNumberOfMethod */
  public static int minimumNumberOfPMLUs()
  {
    return 0;
  }
  /* Code from template association_AddManyToManyMethod */
  public boolean addPMLU(PMLU aPMLU)
  {
    boolean wasAdded = false;
    if (pMLUs.contains(aPMLU)) { return false; }
    pMLUs.add(aPMLU);
    if (aPMLU.indexOfArticle(this) != -1)
    {
      wasAdded = true;
    }
    else
    {
      wasAdded = aPMLU.addArticle(this);
      if (!wasAdded)
      {
        pMLUs.remove(aPMLU);
      }
    }
    return wasAdded;
  }
  /* Code from template association_RemoveMany */
  public boolean removePMLU(PMLU aPMLU)
  {
    boolean wasRemoved = false;
    if (!pMLUs.contains(aPMLU))
    {
      return wasRemoved;
    }

    int oldIndex = pMLUs.indexOf(aPMLU);
    pMLUs.remove(oldIndex);
    if (aPMLU.indexOfArticle(this) == -1)
    {
      wasRemoved = true;
    }
    else
    {
      wasRemoved = aPMLU.removeArticle(this);
      if (!wasRemoved)
      {
        pMLUs.add(oldIndex,aPMLU);
      }
    }
    return wasRemoved;
  }
  /* Code from template association_AddIndexControlFunctions */
  public boolean addPMLUAt(PMLU aPMLU, int index)
  {  
    boolean wasAdded = false;
    if(addPMLU(aPMLU))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPMLUs()) { index = numberOfPMLUs() - 1; }
      pMLUs.remove(aPMLU);
      pMLUs.add(index, aPMLU);
      wasAdded = true;
    }
    return wasAdded;
  }

  public boolean addOrMovePMLUAt(PMLU aPMLU, int index)
  {
    boolean wasAdded = false;
    if(pMLUs.contains(aPMLU))
    {
      if(index < 0 ) { index = 0; }
      if(index > numberOfPMLUs()) { index = numberOfPMLUs() - 1; }
      pMLUs.remove(aPMLU);
      pMLUs.add(index, aPMLU);
      wasAdded = true;
    } 
    else 
    {
      wasAdded = addPMLUAt(aPMLU, index);
    }
    return wasAdded;
  }

  public void delete()
  {
    ArrayList<Location> copyOfLocations = new ArrayList<Location>(locations);
    locations.clear();
    for(Location aLocation : copyOfLocations)
    {
      aLocation.removeArticle(this);
    }
    Journal placeholderJournal = journal;
    this.journal = null;
    if(placeholderJournal != null)
    {
      placeholderJournal.removeArticle(this);
    }
    ArrayList<ResearchMethods> copyOfResearchMethods = new ArrayList<ResearchMethods>(researchMethods);
    researchMethods.clear();
    for(ResearchMethods aResearchMethod : copyOfResearchMethods)
    {
      aResearchMethod.removeArticle(this);
    }
    ArrayList<Topic> copyOfTopics = new ArrayList<Topic>(topics);
    topics.clear();
    for(Topic aTopic : copyOfTopics)
    {
      aTopic.removeArticle(this);
    }
    for(int i=mines.size(); i > 0; i--)
    {
      Mine aMine = mines.get(i - 1);
      aMine.delete();
    }
    DataType placeholderDataType = dataType;
    this.dataType = null;
    if(placeholderDataType != null)
    {
      placeholderDataType.removeArticle(this);
    }
    ArrayList<PMLU> copyOfPMLUs = new ArrayList<PMLU>(pMLUs);
    pMLUs.clear();
    for(PMLU aPMLU : copyOfPMLUs)
    {
      aPMLU.removeArticle(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "author" + ":" + getAuthor()+ "," +
            "pubYear" + ":" + getPubYear()+ "," +
            "title" + ":" + getTitle()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "journal = "+(getJournal()!=null?Integer.toHexString(System.identityHashCode(getJournal())):"null") + System.getProperties().getProperty("line.separator") +
            "  " + "dataType = "+(getDataType()!=null?Integer.toHexString(System.identityHashCode(getDataType())):"null");
  }
}