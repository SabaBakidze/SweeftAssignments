/*
* 1/07/2022
* @Saba Bakidze
* */
import java.util.*


fun main() {

    //1. isPalindrome
    val textToCheck = "txt"
    println("* 1. The text is Palindrome: " + isPalindrome(textToCheck))

    //2. minSplit
    val cashToCheck = 120
    println("* 2. The coins required are: " + minSplit(cashToCheck))

    //3. notContains
    val arrToCheck = arrayOf(-4, 2, 5, 10, 1, 3)
    println("* 3. The array doesn't contain integer: " + notContains(arrToCheck))

    //4. isProperly
    val textToCheck2 = "5+5*((24-10))("
    println("* 4. The text is properly written: " + isProperly(textToCheck2))

    //5. countVariants
    val n = 5
    println("* 5. Amount of variants are: " + countVariants(n))

    //6. DataStructure - Using Hashmap we can remove an element
    //   in O(1) time
    println("* 6.")
    val ds = DataStructure()
    ds.add(10)
    ds.add(2)
    ds.add(30)
    ds.add(4)
    println("Before remove: " + ds.arr)
    ds.remove(30)
    println("After remove: " + ds.arr)

}


//1. isPalindrome
fun isPalindrome(txt: String): Boolean {
    val reverse = txt.reversed()

    return txt.equals(reverse)
}

//2. minSplit
fun minSplit(amount: Int): Int{

    var requiredCoins = 0
    var remainder = 0

    if (amount >= 50) {
        requiredCoins += amount / 50
        remainder = amount % 50
    }

    if (amount >= 20) {
        requiredCoins += remainder / 20
        remainder %= 20
    }

    if (amount >= 10) {
        requiredCoins += remainder / 10
        remainder %= 10
    }

    if (amount >= 5) {
        requiredCoins += remainder / 5
        remainder %= 5
    }

    if (amount >= 1) {
        requiredCoins += remainder / 1
    }
    return requiredCoins
}

//3. notContains
fun notContains(arr: Array<Int>): Int{
    var checkingNum = 0
    do {
        ++checkingNum
    }while (arr.contains(checkingNum))

    return checkingNum
}

//4. isProperly
fun isProperly(sequence: String): Boolean{
    val stackToCheck: Deque<Char> = ArrayDeque()
    val arrOfChars = sequence.toCharArray()

    for (char in arrOfChars){
        if(char == '('){
            stackToCheck.push(char)
        }else if (char == ')'){
            if (stackToCheck.isEmpty()){
                return false
            }

            val topCharacter = stackToCheck.peek()
            if (char != ')' || topCharacter != '('){
                return false
            }
            stackToCheck.pop()
        }
    }

    return (stackToCheck.isEmpty())
}

//5. countVariants
fun countVariants(stairsCount: Int): Int{
    return fibonacci(stairsCount + 1)
}
fun fibonacci(n: Int): Int{
    return if (n <= 1) n else fibonacci(n - 1) + fibonacci(n - 2)
}

