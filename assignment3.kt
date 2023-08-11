fun main(){
    var list1 = listOf(Student(1,"A",12,30.0),
        Student(2,"B",13,6.0),
        Student(3,"C",14,98.0),
        Student(4,"D",15,19.0),
        Student(5,"E",12,67.0),
        Student(6,"F",17,34.0),
        Student(7,"G",15,20.0),
        Student(8,"H",11,10.0)
        )

    println(filterPassedStudent(list1))
    println("Average is - " +filteravgAge(list1))
    println("Student with Maximum Marks -> " + topscore(list1).toString())
}

fun filterPassedStudent(sudentList: List<Student>): List<Student> {
    return sudentList.filter { student -> student.marks >=40.0 }
}

fun filteravgAge(sudentList: List<Student>): Double {
    return sudentList.map { it.age }.average();
}

fun topscore(sudentList: List<Student>): Student {
    return sudentList.maxBy { it.marks };
}

class Student(var id:Int,var name:String, var age:Int,var marks:Double){
    override fun toString(): String {
        return "Name - ${name} \t Age - ${age} \t Marks - ${marks}"
    }
}