fun main(){
    var orderList = listOf(
        Order("1","ABC",3,68.0),
        Order("2","B",3,345.0),
        Order("3","C",3,548.0),
        Order("4","D",3,3.0),
        Order("5","E",3,75.0),
        Order("6","F",3,84.0),
        Order("7","G",3,2.0),
    )

    println(totalListValue(orderList))
    println(findHighesatValueOrder(orderList))
}


class Order(val id: String,val name:String,val quantity:Int,val unitPrice: Double){

    override fun toString(): String {
        return "ID - ${id} , Name - ${name}, totalValue - ${totalValue()}"
    }
    fun totalValue():Double{
        return quantity*unitPrice
    }
}
fun totalListValue(list:List<Order>):Double{
    return list.map { order -> order.totalValue() }.sum()
}
fun findHighesatValueOrder(list:List<Order>):Order?{
    return list.maxByOrNull { order -> order.totalValue() }
}