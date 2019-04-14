import com.liaoguoyin.aipao.client
import java.util.*

fun main(args: Array<String>) {
    println("Please insert your IMEICode:")
    val scanner = Scanner(System.`in`)
    val IMEICode = scanner.nextLine()
    //    val IMEICode = "40ae72be33f64ce6a936661bb8449fa1"
    println("Your IMEICode: $IMEICode")

    val client = client(IMEICode)
    client.checkImeicode()
    client.getInfo()
    client.running()
    client.upload()
}