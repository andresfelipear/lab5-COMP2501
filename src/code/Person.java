/**
 * Person of BCIT
 *
 * @author Andres Arevalo & Walter Chu
 * @version 1.0
 */
public class Person
{
    private final String firstName;
    private final String lastName;
    private final int birthYear;
    private final String married;
    private final double weightPounds;
    private final String highestEducationLevel;
    public static final int CURRENT_YEAR = 2024;

    /**
     * This constructor initializes the information of a person according to 6 parameter inputs.
     *
     * @param firstName             the first name of the person
     * @param lastName              the last name of the person
     * @param birthYear             the year birth of the person
     * @param married               status of the person (yes, no or divorced)
     * @param weightPounds          weight in pounds
     * @param highestEducationLevel highest level of education (high school, undergraduate or graduate)
     */
    public Person(final String firstName,
                  final String lastName,
                  final int birthYear,
                  final String married,
                  final double weightPounds,
                  final String highestEducationLevel)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.weightPounds = weightPounds;

        if(isValidMarriageStatus(married))
        {
            this.married = married;
        } else
        {
            throw new IllegalArgumentException("It should be yes, no or divorced");
        }

        if(isValidEducationLevel(highestEducationLevel))
        {
            this.highestEducationLevel = highestEducationLevel;
        } else
        {
            throw new IllegalArgumentException("It should be high school, undergraduate or graduate");
        }
    }

    /**
     * This constructor initializes the information of a person according to 5 parameter inputs.
     * The birth year is set to the current year.
     *
     * @param firstName             the first name of the person
     * @param lastName              the last name of the person
     * @param married               status of the person (yes, no or divorced)
     * @param weightPounds          weight in pounds
     * @param highestEducationLevel highest level of education (high school, undergraduate or graduate)
     */
    public Person(final String firstName,
                  final String lastName,
                  final String married,
                  final double weightPounds,
                  final String highestEducationLevel)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = CURRENT_YEAR;
        this.weightPounds = weightPounds;

        if(isValidMarriageStatus(married))
        {
            this.married = married;
        } else
        {
            throw new IllegalArgumentException("It should be yes, no or divorced");
        }

        if(isValidEducationLevel(highestEducationLevel))
        {
            this.highestEducationLevel = highestEducationLevel;
        } else
        {
            throw new IllegalArgumentException("It should be high school, undergraduate or graduate");
        }
    }

    /**
     * This constructor initializes the information of a person according to 3 parameter inputs.
     * the birth year is set to the current year, and the education level is set to high school
     * and the married status is set to "no".
     *
     * @param firstName    the first name of the person
     * @param lastName     the last name of the person
     * @param weightPounds weight in pounds
     */
    public Person(final String firstName,
                  final String lastName,
                  final double weightPounds)
    {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = CURRENT_YEAR;
        this.weightPounds = weightPounds;
        this.married = "no";
        this.highestEducationLevel = "high school";
    }

    /**
     * @param educationLevelToVerify education level to verify.
     * @return true if equals to high school, undergraduate or graduate otherwise return false.
     */
    private boolean isValidEducationLevel(final String educationLevelToVerify)
    {
        return educationLevelToVerify.equalsIgnoreCase("high school") ||
                educationLevelToVerify.equalsIgnoreCase("undergraduate") ||
                educationLevelToVerify.equalsIgnoreCase("graduate");
    }

    /**
     * @param marriedStatusToVerify married status to verify.
     * @return true if equals to yes no or divorced otherwise return false.
     */
    private boolean isValidMarriageStatus(final String marriedStatusToVerify)
    {
        return marriedStatusToVerify.equalsIgnoreCase("yes") ||
                marriedStatusToVerify.equalsIgnoreCase("no") ||
                marriedStatusToVerify.equalsIgnoreCase("divorced");
    }

    /**
     * Prints person details.
     */
    public void printDetails()
    {
        System.out.println(firstName + " " + lastName + "(" + getMarriageStatusForPrintDetails(married) + ") was born in " + birthYear +
                                   ", weighs " + String.format("%.1f", weightPounds) + " pounds, and has an " + getHighestEducationForPrintDetails(highestEducationLevel) + " degree!");
    }


    /**
     * Prints person details if kilograms true print weight in kilograms otherwise print it normal.
     *
     * @param kilograms specify if the weight should be print in kilograms or not.
     */
    public void printDetails(final boolean kilograms)
    {
        if(kilograms)
        {
            double weightKilograms;
            weightKilograms = weightPounds * 0.453592;
            System.out.println(firstName + " " + lastName + "(" + getMarriageStatusForPrintDetails(married) + ") was born in " + birthYear +
                                       ", weighs " + String.format("%.1f", weightKilograms) + " kilograms, and has " +
                                       getHighestEducationForPrintDetails(highestEducationLevel) + " degree!");
        } else
        {
            printDetails();
        }
    }

    /**
     * Prints person details if kilograms true print weight in kilograms otherwise print it normal.
     * if uppercase true prints the names in uppercase.
     *
     * @param kilograms specify if the weight should be print in kilograms or not.
     * @param uppercase specify if the output should be print in uppercase or not.
     */
    public void printDetails(final boolean kilograms,
                             final boolean uppercase)
    {
        if(kilograms)
        {
            if(uppercase)
            {
                double weightKilograms;
                weightKilograms = weightPounds * 0.453592;
                System.out.println(firstName.toUpperCase() + " " + lastName.toUpperCase() + "(" + getMarriageStatusForPrintDetails(married) + ") was born in " + birthYear +
                                           ", weighs " + String.format("%.1f", weightKilograms) + " kilograms, and has " +
                                           getHighestEducationForPrintDetails(highestEducationLevel) + " degree!");
            } else
            {
                printDetails(kilograms);
            }
        } else
        {
            if(uppercase)
            {
                System.out.println(firstName.toUpperCase() + " " + lastName.toUpperCase() + "(" + getMarriageStatusForPrintDetails(married) + ") was born in " + birthYear +
                                           ", weighs " + String.format("%.1f", weightPounds) + " pounds, and has " +
                                           getHighestEducationForPrintDetails(highestEducationLevel) + " degree!");
            } else
            {
                printDetails();
            }
        }
    }

    /**
     * @param marriageStatus The marriage status of the person.
     * @return formatted string of the marriage status of the person.
     */
    public String getMarriageStatusForPrintDetails(final String marriageStatus)
    {
        if(marriageStatus.equals("no"))
        {
            return "single";
        }
        else if(marriageStatus.equals("yes"))
        {
            return "married";
        }
        else
        {
            return "divorced";
        }
    }


    /**
     * If undergraduate return "an + undergraduate" otherwise "a + (high school or graduate).
     * @param highestEducationLevel the person highest education level
     * @return formatted string, to meet output expectations.
     */
    private String getHighestEducationForPrintDetails(final String highestEducationLevel)
    {
        if(highestEducationLevel.equalsIgnoreCase("undergraduate"))
        {
            return "an " + highestEducationLevel;
        }
        return "a " + highestEducationLevel;

    }

}
