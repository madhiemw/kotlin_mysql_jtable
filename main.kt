import java.awt.Rectangle
import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement
import javax.swing.*
import javax.swing.table.DefaultTableModel


open class allframe{
    open fun all_popup(){
    }
}
class koneksi() {
    fun mysql(){
    val Url = ("jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false")
    val User = ("root")
    val Password = ("")
    val con: Connection = DriverManager.getConnection(Url, User, Password)
    val query = "SELECT * FROM user"
    val stm: Statement = con.createStatement()
    val res = stm.executeQuery(query)
    var columns = arrayOf("ID", "Name", "Age")
    val data = Array(8) { arrayOfNulls<String>(3) }
    var kandedes = (0)
    do{
        val id = res.getInt("id")
            val nom = res.getString("nama")
            val age = res.getString("age")
            data[kandedes][0] = (id) + ("")
            data[kandedes][1] = (nom)
            data[kandedes][3] = (age)
            ++kandedes
       }  while (res!!.next())
    }
}

class frame_notifikasi : allframe() {
    override fun all_popup() {
        val wronginput = JLabel("   Incorrect password and user")
        val submit = JButton("OK")
        submit.bounds = Rectangle(100,50,100, 50)
        wronginput.bounds = Rectangle(60,-26,200, 100)
        val pop_up_frame = JFrame("Notification")
        pop_up_frame.setSize(300, 200)
        pop_up_frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        pop_up_frame.layout = null
        pop_up_frame.add(wronginput)
        pop_up_frame.isVisible = true
        pop_up_frame.add(submit)
        submit.addActionListener {
            pop_up_frame.dispose()
        }
    }
}
class Table_frame :allframe(){
    override fun all_popup() {
        val koneksi = koneksi()
        koneksi.mysql()
        val newframe = JFrame("Data Mahasiswa")
        val printbutton = JButton("Export")
        //val savebutton = JButton("Save")
        val tableModel = DefaultTableModel(data,col)
        val table = JTable(tableModel)
        newframe.setSize(500, 500)
        newframe.layout = null
        newframe.isVisible = true
        //savebutton.bounds= Rectangle(300 ,390,65 ,40)
        printbutton.bounds = Rectangle(380 ,390,80 ,40)
        tableModel.addColumn("NIM")
        tableModel.addColumn("NAMA")
        tableModel.addColumn("jurusan")
        tableModel.insertRow(0, arrayOf<Any>("Nama", "NIM", "Jurusan"))
        tableModel.insertRow(0, arrayOf<Any>("Muhammad adhiem Wicaksna", "A11.2019.11897", "TI"))
        tableModel.insertRow(0, arrayOf<Any>("Nama", "NIM", "Jurusan"))
        table.bounds = Rectangle(0, 0, 500, 100)
        printbutton.addActionListener {
            table.print()
        }
        newframe.add(table)
        newframe.add(printbutton)
        //newframe.add(savebutton)
    }
}

class login_page :allframe() {
    override fun all_popup() {
        var  allframe = allframe()
        val myframe = JFrame("LOGIN PAGE")
        myframe.setSize(500, 500)
        myframe.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        myframe.layout = null
        val Input_Password = JPasswordField("")
        val Input_Nim = JTextField("kandedes")
        val label = JLabel("PBO")
        val button = JButton("Login")
        Input_Nim.bounds = Rectangle(155, 220, 200, 20)
        Input_Password.bounds = Rectangle(155, 250, 200, 20)
        button.bounds = Rectangle(155, 300, 200, 50)
        label.bounds = Rectangle(240, 40, 200, 100)
        button.addActionListener {
            if (Input_Password.text.equals("Admin") && Input_Nim.text.equals("A11.2019.11897")){
                allframe=Table_frame()
                allframe.all_popup()
            }
            else {
                allframe=frame_notifikasi()
                allframe.all_popup()
            }
        }
        myframe.add(label)
        myframe.add(Input_Nim)
        myframe.add(Input_Password)
        myframe.add(button)
        myframe.isVisible=true
    }}
fun main(){
    var allframe = allframe()
    allframe = login_page()
    allframe.all_popup()

}

