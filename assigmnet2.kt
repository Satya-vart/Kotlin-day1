fun main(){
    var account1 = SavingAccount("1234567","User 1",4700.0);
    var account2 = SavingAccount("4567123","User 2",5000.0);
    var account3 = CheckingAccount("0893452","User 3",9200.0);
    account1.deposit(340.0);
    account2.withdraw(340.0)
    account3.withdraw(9300.0)
    account1.getBalance()
    account2.getBalance()
    account3.getBalance()
}

interface BankAccount{
    fun deposit(value: Double)
    fun withdraw(value: Double)
    fun getBalance()
}

class SavingAccount(val accountNumber:String, val accountHolder: String,
                    var amount: Double, var interestRate:Double=2.0
) : BankAccount{

    override fun deposit(value: Double) {
        amount += value;
        getBalance()
    }

    override fun withdraw(value: Double) {
        if(value > amount) {
            println("Error : Low balance")
            return
        }
        if(amount - value > 1000) amount -= value
        else{
            var valueAfterCharges = 1.02 * value;
            if(amount > valueAfterCharges) amount -= valueAfterCharges
            else{
                println("Error : Low balance")
                return
            }
        }
    }

    override fun getBalance() {
        println("Balance in account : ${accountNumber} assigned to ${accountHolder} is -> ${amount}")
    }

    fun chargeFee(){
        val interest = amount * interestRate;
        amount -= interest
        println("Extra $10 is subtracted for low balance")
    }
}

class CheckingAccount(val accountNumber:String, val accountHolder: String,
                    var amount: Double, val overDraftLimit:Double=500.0
) : BankAccount{

    var fixedLowBalanceCharge = 50;
    override fun deposit(value: Double) {
        amount += value;
    }

    override fun withdraw(value: Double) {
        if(value <= amount)this.amount -= value;
        if(value > amount) println("Error : Low balance")
        if(amount + overDraftLimit > value) {
                println("Assigning loan")
                amount -= value
                amount -= fixedLowBalanceCharge;
            }

    }

    override fun getBalance() {
        println("Balance in account : ${accountNumber} assigned to ${accountHolder} is -> ${amount}")
    }

}