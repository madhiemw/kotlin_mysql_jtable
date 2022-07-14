import java.awt.AWTEventMulticaster.add
import java.awt.Rectangle
import java.net.URL
import java.sql.Connection
import java.sql.DriverManager
import java.sql.Statement
import javax.swing.*
import javax.swing.table.DefaultTableModel


open class allframe{
    open fun all_popup(){
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
class matkul :allframe() {
    override fun all_popup() {
        Class.forName("com.mysql.jdbc.Driver")
        val Url = ("jdbc:mysql://localhost:3306/file")
        val User = ("root")
        val Password = ("")
        val con: Connection = DriverManager.getConnection(Url, User, Password)
        val query = "SELECT * FROM mahasiswa"
        val stm: Statement = con.createStatement()
        val res = stm.executeQuery(query)
        val columns = arrayOf("Nama", "Mata kuliah Aktif","hari jam")
        val data = Array(0) {
            arrayOfNulls<String>(
                3
            )
        }
        val tb = DefaultTableModel(data, columns)
        tb.insertRow(0, arrayOf<Any>("Nama", "Mata Kuliah","Hari/Jam"))
        res.next()
        var urut: Int = 1
        do {
            val nama = res.getString("Nama")
            val matkul = res.getString("Mata Kuliah")
            val jam = res.getString("Hari, Jam")
            tb.insertRow(urut, arrayOf<Any>(nama, matkul,jam))
            ++urut
        } while (res.next())
        val table_matkul = JTable(tb)
        val newframe = JFrame("Daftar Mahasiswa")
        val button1 = JButton("Export")
        val button3= JButton("Back")

        button1.addActionListener {
            table_matkul.print()
        }
        button3.addActionListener {
            newframe.dispose()
        }
        button1.bounds = Rectangle(750, 700, 200, 50)
        button3.bounds = Rectangle(525, 700, 200, 50)
        newframe.add(button1)
        newframe.add(button3)
        newframe.add(table_matkul)
        newframe.setSize(1000, 1000)
        newframe.isVisible = true
    }
}
class Table_frame :allframe() {
    override fun all_popup() {
        var allframe = allframe()
        allframe=matkul()

        Class.forName("com.mysql.jdbc.Driver")
        val Url = ("jdbc:mysql://localhost:3306/file")
        val User = ("root")
        val Password = ("")
        val con: Connection = DriverManager.getConnection(Url, User, Password)
        val query = "SELECT * FROM mahasiswa"
        val stm: Statement = con.createStatement()
        val res = stm.executeQuery(query)
        val columns = arrayOf("Nama", "NIM", "Jurusan","ipk")
        val data = Array(0) {
            arrayOfNulls<String>(
                4
            )
        }
        val tb = DefaultTableModel(data,columns)
        tb.insertRow(0, arrayOf<Any>("Nama","NIM","Jurusan","IPK"))
        res.next()
        var urut :Int = 1
        do{
            val nama = res.getString("Nama")
            val nim = res.getString("NIM")
            val jurusan = res.getString("Jurusan")
            val ipk = res.getString("IPK")
            tb.insertRow(urut, arrayOf<Any>(nama, nim,jurusan,ipk))
            ++urut
        }while (res.next())
        val button1= JButton("Export")
        val button2= JButton("Close")
        val button3= JButton("Mata_Kuliah")
        val table = JTable(tb)
        val newframe = JFrame("Daftar Mahasiswa")
        button1.bounds = Rectangle(750, 700, 200, 50)
        button2.bounds = Rectangle(50, 700, 200, 50)
        button3.bounds = Rectangle(525, 700, 200, 50)
        button1.addActionListener {
            table.print()
        }
        button2.addActionListener {
            newframe.dispose()
        }
         button3.addActionListener {
             allframe.all_popup()
         }
        newframe.add(button3)
        newframe.add(button1)
        newframe.add(button2)
        newframe.add(table)
        newframe.setSize(1000,1000)
        newframe.isVisible=true
        // newframe.add(tb)
    }
}
class login_page :allframe() {
    override fun all_popup( ) {
        var  allframe = allframe()
        val myframe = JFrame("Login Page")
        myframe.setSize(500, 500)
        myframe.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        myframe.layout = null
        val label1 = JLabel("User")
        val label2 = JLabel("Password")
        val Input_Password = JPasswordField("")
        val Input_Nim = JTextField("")
        val label = JLabel("Muhammad Adhiem Wicaksana | A11.2019.11897")
        val button = JButton("Login")
        label1.bounds = Rectangle(90, 220, 200, 20)
        label2.bounds = Rectangle(90, 250, 200, 20)
        Input_Nim.bounds = Rectangle(155, 220, 200, 20)
        Input_Password.bounds = Rectangle(155, 250, 200, 20)
        button.bounds = Rectangle(155, 300, 200, 50)
        label.bounds = Rectangle(110, 40, 300, 100)
        button.addActionListener {
            if (Input_Password.text.equals("") && Input_Nim.text.equals("root")){
                allframe=Table_frame()
                allframe.all_popup()
            }
            else {
                allframe=frame_notifikasi()
                allframe.all_popup()
            }
        }
        myframe.add(label2)
        myframe.add(label1)
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
