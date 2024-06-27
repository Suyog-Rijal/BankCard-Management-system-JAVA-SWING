package Functions;
public class BankCard
{
    //Decleration of the instance variables.
    private String clientName;
    private String issuerBank;
    private String bankAccount;
    private int cardId;
    private double balanceAmount;

    // Constructor of the class where the instance variables are initialized.
    public BankCard(double balanceAmount, int cardId, String bankAccount, String issuerBank)
    {
        this.balanceAmount = balanceAmount;
        this.cardId = cardId;
        this.bankAccount = bankAccount;
        this.issuerBank = issuerBank;

        this.clientName = "";
    }
// Getter method for the instance variable clientName.
    public String getClientName()
    {
        return clientName;
    }
// Getter method for the instance variable issuerBank.
    public String getIssuerBank()
    {
        return issuerBank;
    }
// Getter method for the instance variable bankAccount.
    public String getBankAccount()
    {
        return bankAccount;
    }
// Getter method for the instance variable cardId.
    public int getCardId()
    {
        return cardId;
    }
// Getter method for the instance variable balanceAmount.
    public double getBalanceAmount()
    {
        return balanceAmount;
    }
// Setter method for the instance variable clientName.
    protected void setClientName(String clientName)
    {
        this.clientName = clientName;
    }
// Setter method for the instance variable balanceAmount.
    protected void setBalanceAmount(double balanceAmount)
    {
        this.balanceAmount = balanceAmount;
    }
// Protected method to display the details of the bank card.
    protected void display()
    {
        if(clientName.equals("")){
            System.out.println("The client name is not given!");
        }
        else{
            System.out.println("Client Name: "+clientName);
            System.out.println("Issuer Bank: "+issuerBank);
            System.out.println("Bank Account: "+bankAccount);
            System.out.println("Card Id: "+cardId);
            System.out.println("Balance Ammount: "+balanceAmount);
        }
    }
// Public method that returns the balance amount.
    public double getBalance() {
        return balanceAmount;
    }
// Public method that sets the balance amount.
    public void setBalance(double v) {
        this.balanceAmount = v;
    }
}
