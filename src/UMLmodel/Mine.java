/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/
package UMLmodel;


// line 60 "model.ump"
// line 163 "model.ump"
public class Mine
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum MinMethod { OpenPit, Underground, Placer, InSitu, Mixed }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //Mine Attributes
  private String commodity;
  private MinMethod miningMethod;

  //Mine Associations
  private Article article;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public Mine(String aCommodity, MinMethod aMiningMethod, Article aArticle)
  {
    commodity = aCommodity;
    miningMethod = aMiningMethod;
    boolean didAddArticle = setArticle(aArticle);
    if (!didAddArticle)
    {
      throw new RuntimeException("Unable to create mine due to article. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setCommodity(String aCommodity)
  {
    boolean wasSet = false;
    commodity = aCommodity;
    wasSet = true;
    return wasSet;
  }

  public boolean setMiningMethod(MinMethod aMiningMethod)
  {
    boolean wasSet = false;
    miningMethod = aMiningMethod;
    wasSet = true;
    return wasSet;
  }

  public String getCommodity()
  {
    return commodity;
  }

  public MinMethod getMiningMethod()
  {
    return miningMethod;
  }
  /* Code from template association_GetOne */
  public Article getArticle()
  {
    return article;
  }
  /* Code from template association_SetOneToMany */
  public boolean setArticle(Article aArticle)
  {
    boolean wasSet = false;
    if (aArticle == null)
    {
      return wasSet;
    }

    Article existingArticle = article;
    article = aArticle;
    if (existingArticle != null && !existingArticle.equals(aArticle))
    {
      existingArticle.removeMine(this);
    }
    article.addMine(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Article placeholderArticle = article;
    this.article = null;
    if(placeholderArticle != null)
    {
      placeholderArticle.removeMine(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "commodity" + ":" + getCommodity()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "miningMethod" + "=" + (getMiningMethod() != null ? !getMiningMethod().equals(this)  ? getMiningMethod().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "article = "+(getArticle()!=null?Integer.toHexString(System.identityHashCode(getArticle())):"null");
  }
}