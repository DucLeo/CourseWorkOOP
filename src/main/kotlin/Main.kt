import dataBase.Contact
import dataBase.ContactService
import dataBase.Person
import gui.MainJFrame
import javax.swing.*


fun main() {
    val phonebook = ContactService()

    val person1 = Person("Duc", "Luong")
    phonebook.addContact(person1, Contact.DateOfBirth(10,8,2000))
    phonebook.addContact(person1, Contact.Address("151511","Thanh Hoa","Le Loi","145"))
    phonebook.addContact(person1, Contact.Email("God.Luffy.008@gmail.com"))
    phonebook.addContact(person1, Contact.Phone("+7 (911) 257-25-32"))

    val person2 = Person("Tuan Anh", "Le")
    phonebook.addContact(person2, Contact.DateOfBirth(29,7,2000))
    phonebook.addContact(person2, Contact.Address("192411","Ha Tinh","Hang Lay","204"))
    phonebook.addContact(person2, Contact.Email("letuananh297gmail.com"))
    phonebook.addContact(person2, Contact.Phone("+7 (911) 241-65-19"))

    val phoneBook = MainJFrame(phonebook)
    SwingUtilities.invokeLater {
        phoneBook.isVisible = true
    }
}