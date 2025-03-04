package lab02;
public class HistoricalEvent
{
    public static final String DEFAULT_DESCRIPTION = "Historical event description default.";
    public static final Date DEFAULT_EVENT_DAY = new Date();


    private String description;
    private Date eventDay;

    public HistoricalEvent(String description, Date eventDay)
    {
        if(!this.setAll((description), eventDay))
        {
            System.out.println("ERROR: bad data given to full constructor");
            System.exit(0);
        }
    }

    public HistoricalEvent()
    {
        this(DEFAULT_DESCRIPTION, DEFAULT_EVENT_DAY);
    }

    public HistoricalEvent(HistoricalEvent original)
    {
        if(original != null)
        {
            this.setAll(original.description, original.eventDay);
        }
        else
        {
            System.out.println("Error null data given to copy constructor");
            System.exit(0);
        }
    }

    public boolean setDescription(String description)
    {
        if(description != null) {
            this.description = description;
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean setEventDay(Date eventDay)
    {
        if(description != null) {
            this.eventDay = new Date(eventDay);
            return true;
        }
        else
        {
            return false;
        }

    }

    public boolean setAll(String description, Date eventDay)
    {
        if(this.setDescription(description) && this.setEventDay(eventDay)) {
            return true;
        }
        else
        {
            return false;
        }

    }

    public String GetDescription()
    {
        return this.description;
    }

    public Date GetEventDay()
    {
        return new Date(this.eventDay);
    }



    @Override
    public String toString()
    {
        return "On " + this.eventDay + ": " + this.description;
    }

    @Override
    public boolean equals(Object other)
    {
        if(other == null)
        {
            return false;
        }
        else if(!(other instanceof HistoricalEvent))
        {
            return false;
        }
        else
        {
            HistoricalEvent otherEvent = (HistoricalEvent) other;
            return this.description.equals(otherEvent.description) &&
                    this.eventDay.equals(otherEvent.eventDay);
        }
    }
}