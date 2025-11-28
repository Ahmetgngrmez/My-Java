public class CreditCard{
    private String customer;
    private String bank;
    private String account;
    private int limit;
    protected double balance;
    
    public String getCustomer() {
        return customer;
    }
    public String getBank() {
        return bank;
    }
    public String getAccount() {
        return account;
    }
    public int getLimit() {
        return limit;
    }
    public double getBalance() {
        return balance;
    }
    public CreditCard (String customer,String bank, String account, int limit,double balance){
        this.customer=customer;
        this.bank=bank;
        this.account=account;
        this.limit=limit;
        this.balance=balance;
    }
    public CreditCard(String customer,String bank, String account, int limit){
        this(customer,bank,account,limit,0.0);
    }
    
    public boolean charge(double price){
        if(price+balance>limit){
            return false;
        }
        balance+=price;
        return true;

    }
    
    public void makePayment(double amount){
        balance-=amount;
    }
    public static void printSummary(CreditCard card){
        System.out.println("Customer: "+card.customer);
        System.out.println("Bank: "+card.bank);
        System.out.println("Account: "+card.account);
        System.out.println("Balance: "+card.balance);
        System.out.println("Limit: "+card.limit);
    }
    
    public static void main(String[] args){
        CreditCard[] wallet = new CreditCard[3];

        wallet[0]=new CreditCard("Ahmet", "akbank", "5555 4444 3333", 5000);
        wallet[1]=new CreditCard("Ahmet", "denizbank", "5555 2222 3333", 3500);
        wallet[2]=new CreditCard("Ahmet", "yapıkedi", "5555 1111 3333", 2500,300);

        for(int val=1;val<=16;val++){
            wallet[0].charge(3*val);
            wallet[1].charge(2*val);
            wallet[2].charge(val);
        }

        for(CreditCard card : wallet){
            CreditCard.printSummary(card);
            while(card.getBalance()>200.0){
                card.makePayment(200);
                System.out.println("New balance = "+card.getBalance());
            }
            System.out.println("-----------------------");
        }
    } 
}