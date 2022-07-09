import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement
import javax.swing.JFrame
import javax.swing.JTable
import javax.swing.table.DefaultTableModel
import java.lang.Class

fun main(args: Array<String>) {
    Class.forName("com.mysql.jdbc.Driver")
    val Url = ("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false")
    val User = ("root")
    val Password = ("")
    val con: Connection = DriverManager.getConnection(Url, User, Password)
    val query = "SELECT * FROM user"
    val stm: Statement = con.createStatement()
    val res = stm.executeQuery(query)
    val columns = arrayOf("ID", "Name", "Age")
    val data = Array(8) { arrayOfNulls<String>(3) }
    var kandedes = (0)
    do{
        val id = res.getInt("id")
        val nom = res.getString("nama")
        val age = res.getString("age")
       // data[kandedes][0] = (id)
        data[kandedes][1] = (nom)
        data[kandedes][3] = (age)
        ++kandedes
    }  while (res!!.next())
    val model = DefaultTableModel(data,columns)
    val table = JTable(model)
    val frame = JFrame("kandedes")
    frame.setSize(500,500)
    table.setShowGrid(true)
    table.setShowGrid(true)
    table.showVerticalLines = true
    frame.add(table)
    frame.isVisible= true

}
