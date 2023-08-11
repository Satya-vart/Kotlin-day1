
fun main(){
    var account1 = BankAccount1("1234567","User 1",470.0);
    var account2 = BankAccount1("4567123","User 1",500.0);
    var account3 = BankAccount1("0893452","User 1",920.0);
    account1.deposit(340.0);
    account1.printBalance()
    account2.withdraw(340.0)
    account2.printBalance()
}

class BankAccount1(val accountNumber:String, val accountHolder: String, private var balance: Double){
    fun deposit(value:Double){
        this.balance += value;
    }
    fun withdraw(value:Double){
        if(value > balance) {
            println("Error : Low balance")
            printBalance()
            return
        }
        this.balance -= value;
    }
    fun printBalance(){
        println("Balance in account : ${accountNumber} assigned to ${accountHolder} is -> ${balance}")
    }
}
