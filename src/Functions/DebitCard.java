package Functions;

public class DebitCard extends BankCard
{
    //Decleration of the instance variables.
    private int pinNumber;
    private int withdrawlAmount;
    private String dateOfWithdrawl;
    private boolean hasWithdrawn;

    /* constructor for DebitCard that takes in balance amount, card id, bank account, issuer bank, client name, and pin number
    as inputs*/
    public DebitCard(double balanceAmount, int cardId, String bankAccount, String issuerBank, String clientName, int pinNumber)
    {
        //A call to the superclasss constructor.
        super(balanceAmount, cardId, bankAccount, issuerBank);

        //set the client name using the setClientName method from the super class.
        super.setClientName(clientName);
        this.pinNumber = pinNumber;

        //Initialize the hasWithdrawn boolean to false.
        this.hasWithdrawn = false;
    }

    //Accessor method for the instance variable pinNumber.
    public int getPinNumber()
    {
        return pinNumber;
    }

    //Accessor method for the instance variable withdrawlAmount.
    protected int getWithdrawlAmount()
    {
        return withdrawlAmount;
    }

    //Accessor method for the instance variable dateOfWithdrawl.
    protected String getDateOfWithdrawl()
    {
        return dateOfWithdrawl;
    }

    //Accessor method for the instance variable hasWithdrawn.
    public  boolean getHasWithdrawn()
    {
        return hasWithdrawn;
    }

    //Mutator method the the instance variable withdrawlAmount.
    public void setWithDrawlAmount(int withdrawlAmount)
    {
        this.withdrawlAmount = withdrawlAmount;;
    }

    //A method for withdrawing money, takes in withdrawl amount, date of withdrawl, and pin number as inputs.
    public void withdraw(int withdrawlAmount, String dateOfWithdrawl, int pinNumber)
    {
        //Check if the input pin number matches the pin number for the card.
        if(this.pinNumber == pinNumber){

            //Check if there is enough balance to withdraw the requested amount.
            if(withdrawlAmount <= super.getBalanceAmount()){
                this.hasWithdrawn = true;
                this.withdrawlAmount = withdrawlAmount;
                this.dateOfWithdrawl = dateOfWithdrawl;
                setBalanceAmount(super.getBalanceAmount() - withdrawlAmount);
                System.out.println("Transaction successfully carried out.");
            }
            else{
                System.out.println("Insufficent Balance");
            }
        }
        else{
            System.out.println("Invalid pin");
        }
    }

    //Method for displaying card information.
    protected void display()
    {
        //A call to the display method from the superclass
        super.display();
        System.out.println("Pin Number= "+pinNumber);
        if(hasWithdrawn == true){
            System.out.println("Withdrawl Amount= "+withdrawlAmount);
            System.out.println("Date of withdrawl= "+dateOfWithdrawl);
        }
        else{
        }
    }

}
