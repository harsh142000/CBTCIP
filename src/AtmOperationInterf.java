
public interface AtmOperationInterf {
    public void viewBalance();
    public void withdrawAmount(double withdrawAmount);
    public void depositAmount(double depositAmount );
    public  void viewMiniStatement();

    public void transferAmount(String recipientAccountNumber,double transfer);
}