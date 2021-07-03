/*PLEASE DO NOT EDIT THIS CODE*/
/*This code was generated using the UMPLE 1.30.2.5248.dba0a5744 modeling language!*/
package UMLmodel;


// line 33 "model.ump"
// line 103 "model.ump"
// line 138 "model.ump"
public class JournalDiscipline
{

  //------------------------
  // ENUMERATIONS
  //------------------------

  public enum Discipline { ScienceEnvironment, Policy, Energy, Economics, Engineering, Sustainability, Other }

  //------------------------
  // MEMBER VARIABLES
  //------------------------

  //JournalDiscipline Attributes
  private Discipline discipline;
  private String specify;

  //JournalDiscipline Associations
  private Journal journal;

  //------------------------
  // CONSTRUCTOR
  //------------------------

  public JournalDiscipline(Discipline aDiscipline, String aSpecify, Journal aJournal)
  {
    discipline = aDiscipline;
    specify = aSpecify;
    boolean didAddJournal = setJournal(aJournal);
    if (!didAddJournal)
    {
      throw new RuntimeException("Unable to create journalDiscipline due to journal. See http://manual.umple.org?RE002ViolationofAssociationMultiplicity.html");
    }
  }

  //------------------------
  // INTERFACE
  //------------------------

  public boolean setDiscipline(Discipline aDiscipline)
  {
    boolean wasSet = false;
    discipline = aDiscipline;
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

  public Discipline getDiscipline()
  {
    return discipline;
  }

  public String getSpecify()
  {
    return specify;
  }
  /* Code from template association_GetOne */
  public Journal getJournal()
  {
    return journal;
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
      existingJournal.removeJournalDiscipline(this);
    }
    journal.addJournalDiscipline(this);
    wasSet = true;
    return wasSet;
  }

  public void delete()
  {
    Journal placeholderJournal = journal;
    this.journal = null;
    if(placeholderJournal != null)
    {
      placeholderJournal.removeJournalDiscipline(this);
    }
  }


  public String toString()
  {
    return super.toString() + "["+
            "specify" + ":" + getSpecify()+ "]" + System.getProperties().getProperty("line.separator") +
            "  " + "discipline" + "=" + (getDiscipline() != null ? !getDiscipline().equals(this)  ? getDiscipline().toString().replaceAll("  ","    ") : "this" : "null") + System.getProperties().getProperty("line.separator") +
            "  " + "journal = "+(getJournal()!=null?Integer.toHexString(System.identityHashCode(getJournal())):"null");
  }
}