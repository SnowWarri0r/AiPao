import com.liaoguoyin.aipao.client
import java.io.File
import java.util.*

fun main(args: Array<String>) {
    println("Please insert your IMEICode:")
    val scanner = Scanner(System.`in`)
    val IMEICode = scanner.nextLine()
    println("Your IMEICode: $IMEICode")

    val client = client(IMEICode)
    client.checkImeicode()
    client.getInfo()
    client.running()
    client.upload()

    File("output.txt").appendText("\n" + client.keyInfo.toString())
    println("成功！点击链接查看记录：" +
            "http://sportsapp.aipao.me/Manage/UserDomain_SNSP_Records.aspx/MyResutls?userId=${client.keyInfo["uid"]}")

}
