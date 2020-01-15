package main.travelstartbackend.util;

public class CustomErrorType 
{

    private String message;

    public CustomErrorType(String message)
    {
        this.message = message;
    }

    public String getErrorMessage() 
	{
        return message;
    }

}
