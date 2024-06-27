package Functions;
public class CreditCard extends BankCard
{
    //Decleration of the instance variable.
    private int cvcNumber;
    private double creditLimit;
    private double interestRate;
    private String expirationDate;
    private int gracePeriod;
    private boolean isGranted;
    // Constructor of the class where the instance variables are initialized.
    public CreditCard(int cardId, String clientName, String issuerBank, String bankAccount, double balanceAmount, int cvcNumber, double interestRate, String expirationDate)
    {
        // Calling the constructor of the super class.
        super(balanceAmount, cardId, bankAccount, issuerBank);
        super.setClientName(clientName);
        // Initializing the instance variables.
        this.cvcNumber = cvcNumber;
        this.interestRate = interestRate;
        this.expirationDate = expirationDate;
        this.isGranted = false;
    }

    // Getter methods for the instance variable cvcNumber.
    public int getCvcNumber()
    {
        return cvcNumber;
    }

// Getter methods for the instance variable creditLimit.
    public double getCreditLimit()
    {
        return creditLimit;
    }
// Getter methods for the instance variable interestRate.
    public double getInterestRate()
    {
        return interestRate;
    }
// Getter methods for the instance variable expirationDate.
    public String getExpirationDate()
    {
        return expirationDate;
    }
// Getter methods for the instance variable gracePeriod.
    public int getGracePeriod()
    {
        return gracePeriod;
    }
// Getter methods for the instance variable isGranted.
    public boolean getIsGranted()
    {
        return isGranted;
    }

    // Public method to set the credit limit and the grace period.
    public void setTheCreditLimit(double creditLimit, int gracePeriod)
    {
        if(creditLimit <= (2.5*super.getBalanceAmount())){
            this.isGranted = true;
            this.creditLimit = creditLimit;
            this.gracePeriod = gracePeriod;
            System.out.println("The credit has been sucessfully issued");
        }
        else{
            System.out.println("Sorry! The credit cannot be issued.");
        }
    }

    // proteced methods to cancel the credit card.
    protected void cancelCreditCard()
    {
        this.isGranted = false;
        this.cvcNumber = 0;
        this.creditLimit = 0;
        this.gracePeriod = 0;
    }

// Protected method to dipaly the details of the credit card.
    protected void display()
    {

        super.display();

        if(isGranted == true){
            System.out.println("Credit Limit= "+creditLimit);
            System.out.println("Grace Period= "+gracePeriod);
        }
        else{
            System.out.println("Credit not granted.");
        }
    }

    // Public methos to set the grace period.
    public void setGracePeriod(int i) {
        gracePeriod = i;
    }
}
