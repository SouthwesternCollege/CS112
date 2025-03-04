package lab02;
public class RevisedHistoricalEvent extends HistoricalEvent
{
    public static final String DEFAULT_REVISED_DESCRIPTION = "Revised Historical event description default.";
    public static final String DEFAULT_CITATION = "Academic resource/citation";


    private String revisedDescription;
    private String citation;

    public RevisedHistoricalEvent(String description, Date eventDay, String revisedDescription, String citation)
    {
        super(description, eventDay);
        this.setRevisedDescription(revisedDescription);
        this.setCitation(citation);
    }

    public RevisedHistoricalEvent()
    {
        this(HistoricalEvent.DEFAULT_DESCRIPTION, HistoricalEvent.DEFAULT_EVENT_DAY, DEFAULT_REVISED_DESCRIPTION, DEFAULT_CITATION);
    }

    public void setRevisedDescription(String revisedDescription) {
        this.revisedDescription = revisedDescription;
    }
    public void setCitation(String citation) {
        this.citation = citation;
    }

    public boolean setAll(String description, Date eventDay, String revisedDescription, String citation)
    {
        if(!super.setAll(revisedDescription, eventDay))
        {
            this.setRevisedDescription(revisedDescription);
            this.setCitation(citation);
            return true;
        }
        else
        {
            return false;
        }
    }

    public String getRevisedDescription() {
        return revisedDescription;
    }
    public String getCitation() {
        return citation;
    }



    @Override
    public String toString()
    {
        return "The following \"history\" was told for many years:\n\n" +
                super.toString() + "\n\n\nBy correcting history, not just rewriting it, we are revising it to embark on the process of righting a wrong.\nHere is the revised history:\n"
                + this.revisedDescription + "\n\nSource: " + this.citation;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null)
        {
            return false;
        }
        else if(!(this.getClass() != other.getClass()))
        {
            return false;
        }
        else
        {
            RevisedHistoricalEvent otherEvent = (RevisedHistoricalEvent) other;
            return super.equals(other) &&
                    this.revisedDescription.equals(otherEvent.revisedDescription) &&
                    this.citation.equals(otherEvent.citation);
        }
    }
    //this is not a social studies class nor a history class
    //this is not a social studies class nor a history class
    //this is not a social studies class nor a history class
    //this is not a social studies class nor a history class
    //this is not a social studies class nor a history class
    //this is not a social studies class nor a history class

    public void teach()
    {
        System.out.println(this.toString());
    }
}